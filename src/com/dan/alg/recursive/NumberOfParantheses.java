package com.dan.alg.recursive;

import java.util.Arrays;

/**
 * Given a number n, represent all the valid values one can show these parantheses
 *
 * E.g. n = 1 => ()
 * n = 2 => ()(), (())
 * etc.
 */
public class NumberOfParantheses {

    public static void main (final String [] args) {

        final int n = 3;
        final String [] parantheses = new String [n*2];
        final int total = parantheses(parantheses, 0, n, 0, 0);
        System.out.println(total);
    }

    static int parantheses(final String[] parantheses, final int idx, final int n, final int open, final int closed) {
        if (idx >= parantheses.length) {
            System.out.println(Arrays.toString(parantheses));
            return 1;
        }
        int total = 0;
        if (open < n) {
            parantheses[idx] = "(";
            total += parantheses(parantheses, idx + 1, n, open + 1, closed);
        }
        if (closed < open) {
            parantheses[idx] = ")";
            total += parantheses(parantheses, idx + 1, n, open, closed + 1);
        }
        return total;
    }

}
