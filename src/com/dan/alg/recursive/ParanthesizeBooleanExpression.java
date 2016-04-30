package com.dan.alg.recursive;

/**
 * Count the number of ways in which you can paranthesize a given boolean expression so that it evaluates to a given
 * value which is either {@code true} or {@code false}
 *
 * e.g. paranthesize("1|2&3|4&5", true) -> will return a number representing the result
 */
public class ParanthesizeBooleanExpression {


    private static int paranthesize(final String expr, final boolean output) {
        if (null == expr || expr.isEmpty()) {
            return 0;
        }

        return paranthesize(expr, output);
    }

}
