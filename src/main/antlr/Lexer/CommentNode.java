package Lexer;

public class CommentNode {
    public CommentType type;
    public int row;
    public int col;

    CommentNode(CommentType type, int row, int col) {
        this.type = type;
        this.row = row;
        this.col = col;
    }

    CommentNode(String type, int row, int col) {
        this.row = row;
        this.col = col;

        if (type.equals("(*"))
            this.type = CommentType.OPEN;
        else if (type.equals("*)"))
            this.type = CommentType.CLOSE;
    }

}

