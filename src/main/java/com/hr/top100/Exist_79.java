package com.hr.top100;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-28
 */
public class Exist_79 {

    public boolean exist(char[][] board, String word) {

        char[] cs = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == cs[0]) {
                    if (this.exist(board, cs, 0, i, j)) return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, char[] cs, int idx, int i, int j) {
        if (idx == cs.length) return true;
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) return false;
        if (cs[idx] != board[i][j]) return false;

        board[i][j] = '.';
        boolean up = this.exist(board, cs, idx + 1, i - 1, j);
        boolean down = this.exist(board, cs, idx + 1, i + 1, j);
        boolean left = this.exist(board, cs, idx + 1, i, j - 1);
        boolean right = this.exist(board, cs, idx + 1, i, j + 1);
        board[i][j] = cs[idx];
        return up || down || left || right;
    }

    public static void main(String[] args) {
        // a b
        // c d
        char[][] board = {{'a','a'}};
        Exist_79 instance = ReflectUtils.getInstance(Exist_79.class);
        System.out.println(instance.exist(board, "aa"));
    }
}
