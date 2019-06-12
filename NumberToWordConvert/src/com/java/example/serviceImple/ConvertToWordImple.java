package com.java.example.serviceImple;

import java.io.IOException;

import com.java.example.service.ConvertToWord;

/**
 * This is the implementation class
 *
 */
public class ConvertToWordImple implements ConvertToWord {

	private String[] ones = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten" };

	private String[] tens = { "", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty",
			"ninety" };
	private String[] twenties = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
			"twenty" };

	private String[] hundreds = { "ones", "tens", "hundred", "thousand", "thousand", "lakhs", "lakhs", "crore",
			"crore" };

	private String word = "";
	private String tempWord = null;
	private int lastDigit = 0;

	/**
	 * @param number This is the first parameter to convToWord method
	 * @param count This is the second parameter to convToWord method
	 * @return int returns .
	 */
	@Override
	public int convToWord(int number, int count) throws IOException {
        
		if(number<0) {
			System.out.println("The Entered number is Negative Number");
			return 1;
			
		}
		int quotient = number / 10;
		int reminder = number % 10;
		getTheWord(reminder, count);
		if (quotient <= 0) {
			word = tempWord + word;
			System.out.println(" output : " + word);
			return 0;
		} else {
			return convToWord(quotient, count + 1);
		}
	}

	private void getTheWord(int reminder, int placeValue) {
		String newWord = null;
		switch (placeValue) {

		case 0:
			newWord = " " + ones[reminder];
			break;
		case 1:
			if (reminder == 1) {

				int number = Integer.parseInt(String.valueOf(reminder + "" + lastDigit));
				newWord = " " + twenties[number];
			} else {
				word = tempWord + word;
				newWord = " " + tens[reminder];
			}
			break;
		case 2:
			word = tempWord + word; // adding tens
			newWord = " " + ones[reminder] + " " + hundreds[placeValue] + " and";
			break;
		case 3:
			word = tempWord + word; // adding hundred
			newWord = " " + ones[reminder] + " " + hundreds[placeValue];
			break;
		case 4:
			if (reminder == 1) {
				word = word;
				int number = Integer.parseInt(String.valueOf(reminder + "" + lastDigit));
				newWord = "" + twenties[number] + " " + hundreds[placeValue] + "";
			} else {
				word = tempWord + word;
				newWord = " " + tens[reminder] + "";
			}
			break;

		/*
		 * default: System.out.println(" This is default statement, it won't print ");
		 * break;
		 */
		}
		lastDigit = reminder;
		tempWord = newWord;
	}

}
