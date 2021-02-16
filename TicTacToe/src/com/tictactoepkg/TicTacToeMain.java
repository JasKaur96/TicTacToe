package com.tictactoepkg;

import java.util.Scanner;

public class TicTacToeMain {
	static char user = 'x';
	static char comp = 'o';
	
	//Initialize board.
	public static void displayBoard() {
		char[] board = new char[10];
		for (int i = 1; i < 10; i++) {
			board[i] = ' ';
		}
	}
	
	//Take user choice.
	public static void inputLetter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter X or O: ");
		char val = sc.next().charAt(0);
		//To check if user input is capital or small letter and assign it.
		if (val == 'x' || val == 'X') {
			user = 'X';
			comp = 'O';
		} else if (val == 'o' || val == 'O') {
			user = 'O';
			comp = 'X';
		} else
			System.out.println("Invalid Input");
	}
	
	//Main to calls the methods to display board and take user choice.
	public static void main(String[] args) {
		System.out.println("*****Welcome to the TicTacToe Game.*****");
		displayBoard();
		inputLetter();
	}
}
