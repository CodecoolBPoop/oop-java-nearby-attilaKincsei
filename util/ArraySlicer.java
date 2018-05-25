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
		
		int StartIndex2 = Math.min(yCoord + 1, SubArray.length);
		int EndIndex2 = Math.min(yCoord + interval + 1, SubArray.length);
		int[] ArraySlice2 = Arrays.copyOfRange(SubArray, StartIndex2, EndIndex2);

		// Concatenating two array slices with arraycopy() method:
        int slice1Length = ArraySlice1.length;
        int slice2Length = ArraySlice2.length;
		this.ArraySlice = new int[slice1Length + slice2Length];

        System.arraycopy(ArraySlice1, 0, this.ArraySlice, 0, slice1Length);
        System.arraycopy(ArraySlice2, 0, this.ArraySlice, slice1Length, slice2Length);
    }

	public void PrintArraySlice() {
		System.out.println(Arrays.toString(this.ArraySlice));
    }

}

