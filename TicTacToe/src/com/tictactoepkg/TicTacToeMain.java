package com.tictactoepkg;

import java.util.Scanner;

public class TicTacToeMain {
	static char user = 'x';
	static char comp = 'o';

	public static void displayBoard() {
		char[] board = new char[10];
		for (int i = 1; i < 10; i++) {
			board[i] = ' ';
		}
		System.out.println("" + board[1] + " | " + board[2] + " | " + board[3]);
		System.out.println("----" + "----" + "--" + "");
		System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
		System.out.println("----" + "----" + "--" + "");
		System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
	}

	public static void inputLetter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter X or O: ");
		char val = sc.next().charAt(0);
		if (val == 'x' || val == 'X') {
			user = 'X';
			comp = 'O';
			System.out.println("You are " + user + " and Computer is " + comp);
		} else if (val == 'o' || val == 'O') {
			user = 'O';
			comp = 'X';
			System.out.println("You are " + user + " and Computer is " + comp);
		} else
			System.out.println("Invalid Input");
	}
	
	
	public static void main(String[] args) {
		System.out.println("*****Welcome to the TicTacToe Game.*****");
		inputLetter();
		displayBoard();
	}
}
