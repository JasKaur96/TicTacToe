package com.tictactoepkg;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeGame1 {
	static Scanner sc = new Scanner(System.in);
	static String board[];
	static String turn;
    //printing the board
	static void printBoard() {
		System.out.println("" + board[0] + " | " + board[1] + " | " + board[2]);
		System.out.println("----" + "----" + "--" + "");
		System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
		System.out.println("----" + "----" + "--" + "");
		System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
	}
	//Checks whose turn.
	String chooseplayer() 
	{
		int random = (int) (Math.floor(Math.random() * 10) % 2);
		switch (random) {

		case 0:
			System.out.println("its palyer turn");
			turn = "x";
			break;
			case 1:
			System.out.println("it's computer turn");
				turn = "o";
			break;
			}
			
			return turn;
		}
	    //giving the status of board
		static void populateEmptyBoard() {
			for (int a = 0; a < 9; a++) {
				board[a] = String.valueOf(a + 1);
			}
		}
		
		
		String checkWinner() {

			for (int a = 0; a < 8; a++) {
				String line = null;
				switch (a) {
				case 0:
					line = board[0] + board[1] + board[2];
					break;
				case 1:
					line = board[3] + board[4] + board[5];
					break;
				case 2:
					line = board[6] + board[7] + board[8];
					break;
				case 3:
					line = board[0] + board[3] + board[6];
					break;
				case 4:
					line = board[1] + board[4] + board[7];
					break;
				case 5:
					line = board[2] + board[5] + board[8];
					break;
				case 6:
					line = board[0] + board[4] + board[8];
					break;
				case 7:
					line = board[2] + board[4] + board[6];
					break;
				}
				if (line.equals("xxx")) {
					return "x";
				} else if (line.equals("ooo")) {
					return "o";
				}
			}
	         //loop for checking draw values
			for (int a = 0; a < 9; a++) {
				if (Arrays.asList(board).contains(String.valueOf(a + 1))) {
					break;
				} else if (a == 8) {
					return "draw";
				}
			}

			System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
			return null;
		}
		
		static void isPlay() {
			turn = new TicTacToeGame1().chooseplayer();
			String t1 = turn;
			populateEmptyBoard();

			System.out.println("Welcome to Tic Tac Toe game");
			System.out.println("_____________________________");
			System.out.println();
			printBoard();
			System.out.println("______________________________");
			System.out.println();
			System.out.println("now it is " + turn + " to make a move");
			System.out.println("enter your input in the slot of your choice");

			String winner = null;
			while (winner == null) {
				int input;

				// play for computer
				if (turn == "o") {
					System.out.println("its computer turn");
					int randomcpu = (int) (Math.floor(Math.random() * 10) % 9);
					input = randomcpu;
					System.out.println(input);
					try {
						// input = sc.nextInt();
						if (!(input > 0 && input <= 9)) {
							System.out.println("Invalid input; re-enter slot number:");
							continue;
						}
					}

					catch (InputMismatchException e) {
						System.out.println("Invalid input; re-enter slot number:");
						continue;
					}

					if (board[input - 1].equals(String.valueOf(input))) {
						board[input - 1] = turn;
						if (turn.equals("o")) {
							turn = "x";
						} else {
							turn = "o";
						}
						printBoard();
						winner = new TicTacToeGame1().checkWinner();
						System.out.println(winner);
						printBoard();

					}

					else {
						System.out.println("Slot already taken; re-enter slot number:");
						continue;
					}
				}

				// play for players user
				else {
					System.out.println("its player turn");
					try {
						input = sc.nextInt();
						if (!(input > 0 && input <= 9)) {
							System.out.println("Invalid input; re-enter slot number:");
							continue;
						}
					}

					catch (InputMismatchException e) {
						System.out.println("Invalid input; re-enter slot number:");
						continue;
					}

					if (board[input - 1].equals(String.valueOf(input))) {
						board[input - 1] = turn;
						if (turn.equals("x")) {
							turn = "o";
						} else {
							turn = "x";
						}
						printBoard();
						winner = new TicTacToeGame1().checkWinner();
						System.out.println(winner);
						printBoard();

					}
					else {
						System.out.println("Slot already taken; re-enter slot number:");
						continue;
					}
				}
			}
			if (winner.equalsIgnoreCase("draw")) {
				System.out.println("It's a draw! Thanks for playing.");
			}
			else {
				System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
			}
		}

		public static void main(String[] args) {
			board = new String[9];
			populateEmptyBoard();
			//printBoard();
			isPlay();
		}
}

