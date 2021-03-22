package com.codecool.nearby;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.ArrayIndexOutOfBoundsException;

public class UserInput {
	
	private int[][] initialArrayToSlice;

	public UserInput (int[][] arrayParam) {
		initialArrayToSlice = arrayParam;
	}

	public int[] userInput() {

		String[] inputKeys = new String[] {
			"x coordinate",
			"y coordinate",
			"interval"
		};

		String[] inputMessages = new String[] {
			"\nFor the %s, please, enter an integer between 0 and 2 inclusively: ",
			"\nFor the %s, please, enter an integer between 0 and %d inclusively: ",
			"\nFor the %s, please, enter an integer greater than or equal to 0: ",
		};

		int[] inputArray = new int[3];
		for (int i = 0; i < inputKeys.length; i++) {
			boolean invalidInteger = true;
			do {
				try {
					System.out.printf(inputMessages[i], inputKeys[i], initialArrayToSlice[inputArray[0]].length - 1);
					Scanner inputScanner = new Scanner(System.in);
					inputArray[i] = inputScanner.nextInt();
					if (inputArray[i] >= 0) {
						boolean conditionForX = (i == 0 && inputArray[0] < initialArrayToSlice.length);
						boolean conditionForY = (i == 1 && inputArray[1] < initialArrayToSlice[inputArray[0]].length);
						boolean conditionForInterval = (i == 2);
						if (conditionForX || conditionForY || conditionForInterval) {
							invalidInteger = false;	
						}
					} else {
						System.out.println("Not a valid integer. Please, try again.");
					}
					System.out.printf("You entered %s for the %s.\n", inputArray[i], inputKeys[i]);
				} catch (InputMismatchException|ArrayIndexOutOfBoundsException error) {
					invalidInteger = true;
					inputArray[i] = 0;
					System.out.println(error);
					System.out.println("Not a valid integer. Please, try again.\n");
				}
			} while(invalidInteger);
		}
	
		return inputArray;
	}

}