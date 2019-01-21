package com.allan.algorithm.taolu.exercises;

/*

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.


Example 2:
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.


The obvious answer is to do a bruth force. The idea here is finding the minimum price and the max Profit as you iterate from the list.

create a variable minPrice, and initialize to the MAX integer, and create a variable maxProfit, initialize to zero.

 loop thru the array, and check:
 if the array[i] < minPrice:
     minPrice = array[i]
  else if array[i] - minPrice > maxProfit
     maxProfit = array[i] - minprice

   return maxProfit
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int maxProfit = findMaxProfit( new int[] { 7, 1, 5, 3, 6, 4});
        System.out.println(maxProfit);
    }

    private static int findMaxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for( int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
