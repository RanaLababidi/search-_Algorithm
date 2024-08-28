package Models;

public class Node {
    Node parent;
    Board board;
    int depth;
    Movement movement;

    public Node(Node parent, Board board, int depth, Movement movement) {
        this.parent = parent;
        this.board = board;
        this.depth = depth;
        this.movement = movement;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }
}
