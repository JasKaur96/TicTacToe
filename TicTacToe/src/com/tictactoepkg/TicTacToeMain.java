package com.tictactoepkg;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeGame {

	static Scanner sc = new Scanner(System.in);
	static String board[];
	static String turn;
	static char user = 'x';
	static char comp = 'o',result = ' ';

	//printing the board
	static void displayBoard() {
		System.out.println("" + board[0] + " | " + board[1] + " | " + board[2]);
		System.out.println("----" + "----" + "--" + "");
		System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
		System.out.println("----" + "----" + "--" + "");
		System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
	}
	
	// Taking choice x or o from user
	private static void makeChoice() {
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
	// To toss and check who starts.
		private static void toss() {
			int tossCheck = (int) Math.floor(Math.random() * 10) % 2;
			if (tossCheck == 0) {
				System.out.println("\nIt's your turn first!");
				turn = "user";
			} else {			
				System.out.println("\nIt's computer's turn first!");
				turn = "comp";
			}
		}
		
    //giving the status of board
	static void populateEmptyBoard() {
		for (int index = 0; index < 9; index++) {
			board[index] = String.valueOf(index + 1);
		}
	}
	
	//To check winner
	private static String checkWinner() {
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
			if (line.equals("XXX")) {
				return "X";
			} else if (line.equals("OOO")) {
				return "O";
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
		System.out.println(user + "'s turn. Enter a position :");
		return null;
	}
	
	//Play game. user and computer input taken to make move.
	private static void isPlay() {
		System.out.println("*****Welcome to Tic Tac Toe game*****");
		makeChoice();
		toss();
		populateEmptyBoard();
		System.out.println();
		displayBoard();
		System.out.println("______________________________");
		System.out.println();
		System.out.println("\nIt's " + user + "'s turn to make a move");
		System.out.println("\nEnter position to make a move:");

		String winner = null;
		while (winner == null) {
			int input;

			// play for computer
			if (turn == "O") {
				System.out.println("\nIts computer turn");
				int randomcpu = (int) (Math.floor(Math.random() * 10) % 9);
				input = randomcpu;
				System.out.println(input);
				try {
					if (!(input > 0 && input <= 9)) {
						System.out.println("Invalid input.Re-enter position number:");
						continue;
					}
				}

				catch (InputMismatchException e) {
					System.out.println("Invalid input.Re-enter position number:");
					continue;
				}

				if (board[input - 1].equals(String.valueOf(input))) {
					board[input - 1] = turn;
					if (turn.equals("O")) {
						turn = "X";
					} else {
						turn = "O";
					}
					displayBoard();
					winner = checkWinner();
//					System.out.println(winner);
					displayBoard();
				}

				else {
					System.out.println("Position already taken.Re-enter position :");
					continue;
				}
			}

			// play for players user
			else {
				try {
					input = sc.nextInt();
					if (!(input > 0 && input <= 9)) {
						System.out.println("Invalid input.Re-enter position:");
						continue;
					}
				}

				catch (InputMismatchException e) {
					System.out.println("Invalid input.Re-enter position.");
					continue;
				}

				if (board[input - 1].equals(String.valueOf(input))) {
					board[input - 1] = turn;
					if (turn.equals("X")) {
						turn = "O";
					} else {
						turn = "X";
					}
					displayBoard();
					winner = checkWinner();
				}
				else {
					System.out.println("Position already taken. Re-enter position:");
					continue;
				}
			}
		}
		if (winner.equalsIgnoreCase("draw")) {
			System.out.println("\nIt's a draw! Thanks for playing.");
		}
		else {
			System.out.println("\nCongratulations! " + winner + " won! Thanks for playing.");
		}
	}

	public static void main(String[] args) {
		board = new String[9];
		populateEmptyBoard();
		isPlay();
	}

}
