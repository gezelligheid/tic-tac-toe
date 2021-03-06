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
    int round = 1;
    String currentPlayer = p1;
    while (!gameOver){
      showBoard(board);
      // determine player by round
      currentPlayer = (round % 2 == 0) ? p1 : p2;
      // ask player for move
      System.out.print("horizontal move 1-3:");
      int h = in.nextInt();
      System.out.println();
      System.out.print("vertical move 1-3:");
      int v = in.nextInt();
      System.out.println();

      if(isLegal(board,h,v)){
        executeMove(board, h, v, currentPlayer);
        if (checkWinner(board, currentPlayer)) break;
        round++;
        if (round == 10) {
          System.out.println("game ended in tie");
          break;
        }
      }else System.out.println("ilegal move, please reevaluate it");


      }
    showBoard(board);
  }
  public static void showBoard(String[] b){
    for (int i = 0; i < b.length; i++) {
      System.out.println(b[i]);
    }
  }
  public static boolean isLegal(String[] board, int h, int v){
    // checks if move is on board
    if (h>3 || h<1 || v>3 || v<1) {
      return false;
    }
    int sI = 1+(h-1)*4;
    // checks if square at string index is filled
    return (board[v-1].substring(sI,sI+1).equals(" "));
  }
  public static void executeMove(String[] board, int h, int v, String player){
    int sI = 1+(h-1)*4;
    board[v-1] = board[v-1].substring(0,sI) + player + board[v-1].substring(sI + 1, board[1].length());
  }
  public static boolean checkWinner(String[] board, String currentPlayer){
    String winMessage = "player " + currentPlayer + " wins!";
    // check diagonal
    if ((Character.isLetter(board[1].charAt(5))) && ((board[0].charAt(1) == board[1].charAt(5) && board[1].charAt(5) == board[2].charAt(9))||
        (board[2].charAt(1) == board[1].charAt(5) && board[1].charAt(5) == board[0].charAt(9)))) {
          System.out.println(winMessage);
          return true;
    }
    // check horizontal
    for (int i = 0; i < board.length; i++) {
      if (Character.isLetter(board[i].charAt(1)) &&
          (board[i].charAt(1) == board[i].charAt(5) && board[i].charAt(5) == board[i].charAt(9))) {
            System.out.println(winMessage);
            return true;
      }
      if (Character.isLetter(board[0].charAt(1 + 4*i)) &&
          (board[0].charAt(1 + 4*i) == board[1].charAt(1 + 4*i) &&
          board[1].charAt(1 + 4*i) == board[2].charAt(1 + 4*i))) {
            System.out.println(winMessage);
            return true;
      }
    }

    return false;
  }






}
