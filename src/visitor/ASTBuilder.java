package visitor;

import parser.*;
import java.util.ArrayList;
import java.util.List;

public class ASTBuilder extends ControlFlowBaseVisitor<ASTNode> {

    @Override
    public ASTNode visitProgram(ControlFlowParser.ProgramContext ctx) {
        List<ASTNode> stmts = new ArrayList<>();
        if (ctx.statement() != null) {
            for (ControlFlowParser.StatementContext s : ctx.statement()) {
                ASTNode node = visit(s);
                if (node != null) stmts.add(node);
            }
        }
        return new ProgramNode(stmts);
    }

    @Override
    public ASTNode visitStatement(ControlFlowParser.StatementContext ctx) {
        // الـ statement بتفرع لحالتين، بنمرر الزيارة للنوع اللي جه منها
        if (ctx.matchedStatement() != null) return visit(ctx.matchedStatement());
        if (ctx.unmatchedStatement() != null) return visit(ctx.unmatchedStatement());
        return null;
    }

    // --- التعامل مع الـ IF-ELSE والـ FOR (Matched) ---
    @Override
    public ASTNode visitMatchedStatement(ControlFlowParser.MatchedStatementContext ctx) {
        // 1. حالة الـ IF-ELSE
        if (ctx.IF() != null) {
            String condition = ctx.expression().getText();
            // بما إنه matched، الـ then والـ else لازم يكونوا matched
            ASTNode thenBranch = visit(ctx.matchedStatement(0));
            ASTNode elseBranch = visit(ctx.matchedStatement(1));
            return new IfNode(condition, thenBranch, elseBranch);
        }
        
        // 2. حالة الـ FOR
        else if (ctx.FOR() != null) {
            ASTNode init = visit(ctx.assignmentStmt());
            String condition = ctx.expression().getText();
            ASTNode update = visit(ctx.assignment());
            // الـ body هنا "statement" عامة عشان تقبل nested if
            ASTNode body = visit(ctx.statement()); 
            return new ForNode(init, condition, update, body);
        }
        
        // 3. Block
        else if (ctx.block() != null) {
            return visit(ctx.block());
        }
        
        // 4. Assignment
        else if (ctx.assignmentStmt() != null) {
            return visit(ctx.assignmentStmt());
        }

        return null;
    }

    // --- التعامل مع الـ IF البسيطة أو المتداخلة (Unmatched) ---
    @Override
    public ASTNode visitUnmatchedStatement(ControlFlowParser.UnmatchedStatementContext ctx) {
        // الحالة الأولى: if (cond) statement (من غير else)
        if (ctx.matchedStatement() == null) {
            String condition = ctx.expression().getText();
            ASTNode thenBranch = visit(ctx.statement()); // زيارة الـ statement (سواء matched أو unmatched)
            return new IfNode(condition, thenBranch, null); // الـ else هنا null
        } 
        // الحالة الثانية: if (cond) matchedStatement ELSE unmatchedStatement (التداخل)
        else {
            String condition = ctx.expression().getText();
            ASTNode thenBranch = visit(ctx.matchedStatement());
            ASTNode elseBranch = visit(ctx.unmatchedStatement());
            return new IfNode(condition, thenBranch, elseBranch);
        }
    }

    @Override
    public ASTNode visitBlock(ControlFlowParser.BlockContext ctx) {
        List<ASTNode> stmts = new ArrayList<>();
        if (ctx.statement() != null) {
            for (ControlFlowParser.StatementContext s : ctx.statement()) {
                ASTNode node = visit(s);
                if (node != null) stmts.add(node);
            }
        }
        return new BlockNode(stmts);
    }

    @Override
    public ASTNode visitAssignmentStmt(ControlFlowParser.AssignmentStmtContext ctx) {
        return visit(ctx.assignment());
    }

    @Override
    public ASTNode visitAssignment(ControlFlowParser.AssignmentContext ctx) {
        String id = (ctx.ID() != null) ? ctx.ID().getText() : "unknown";
        
        // تم إضافة فحص هنا لمنع الـ NullPointerException
        String exprText = (ctx.expression() != null) ? ctx.expression().getText() : "";
        
        ExprNode expr = new ExprNode(exprText);
        return new AssignNode(id, expr);
    }
}