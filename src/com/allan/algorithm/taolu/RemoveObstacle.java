package com.allan.algorithm.taolu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/*

Given:
- The robot can move one block at a time. (up, down, left, right)
- asking for minimum distance required for the rogot to remove obstacle
- robot can only go to flat(1)
- robot cannot enter trenches (0)
- robot needs to take down a single obstacle(9)

Analysis:
This problem seems like a dynamic programming problem since it is asking for the
minimum distance. but considering that it is given a 2D matrix, It may also be a Graph
problem. We will need depth first search algorithm to solve this.

given a simple input. maybe a 2x2 matrix.

[
[1,9]
[1,1]
]

there are two paths.

(0,0) -> (1,0)  = 1 step
(0,0) -> (0,1) -> (1,1) -> (1,0) = 3 steps

Obviously, the minimum path is 1 step.

what if the input is:

[
[1,9]
[0,1]
]

so there is only one path, because the other path is blocked by a trench.

we need to keep track of the coordinates that we have visited to avoid exhausting
the stack.


using DFS and finding the minumum for valid path.

[
[1,0,0],
[1,0,0],
[1,9,1]
]

          dfs(0,0, 3, 3, 0, visited=[])
          /      |         |         \
  dfs(1,0)     dfs(-1,0)   dfs(0,1)    dfs(0,-1)


- if it is out of boundary, return the Maximum Integer.

- if the path is an obstacle (9) - return the distance

- if the path is a flat (1) - move to all path and add 1 to distance.

*/
public class RemoveObstacle {

    public static void main(String[] args) {
        int numRows = 5;
        int numColumns = 4;
        List<List<Integer>> lot = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(1);
        row1.add(1);
        row1.add(1);
        lot.add(row1);
        List<Integer> row2 = new ArrayList<>();
        row2.add(0);
        row2.add(1);
        row2.add(1);
        row2.add(1);
        lot.add(row2);
        List<Integer> row3 = new ArrayList<>();
        row3.add(0);
        row3.add(1);
        row3.add(0);
        row3.add(1);
        lot.add(row3);
        List<Integer> row4 = new ArrayList<>();
        row4.add(1);
        row4.add(1);
        row4.add(9);
        row4.add(1);
        lot.add(row4);
        List<Integer> row5 = new ArrayList<>();
        row5.add(0);
        row5.add(0);
        row5.add(1);
        row5.add(1);
        lot.add(row4);
        int minimumDistance = removeObstacle(numRows, numColumns, lot);
        System.out.println(minimumDistance);
    }

    public static final int OBSTACLE = 9;
    public static final int TRENCH = 0;
    public static final int FLAT = 1;

    public static int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot)
    {
        Set<String> visited = new HashSet<>();
        int startRow = 0;
        int startColumn = 0;
        if (numRows < 1 || numRows > 1000 || numColumns < 1 || numRows > 1000)
        {
            return -1;
        }
        if (lot == null || lot.isEmpty()) {
            return -1;
        }
        return dfs(startRow, startColumn, numRows, numColumns, lot, 0, visited);
    }

    public static int dfs(int row, int column, int numRows, int numColumns, List<List<Integer>> lot, int distance, Set<String> visited) {
        // first check for boundary, trench, and visited coordinate.
        if(row < 0 ||
                column < 0 ||
                column >= numColumns ||
                row >= numRows ||
                lot.get(row).get(column) == TRENCH ||
                visited.contains(row + "." + column)
                ) {
            return Integer.MAX_VALUE;
        }

        if (lot.get(row).get(column) == OBSTACLE ) {
            return distance; // obstacle found!
        }

        if (lot.get(row).get(column) == FLAT) {
            // its a flat, we can continue to explore
            visited.add(row + "." + column);
            int currentDistance = distance + 1;
            int route1 = dfs(row + 1, column, numRows, numColumns, lot, currentDistance, visited); // go right
            int route2 = dfs(row - 1, column, numRows, numColumns, lot, currentDistance, visited); // go left
            int route3 = dfs(row, column + 1, numRows, numColumns, lot, currentDistance, visited); // go down
            int route4 = dfs(row, column - 1, numRows, numColumns, lot, currentDistance, visited); // go up

            return Math.min(Math.min(Math.min(route1,route2), route3), route4);
        }
        return Integer.MAX_VALUE; // bad case.
    }
}
