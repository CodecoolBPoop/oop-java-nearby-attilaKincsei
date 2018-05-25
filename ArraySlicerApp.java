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
		
		// Getting user input from command line for x and y coordinates and range:
    	int xCoordinate = Integer.parseInt(args[0]);
    	int yCoordinate = Integer.parseInt(args[1]);
    	int interval = Integer.parseInt(args[2]);
    	System.out.println("\nChosen sub-array has index " + args[0]);
    	System.out.println(
    		"Chosen element of sub-array has index " + args[1] + " and a value of " + Integer.toString(InitialArray[xCoordinate][yCoordinate])
    	);
    	System.out.println("Chosen range is " + args[2]);
    	
    	// Creating an instance of ArraySlicer class
    	ArraySlicer MyTwoDArray = new ArraySlicer(InitialArray);
    	// Slicing the array by invoking the nearby method of AS class:
    	MyTwoDArray.nearby(xCoordinate, yCoordinate, interval);
    	// Printing sliced array to terminal by invoking the PrintArraySlice method of AS class:
    	System.out.println("\nThe result of slicing the sub-array exlcuding the the chosen element: ");
    	MyTwoDArray.PrintArraySlice();
    }

}

