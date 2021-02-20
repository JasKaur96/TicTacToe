package com.tictactoepkg;

import java.util.Scanner;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeMain {
	static char user = 'x';
	static char comp = 'o',result = ' ';
	static char[] board = new char[10];
	static String turn = " ";
//	static int position;

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
		blockWinner();
		int compPosition = (int) (Math.floor(Math.random() * 10) );
		for (int index = 1; index < 10; index++) {
			if (board[compPosition] == ' ')
				makeMove(compPosition);
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
			winTie();
		} 
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

	private static void winTie() {
		displayBoard();
		for (int index = 1; index < 10; index++) { // for loop
			if (board[index] != ' ') { // if statement
				if ((board[1] == board[2]) && (board[2] == board[3]))
					result = board[1];
	//		System.out.println(board[1]+" wins");
				// middle row
				if ((board[4] == board[5]) && (board[5] == board[6]))
					result = board[4];
	//		System.out.println(board[4]+" wins");
				// bottom row
				if ((board[7] == board[8]) && (board[8] == board[9]))
					result = board[7];
	//		System.out.println(board[7]+" wins");
				/*
				 * Check verticals left column
				 */
				if ((board[1] == board[3]) && (board[3] == board[7]))
					result = board[1];
	//	System.out.println(board[1]+" wins");
				// middle column
				if ((board[2] == board[5]) && (board[5] == board[8]))
					result = board[2];
	//	System.out.println(board[2]+" wins");
				// right column
				if ((board[3] == board[6]) && (board[6] == board[9]))
					result = board[3];
	//	System.out.println(board[3]+" wins");
				/*
				 * Check diagonals one diagonal
				 */
				if ((board[1] == board[5]) && (board[5] == board[9]))
					result = board[1];
	//	System.out.println(board[1]+" wins");
				// the other diagonal
				if ((board[3] == board[5]) && (board[5] == board[7]))
					result = board[3];
	//	System.out.println(board[3]+" wins");
			}
		}
		
		if(result == 'X') 
			System.out.println(result+ " won the game!");
		else if(result == 'X')
			System.out.println(result+ " won the game!");
		else {
			if (turn == "user") 
				compTurn();
			else
				takePosition();
		}
	}

	public static void blockWinner(){
		int position;
		for(int index = 1; index < 10; index++) {
			if(board[index] == index && board[index + 1] == index + 1) {
				position = index + 2;
			} else if (board[index + 2] ==index + 2 && board[index + 1] == index + 1) {
				position = index;
			} else if (board[index] == index && board[index + 2] == index + 3) {
				position = index + 1;
			}
		}
		compTurn();
	}
	
	public static int cornerCheck() {
	    if (board[1] == ' ') return 1;
        else if (board[3] == ' ') return 3;
        else if (board[7] == ' ') return 7;
        else if (board[9] == ' ') return 9;
        return 0;
	}
		
	// Calls method to take input for position and displaying board.
	public static void main(String[] args) {
		System.out.println("*****Welcome to the TicTacToe Game.*****");
		inputLetter();
		display();
		toss();
	}
}