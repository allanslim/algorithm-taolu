package com.allan.algorithm.taolu.dp;

public class RegularExpressionMatching {

/**

     example:

     pattern= xa*b.c
     string=xaabyc



t[i][j] - 2 dimentional boolean matrix (bottoms up)

where: i -> text
       j -> pattern


t[i][j] equals to:

1) t[i-1][j-1]  if str[i] == pattern[j] or pattern[j] == '.'  that means, you can exclude this value, and use the previous one:


example: if pattern is x, and string is x, then since they are match, we can remove then, then compare their previous, which
     empty string to empty string. that's why the value should be taken from t[i-1][j-1]


2)  t[i][j-2] if pattern[j] == '*',

example: if the pattern is xa* and string is x, a* can represent zero or more occurences,

     xa* <-- a* can be zero occurences, therefore can be x.
     x

     thats why, t[i][j-2]


3) t[i-1][j]  if str[i] == pattern[j-1] || pattern[j-1]== '.'



     now let say for example, the input is:

      | x| a | *
     x|  |   |
     a|  |   |

     xa* == x but the string is xa, so it is false, check another condition ->  if str[i] == pattern[j-1] ||  pattern[j-1]



     4)   return false str[i] does match with  pattern[i].


       0
      | |x|a|*|b|.|c|
   0  |T|f|f|f|f|f|f|
     x|f|0|1|0|0|0|0|
     a|f|0|0|1|0|0|0|
     a|f|0|0|0|1|0|0|
     b|f|0|0|0|0|1|0|
     y|f|0|0|0|0|0|1|
     c|f|0|0|0|0|0|0|

     0-0 is True, because empty string and empty pattern match




     */

    public static void main(String[] args) {
        char[] pattern = {'x', 'a', '*', 'b', '.', 'c'};
        char[] text = { 'x', 'a', 'a', 'b', 'y', 'c' };
        boolean isMatch = matchRegex(text, pattern);
        System.out.println(isMatch);

        isMatch = matchRegex(new char[]{'a','a'}, new char[]{'a'});
        System.out.println(isMatch);
    }

    public boolean isMatch(String s, String p) {
        return matchRegex(s.toCharArray(), p.toCharArray());
    }

    private static boolean matchRegex(char[] text, char[] pattern) {
        boolean[][] t = new boolean[text.length + 1][pattern.length + 1];

        t[0][0] = true;

        for (int row = 1; row < t.length - 1; row++) {
            t[row][0] = false;
        }

        for (int col = 1; col < t[0].length - 1; col++) {
            t[0][col] = false;
        }

        // deals with patterns like a* or a*b* or a*b*c*
        for (int i = 1; i < t[0].length; i++) {
            if (pattern[i - 1] == '*') {
                t[0][i] = t[0][i - 2];
            }
        }


        for (int row = 1; row < t.length; row++) {
            for (int col = 1; col < t[0].length; col++) {
                if (text[row - 1] == pattern[col - 1] || pattern[col - 1] == '.') {
                    t[row][col] = t[row - 1][col - 1];
                } else if (pattern[col - 1] == '*') {

                    t[row][col] = t[row][col - 2];

                    if (pattern[col - 2] == '.' || pattern[col - 2] == text[row - 1]) {
                        t[row][col] = t[row][col] | t[row - 1][col];
                    }

                } else {
                    t[row][col] = false;
                }
            }
        }

        return t[text.length][pattern.length];
    }

    private static void printMatrix(boolean[][] matrix ) {
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                System.out.print("|");
                System.out.print(matrix[row][col]);
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
