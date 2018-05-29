import util.ArraySlicer;
import util.ExceptionHandler;
import java.util.Arrays;

class ArraySlicerApp {

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
		ExceptionHandler excHandler = new ExceptionHandler(initialArray);
		int[] userInputArray = excHandler.userInput();

		// Slicing and printing the sub-array slice:
		ArraySlicer myTwoDArray = new ArraySlicer(initialArray);
		myTwoDArray.nearby(userInputArray);
		int chosenElement = initialArray[userInputArray[0]][userInputArray[1]];
		System.out.printf("\nThe result of slicing the sub-array exlcuding the chosen element (%d):\n", chosenElement);
		myTwoDArray.printArraySlice();
    }
}

