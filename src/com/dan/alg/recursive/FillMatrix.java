package com.dan.alg.recursive;

import java.util.Arrays;

/**
 * Given a matrix with different colours represented as integer codes write an algorithm that will fill the matrix with
 * a given color starting at a point for all the adjacent points of the same color of the initial point
 */
public class FillMatrix {

    public static void main (final String [] args) {

        final int [][] mat = new int [][] {
                {1, 2, 3, 2, 4},
                {2, 2, 3, 3, 5},
                {3, 3, 3, 1, 6},
                {5, 5, 5, 5, 5},
                {3, 3, 5, 6, 1}
        };
        final int row = 2, col = 2, initialColor = mat[row][col], desiredColor = 7;
        fill(mat, row, col, initialColor, desiredColor);
        for (int r = 0; r < mat.length; r ++) {
            System.out.println(Arrays.toString(mat[r]));
        }
    }

    private static void fill(final int [] [] mat, final int row, final int col, final int initalColor, final int desiredColor) {
        if (row < 0 || col < 0 || row >= mat.length || col >= mat[0].length) {
            return;
        }
        if (initalColor == mat[row][col]) {
            mat[row][col] = desiredColor;
            fill(mat, row - 1, col, initalColor, desiredColor);
            fill(mat, row + 1, col, initalColor, desiredColor);
            fill(mat, row, col - 1, initalColor, desiredColor);
            fill(mat, row, col + 1, initalColor, desiredColor);
        }
    }
}
