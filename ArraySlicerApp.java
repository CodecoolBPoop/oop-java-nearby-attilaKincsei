import util.ArraySlicer;
import java.util.Arrays;

class ArraySlicerApp {
    public static void main(String[] args) {
		// Creating and printing the demo array
		System.out.println("\nArray of arrays to slice:");
    	int[][] InitialArray = new int[][] {
    		{ 2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323 },
    		{ 1, 3, 5, 7 },
    		{ 321, 320, 32, 3, 41241, -11, -12, -13, -66, -688 }
    	};
    	for (int[] subArray : InitialArray) {
	    	System.out.println(Arrays.toString(subArray));
    	}
		int xCoordinate = Integer.parseInt(args[0]);
		int yCoordinate = Integer.parseInt(args[1]);
		int interval = Integer.parseInt(args[2]);

		// Getting user input from command line for x and y coordinates and range:
		System.out.printf("\nThe parameters you entered are %s, %s, %s.\n", args[0], args[1], args[2]);
		if (xCoordinate >= 0 && xCoordinate < 3) {
			try {
				// Creating an instance of ArraySlicer class
				ArraySlicer MyTwoDArray = new ArraySlicer(InitialArray);
				// Slicing the array by invoking the nearby method of AS class:
				MyTwoDArray.nearby(xCoordinate, yCoordinate, interval);
				// Printing sliced array to terminal by invoking the PrintArraySlice method of AS class:
				String chosenElement = Integer.toString(InitialArray[xCoordinate][yCoordinate]);
				System.out.println("\nThe result of slicing the sub-array exlcuding the the chosen element (" + chosenElement + "): ");
				MyTwoDArray.PrintArraySlice();
			} catch (ArrayIndexOutOfBoundsException e) {
				String highestIndex = Integer.toString(InitialArray[xCoordinate].length - 1);
				System.out.print("If the first parameter is " + args[0] + ", then the second parameter should be between 0 and " +
					highestIndex + " inclusively.\n");
				System.out.println("Error message: " + e);
			}
		} else {
			System.out.print("Each parameter should be an integer.\n");
			System.out.print("The first parameter should be between 0 and 2 inclusively.\n");
		}
    }
}

