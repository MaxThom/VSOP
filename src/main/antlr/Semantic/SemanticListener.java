package Semantic;

import VSOP.Semantic.SEMANTICBaseListener;

import java.util.HashMap;
import java.util.Map;

import static VSOP.Semantic.SEMANTICParser.*;

public class SemanticListener extends SEMANTICBaseListener {

    private Map<String, Integer> variables;
    private String fileName;
    public String treeOuput;

    public Boolean lexicalError = false;

    public SemanticListener(String fileName) {
        variables = new HashMap<>();
        this.fileName = fileName;
        treeOuput = "";
    }

    @Override
    public void exitProgram(ProgramContext ctx) {
        StringBuilder output = new StringBuilder();
        System.out.println("SEMANTIC");
    }



    private StringBuilder handleClass(ClassDefinitionContext classDef) {
        StringBuilder output = new StringBuilder();

        return output;
    }

    private StringBuilder handleField(FieldContext field) {
        StringBuilder output = new StringBuilder();

        return output;
    }

    private StringBuilder handleMethod(MethodDefinitionContext method) {
        StringBuilder output = new StringBuilder();

        return output;
    }

    private StringBuilder handleBlock(BlockContext block) {
        StringBuilder output = new StringBuilder();

        return output;
    }

    private StringBuilder handleStatement(StatementContext statement) {
        StringBuilder output = new StringBuilder();

        return output;
    }

    private StringBuilder handleIfStatement(IfStatementContext ifStatement) {
        StringBuilder output = new StringBuilder();

        return output;
    }

    private StringBuilder handleWhileStatement(WhileStatementContext whileStatement) {
        StringBuilder output = new StringBuilder();


        return output;
    }

    private StringBuilder handleAssign(AssignContext assign) {
        StringBuilder output = new StringBuilder();

        return output;
    }

    private StringBuilder handleLet(LetContext let) {
        StringBuilder output = new StringBuilder();


        output.append(")");
        return output;
    }

    private StringBuilder handleUnOperation(UnOperationContext unOp) {
        StringBuilder output = new StringBuilder();

        return output;
    }

    private StringBuilder handleNewObj(NewObjContext obj) {
        StringBuilder output = new StringBuilder();

        return output;
    }

    private StringBuilder handleCallMethod(CallMethodContext call) {
        StringBuilder output = new StringBuilder();

        return output;
    }

    private StringBuilder handleSingleCallMethod(SingleCallMethodContext singleCall) {
        StringBuilder output = new StringBuilder();

        return output;
    }

    private StringBuilder handleCallFunction(CallFunctionContext callFunc) {
        StringBuilder output = new StringBuilder();

        return output;
    }

    private StringBuilder handleCaller(CallerContext caller) {
        StringBuilder output = new StringBuilder();

        return output;
    }

    private StringBuilder handleArgument(ArgumentContext arg) {
        StringBuilder output = new StringBuilder();

        return output;
    }

    private StringBuilder handleBinaryOperation(BinaryOperationContext binOp) {
        StringBuilder output = new StringBuilder();

        return output;
    }

    private StringBuilder handleCondition(ConditionContext cond) {
        StringBuilder output = new StringBuilder();

        return output;
    }

    private StringBuilder handleTerm(TermContext term) {
        StringBuilder output = new StringBuilder();

        return output;
    }

    private StringBuilder handleFactor(FactorContext factor) {
        StringBuilder output = new StringBuilder();

        return output;
    }

    private StringBuilder handleValue(ValueContext value) {
        StringBuilder output = new StringBuilder();

        return output;
    }
}
