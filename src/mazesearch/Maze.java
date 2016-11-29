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
        
        if (!valid(row, column)) {
            return false;
        } else {
            grid[row][column] = TRIED;
        }

        boolean possible = false;
        
        toString(grid);

        Thread.sleep(500);
        
        for (int i = 0; i < 
                100; i++) {
            System.out.println("");
        }
        
        if ((traverse(row - 1, column) || traverse(row + 1, column) || traverse(row, column + 1) || traverse(row, column - 1)) || (row == grid.length - 1 && column == grid[0].length - 1)) {
            grid[row][column] = PATH;
            possible = true;
        }
        
        if (row == grid.length - 1 && column == grid[0].length - 1) {
            toString(grid);
        }
        return possible;
    }

    private boolean valid(int row, int column) throws InterruptedException {
        return (row < grid.length && row >= 0) && (column < grid[0].length && column >= 0) && grid[row][column] == 1;
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
