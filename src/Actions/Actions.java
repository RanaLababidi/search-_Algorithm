package Actions;
import Models.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Actions {
  static   List<Integer> shera = new ArrayList<> (Arrays.asList (10,21,27,38,44,55,61,72));
   static Movement dest = new Movement (10,true,true);
   static Movement beng = new Movement (24,true,true);
   static Movement shake = new Movement (6,false,true);
   static Movement bara = new Movement (12,false,true);
   static Movement doaq = new Movement (2,false,false);
   static Movement three = new Movement (3,false,false);
   static Movement four = new Movement (4,false,false);
   static Movement khal = new Movement (1,false,false);
   //list of all actions
    static ArrayList<Movement> movementArrayList = new ArrayList<> (Arrays.asList (dest,beng,shake,bara,doaq,three,four));
    //return false if you can't but pawn on shera because the enemy is on it
    public static boolean setOnShera(Pawn pawn,int movement,Board board){
        Player playerEnemy ;
        //next index
        int index =pawn.getPosition ()+movement;
            //if the current player is the 1 player
            if (pawn.getPlayer ().getPlayerNumber () == board.getPlayer1 ().getPlayerNumber ())
                playerEnemy = board.getPlayer2 ();
            //if the current player is the 2 player
            else
                playerEnemy = board.getPlayer1 ();

            for (Pawn pawn1 : playerEnemy.getPawnInBoard ()){
                if (pawn1.getPosition ()==index)
                    return false;
            }
            return true;
    }
    public void killing(Movement movement,Board board,Player player){


    }

    //can move (movement steps more than possible step, if can stand on shera?, )
    public static boolean checkMove(Board board,Movement movement, Pawn pawn){
        //الحركات الباقية للوصول للنهاية لضمان عدم الخرج من الرقعة
        if (83 - pawn.getPosition ()< movement.getSteps ())
                return false;
        //موقع الحجر الناتج عن الحركة
        int index = pawn.getPosition ()+movement.getSteps ();
        if (shera.contains (index)) {
            if (!setOnShera (pawn, movement.getSteps (), board))
                return false;
        }
       return true;
    }
    //return list of the  pawn that can move
    public static ArrayList<Pawn> getPossiblePawns (Board board,Movement movement,Player player){
        ArrayList<Pawn> possiblePawns = new ArrayList<> ();
        for (Pawn pawn : player.getPawnInBoard ()){
            if (checkMove (board,movement,pawn))
                possiblePawns.add (pawn);
        }
        return possiblePawns;
    }
    //random move
    public static Movement getMovement(){
        Random random =new Random ();
        int index = random.nextInt (7);
        return movementArrayList.get (index);
    }
    //allow the player to  play 10 time and store it in list
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

    //new board = copy board + moving
    public static Board move(Movement movement ,Pawn pawn ,Board board){
        ArrayList<Pawn> newPawnArrayList = new ArrayList<> ();
        Player player;
        Board newBoard;
        //copy new players to add it to the new copied node
        if (pawn.getPlayer ().getPlayerNumber ()==board.getPlayer1 ().getPlayerNumber ()){
            player = new Player (board.getPlayer1 ().getPawnInBoard (),1);
        }
        else {
            player = new Player (board.getPlayer2 ().getPawnInBoard (),2);
        }
        //copy pawns but with  the moved pawns change its position
        for (Pawn pawn1 : player.getPawnInBoard ()){
            Pawn newPawn = new Pawn (pawn1.getPosition (),pawn1.getPlayer ());
            if (newPawn.getPosition ()==pawn.getPosition ()) {
                newPawn.setPosition (newPawn.getPosition () + movement.getSteps ());
            }
            newPawnArrayList.add (newPawn);
        }
        player.setPawnInBoard (newPawnArrayList);

        if (player.getPlayerNumber ()==1)
            newBoard = new Board (player,board.getPlayer2 ());
        else
            newBoard  = new Board (board.getPlayer1 (),player);

        return newBoard;
    }

   //generate next Node fot the algo
    public static ArrayList<Node> getNextStates(Node node, Player player){
        ArrayList<Node> nextStates = new ArrayList<> ();
        for (Movement movement : movementArrayList) {
            ArrayList<Pawn> possiblePawns = getPossiblePawns (node.getBoard (),movement, player);
            for (Pawn pawn : possiblePawns){
                Board newBoard = move (movement,pawn,node.getBoard ());
                Node newNode = new Node (node,newBoard,node.getDepth ()+1,movement);
                nextStates.add (newNode);
            }
        }
        return nextStates;
    }

   // all pawn on board + all pawn in the end
    public static boolean isWin(Player player){
        if (player.getPawnInBoard ().size ()==4) {
            for (Pawn pawn : player.getPawnInBoard ()) {
                if (pawn.getPosition () != 83)
                    return false;
            }
            return true;
        }
            return false;
    }

    //add pawn to the player in the board
    public void addPawn(Player player){
        player.getPawnInBoard().add(new Pawn(0, player));
    }

}
