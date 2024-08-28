package Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
Player player1 ;
Player player2 ;

String [] board =new String[83];


    public Board(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public String[] getBoard() {
        return board;
    }

    public void setBoard(String[] board) {
        this.board = board;
    }

    public void print(){
        List<Integer> shera = new ArrayList<> (Arrays.asList (10,21,27,38,44,55,61,72));
        for (int i=0 ;i<board.length;i++){
            board[i]=".";
            if (shera.contains (i))
                board[i]="X";
        }
        for (Pawn pawn : player1.getPawnInBoard ()){
            board[pawn.getPosition ()]="1";
        }
        for (Pawn pawn : player2.getPawnInBoard ()){
            board[pawn.getPosition ()]="2";
        }
        for (int i=0 ;i<board.length*2;i++){
            System.out.print ("_");
        }
        System.out.println ();
        for (int i=0 ;i<board.length;i++){
            System.out.print ("|"+board[i]);
        }
        System.out.println ();
        for (int i=0 ;i<board.length*2;i++){
            System.out.print ("-");
        }
    }
}
