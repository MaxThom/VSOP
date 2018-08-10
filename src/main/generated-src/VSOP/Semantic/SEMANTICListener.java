// Generated from Semantic\SEMANTIC.g4 by ANTLR 4.7.1
package VSOP.Semantic;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SEMANTICParser}.
 */
public interface SEMANTICListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SEMANTICParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SEMANTICParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SEMANTICParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SEMANTICParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SEMANTICParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SEMANTICParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void enterClassDefinition(SEMANTICParser.ClassDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void exitClassDefinition(SEMANTICParser.ClassDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#methodDefinition}.
	 * @param ctx the parse tree
	 */
	void enterMethodDefinition(SEMANTICParser.MethodDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#methodDefinition}.
	 * @param ctx the parse tree
	 */
	void exitMethodDefinition(SEMANTICParser.MethodDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#formal}.
	 * @param ctx the parse tree
	 */
	void enterFormal(SEMANTICParser.FormalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#formal}.
	 * @param ctx the parse tree
	 */
	void exitFormal(SEMANTICParser.FormalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(SEMANTICParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(SEMANTICParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#callMethod}.
	 * @param ctx the parse tree
	 */
	void enterCallMethod(SEMANTICParser.CallMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#callMethod}.
	 * @param ctx the parse tree
	 */
	void exitCallMethod(SEMANTICParser.CallMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#singleCallMethod}.
	 * @param ctx the parse tree
	 */
	void enterSingleCallMethod(SEMANTICParser.SingleCallMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#singleCallMethod}.
	 * @param ctx the parse tree
	 */
	void exitSingleCallMethod(SEMANTICParser.SingleCallMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#caller}.
	 * @param ctx the parse tree
	 */
	void enterCaller(SEMANTICParser.CallerContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#caller}.
	 * @param ctx the parse tree
	 */
	void exitCaller(SEMANTICParser.CallerContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#callFunction}.
	 * @param ctx the parse tree
	 */
	void enterCallFunction(SEMANTICParser.CallFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#callFunction}.
	 * @param ctx the parse tree
	 */
	void exitCallFunction(SEMANTICParser.CallFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(SEMANTICParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(SEMANTICParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(SEMANTICParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(SEMANTICParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(SEMANTICParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(SEMANTICParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(SEMANTICParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(SEMANTICParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(SEMANTICParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(SEMANTICParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#elseStat}.
	 * @param ctx the parse tree
	 */
	void enterElseStat(SEMANTICParser.ElseStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#elseStat}.
	 * @param ctx the parse tree
	 */
	void exitElseStat(SEMANTICParser.ElseStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#let}.
	 * @param ctx the parse tree
	 */
	void enterLet(SEMANTICParser.LetContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#let}.
	 * @param ctx the parse tree
	 */
	void exitLet(SEMANTICParser.LetContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#newObj}.
	 * @param ctx the parse tree
	 */
	void enterNewObj(SEMANTICParser.NewObjContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#newObj}.
	 * @param ctx the parse tree
	 */
	void exitNewObj(SEMANTICParser.NewObjContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#binaryOperation}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOperation(SEMANTICParser.BinaryOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#binaryOperation}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOperation(SEMANTICParser.BinaryOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#expr1}.
	 * @param ctx the parse tree
	 */
	void enterExpr1(SEMANTICParser.Expr1Context ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#expr1}.
	 * @param ctx the parse tree
	 */
	void exitExpr1(SEMANTICParser.Expr1Context ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#expr2}.
	 * @param ctx the parse tree
	 */
	void enterExpr2(SEMANTICParser.Expr2Context ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#expr2}.
	 * @param ctx the parse tree
	 */
	void exitExpr2(SEMANTICParser.Expr2Context ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#expr3}.
	 * @param ctx the parse tree
	 */
	void enterExpr3(SEMANTICParser.Expr3Context ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#expr3}.
	 * @param ctx the parse tree
	 */
	void exitExpr3(SEMANTICParser.Expr3Context ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#expr4}.
	 * @param ctx the parse tree
	 */
	void enterExpr4(SEMANTICParser.Expr4Context ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#expr4}.
	 * @param ctx the parse tree
	 */
	void exitExpr4(SEMANTICParser.Expr4Context ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#expr5}.
	 * @param ctx the parse tree
	 */
	void enterExpr5(SEMANTICParser.Expr5Context ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#expr5}.
	 * @param ctx the parse tree
	 */
	void exitExpr5(SEMANTICParser.Expr5Context ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#expr6}.
	 * @param ctx the parse tree
	 */
	void enterExpr6(SEMANTICParser.Expr6Context ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#expr6}.
	 * @param ctx the parse tree
	 */
	void exitExpr6(SEMANTICParser.Expr6Context ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#expr7}.
	 * @param ctx the parse tree
	 */
	void enterExpr7(SEMANTICParser.Expr7Context ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#expr7}.
	 * @param ctx the parse tree
	 */
	void exitExpr7(SEMANTICParser.Expr7Context ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#expr8}.
	 * @param ctx the parse tree
	 */
	void enterExpr8(SEMANTICParser.Expr8Context ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#expr8}.
	 * @param ctx the parse tree
	 */
	void exitExpr8(SEMANTICParser.Expr8Context ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#termOperator}.
	 * @param ctx the parse tree
	 */
	void enterTermOperator(SEMANTICParser.TermOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#termOperator}.
	 * @param ctx the parse tree
	 */
	void exitTermOperator(SEMANTICParser.TermOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#factorOperator}.
	 * @param ctx the parse tree
	 */
	void enterFactorOperator(SEMANTICParser.FactorOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#factorOperator}.
	 * @param ctx the parse tree
	 */
	void exitFactorOperator(SEMANTICParser.FactorOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#comparatorOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparatorOperator(SEMANTICParser.ComparatorOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#comparatorOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparatorOperator(SEMANTICParser.ComparatorOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(SEMANTICParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(SEMANTICParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVarType(SEMANTICParser.VarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVarType(SEMANTICParser.VarTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SEMANTICParser#varValue}.
	 * @param ctx the parse tree
	 */
	void enterVarValue(SEMANTICParser.VarValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SEMANTICParser#varValue}.
	 * @param ctx the parse tree
	 */
	void exitVarValue(SEMANTICParser.VarValueContext ctx);
}