package com.codecool.nearby;

import java.util.Arrays;
import java.lang.Math;

public class ArraySlicer {
	private int[][] twoDArray;
	
	private int[] arraySlice;
	
	public ArraySlicer (int[][] arrayParam) {
		this.twoDArray = arrayParam;
	}
	
	public void nearby(int[] inputArray) {
		int xCoord = inputArray[0];
		int yCoord = inputArray[1];
		int interval = inputArray[2];

		int[] subArray = this.twoDArray[xCoord];
		int startIndex1 = yCoord - Math.min(interval, yCoord);
		int endIndex1 = yCoord;
		int[] arraySlice1 = Arrays.copyOfRange(subArray, startIndex1, endIndex1);
		
		int startIndex2 = Math.min(yCoord + 1, subArray.length);
		int endIndex2 = Math.min(yCoord + interval + 1, subArray.length);
		int[] arraySlice2 = Arrays.copyOfRange(subArray, startIndex2, endIndex2);

		// Concatenating two array slices with arraycopy() method:
        int slice1Length = arraySlice1.length;
        int slice2Length = arraySlice2.length;
		this.arraySlice = new int[slice1Length + slice2Length];

        System.arraycopy(arraySlice1, 0, this.arraySlice, 0, slice1Length);
        System.arraycopy(arraySlice2, 0, this.arraySlice, slice1Length, slice2Length);
    }

	public void printArraySlice() {
		System.out.println(Arrays.toString(this.arraySlice));
    }
}

