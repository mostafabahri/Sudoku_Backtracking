package Sudoku.Controller;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mostafa on 3/11/2016.
 * validation parts!
 */
class Validation {


    private static boolean Row(int[][] grid, int row, int pc) {
        for (int j = 0; j < 9; j++) {
            if (grid[row][j] == pc) {
                return true;
            }
        }
        return false;
    }

    private static boolean Column(int[][] grid, int col, int pc) {
        for (int i = 0; i < 9; i++) {
            if (grid[i][col] == pc) {
                return true;
            }
        }
        return false;
    }

    private static boolean BlockInner(int[][] grid, int blockPart, int pc) {
        //checking the bounds of found block part!
        blockPart--;
        int x = blockPart / 3, y = blockPart % 3;
        for (int i = x * 3; i < x * 3 + 3; i++) {
            for (int j = y * 3; j < y * 3 + 3; j++) {
                if (grid[i][j] == pc) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean Block(int[][] grid, int i, int j, int pc) {
        //determining the block part
        return BlockInner(grid, (i / 3 * 3) + (j / 3 + 1), pc);
    }


    static boolean ResultOfAll(int[][] grid, int i, int j, int pc) {

        //checking the 3 conditions for a cell to be valid!
        return !Row(grid, i, pc) && !Column(grid, j, pc) && !Block(grid, i, j, pc);
    }

}

