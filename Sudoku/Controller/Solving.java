package Sudoku.Controller;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Exchanger;

/**
 * Created by Mostafa on 3/8/2016.
 * Solving procedures!
 */
public class Solving {


    private int[][] grid;
    private boolean solved;

    public Solving() {
        solved = false;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    void PrintMap() {
        for (int[] row : grid) System.out.println(Arrays.toString(row));
    }

    public void Solve() {
        CoreComp CC = new CoreComp(grid);
        CC.Run();
        solved = true;
    }

    public int[][] getGrid() {
        if (solved) return grid;
        throw new AssertionError("Not solved yet!!");
    }

}