/*
PROBLEM 122
Say you have an array for which the ith element is the price of a given stock on 
day i.

Design an algorithm to find the maximum profit. You may complete as many 
transactions as you like (ie, buy one and sell one share of the stock multiple 
times). However, you may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).
--------------------------------------------------------------------------------
time complexity: O(n)
space complexity: O(n)
n - length of array prices
*/
public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            int j = i;
            while (j + 1 < prices.length && prices[j + 1] > prices[j]) {
                j++;
            }
            if (j < prices.length && prices[j] > prices[i]) {
                profit += (prices[j] - prices[i]);
                i = j;
            }
        }
        
        return profit;
    }
}

/*
Another expression
*/

public class Solution {
public int maxProfit(int[] prices) {
    int total = 0;
    for (int i=0; i< prices.length-1; i++) {
        if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
    }
    
    return total;
}