package mazesearch;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ShadowX
 */
public class Maze {

    private final int TRIED = 3;

    private final int PATH = 7;

    private int[][] grid
            = {{1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0},
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
            {1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

    public boolean traverse(int row, int column) throws InterruptedException {

        if (valid(row, column)) {
            grid[row][column] = TRIED;
        } else {
            return false;
        }

        if (traverse(row - 1, column) || traverse(row + 1, column) || traverse(row, column + 1) || traverse(row, column - 1)) {
            grid[row][column] = PATH;
            return true;
        }
        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }

        toString(grid);

        Thread.sleep(500);

        return true;

    }

    private boolean valid(int row, int column) throws InterruptedException {
        if (row < grid.length && row >= 0 && column < grid[0].length && column >= 0) {
            return true;
        } else {
            return false;
        }
    }

    private void toString(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
