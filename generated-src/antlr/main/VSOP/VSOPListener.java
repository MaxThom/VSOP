// Generated from VSOP.g4 by ANTLR 4.7.1
package me.VSOP;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link VSOPParser}.
 */
public interface VSOPListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link VSOPParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(VSOPParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link VSOPParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(VSOPParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link VSOPParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(VSOPParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link VSOPParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(VSOPParser.NameContext ctx);
}