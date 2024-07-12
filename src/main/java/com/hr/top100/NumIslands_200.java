package com.hr.top100;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-31
 */
public class NumIslands_200 {

    //  ["1","1","0","0","0"],
    //  ["1","1","0","0","0"],
    //  ["0","0","1","0","0"],
    //  ["0","0","0","1","1"]
    public int numIslands(char[][] grid) {

        int m = grid.length, n = grid[0].length, res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                this.backtrace(grid, i, j, m, n);
                ++res;
            }
        }
        return res;
    }

    private void backtrace(char[][] grid, int i, int j, int m, int n) {

        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') return;
        grid[i][j] = '0';
        this.backtrace(grid, i - 1, j, m, n);
        this.backtrace(grid, i + 1, j, m, n);
        this.backtrace(grid, i, j - 1, m, n);
        this.backtrace(grid, i, j + 1, m, n);
    }
}
