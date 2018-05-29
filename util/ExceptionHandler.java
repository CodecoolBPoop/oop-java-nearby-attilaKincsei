package util;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.ArrayIndexOutOfBoundsException;

public class ExceptionHandler {
	
	private int[][] twoDimArray;

	public ExceptionHandler (int[][] arrayParam) {
		this.twoDimArray = arrayParam;
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
					System.out.printf(inputMessages[i], inputKeys[i], this.twoDimArray[inputArray[0]].length - 1);
					Scanner inputScanner = new Scanner(System.in);
					inputArray[i] = inputScanner.nextInt();
					if (inputArray[i] >= 0) {
						boolean conditionForX = (i == 0 && inputArray[0] < this.twoDimArray.length);
						boolean conditionForY = (i == 1 && inputArray[1] < this.twoDimArray[inputArray[0]].length);
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