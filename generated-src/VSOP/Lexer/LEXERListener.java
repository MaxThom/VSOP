// Generated from Lexer\LEXER.g4 by ANTLR 4.7.1
package VSOP.Lexer;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LEXERParser}.
 */
public interface LEXERListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LEXERParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LEXERParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LEXERParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LEXERParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link LEXERParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(LEXERParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LEXERParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(LEXERParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LEXERParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(LEXERParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link LEXERParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(LEXERParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link LEXERParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(LEXERParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link LEXERParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(LEXERParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link LEXERParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(LEXERParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link LEXERParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(LEXERParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link LEXERParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(LEXERParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link LEXERParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(LEXERParser.AddContext ctx);
}