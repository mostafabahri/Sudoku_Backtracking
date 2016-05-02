package Sudoku.Controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

class FileHandler {
    private int size;
    private Scanner FileIn;
    private boolean isFileSet;

    private int[][] frame;

    FileHandler(int size, String filename) throws FileNotFoundException {
        if (size < 1) {
            throw new IndexOutOfBoundsException("Invalid size!");
        }
        this.size = size;
        setFile(filename);
        isFileSet = true;
        readFile();
    }

    private void readFile() {
        if (isFileSet) {
            frame = new int[size][size];
            for (int i = 0; i < size; i++) {
                String[] line = FileIn.nextLine().split("");
                for (int j = 0; j < size; j++) {
                    frame[i][j] = Integer.parseInt(line[j]);
                }
            }
        }
        FileIn.close();
    }

    private void setFile(String filename) throws FileNotFoundException {
        FileIn = new Scanner(new FileReader(filename));
    }

    int[][] getFrame() {
        return frame;
    }

}