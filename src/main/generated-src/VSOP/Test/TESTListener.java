// Generated from Test\TEST.g4 by ANTLR 4.7.1
package VSOP.Test;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TESTParser}.
 */
public interface TESTListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TESTParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(TESTParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link TESTParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(TESTParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link TESTParser#binaryOperation}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOperation(TESTParser.BinaryOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TESTParser#binaryOperation}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOperation(TESTParser.BinaryOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TESTParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(TESTParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TESTParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(TESTParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TESTParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(TESTParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link TESTParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(TESTParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link TESTParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(TESTParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TESTParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(TESTParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link TESTParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(TESTParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TESTParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(TESTParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link TESTParser#unOperation}.
	 * @param ctx the parse tree
	 */
	void enterUnOperation(TESTParser.UnOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TESTParser#unOperation}.
	 * @param ctx the parse tree
	 */
	void exitUnOperation(TESTParser.UnOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TESTParser#newObj}.
	 * @param ctx the parse tree
	 */
	void enterNewObj(TESTParser.NewObjContext ctx);
	/**
	 * Exit a parse tree produced by {@link TESTParser#newObj}.
	 * @param ctx the parse tree
	 */
	void exitNewObj(TESTParser.NewObjContext ctx);
	/**
	 * Enter a parse tree produced by {@link TESTParser#unOperator}.
	 * @param ctx the parse tree
	 */
	void enterUnOperator(TESTParser.UnOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TESTParser#unOperator}.
	 * @param ctx the parse tree
	 */
	void exitUnOperator(TESTParser.UnOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link TESTParser#termOperator}.
	 * @param ctx the parse tree
	 */
	void enterTermOperator(TESTParser.TermOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TESTParser#termOperator}.
	 * @param ctx the parse tree
	 */
	void exitTermOperator(TESTParser.TermOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link TESTParser#comparaiser}.
	 * @param ctx the parse tree
	 */
	void enterComparaiser(TESTParser.ComparaiserContext ctx);
	/**
	 * Exit a parse tree produced by {@link TESTParser#comparaiser}.
	 * @param ctx the parse tree
	 */
	void exitComparaiser(TESTParser.ComparaiserContext ctx);
	/**
	 * Enter a parse tree produced by {@link TESTParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(TESTParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link TESTParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(TESTParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link TESTParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVarType(TESTParser.VarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TESTParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVarType(TESTParser.VarTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TESTParser#varValue}.
	 * @param ctx the parse tree
	 */
	void enterVarValue(TESTParser.VarValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TESTParser#varValue}.
	 * @param ctx the parse tree
	 */
	void exitVarValue(TESTParser.VarValueContext ctx);
}