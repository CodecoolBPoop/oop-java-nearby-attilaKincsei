import util.ArraySlicer;
import java.util.Arrays;
import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.ArrayIndexOutOfBoundsException;

class ArraySlicerApp {

	// Creating and printing the demo array
	public int[][] initialArray = new int[][] {
		{ 2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323 },
		{ 1, 3, 5, 7 },
		{ 321, 320, 32, 3, 41241, -11, -12, -13, -66, -688 }
	};

	
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
					System.out.printf(inputMessages[i], inputKeys[i], this.initialArray[inputArray[0]].length - 1);
					Scanner inputScanner = new Scanner(System.in);
					inputArray[i] = inputScanner.nextInt();
					if (inputArray[i] >= 0) {
						boolean conditionForX = (i == 0 && inputArray[0] < this.initialArray.length);
						boolean conditionForY = (i == 1 && inputArray[1] < this.initialArray[inputArray[0]].length);
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

    public static void main(String[] args) {
		// Creating and printing the demo array
    	int[][] initialArray = new int[][] {
    		{ 2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323 },
    		{ 1, 3, 5, 7 },
    		{ 321, 320, 32, 3, 41241, -11, -12, -13, -66, -688 }
    	};
    	
		System.out.println("\nArray of arrays to slice:");
    	for (int[] subArray : initialArray) {
	    	System.out.println(Arrays.toString(subArray));
    	}
		// Getting input from user for slicing
		ArraySlicerApp myASAPP = new ArraySlicerApp();
		int[] userInputArray = myASAPP.userInput();

		int xCoordinate = userInputArray[0];
		int yCoordinate = userInputArray[1];
		int interval = userInputArray[2];


		// Slicing and printing the sub-array slice:
		ArraySlicer myTwoDArray = new ArraySlicer(initialArray);
		myTwoDArray.nearby(xCoordinate, yCoordinate, interval);
		int chosenElement = initialArray[xCoordinate][yCoordinate];
		System.out.printf("\nThe result of slicing the sub-array exlcuding the chosen element (%d):\n", chosenElement);
		myTwoDArray.printArraySlice();
    }
}

