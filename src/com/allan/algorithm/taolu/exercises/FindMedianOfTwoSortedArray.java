package com.allan.algorithm.taolu.exercises;

public class FindMedianOfTwoSortedArray {

/**

Given two sorted array, find the median of both.

 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0

 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5


 For a sorted array, finding the median is getting the center value the array.

 for odd, it will be just the center:

 1, 2, 3, 4, 5
       ^

 for even, it will be the average of the two middle values.

 1, 2, 3, 4, 5, 6
       ^  ^
 avg(3,4) = 3 + 4 / 2 = 3.5


 you can derive the formula as:

 n/2 = odd
 avg( floor((n-1)/2) ,  n/2 ) = even

 Now, let say, you have 2 arrays.

 x = x1 x2 x3 x4 x5 x6
 y = y1 y2 y3 y4 y5 y6 y7 y8

 We have to partition these elements into two halfs, such that, the number of elements in each half is exactly the same
 -and- every element in the left half is less than or equal to every elements in the right half.

 let suppose we are partition x, like this:

 x = x1 x2| x3 x4 x5

 there are 2 elements on the left side, and 4 elements on the right

 in that case we have to partition y, at this point:

 y = y1 y2 y3 y4 y5 | y6 y7 y8

 number of elements in the left 5, and number of elements in the right is 3.

 so adding all the left:

 2 + 5 = 7

 adding all the right:

 4 + 3 = 7

 so we have partition both arrays in equal halfs:


 Now, we have to check if very element in the left half is less than or equal to every elements in the right half.

 x = x1 x2| x3 x4 x5
 y = y1 y2 y3 y4 y5 | y6 y7 y8

 now we know that x2 is less than or equal to x3, and y5 is less than or equal to y6

 x2 <= y6
 y5 <= x3

 if this was the case, then we are guaranteed, that every elements in the left, is less than or equal to every elements in the right

once you find this partition then, we know that the median is in these 4 elements:

 x2, x3
 y5, y6

 so the median would be:

 avg( max( x2, y5), min(x3, y6) ) -> if the total number of elements in even.

 for odd, it will be:

 max(x2,y5)

 So the thing that we need to solve, is to find the partition, and to do that we do a binary search

 on the SMALLER of the two arrays, and find such a point that every eleemnt in the left, is less than or equal to
 every elements on the right.

 the time complexity here would be:  O(log min(x,y)), where x and y are lengths of two arrays.


 for example:

 x = 1, 3, 8, 9, 15
 y = 7, 11, 18, 19, 21, 25

 combining these two:

1, 3, 7, 8, 9, 11, 15, 18, 19, 21, 25
               ^


 partitionX = x / 2

 partitionY = (x + y + 1) / 2 - partitionX

 we need +1, because it plays well with both odd and even number of elements in the combined array


if:
 maxLeftX <= minRightY
 maxLeftY <= minRightX

then you found the partition, use the formula above:

 else if:
 maxLeftX > minsRightY
 move towards left in X

 else:
 move towards right in X


 since x is the smaller array, do a binary search on X.

 start = 0
 end = 4


 partitionX = (4 + 0) / 2 = 2
 partitionY = (5 + 6 + 1) / 2  - 2 = 4


 1, 3           |  8, 9, 15
 7, 11, 18, 19  |  21, 25

 is 3 <= 21 -- yes
 is 19 <= 8 -- no

 this means we are too far in the left, so we have to move right, so to move:


 start = partitionX + 1 = 3

 partitionX = (3 + 4 ) / 2 = 3.5 = 3
 partitionY =  ( 5 + 6 + 1) /2 = 6 - 3 = 3

 now the partition:

 1, 3,8         | 9, 15
 7, 11, 18      | 19, 21, 25


 check, is 8 <= 19 -- yea
 is 18 <= 9 == No.

 then we need to move even further to the right.

 there are edge cases that we need to consider.

 if x parition is 0, then we set the value of partitionX to MIN,
 if y partition is n, then we set the value to MAX.

 to steps:

 1) find the minimum array to do binary Search.


*/

    public static void main(String[] args) {
        double median = findMedianSortedArrays(new int[]{1, 3, 8, 9, 15}, new int[]{7, 11, 19, 21, 18, 25});
        System.out.println(median);
    }

    private static double findMedianSortedArrays(int[] input1, int[] input2) {

        if( input1.length > input2.length) {
            return findMedianSortedArrays(input2, input1);
        }

        int x = input1.length;
        int y = input2.length;

        int low = 0;
        int high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            //if partitionX is 0, it means nothing is there on the left side use MIN
            //if parttionX is length of input, then there's nothing on the right, is MAX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // we have partitioned array at the correct place, now we use the formula
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { // we are too far on the right side for partiotnX. go to the left
                high = partitionX - 1;
            } else { // we are too far on the left side of partitionX, go to the right.
                low = partitionX + 1;
            }
        }
        // input arrays are not sorted.
        throw new IllegalArgumentException();
    }
}
