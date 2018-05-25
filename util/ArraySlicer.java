package util;

import java.util.Arrays;
import java.lang.Math;

public class ArraySlicer {
	private int[][] TwoDArray;
	
	private int[] ArraySlice;
	
	public ArraySlicer (int[][] ArrayParam) {
		this.TwoDArray = ArrayParam;
	}
	
	public void nearby(int xCoord, int yCoord, int interval) {
		
		int[] SubArray = this.TwoDArray[xCoord];
		int StartIndex1 = yCoord - Math.min(interval, yCoord);
		int EndIndex1 = yCoord;
		int[] ArraySlice1 = Arrays.copyOfRange(SubArray, StartIndex1, EndIndex1);
		
		int StartIndex2 = Math.min(yCoord + 1, SubArray.length - 1);
		int EndIndex2 = Math.min(yCoord + interval + 1, SubArray.length - 1);
		int[] ArraySlice2 = Arrays.copyOfRange(SubArray, StartIndex2, EndIndex2);

		this.ArraySlice = new int[ArraySlice1.length + ArraySlice2.length];

		int index = 0;
		
		for (int number : ArraySlice1) {
			this.ArraySlice[index] = number;
			index++;
		}
		
		for (int number : ArraySlice2) {
			this.ArraySlice[index] = number;
			index++;
		}
    }

	public void PrintArraySlice() {
		System.out.println(Arrays.toString(this.ArraySlice));
    }

}

