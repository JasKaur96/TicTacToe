package com.tictactoepkg;

import java.util.Scanner;

public class TicTacToeMain {
	static char user = 'x';
	static char comp = 'o';
	char[] board = new char[10];
	
	//Initialize empty board.
	public static void display() {
		char[] board = new char[10];
		for (int i = 1; i < 10; i++) {
			board[i] = ' ';
		}
	}
	
	//Display empty board
	public static void displayBoard() {
		char[] board = new char[10];
		System.out.println("" + board[1] + " | " + board[2] + " | " + board[3]);
		System.out.println("----" + "----" + "--" + "");
		System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
		System.out.println("----" + "----" + "--" + "");
		System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
	}

	//Taking choice x or o from user
	public static void inputLetter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter X or O: ");
		char val = sc.next().charAt(0);
		
		//Checking if choice is capital or small and assigning it.
		if (val == 'x' || val == 'X') {
			user = 'X';
			comp = 'O';
		} 
		else if (val == 'o' || val == 'O') {
			user = 'O';
			comp = 'X';
		}
		else
			System.out.println("Invalid Input");
	}
	
	//Take position value from user.
	public static void takePosition() {
		Scanner sc = new Scanner(System.in);
		char[] board = new char[10];
		
		System.out.println("\nEnter the Position :");
		int position = sc.nextInt();
			if(position > 0 && position < 10) {
				if(board[position] != ' ' ) {
					System.out.println("Position available.");
				}
				else 
					System.out.println("Position filled.");
			}
			else
				System.out.println("Invalid position! please enter within 1-9");
			
	}

	//Calls method to take input for position and displaying board.
	public static void main(String[] args) {
		System.out.println("*****Welcome to the TicTacToe Game.*****");
		inputLetter();
		display();
		takePosition();
	}
}