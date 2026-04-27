// Generated from grammar/ControlFlow.g4 by ANTLR 4.13.2

    package parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ControlFlowParser}.
 */
public interface ControlFlowListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ControlFlowParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ControlFlowParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ControlFlowParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ControlFlowParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ControlFlowParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ControlFlowParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ControlFlowParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ControlFlowParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ControlFlowParser#matchedStatement}.
	 * @param ctx the parse tree
	 */
	void enterMatchedStatement(ControlFlowParser.MatchedStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ControlFlowParser#matchedStatement}.
	 * @param ctx the parse tree
	 */
	void exitMatchedStatement(ControlFlowParser.MatchedStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ControlFlowParser#unmatchedStatement}.
	 * @param ctx the parse tree
	 */
	void enterUnmatchedStatement(ControlFlowParser.UnmatchedStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ControlFlowParser#unmatchedStatement}.
	 * @param ctx the parse tree
	 */
	void exitUnmatchedStatement(ControlFlowParser.UnmatchedStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ControlFlowParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ControlFlowParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ControlFlowParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ControlFlowParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ControlFlowParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(ControlFlowParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link ControlFlowParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(ControlFlowParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link ControlFlowParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(ControlFlowParser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ControlFlowParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(ControlFlowParser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ControlFlowParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(ControlFlowParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ControlFlowParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(ControlFlowParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ControlFlowParser#assignmentStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStmt(ControlFlowParser.AssignmentStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ControlFlowParser#assignmentStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStmt(ControlFlowParser.AssignmentStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ControlFlowParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ControlFlowParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ControlFlowParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ControlFlowParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ControlFlowParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(ControlFlowParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ControlFlowParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(ControlFlowParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ControlFlowParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpr(ControlFlowParser.EqualityExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ControlFlowParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpr(ControlFlowParser.EqualityExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ControlFlowParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(ControlFlowParser.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ControlFlowParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(ControlFlowParser.RelationalExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ControlFlowParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(ControlFlowParser.AdditiveExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ControlFlowParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(ControlFlowParser.AdditiveExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ControlFlowParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpr(ControlFlowParser.MultiplicativeExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ControlFlowParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpr(ControlFlowParser.MultiplicativeExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ControlFlowParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(ControlFlowParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ControlFlowParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(ControlFlowParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ControlFlowParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(ControlFlowParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ControlFlowParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(ControlFlowParser.PrimaryContext ctx);
}