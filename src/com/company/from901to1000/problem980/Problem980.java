package com.company.from901to1000.problem980;

public class Problem980 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        grid = new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}};
        grid = new int[][]{{1, 0}, {0, 2}};
        System.out.println(solution.uniquePathsIII(grid));
    }
}

class Solution {
    private int answer = 0;

    public int uniquePathsIII(int[][] grid) {
        boolean[][] wasThere = new boolean[ grid.length][grid[0].length];
        int startRow = -1;
        int startCol = -1;
        int finishRow = -1;
        int finishCol = -1;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                wasThere[i][j] = false;
                count++;
                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
                if (grid[i][j] == 2) {
                    finishRow = i;
                    finishCol = j;
                }
                if (grid[i][j] == -1) {
                    wasThere[i][j] = true;
                    count--;
                }

            }
        }
        find(grid, wasThere, startRow, startCol, finishRow, finishCol, 0, count);
        return answer;
    }

    public void find(int[][] grid,
                     boolean[][] wasThere,
                     int row,
                     int col,
                     int finishRow,
                     int finishCol,
                     int count,
                     int finishCount) {
        count++;
        if (row == finishRow && col == finishCol) {
            if (count == finishCount) {
                answer++;
            }
            return;
        }

        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return;
        }

        if (wasThere[row][col]) {
            return;
        }

        wasThere[row][col] = true;
        find(grid, wasThere, row, col - 1, finishRow, finishCol, count, finishCount);
        find(grid, wasThere, row - 1, col, finishRow, finishCol, count, finishCount);
        find(grid, wasThere, row, col + 1, finishRow, finishCol, count, finishCount);
        find(grid, wasThere, row + 1, col, finishRow, finishCol, count, finishCount);
        wasThere[row][col] = false;
    }
}
