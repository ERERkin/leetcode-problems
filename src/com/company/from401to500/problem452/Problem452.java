package com.company.from401to500.problem452;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Problem452 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(solution.findMinArrowShots(points));
    }
}

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int arrows = 1;
        int prev = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[prev][1]) {
                arrows += 1;
                prev = i;
            }
        }
        return arrows;
    }
}