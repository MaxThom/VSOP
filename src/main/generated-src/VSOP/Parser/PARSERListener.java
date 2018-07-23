// Generated from Parser\PARSER.g4 by ANTLR 4.7.1
package VSOP.Parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PARSERParser}.
 */
public interface PARSERListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PARSERParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PARSERParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PARSERParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PARSERParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PARSERParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(PARSERParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(PARSERParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(PARSERParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(PARSERParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(PARSERParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(PARSERParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(PARSERParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(PARSERParser.AddContext ctx);
}