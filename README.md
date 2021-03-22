Assignment: Nearby elements
Your task is to find and return the nearby elements from a two-dimensional int array. Let's work here with this example data array:

    int[][] multi = new int[][]{
            { 2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323 },
            { 1, 3, 5, 7 },
            { 321, 320, 32, 3, 41241, -11, -12, -13, -66, -688 }
    };
The data array should be kept private. Write a method for the class which

can access the data array
has 3 input arguments: x, y – the position coordinates of a target element in the array (starting from 0) and range – another int value
returns an int array with the nearby elements of the target at [x, y] within the maximum "distance" of range (excluding the target element itself).
The signature of this method is:

    public int[] nearby(int x, int y, int range)
Example answers for the above data:

nearby(0, 2, 2) would result: [2, 0, 1241, 12]
nearby(1, 0, 1) would result: [3]
nearby(1, 3, 5) would result: [1, 3, 5]
Base repo
https://classroom.github.com/a/FGOOZgjY

Materials:
Java fundamentals
Code style
Keywords
Methods
Running application
