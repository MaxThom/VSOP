package Lexer;

/**
 * Represent a comment node. (* or *) with is position for errors
 */
public class CommentNode {
    public CommentType type;
    public int row;
    public int col;

    CommentNode(CommentType type, int row, int col) {
        this.type = type;
        this.row = row;
        this.col = col;
    }
}

