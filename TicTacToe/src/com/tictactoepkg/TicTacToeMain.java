package com.tictactoepkg;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeMain {
	static char user = 'x';
	static char comp = 'o';
	static char[] board = new char[10];
	static String turn = " ";

	// Initialize empty board.
	private static void display() {
		for (int index = 1; index < 10; index++) {
			board[index] = ' ';
		}
	}

	// Display empty board
	private static void displayBoard() {
		System.out.println("" + board[1] + " | " + board[2] + " | " + board[3]);
		System.out.println("----" + "----" + "--" + "");
		System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
		System.out.println("----" + "----" + "--" + "");
		System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
	}

	// Taking choice x or o from user
	private static void inputLetter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter X or O: ");
		char val = sc.next().charAt(0);

		// Checking if choice is capital or small and assigning it.
		if (val == 'x' || val == 'X') {
			user = 'X';
			comp = 'O';
		} else if (val == 'o' || val == 'O') {
			user = 'O';
			comp = 'X';
		} else
			System.out.println("Invalid Input");
	}

	// Take position value from user.
	public static void takePosition() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter the Position :");
		int position = sc.nextInt();
		if (position > 0 && position < 10) {
			if (board[position] == ' ') {
				makeMove(position);
			} else
				System.out.println("Position filled.");
		} else
			System.out.println("Invalid position! please enter within 1-9");
	}

	// Computer's turn
	private static void compTurn() {
		int compPosition = (int) (Math.floor(Math.random() * 10) );
		boolean win = false;
		for (int index = 1; index < 10; index++) {
			if (board[compPosition] == ' ')
				makeMove(compPosition);
				winnerCheck();	
		}
		
		for (int i = 1; i < 10; i++) {
			switch(i) {
			case 1:
				  if( (board[2] == compPosition && board[3] == compPosition)
                          || (board[4] == compPosition && board[7] == compPosition)
                          || (board[5] == compPosition && board[9] == compPosition) ) {
                                            
					  if (board[compPosition] == ' ') {
						  	makeMove(compPosition);
					  		win = true;			
					  }
				  }
				  break;
			case 2:
				  if( (board[1] == compPosition && board[3] == compPosition)
                          || (board[5] == compPosition && board[8] == compPosition)) {
                                            
					  if (board[compPosition] == ' ') {
						  	makeMove(compPosition);
					  		win = true;			
					  }
				  }
			  case 3:
                  if( (board[1] == compPosition && board[2] == compPosition)
                          || (board[6] == compPosition && board[9] == compPosition)
                          || (board[5] == compPosition && board[7] == compPosition) ) {
                      if (board[i] == ' ') {
                    	  makeMove(compPosition);
					  	  win = true;	
                      }
                  }
                  break;
              case 4:
                  if( (board[1] == compPosition && board[7] == compPosition)
                          || (board[5] == compPosition && board[6] == compPosition) ) {
                      if (board[i] == ' ') {
                    	  makeMove(compPosition);
					  	  win = true;
                      }
                  }
                  break;
              case 5:
                  if( (board[1] == compPosition && board[9] == compPosition)                         || (board[3] == compPosition && board[7] == compPosition)
                          || (board[2] == compPosition && board[8] == compPosition) ) {
                	  if (board[i] == ' ') {
                     	  makeMove(compPosition);
 					  	  win = true;
                      }
                  }
                  break;
              case 6:
                  if( (board[3] == compPosition && board[9] == compPosition)
                          || (board[4] == compPosition && board[5] == compPosition)) {
               	   if (board[i] == ' ') {
                    	makeMove(compPosition);
					  	win = true;
                      }
                  }
                  break;
              case 7:
                  if( (board[1] == compPosition && board[4] == compPosition)
                          || (board[5] == compPosition && board[3] == compPosition)
                          || (board[8] == compPosition && board[9] == compPosition) ) {
               	   if (board[i] == ' ') {
                    	  makeMove(compPosition);
					  	  win = true;
                      }
                  }
                  break;
               case 8:
                  if( (board[7] == compPosition && board[9] == compPosition)
                          || (board[2] == compPosition && board[5] == compPosition) ) {
               	   if (board[i] == ' ') {
                    	  makeMove(compPosition);
					  	  win = true;
                      }
                  }
                  break;
             case 9:
                  if( (board[8] == compPosition && board[7] == compPosition)
                          || (board[6] == compPosition && board[3] == compPosition)
                          || (board[5] == compPosition && board[1] == compPosition) ) {
               	   if (board[i] == ' ') {
                    	  makeMove(compPosition);
					  	  win = true;
                      }
                  }
                  break;
			}
		}
	}

	// To make a move to the position.
	private static void makeMove(int position) {
		for (int index = 1; index < 10; index++) {
			if (turn == "user") {
				board[position] = user;
				turn = "comp";
			} else {
				board[position] = comp;
				turn = "user";
			}
		}
		displayBoard();
	}

	// To toss and check who starts.
	private static void toss() {

		int tossCheck = (int) Math.floor(Math.random() * 10) % 2;
		if (tossCheck == 0) {
			turn = "user";
			System.out.println("It's your turn first!");
			takePosition();
		} else {
			turn = "comp";
			System.out.println("It's computer's turn first!");
			compTurn();
		}

	}

	// To check who won the game.
	private static String winnerCheck() {
		String result = null;
		for (int i = 1; i < 10; i++) {
			switch (i) {
			case 1:
				result = new StringBuilder().append(board[1]).append(board[2]).append(board[3]).toString();
				break;
			case 2:
				result = new StringBuilder().append(board[4]).append(board[5]).append(board[6]).toString();
				break;
			case 3:
				result = new StringBuilder().append(board[7]).append(board[8]).append(board[9]).toString();
				break;
			case 4:
				result = new StringBuilder().append(board[1]).append(board[5]).append(board[9]).toString();
				break;
			case 5:
				result = new StringBuilder().append(board[3]).append(board[5]).append(board[7]).toString();
				break;
			case 6:
				result = new StringBuilder().append(board[2]).append(board[5]).append(board[8]).toString();
				break;
			case 7:
				result = new StringBuilder().append(board[1]).append(board[3]).append(board[7]).toString();
				break;
			case 8:
				result = new StringBuilder().append(board[3]).append(board[6]).append(board[9]).toString();
				break;
			}
			if (result.equals("XXX"))
				return "X";
			else if (result.equals("OOO"))
				return "O";
		}
		// Loop to check if draw.
		for (int index = 1; index < 9; index++) {
			if (Arrays.asList(board).contains(String.valueOf(index))) {
				break;
			} else if (index == 9)
				return "Draw";
		}
		return "Winner is " + result;
	}

	private static void play() {
		String winner = null;
		while (winner == null) {
			if (turn == "user") {
				compTurn();
			} else
				takePosition();
		}
	}

	// Calls method to take input for position and displaying board.
	public static void main(String[] args) {

		System.out.println("*****Welcome to the TicTacToe Game.*****");
		inputLetter();
		display();
		toss();
		play();
		winnerCheck();
	}
}
