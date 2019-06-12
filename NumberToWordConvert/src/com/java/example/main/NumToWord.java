package com.java.example.main;

import java.io.IOException;
import java.util.Scanner;

import com.java.example.service.ConvertToWord;
import com.java.example.serviceImple.ConvertToWordImple;


/**
  * This is the main method which convert the given number to word.
  * @param args Unused.
  * @return Nothing.
  * @exception IOException On input error.
  * @see IOException
 */
public class NumToWord {

	public static void main(String[] args) throws IOException {

		ConvertToWord cw = new ConvertToWordImple();
		int number = 0;
		Scanner input = new Scanner(System.in);
		System.out.println(" Enter the number : ");
		number = input.nextInt();
		/*
		 * if(number<0) { System.out.println("The Entered number is Negative Number");
		 * System.exit(0); }
		 */
		// here calling the method to convert the given number to word
		cw.convToWord(number, 0);

	}

}
