import java.util.Scanner;

class Game {
    char[] board;
    char currentPlayer;

    Game() {
	board = new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' '};
	currentPlayer = 'X';
    }
    void printBoard() {
	System.out.println();
	System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
	System.out.println("--+---+--");
	System.out.println(board[3] + " | " + board[4] + " | " + board[5]);	
	System.out.println("--+---+--");
	System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
	System.out.println();
    }
    
    boolean isDraw() {
	for (char c : board){
	   if (c == ' ') return false;
        }
	return true;
    } 
    
    boolean checkWin() {
    int[][] winPatterns = {
        {0,1,2},{3,4,5},{6,7,8},
        {0,3,6},{1,4,7},{2,5,8},
        {0,4,8},{2,4,6}
    };

    for (int[] p : winPatterns) {
        if (board[p[0]] == currentPlayer &&
            board[p[1]] == currentPlayer &&
            board[p[2]] == currentPlayer) {
            return true;
        }
    }
    return false;
}
    void switchPlayer() {
       if (currentPlayer == 'X')
           currentPlayer = 'O';
       else
           currentPlayer = 'X';
    }
}

public class TicTacToe {
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	Game game = new Game();

	boolean running = true;
        while (running) {
	   game.printBoard();

	   System.out.println("Player" + game.currentPlayer + ",enter position (1-9):");
           int pos = sc.nextInt() - 1;

           if (pos < 0 || pos > 8 || game.board[pos] !=' ') {
               System.out.println("Invalid move! Try again.");
               continue;
           }
    
           game.board[pos] = game.currentPlayer;

           if (game.checkWin()) {
               game.printBoard();
               System.out.println("Player " + game.currentPlayer + "wins!");
               running = false;
           } else if (game.isDraw()) {
               game.printBoard();
               System.out.println("it's a draw!");
               running = false;
           } else {
               game.switchPlayer();
         
           }
        }
         
        sc.close();
    }
}