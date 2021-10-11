import java.util.Scanner;

import java.util.Random;

class Paintball implements TwoPlayerGame 
{ 
    //private static final TwoPlayerGame.Player Player1 = null;
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    
    int[] p1tiers;
    int[] p2tiers;
    
    int p1target;
    int p1move;
    int p1currentLoc;
    int p1guess;
    int p1score;
   
   
    int p2target;
    int p2move;
    int p2currentLoc;
    int p2guess;
    int p2score;

    int column = 5;
    int row = 3;

    int rounds = 0;

    String[][]board;
    
   
    
   
   
 
// empty constructor 
 public Paintball ()
 {
    board = new String [row][column];
    //player 1 side 
     board[0][0] = "O";
     board[0][1] = "O";
     board[0][2] = "O";
     board[0][3] = "O";
     board[0][4] = "O";
     
     //middle
     board[1][0] = " ";
     board[1][1] = " ";
     board[1][2] = " ";
     board[1][3] = " ";
     board[1][4] = " ";
    // player 2 side
     board[2][0] = "O";
     board[2][1] = "O";
     board[2][2] = "O";
     board[2][3] = "O";
     board[2][4] = "O";

    
    p1tiers = new int[5];
    p2tiers = new int[5];

    
    
 }

 
     
 // Player move method 
 

 

public void player1Move (){
    
    // asks player 1 for a target and a space to move
    System.out.print("PLayer 1: Choose target");
         p1target = scan.nextInt();
    System.out.print("Player 1: Choose A tier to move to");
        p1move = scan.nextInt();

        //executes player aim and move
          p1guess = p2tiers[p1target];
          p1currentLoc = p1tiers[p1move];

}
public void player2Move (){
    
    // asks player 2 (computer) to do the same as player1
    
    System.out.print("PLayer 2 turn:");
         p2target = rand.nextInt(p1tiers.length);
         p2move = rand.nextInt(p2tiers.length);

        //executes player aim and move
            p2guess = p1tiers[p2target];
            p2currentLoc = p2tiers[p2move];

            if(p1guess == p2currentLoc){
                p1score++;
            }
            if(p2guess == p1currentLoc){
                p2score++;
            }

}
 
public void playerMove(TwoPlayerGame.Player p) throws IllegalArgumentException {
   
    
        if( p.equals(TwoPlayerGame.Player.ONE))
        {
            player1Move();
        }
        else {
            player2Move();
        }


    }

     public void drawBoard()
    {
        for(int i=0; i< p2tiers.length; i++)
        {
        if( p1guess == p2move)
        {
            board[2][p1guess] = "!";
        }
        else if (p1guess != p2move){

            board[2][p2move] = "X";
            board[2][p1guess] = "<";
        }
        }

        for(int i=0; i< p1tiers.length;i++){
            if( p2guess == p1move)
        {
            board[0][p2guess] = "!";
        }
        else if (p2guess != p1move){

            board[0][p1move] = "X";
            board[2][p2guess] = "<";
        }

        }
        System.out.print(board);
        

        

        }



    

 


public boolean gameIsWon()
{
 
if( p1score > p2score){
     
     return true;
     
     }
     else  if(p2score > p1score){
        
        return true;
       
    }
    else{
        return false;
    }
}

 public void announceWinner()

{
    if( p1score > p2score){
        System.out.print("PLayer 1 is the winner");
    }
    else  if(p2score > p1score){
        System.out.print("PLayer 2 is the winner");

    }
}

}