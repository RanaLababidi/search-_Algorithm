package com.company;
import Models.Board;
import Models.Movement;
import Models.Pawn;
import Models.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    static Movement dest = new Movement (10,true,true);
    static Movement beng = new Movement (24,true,true);
    static Movement shake = new Movement (6,false,true);
    static Movement bara = new Movement (12,false,true);
    static Movement doaq = new Movement (2,false,false);
    static Movement three = new Movement (3,false,false);
    static Movement four = new Movement (4,false,false);
    static Movement khal = new Movement (1,false,false);

    static ArrayList<Movement> movementArrayList = new ArrayList<> (Arrays.asList (dest,beng,shake,bara,doaq,three,four));
    public static void main(String[] args) {
        // safe zone
        //75->81
        //0->7
//for (Movement movement : myTern ()){
//    System.out.println (movement.getSteps ());
        Player player1 = new Player (1);
        Player player2 = new Player (2);
        Pawn pawn1 = new Pawn (5,player1);
        Pawn pawn2 = new Pawn (25,player2);
        player1.getPawnInBoard ().add (pawn1);
        player2.getPawnInBoard ().add (pawn2);
        Board board = new Board (player1,player2);
        board.print ();
}

    private static ArrayList<Movement> myTernHelper(int count,ArrayList<Movement> ternList){
        if (count==10)
            return ternList;

        Movement movement = getMovement ();
        ternList.add (movement);
        if (movement.isKhal ())
            ternList.add (khal);

        if (movement.isPlayAgain ())
            myTernHelper (count++,ternList);

        return ternList;

    }

    public static ArrayList<Movement> myTern(){
        return myTernHelper (1,new ArrayList<> ());
    }
    public static Movement getMovement(){
        Random random =new Random ();
        int index = random.nextInt (7);
        return movementArrayList.get (index);
    }
    }

//   public static void print(ArrayList player1)  {
//       ArrayList<String> speace = new ArrayList<> ();
//
//       for (int i =0 ;i<8*3;i++){
//           speace .add (" ");
//       }
//       for (int i =0 ;i<speace.size ();i++){
//           if (i%3==0)
//               System.out.println ();
//           System.out.print (speace.get (i));
//       }
//        for (int i = 0; i < player1.size (); i++) {
//
//            if (i%3==0)
//                System.out.println ();
//            System.out.print (player1.get (i));
//        }
//    }


