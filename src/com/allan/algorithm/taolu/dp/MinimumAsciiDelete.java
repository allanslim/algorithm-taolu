package com.allan.algorithm.taolu.dp;

public class MinimumAsciiDelete {

    /*

Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.

Input: s1 = "sea", s2 = "eat"
Output: 231
Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.

Input: s1 = "delete", s2 = "leet"
Output: 403
Explanation: Deleting "dee" from "delete" to turn the string into "let",
adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from "leet" adds 101[e] to the sum.
At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.

Note:

0 < s1.length, s2.length <= 1000.
All elements of each string will have an ASCII value in [97, 122].


example:

s1=ba
s2=aa


ascii:
a=97
b=98

create a nxm matrix.

    | "" | a | a
 "" |0   |97 |194
 b  |98  |   |
 a  |195 |   |

make a comparison:

if the input is ("", "") the answer is zero, because there is nothing to delete.
if the input is ("", "a"), the answer is 97, because we have to delete "a" (ascii 97) to make the two string equal ("","").
if the input is ("", "aa"), the answer ascii(a) + ascii(a) = 194.

if the input is ("b",""), the answer is 98 (ascii of b), because we have to delete "b", to make the two string equal
if the input is ("ba,""), the answer is 195, because we have to delete "ba", to make the two string equal


    | "" | a | a
 "" |0   |97 |194
 b  |98  |195|
 a  |195 |   |



if the input is ("b", "a"), we need to delete "b" and "a", to make the string equal. ("",""), so that would be
ascii(a) + ascii(b), which is 97 + 98 = 194.

    | "" | a | a
 "" |0   |97 |194
 b  |98  |195|292
 a  |195 |   |

if the input is ("b", "aa"), we need to delete "b" and "aa", to make the string equal ("",""). so that would be:
ascii(b) + ascii(aa) = 98 + 194 = 292


    | "" | a | a
 "" |0   |97 |194
 b  |98  |195|292
 a  |195 |98 |


if the input is ("ba","a"), notice that, the last characters are equal.

ba <-
 a <-
---

if the characters are equal, we don't need to delete that character. We don't need to delete "a", we only have to
compare the pervious characters. which is:

b
""
---

now if the input is (b,""), we need to delete "b", which is 98. You can see that there is a pattern.
if the input is equal, you can get the of arr[i-1][j-1].



    | "" | a | a
 "" |0   |97 |194
 b  |98  |195|292
 a  |195 |98 |195


if the input is ("ba", "aa"). the input ("ba","aa"), is the same as the previous input plus current input. which is:
input ("b", "a") + input("a","a")

"ba"  = "b" + "a"
"aa" = "a"  + "a"




    */
    public static void main(String[] args) {

//        String s1 = "sea";
//        String s2 = "eat";

        String s1 = "ba";
        String s2 = "aa";

        int sum = minimumDeleteSumBottomUp(s1, s2);
        System.out.println(sum);

        sum =  minimumDeleteSum(s1, s2);
        System.out.println(sum);
    }


    private static int minimumDeleteSumBottomUp(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for(int col = 1; col <= n; col++) {
            dp[0][col] = dp[0][col - 1] + s2.charAt(col - 1);
        }

        for(int row = 1; row <= m; row++) {
            dp[row][0] = dp[row - 1][0] + s1.charAt(row - 1);
        }

        printMatrix(dp);

        for(int row = 1; row <= m; row++) {
            for( int col = 1; col <= n; col++) {
                if(s1.charAt(row - 1) ==  s2.charAt(col - 1)) {
                    dp[row][col] = dp[row - 1][col - 1];
                }
                else {
                    dp[row][col] = Math.min(dp[row - 1][col] + s1.charAt(row - 1),
                                            dp[row][col - 1] + s2.charAt(col - 1)
                                            );
                }
            }
        }

        printMatrix(dp);

        return dp[m][n];
    }


    private static void printMatrix(int[][] matrix ) {
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                System.out.print("|");
                System.out.print(matrix[row][col]);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    private static int minimumDeleteSum(String s1, String s2) {
        if(s1.equals("")) {
            return asciiOf(s2);
        }

        if(s2.equals("")) {
            return asciiOf(s1);
        }

        if(s1.equals(s2)) {
            return s1.charAt(0);

        }


        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);
        return Math.min(c1 + minimumDeleteSum(s1.substring(1, s1.length() ), s2),
                       c2 + minimumDeleteSum(s1, s2.substring(1, s2.length() )));
//        return Math.max( minimumDeleteSum(s1.substring(1, s1.length() ), s2),
//                       minimumDeleteSum(s1, s2.substring(1, s2.length() )));

    }

    private static int asciiOf(String input) {
        int total = 0;
        for( char c : input.toCharArray() ) {
            total += (int) c;
        }
        return total;
    }


}
