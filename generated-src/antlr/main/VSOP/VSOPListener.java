// Generated from VSOP.g4 by ANTLR 4.7.1
package VSOP;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link VSOPParser}.
 */
public interface VSOPListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link VSOPParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(VSOPParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link VSOPParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(VSOPParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link VSOPParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(VSOPParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link VSOPParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(VSOPParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link VSOPParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(VSOPParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link VSOPParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(VSOPParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link VSOPParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(VSOPParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link VSOPParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(VSOPParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link VSOPParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(VSOPParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link VSOPParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(VSOPParser.AddContext ctx);
}