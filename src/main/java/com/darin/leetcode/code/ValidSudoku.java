package com.darin.leetcode.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。 char[n][0 to 8] n=0 to 8
 * 数字 1-9 在每一列只能出现一次。 char[0 to 8][n] n=0 to 8
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 char[3n-(3 to 1)][3n-(3 to 1)] n=1 to 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 */
public class ValidSudoku {

    /**
     * solution 2
     * @param board
     * @return
     */
    public boolean isValidSudoku1(char[][] board) {
        //inti data
        HashMap<Integer, Integer> rows[] = new HashMap[9];
        HashMap<Integer, Integer> columns[] = new HashMap[9];
        HashMap<Integer, Integer> boxes[] = new HashMap[9];
        for(int i = 0; i < 9; i++){
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char num = board[i][j];
                if(num != '.'){
                    int n = (int)num;

                    //indicate which boxes(0 - 8) current value is in
                    int box_index = (i/3)*3 + j/3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1); //value n show time in row i
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1); //value n show time in column j
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1); //value n show time in box j

                    // check if this value has been already seen before
                    if(rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    /**
     * solution 1
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                if(set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
            set.clear();
        }

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[j][i] == '.') continue;
                if(set.contains(board[j][i])) return false;
                set.add(board[j][i]);
            }
            set.clear();
        }

        for(int o = 1; o <= 3; o++) {
            for(int k = 1; k <= 3; k++){
                for (int i = 3*o-3; i < 3*o; i++) {
                    for(int j = 3*k-3; j < 3*k; j++){
                        if(board[j][i] == '.') continue;
                        if(set.contains(board[j][i])) return false;
                        set.add(board[j][i]);
                    }
                }
                set.clear();
            }
        }
        return true;
    }
}
