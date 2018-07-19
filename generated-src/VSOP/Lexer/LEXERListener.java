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
	 * Enter a parse tree produced by {@link LEXERParser#keyword}.
	 * @param ctx the parse tree
	 */
	void enterKeyword(LEXERParser.KeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link LEXERParser#keyword}.
	 * @param ctx the parse tree
	 */
	void exitKeyword(LEXERParser.KeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link LEXERParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(LEXERParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LEXERParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(LEXERParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LEXERParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(LEXERParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LEXERParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(LEXERParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link LEXERParser#objectIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterObjectIdentifier(LEXERParser.ObjectIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link LEXERParser#objectIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitObjectIdentifier(LEXERParser.ObjectIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link LEXERParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdentifier(LEXERParser.TypeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link LEXERParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdentifier(LEXERParser.TypeIdentifierContext ctx);
}