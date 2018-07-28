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
	 * Enter a parse tree produced by {@link PARSERParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(PARSERParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(PARSERParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(PARSERParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(PARSERParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(PARSERParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(PARSERParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#elseStat}.
	 * @param ctx the parse tree
	 */
	void enterElseStat(PARSERParser.ElseStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#elseStat}.
	 * @param ctx the parse tree
	 */
	void exitElseStat(PARSERParser.ElseStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(PARSERParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(PARSERParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#comparaiser}.
	 * @param ctx the parse tree
	 */
	void enterComparaiser(PARSERParser.ComparaiserContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#comparaiser}.
	 * @param ctx the parse tree
	 */
	void exitComparaiser(PARSERParser.ComparaiserContext ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(PARSERParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(PARSERParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVarType(PARSERParser.VarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVarType(PARSERParser.VarTypeContext ctx);
}