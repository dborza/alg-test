package com.dan.alg.recursive;

import java.util.Arrays;

/**
 * There are n boxes of given width, height and length. They can be stacked on top of each other only if the one on the
 * bootom is larger in all 3 dimensions than the one on top of it. Implement a method to compute the height the tallest
 * possible stack.
 */
public class StackedBoxes {

    /**
     * Given the sizes represented in the 3 arrays, start with selecting boxes and putting them on top of each other.
     * When you cannot stack anything on top verify if you've found a potential solution to the problem.
     */
    public static void main (final String [] args) {

        final int [] w = { Integer.MAX_VALUE, 2, 3, 4, 1 };
        final int [] h = { Integer.MAX_VALUE, 4, 4, 1, 1 };
        final int [] d = { Integer.MAX_VALUE, 3, 4, 5, 1 };
        final boolean [] selected = new boolean [w.length];
        final int [] sol = new int [w.length];
        final int [] finalSol = new int[w.length];

        findMaxHeight(w, h, d, selected, sol, 1, finalSol);

        System.out.println("Solution: " + Arrays.toString(finalSol));
    }

    private static void findMaxHeight(final int[] w, final int[] h, final int[] d, final boolean[] selected, final int[] sol,
                                      final int idx, final int [] finalSol) {
        if (idx > w.length) {
            return;
        }
        for (int i = 1; i < w.length; i ++) {
            if (!selected[i]) {
                if (w[i] < w[idx-1] && h[i] < h[idx-1] && d[i] < d[idx-1]) {
                    selected[i] = true;
                    sol[idx] = i;
                    sol[0] += h[i];
                    if (sol[0] > finalSol[0]) {
                        for (int j = 0; j < w.length; j ++) {
                            finalSol[j] = sol[j];
                        }
                    }
                    findMaxHeight(w, h, d, selected, sol, idx + 1, finalSol);
                    sol[0] -= h[i];
                    selected[i] = false;
                    sol[idx] = 0;
                }
            }
        }

    }


}
