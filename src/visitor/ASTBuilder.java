package visitor;

import parser.*;
import java.util.ArrayList;
import java.util.List;

public class ASTBuilder extends ControlFlowBaseVisitor<ASTNode> {

    @Override
    public ASTNode visitProgram(ControlFlowParser.ProgramContext ctx) {
        List<ASTNode> stmts = new ArrayList<>();

        for (ControlFlowParser.StatementContext s : ctx.statement()) {
            ASTNode node = visit(s);
            if (node != null) stmts.add(node);
        }

        return new ProgramNode(stmts);
    }

    @Override
    public ASTNode visitStatement(ControlFlowParser.StatementContext ctx) {
        if (ctx.matchedStatement() != null) return visit(ctx.matchedStatement());
        if (ctx.unmatchedStatement() != null) return visit(ctx.unmatchedStatement());
        return null;
    }

    @Override
    public ASTNode visitMatchedStatement(ControlFlowParser.MatchedStatementContext ctx) {

        if (ctx.IF() != null) {
            ExprNode condition = new ExprNode(ctx.expression().getText());

            ASTNode thenBranch = visit(ctx.matchedStatement(0));
            ASTNode elseBranch = visit(ctx.matchedStatement(1));

            return new IfNode(condition.toString(), thenBranch, elseBranch);
        }

  else if (ctx.FOR() != null) {

    ASTNode init = visit(ctx.forInit());

    ExprNode condition = new ExprNode(ctx.expression().getText());

    ASTNode update = visit(ctx.forUpdate());

    ASTNode body = visit(ctx.statement());

    return new ForNode(init, condition.toString(), update, body);
}

        else if (ctx.block() != null) {
            return visit(ctx.block());
        }

        else if (ctx.assignmentStmt() != null) {
            return visit(ctx.assignmentStmt());
        }

        return null;
    }

    @Override
    public ASTNode visitUnmatchedStatement(ControlFlowParser.UnmatchedStatementContext ctx) {

        if (ctx.matchedStatement() == null) {
            ExprNode condition = new ExprNode(ctx.expression().getText());
            ASTNode thenBranch = visit(ctx.statement());
            return new IfNode(condition.toString(), thenBranch, null);
        }

        else {
            ExprNode condition = new ExprNode(ctx.expression().getText());
            ASTNode thenBranch = visit(ctx.matchedStatement());
            ASTNode elseBranch = visit(ctx.unmatchedStatement());

            return new IfNode(condition.toString(), thenBranch, elseBranch);
        }
    }

    @Override
    public ASTNode visitBlock(ControlFlowParser.BlockContext ctx) {
        List<ASTNode> stmts = new ArrayList<>();

        for (ControlFlowParser.StatementContext s : ctx.statement()) {
            ASTNode node = visit(s);
            if (node != null) stmts.add(node);
        }

        return new BlockNode(stmts);
    }

    @Override
    public ASTNode visitAssignmentStmt(ControlFlowParser.AssignmentStmtContext ctx) {
        return visit(ctx.assignment());
    }

    @Override
    public ASTNode visitAssignment(ControlFlowParser.AssignmentContext ctx) {

        String id = ctx.ID().getText();
        ExprNode expr = new ExprNode(ctx.expression().getText());

        return new AssignNode(id, expr);
    }
}