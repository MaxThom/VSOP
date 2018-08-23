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
	 * Enter a parse tree produced by {@link PARSERParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(PARSERParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(PARSERParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void enterClassDefinition(PARSERParser.ClassDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void exitClassDefinition(PARSERParser.ClassDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#methodDefinition}.
	 * @param ctx the parse tree
	 */
	void enterMethodDefinition(PARSERParser.MethodDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#methodDefinition}.
	 * @param ctx the parse tree
	 */
	void exitMethodDefinition(PARSERParser.MethodDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#formal}.
	 * @param ctx the parse tree
	 */
	void enterFormal(PARSERParser.FormalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#formal}.
	 * @param ctx the parse tree
	 */
	void exitFormal(PARSERParser.FormalContext ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(PARSERParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(PARSERParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#callMethod}.
	 * @param ctx the parse tree
	 */
	void enterCallMethod(PARSERParser.CallMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#callMethod}.
	 * @param ctx the parse tree
	 */
	void exitCallMethod(PARSERParser.CallMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#singleCallMethod}.
	 * @param ctx the parse tree
	 */
	void enterSingleCallMethod(PARSERParser.SingleCallMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#singleCallMethod}.
	 * @param ctx the parse tree
	 */
	void exitSingleCallMethod(PARSERParser.SingleCallMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#caller}.
	 * @param ctx the parse tree
	 */
	void enterCaller(PARSERParser.CallerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#caller}.
	 * @param ctx the parse tree
	 */
	void exitCaller(PARSERParser.CallerContext ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#callFunction}.
	 * @param ctx the parse tree
	 */
	void enterCallFunction(PARSERParser.CallFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#callFunction}.
	 * @param ctx the parse tree
	 */
	void exitCallFunction(PARSERParser.CallFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(PARSERParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(PARSERParser.ArgumentContext ctx);
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
	 * Enter a parse tree produced by {@link PARSERParser#let}.
	 * @param ctx the parse tree
	 */
	void enterLet(PARSERParser.LetContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#let}.
	 * @param ctx the parse tree
	 */
	void exitLet(PARSERParser.LetContext ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#newObj}.
	 * @param ctx the parse tree
	 */
	void enterNewObj(PARSERParser.NewObjContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#newObj}.
	 * @param ctx the parse tree
	 */
	void exitNewObj(PARSERParser.NewObjContext ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#binaryOperation}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOperation(PARSERParser.BinaryOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#binaryOperation}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOperation(PARSERParser.BinaryOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#expr1}.
	 * @param ctx the parse tree
	 */
	void enterExpr1(PARSERParser.Expr1Context ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#expr1}.
	 * @param ctx the parse tree
	 */
	void exitExpr1(PARSERParser.Expr1Context ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#exprOr}.
	 * @param ctx the parse tree
	 */
	void enterExprOr(PARSERParser.ExprOrContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#exprOr}.
	 * @param ctx the parse tree
	 */
	void exitExprOr(PARSERParser.ExprOrContext ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#expr2}.
	 * @param ctx the parse tree
	 */
	void enterExpr2(PARSERParser.Expr2Context ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#expr2}.
	 * @param ctx the parse tree
	 */
	void exitExpr2(PARSERParser.Expr2Context ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#expr3}.
	 * @param ctx the parse tree
	 */
	void enterExpr3(PARSERParser.Expr3Context ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#expr3}.
	 * @param ctx the parse tree
	 */
	void exitExpr3(PARSERParser.Expr3Context ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#expr4}.
	 * @param ctx the parse tree
	 */
	void enterExpr4(PARSERParser.Expr4Context ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#expr4}.
	 * @param ctx the parse tree
	 */
	void exitExpr4(PARSERParser.Expr4Context ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#expr5}.
	 * @param ctx the parse tree
	 */
	void enterExpr5(PARSERParser.Expr5Context ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#expr5}.
	 * @param ctx the parse tree
	 */
	void exitExpr5(PARSERParser.Expr5Context ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#expr6}.
	 * @param ctx the parse tree
	 */
	void enterExpr6(PARSERParser.Expr6Context ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#expr6}.
	 * @param ctx the parse tree
	 */
	void exitExpr6(PARSERParser.Expr6Context ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#expr7}.
	 * @param ctx the parse tree
	 */
	void enterExpr7(PARSERParser.Expr7Context ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#expr7}.
	 * @param ctx the parse tree
	 */
	void exitExpr7(PARSERParser.Expr7Context ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#expr8}.
	 * @param ctx the parse tree
	 */
	void enterExpr8(PARSERParser.Expr8Context ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#expr8}.
	 * @param ctx the parse tree
	 */
	void exitExpr8(PARSERParser.Expr8Context ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#termOperator}.
	 * @param ctx the parse tree
	 */
	void enterTermOperator(PARSERParser.TermOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#termOperator}.
	 * @param ctx the parse tree
	 */
	void exitTermOperator(PARSERParser.TermOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#factorOperator}.
	 * @param ctx the parse tree
	 */
	void enterFactorOperator(PARSERParser.FactorOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#factorOperator}.
	 * @param ctx the parse tree
	 */
	void exitFactorOperator(PARSERParser.FactorOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PARSERParser#comparatorOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparatorOperator(PARSERParser.ComparatorOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#comparatorOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparatorOperator(PARSERParser.ComparatorOperatorContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link PARSERParser#varValue}.
	 * @param ctx the parse tree
	 */
	void enterVarValue(PARSERParser.VarValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PARSERParser#varValue}.
	 * @param ctx the parse tree
	 */
	void exitVarValue(PARSERParser.VarValueContext ctx);
}