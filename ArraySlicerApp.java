import util.ArraySlicer;

class ArraySlicerApp {
    public static void main(String[] args) {
    	int[][] InitialArray = new int[][] {
    		{ 2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323 },
    		{ 1, 3, 5, 7 },
    		{ 321, 320, 32, 3, 41241, -11, -12, -13, -66, -688 }
    	};
    	int xCoordinate = 1;
    	int yCoordinate = 3;
    	int interval = 5;
    	ArraySlicer MyTwoDArray = new ArraySlicer(InitialArray);
    	MyTwoDArray.nearby(xCoordinate, yCoordinate, interval);
    	MyTwoDArray.PrintArraySlice();
    }

}
