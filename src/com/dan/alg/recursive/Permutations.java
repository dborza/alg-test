package com.dan.alg.recursive;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Compute the permustaions of a given string.
 *
 * 1. Without dupes
 * 2. With dupes
 */
public class Permutations {

    public static void main (final String [] args) {

        final String s = "abacbacc";
        final char [] c = new char [s.length()];
        final boolean [] chosen = new boolean [s.length()];
        //permsWithDupes(s, chosen, c, 0);
        final boolean [] charSet = charSet(s);
        final int size = size(charSet);
        final char [] perm = new char[size];
        permsWithoutDupes(charSet, perm, size, new boolean [255], 0);

    }

    private static void permsWithDupes(final String str, final boolean [] chosen, final char [] c, final int idx) {
        if (idx == str.length()) {
            System.out.println(Arrays.toString(c));
        }
        for (int possibleCharIdx = 0; possibleCharIdx < str.length(); possibleCharIdx ++) {
            if (chosen[possibleCharIdx] == false) {
                chosen[possibleCharIdx] = true;
                c[idx] = str.charAt(possibleCharIdx);
                permsWithDupes(str, chosen, c, idx + 1);
                chosen[possibleCharIdx] = false;
            }
        }
    }

    private static void permsWithoutDupes(final boolean [] charSet, final char [] perm, final int n, final boolean [] chosen, int idx) {
        if (idx >= n) {
            System.out.println(perm);
        }
        for (char c = 0; c < 255; c ++) {
            if (charSet[c] == true && chosen[c] == false) {
                chosen[c] = true;
                perm[idx] = c;
                permsWithoutDupes(charSet, perm, n, chosen, idx + 1);
                chosen[c] = false;
            }
        }
    }

    static boolean [] charSet(final String s) {
        final boolean [] c = new boolean [255];
        for (int i = 0; i < s.length(); i ++) {
            c[s.charAt(i)] = true;
        }
        System.out.println("Built charset " + Arrays.toString(c));
        return c;
    };

    static int size(final boolean [] charSet) {
        int size = 0;
        for (boolean b : charSet) {
            if (b) {
                size ++;
            }
        }
        return size;
    }
}
