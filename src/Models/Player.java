package Models;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    String [] board =new String[83];
    List<Pawn> pawnInBoard = new ArrayList<> ();

    int playerNumber;

    List<Integer> safe = new ArrayList<> (Arrays.asList (0,1,2,3,4,5,6,82,81,80,79,78,77,76,10,21,27,38,44,55,61,72));

    public Player(int playerNumber) {

        this.playerNumber = playerNumber;
    }

    public Player( List<Pawn> pawnInBoard,int playerNumber ) {
       // this.arrayList = arrayList;
        this.pawnInBoard = pawnInBoard;
        this.playerNumber = playerNumber;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String[] getBoard() {
        return board;
    }

    public void setBoard(String[] board) {
        this.board = board;
    }

    public List<Pawn> getPawnInBoard() {
        return pawnInBoard;
    }

    public void setPawnInBoard(List<Pawn> pawnInBoard) {
        this.pawnInBoard = pawnInBoard;
    }

}
