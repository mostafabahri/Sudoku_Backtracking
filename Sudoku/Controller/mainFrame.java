package Sudoku.Controller;

import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 * Created by MostafaLesani on 3/8/2016.
 * main Controller
 */
public class mainFrame {

    public static void main(String[] args) throws FileNotFoundException, AssertionError {
        Solving Solver = new Solving();
        FileHandler fileHandler = new FileHandler(9, "src/Sudoku/Maps/beta.txt");
        Solver.setGrid(fileHandler.getFrame());
        Solver.PrintMap();
        Solver.Solve();

        System.out.println();
        System.out.println("Solved: ");
        final int[][] result = Solver.getGrid();

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
