// Generated from CodeGeneration\CODE.g4 by ANTLR 4.7.1
package VSOP.CodeGeneration;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CODEParser}.
 */
public interface CODEListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CODEParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CODEParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CODEParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CODEParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CODEParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(CODEParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(CODEParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void enterClassDefinition(CODEParser.ClassDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void exitClassDefinition(CODEParser.ClassDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#methodDefinition}.
	 * @param ctx the parse tree
	 */
	void enterMethodDefinition(CODEParser.MethodDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#methodDefinition}.
	 * @param ctx the parse tree
	 */
	void exitMethodDefinition(CODEParser.MethodDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#formal}.
	 * @param ctx the parse tree
	 */
	void enterFormal(CODEParser.FormalContext ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#formal}.
	 * @param ctx the parse tree
	 */
	void exitFormal(CODEParser.FormalContext ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(CODEParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(CODEParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#callMethod}.
	 * @param ctx the parse tree
	 */
	void enterCallMethod(CODEParser.CallMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#callMethod}.
	 * @param ctx the parse tree
	 */
	void exitCallMethod(CODEParser.CallMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#singleCallMethod}.
	 * @param ctx the parse tree
	 */
	void enterSingleCallMethod(CODEParser.SingleCallMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#singleCallMethod}.
	 * @param ctx the parse tree
	 */
	void exitSingleCallMethod(CODEParser.SingleCallMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#caller}.
	 * @param ctx the parse tree
	 */
	void enterCaller(CODEParser.CallerContext ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#caller}.
	 * @param ctx the parse tree
	 */
	void exitCaller(CODEParser.CallerContext ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#callFunction}.
	 * @param ctx the parse tree
	 */
	void enterCallFunction(CODEParser.CallFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#callFunction}.
	 * @param ctx the parse tree
	 */
	void exitCallFunction(CODEParser.CallFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(CODEParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(CODEParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(CODEParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(CODEParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(CODEParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(CODEParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(CODEParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(CODEParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(CODEParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(CODEParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#elseStat}.
	 * @param ctx the parse tree
	 */
	void enterElseStat(CODEParser.ElseStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#elseStat}.
	 * @param ctx the parse tree
	 */
	void exitElseStat(CODEParser.ElseStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#let}.
	 * @param ctx the parse tree
	 */
	void enterLet(CODEParser.LetContext ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#let}.
	 * @param ctx the parse tree
	 */
	void exitLet(CODEParser.LetContext ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#newObj}.
	 * @param ctx the parse tree
	 */
	void enterNewObj(CODEParser.NewObjContext ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#newObj}.
	 * @param ctx the parse tree
	 */
	void exitNewObj(CODEParser.NewObjContext ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#binaryOperation}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOperation(CODEParser.BinaryOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#binaryOperation}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOperation(CODEParser.BinaryOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#expr1}.
	 * @param ctx the parse tree
	 */
	void enterExpr1(CODEParser.Expr1Context ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#expr1}.
	 * @param ctx the parse tree
	 */
	void exitExpr1(CODEParser.Expr1Context ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#expr2}.
	 * @param ctx the parse tree
	 */
	void enterExpr2(CODEParser.Expr2Context ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#expr2}.
	 * @param ctx the parse tree
	 */
	void exitExpr2(CODEParser.Expr2Context ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#expr3}.
	 * @param ctx the parse tree
	 */
	void enterExpr3(CODEParser.Expr3Context ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#expr3}.
	 * @param ctx the parse tree
	 */
	void exitExpr3(CODEParser.Expr3Context ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#expr4}.
	 * @param ctx the parse tree
	 */
	void enterExpr4(CODEParser.Expr4Context ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#expr4}.
	 * @param ctx the parse tree
	 */
	void exitExpr4(CODEParser.Expr4Context ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#expr5}.
	 * @param ctx the parse tree
	 */
	void enterExpr5(CODEParser.Expr5Context ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#expr5}.
	 * @param ctx the parse tree
	 */
	void exitExpr5(CODEParser.Expr5Context ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#expr6}.
	 * @param ctx the parse tree
	 */
	void enterExpr6(CODEParser.Expr6Context ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#expr6}.
	 * @param ctx the parse tree
	 */
	void exitExpr6(CODEParser.Expr6Context ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#expr7}.
	 * @param ctx the parse tree
	 */
	void enterExpr7(CODEParser.Expr7Context ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#expr7}.
	 * @param ctx the parse tree
	 */
	void exitExpr7(CODEParser.Expr7Context ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#expr8}.
	 * @param ctx the parse tree
	 */
	void enterExpr8(CODEParser.Expr8Context ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#expr8}.
	 * @param ctx the parse tree
	 */
	void exitExpr8(CODEParser.Expr8Context ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#termOperator}.
	 * @param ctx the parse tree
	 */
	void enterTermOperator(CODEParser.TermOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#termOperator}.
	 * @param ctx the parse tree
	 */
	void exitTermOperator(CODEParser.TermOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#factorOperator}.
	 * @param ctx the parse tree
	 */
	void enterFactorOperator(CODEParser.FactorOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#factorOperator}.
	 * @param ctx the parse tree
	 */
	void exitFactorOperator(CODEParser.FactorOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#comparatorOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparatorOperator(CODEParser.ComparatorOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#comparatorOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparatorOperator(CODEParser.ComparatorOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(CODEParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(CODEParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVarType(CODEParser.VarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVarType(CODEParser.VarTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CODEParser#varValue}.
	 * @param ctx the parse tree
	 */
	void enterVarValue(CODEParser.VarValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CODEParser#varValue}.
	 * @param ctx the parse tree
	 */
	void exitVarValue(CODEParser.VarValueContext ctx);
}