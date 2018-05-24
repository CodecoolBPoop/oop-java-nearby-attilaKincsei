package util;

import java.util.Arrays;
import java.lang.Math;

/* Methods needed to solve the problem in java
creating a new integer variable: int MyIntegerVariable = 10;
https://www.tutorialspoint.com/java/java_variable_types.htm
indexing [integer]
slicing: copying parts of an array
calculating length: MyArray.length
if conditional: ???
return statement: return SolutionArray */

/* to be continued: removing element: https://www.programiz.com/java-programming/examples/concatenate-two-arrays */

public class ArraySlicer {
	private int[][] TwoDArray;
	
	public int[] ArraySlice;
	
	public ArraySlicer (int[][] ArrayParam) {
		TwoDArray = ArrayParam;
	}
	
	public void nearby(int xCoord, int yCoord, int interval) {
		int[] SubArray = TwoDArray[xCoord];
		int StartIndex1 = yCoord - Math.min(interval, yCoord);
		int EndIndex1 = yCoord;
		int[] ArraySlice1 = Arrays.copyOfRange(SubArray, StartIndex1, EndIndex1);
		int StartIndex2 = Math.min(yCoord + 1, SubArray.length - 1);
		int EndIndex2 = Math.min(yCoord + interval + 1, SubArray.length - 1);
		int[] ArraySlice2 = Arrays.copyOfRange(SubArray, StartIndex2, EndIndex2);
		ArraySlice = new int[ArraySlice1.length + ArraySlice2.length];
		int index = 0;
		
		for (int number : ArraySlice1) {
			ArraySlice[index] = number;
			index++;
		}
		
		for (int number : ArraySlice2) {
			ArraySlice[index] = number;
			index++;
		}
    }

	public void PrintArraySlice() {
		System.out.println(Arrays.toString(ArraySlice));
    }

}

