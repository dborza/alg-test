package com.dan.alg.recursive;

import java.util.Arrays;

/**
 * Given an infinite number of coins of 25, 10, 5 and 1 cents compute the total number of representing a value of n cents
 */
public class Coins {

    public static void main (final String [] args) {
        final int n = 8;
        final int [] coins = new int [] { 25, 10, 5, 1 };
        final int [] numberOfTimes = new int [4];   //  number of times a coin was picked
        final int total = compute(n, 0, 0, coins, numberOfTimes);
        System.out.println(total);
    }

    private static int compute(final int sum, final int partialSum, final int idx, final int [] coins, final int [] numberOfTimes) {
        System.out.println("compute sum=" +sum + ", partialSum: " + partialSum + ", idx: " + idx + ", coins: " + Arrays.toString(coins)
         + ", numberOfTimes: " + Arrays.toString(numberOfTimes));
        if (partialSum > sum) {
            return 0;
        } else if (partialSum == sum) {
            System.out.println("Found solution: " + Arrays.toString(numberOfTimes));
            return 1;
        }
        int total = 0;
        for (int coin = idx; coin < coins.length; coin ++) {
            final int maxPossibleValue = (sum - partialSum) / coins[coin];
            System.out.println("Finding possible value for coin " + coins[coin] + ", 1.." + maxPossibleValue);
            for (int possibleValue = 1; possibleValue <= maxPossibleValue; possibleValue ++) {
                numberOfTimes[coin] = possibleValue;
                total += compute(sum, partialSum + possibleValue * coins[coin], coin + 1, coins, numberOfTimes);
            }
        }
        return total;
    }

}
