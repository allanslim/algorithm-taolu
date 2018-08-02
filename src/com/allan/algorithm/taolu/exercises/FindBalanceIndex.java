package com.allan.algorithm.taolu.exercises;

import java.util.stream.IntStream;

/*
find the balance index of an array where balanced index i is defined as the one whose left sum is equal to the right sum of the index .

e.g.

The balance index of array = [-1,2,3,1] is 2.

     v
-1,2,3,1

left side of index 2 is (-1, 2) which is  -1 + 2 = 1
right side of index 2 is (1)

-2 + 1 == 1

return -1 if there's no balance index.
return 0 if array only has single element


anaylysis:

given: -1, 2, 3, 1
find the total sum = 5

total sum = 5
left = 0

loop thru input
-------------

iteration 0:

sum = 5
left = 0

  v
 -1,2, 3, 1

check if left == sum:
  if yes return index
  if not add value to left, and subtract it from sum.


iteration 1:

sum = 6
left = -1

    v
 -1,2, 3, 1

check if left == sum:
  if yes return index
  if not add value to left, and subtract it from sum.

iteration 2:

sum = 4
left = 1

       v
 -1,2, 3, 1

check if left == sum:
  if yes return index
  if not add value to left, and subtract it from sum.

iteration 3:

sum = 1
left = 1

       v
 -1,2, 3, 1

check if left == sum:
  if yes return index
  if not add value to left, and subtract it from sum.

  v
1,1

2
1

 */
public class FindBalanceIndex {

    public static void main(String[] args) {
        expect(0, findBalanceIndex(new int[]{3}));
        expect(-1, findBalanceIndex(new int[]{1,1}));
        expect(2, findBalanceIndex(new int[]{-1,2,3,1}));
        expect(2, findBalanceIndex(new int[]{3,-3,8}));
        expect(0, findBalanceIndex(new int[]{0,1,-1}));
        expect(0, findBalanceIndex(new int[]{0,0}));
    }

    private static int findBalanceIndex(int[] inputArray) {
        if(inputArray.length == 1) {
            return 0;
        }

        //int sum = IntStream.of(inputArray).sum();
        int sum = 0;
        for( int i = 0; i < inputArray.length; i++) {
            sum += inputArray[i];
        }

        int left = 0;

        for(int i = 0; i < inputArray.length; i++) {
            sum -= inputArray[i];

            if(sum == left) {
                return i;
            } else {
                left += inputArray[i];
            }
        }
        return -1;
    }

    private static void expect(int a, int b) {
        if(a == b){
            System.out.println(String.format("Success index: %d", a));
            return;
        }
        System.out.println(String.format("Failure, expected %d, actual: %d", a, b));
    }
}
