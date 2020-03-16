/*
1.  clearBoard:
Did I use the correct method definition?
Mark out of 5:5
Comment:used name according to function
Did I use loops to set each position to the BLANK character?
Mark out of 5:5
Comment:used loops
   2.  printBoard
Did I use the correct method definition?
Mark out of 5:5
Comment:used name according to function
Did I loop through the array and prints out the board in a way that it looked like a board?
Mark out of 5:5
Comment:3 by 3 table printed
   3.  canMakeMove
Did I have the correct function definition and returned the correct item?
Mark out of 5:5
Comment:boolean true if can make move
Did I check if a specified location was BLANK?
Mark out of 5:5
Comment:true for blank
   4.  makeMove
Did I have the correct function definition?
Mark out of 5:5
Comment:used name according to function
Did I set the  currentPlayerPiece in the specified location?
Mark out of 5:5
Comment:    piece placed in correct position
   5.  isBoardFull
Did I have the correct function definition and returned the correct item?
Mark out of 5:5
Comment:       used name according to function, boolean return type 
Did I loop through the board to check if there are any BLANK characters?
Mark out of 5:5
Comment:yes
   6.  winner
Did I have the correct function definition and returned the winning character
Mark out of 5:5
Comment:     used name according to function, return winning character
Did I identify all possible horizontal, vertical and diagonal winners  
Mark out of 15:10
Comment: I identified all 8 possible wins in the code, however my program seems to ignore some of the wins.
   7.main

Did I create a board of size 3 by 3 and use the clearBoard method to set all the positions to the BLANK character ('  ')?
Mark out of 3:3
Comments:loops in which board was set to blank
Did I loop asking the user for a location until wither the board was full or there was a winner?
Mark out of 5:5
Comments:infinite loop because board was reset after it was full or there was a winner
Did I call all of the methods above?
Mark out of 5:5
Comments:all methods called
Did I handle incorrect locations provided by the user (either occupied or invalid locations)?
Mark out of 3:3
Comments:message appears instructing user to enter valid position if user enters invalid
Did I switch the current player piece from cross to nought and vice versa after every valid move?
Mark out of 3:3
Comments:done in main method
Did I display the winning player piece or a draw at the end of the game?
Mark out of 3:3
Comments:tie or winner shown

   8.  Overall
Is my code indented correctly?
Mark out of 3:3
Comments:i can indent well
Do my variable names and Constants (at least four of them) make sense?
Mark out of 3:3
Comments:named according to function of the variable
Do my variable names, method names and class name follow the Java coding standard
Mark out of 2:2
Comments:named according to function
      Total Mark out of 100 (Add all the previous marks):  95
*/

import java.util.Scanner;

public class NoughtsAndCrosses {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Noughts and Crosses! \n\nHere is a "
				+ "sample input table corresponding to the positions on the board:"
				+ "\n\n 1 1 | 1 2 | 1 3\n 2 1 | 2 2 | 2 3\n 3 1 | 3 2 | 3 3"
				+ "\n\nPostions to place pieces must be entered as shown in the above table "
				+ "([ROW][SPACE][COLLUMN])\n\nEnjoy!\n");
		
		Scanner input = new Scanner(System.in);
		char[][] board = new char[3][3];
		clearBoard(board);
		char currentPlayerPiece = 'X';
		
		while(!isBoardFull(board) && winner(board) == ' ')
		{
			System.out.println(currentPlayerPiece + "'s turn, enter position:");
			int row = input.nextInt();
			int collumn = input.nextInt();
			row--;
			collumn--;
			if(row < 3 && collumn < 3 && canMakeMove(board, row, collumn))
			{
				makeMove(board, currentPlayerPiece, row, collumn);
				printBoard(board);
				System.out.print("\n" + winner(board));
				if(currentPlayerPiece == 'X')
				{
					currentPlayerPiece = 'O';
				}
				else if(currentPlayerPiece == 'O')
				{
					currentPlayerPiece = 'X';
				}
			}
			else System.out.println("Positions entered must be vacant and within the board's limits!");
			
			if(isBoardFull(board) && winner(board) == ' ')
			{
				System.out.print("TIE!\n\n");
				clearBoard(board);
			}
			else if(winner(board) != ' ') 
			{
				System.out.print(" IS THE WINNER!\n\n");
				clearBoard(board);
			}
		}
		
		input.close();
		
	}
	
	public static void clearBoard(char[][] board) {
		
		for(int i = 0; i <= 2; i++) 
		{
			board[i][0] = ' ';
			board[i][1] = ' ';
			board[i][2] = ' ';
		}
		
	}
	
	public static void printBoard(char[][] board) {
		
		for(int i = 0; i <= 2; i++) 
		{
			System.out.println(" " + Character.toString(board[i][0]) + " | " +
					Character.toString(board[i][1]) + " | " + 
					Character.toString(board[i][2]));
		}
		
	}
	
	public static boolean canMakeMove(char[][] board, int row, int collumn) {
		
		if(board[row][collumn] == ' ') 
		{
			return true;
		}
		else return false;
		
	}
	
	public static void makeMove(char[][] board, char currentPlayerPiece, int row, int collumn) {
		
		board[row][collumn] = currentPlayerPiece;
		
	}
	
	public static boolean isBoardFull(char[][] board) {
		
		boolean boardFull = true;
		
		for(int i = 0; i <= 2; i++) 
		{
			if(boardFull == true && board[i][0] != ' ' && board[i][1] != ' ' && board[i][2] != ' ')
			{
				boardFull = true;
			}
			else boardFull = false;
		}
		
		return boardFull;
		
	}
	
	public static char winner(char[][] board) {
		
		char winningPiece = ' ';
		
		for(int i = 0; i <= 2; i++) 
		{
			if(i == 0 && board[i][i] != ' ')
			{
				if((board[i][i] == board[i][i+1] && board[i][i] == board[i][i+2]) ||
						(board[i][i] == board[i+1][i+1] && board[i][i] == board[i+2][i+2]) ||
						(board[i][i] == board[i+1][i] && board[i][i] == board[i+2][i])) 
				{
					winningPiece = board[i][i];
				}
			}
			if(i == 1 && board[i][i] != ' ')
			{
				if(board[i][i-1] == board[i][i] && board[i][i-1] == board[i][i+1])
				{
					winningPiece = board[i][i-1];
				}
			}
			if(i == 2 && board[i][i] != ' ')
			{
				if(board[i][i-2] == board[i][i-1] && board[i][i-2] == board[i][i] || 
						board[i][i-2] == board[i-1][i-1] && board[i][i-2] == board[i-2][i])
				{
					winningPiece = board[i][i-2];
				}
			}
		}
		
		if(winningPiece == ' ') 
		{
			for(int i = 1; i <= 2; i++)
			{
				if(i == 1 && (board[i-1][i] == board[i][i] && board[i-1][i] == board[i+1][i]))
				{
					winningPiece = board[i-1][i];
				}
				if(i == 2 && (board[i-2][i] == board[i-1][i] && board[i-2][i] == board[i][i]))
				{
					winningPiece = board[i-2][i];
				}
			}
		}
		
		return winningPiece;
		
	}
	
}