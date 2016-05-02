package Sudoku.Controller;

/**
 * Created by Mostafa on 3/11/2016.
 * Core computations!
 */

class CoreComp {

    private int[][] grid;
    private int zeroCount;

    CoreComp(int[][] grid) {
        this.grid = grid;
        CountZeroes();
    }
    private void CountZeroes() {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (grid[i][j] == 0) zeroCount++;
    }

    private void Backtracking() {
        int[] first = root();
        bt(first[0], first[1]);
    }

    void Run() {
        Backtracking();
    }

    private int[] root() {
        int[] first = {0, 0};
        if (emptyCell(first[0], first[1])) {
            return first;
        } else {
            return decideNext(first[0], first[1]);
        }
    }
    //main backtracking algorithm!
    private boolean bt(int i, int j) {

        for (int c = 1; c <= 9; c++) {

            if (canPlace(i, j, c)) {

                setCell(i, j, c);
                //checks if finished
                if (accept()) return true;

                int[] next = decideNext(i, j);
                //recursive call here!
                if (bt(next[0], next[1])) {
                    return true;
                }
                restoreCell(i, j);
            }
        }
        return false;
    }

    private boolean canPlace(int i, int j, int c) {
        return Validation.ResultOfAll(grid, i, j, c);
    }

    private void restoreCell(int i, int j) {
        grid[i][j] = 0;
        zeroCount++;
    }

    private void setCell(int i, int j, int s) {
        grid[i][j] = s;
        zeroCount--;
    }

    private int[] decideNext(int i, int j) {
        int[] next = next(i, j);
        if (next != null) {
            if (emptyCell(next[0], next[1])) {
                return next;
            } else return decideNext(next[0], next[1]);
        }
        throw new AssertionError("More than size!");
    }

    private int[] next(int i, int j) {
        if (j == 8) {
            i++;
            j = 0;
        } else {
            j++;
        }
        if (i <= 8)
            return new int[]{i, j};
        else return null;
    }

    private boolean emptyCell(int i, int j) {
        return grid[i][j] == 0;
    }

    private boolean accept() {
        //it shows the condition- where all candidates are
        //the solution. hence no zeros left!
        return zeroCount == 0;
    }
}
