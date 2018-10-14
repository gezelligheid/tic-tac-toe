import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

//read in moves
//show resulting board
//check rules
//congratulate winner
public class TTT{
  //design board bethod
  //method to print the current board
  // in each step ask user for coordinates 3 by 3 of move (while)
  // method checks if the move is legal
  // execute move on the board and see if it wins
  // end when wins or board is full
  // combine the methods to turn them into a game
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    final String p1 = "x";
    final String p2 = "o";
    String[] board = {"[ ] [ ] [ ]","[ ] [ ] [ ]","[ ] [ ] [ ]"};
    // showBoard(board);
    boolean gameOver = false;
    while (!gameOver){
      System.out.print("horizontal move 1-3:");
      int h = in.nextInt();
      System.out.println();
      System.out.print("vertical move 1-3:");
      int v = in.nextInt();
      System.out.println();
      if(isLegal(board,h,v)){

      };


      }
    showBoard(board);
  }
  public static void showBoard(String[] b){
    for (int i = 0; i < b.length; i++) {
      System.out.println(b[i]);
    }
  }
  public static boolean isLegal(String[] board, int h, int v){
    if (h>3 || h<1 || v>3 || v<1) {
      return false;
    }
    int sI = 1+(v-1)*4;
    return (board[h-1].substring(sI,sI+1).equals(" "));
  }
  public static void executeMove(String[] board, int h, int v){
    int sI = 1+(v-1)*4;
  }
  // public static boolean squareEmpty(String[] board, int h, int v){
  //   return (board[h-1].substring(1+(v-1)*3).equals(" "));
  //   }






}
