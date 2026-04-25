// Generated from grammar/ControlFlow.g4 by ANTLR 4.13.2

    package parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ControlFlowParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ControlFlowVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ControlFlowParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ControlFlowParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link ControlFlowParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(ControlFlowParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ControlFlowParser#matchedStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchedStatement(ControlFlowParser.MatchedStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ControlFlowParser#unmatchedStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnmatchedStatement(ControlFlowParser.UnmatchedStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ControlFlowParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(ControlFlowParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ControlFlowParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(ControlFlowParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ControlFlowParser#assignmentStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStmt(ControlFlowParser.AssignmentStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ControlFlowParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ControlFlowParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ControlFlowParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(ControlFlowParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ControlFlowParser#equalityExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(ControlFlowParser.EqualityExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ControlFlowParser#relationalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(ControlFlowParser.RelationalExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ControlFlowParser#additiveExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(ControlFlowParser.AdditiveExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ControlFlowParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpr(ControlFlowParser.MultiplicativeExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ControlFlowParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(ControlFlowParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ControlFlowParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(ControlFlowParser.PrimaryContext ctx);
}