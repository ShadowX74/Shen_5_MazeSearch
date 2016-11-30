package mazesearch;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    //Paths to place down
    private final int TRIED = 3;

    private final int PATH = 7;

    //map
    public int[][] grid = new int[8][13];
//            private int[][] grid 
//            = {{1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
//            {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1},
//            {0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0},
//            {1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
//            {1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1},
//            {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
//            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

/***********************************************************************
* Method: generate
* Description: creates random solvable maze
* Parameters: N/A
* Pre-conditions: called to create maze
* Post-conditions: maze created
***********************************************************************/
    public void generate() {
        Random rand = new Random();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = rand.nextInt(2); //Random walls or paths
            }
        }
        
        try {
            if (!testMaze(0, 0)) { //If not solvable, re-generate
                generate();
            } else {
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[i].length; j++) {
                        if (grid[i][j] == 3 || grid[i][j] == 7) {
                            grid[i][j] = 1; //Reset path
                        }
                    }
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Maze.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    static Random rand = new Random();
/***********************************************************************
* Method: traverse
* Description: solves maze
* Parameters: int row, column, starting point
* Pre-conditions: called to solve maze
* Post-conditions: maze solved
***********************************************************************/
    public boolean traverse(int row, int column) throws InterruptedException {

        if (!valid(row, column)) {
            return false;
        } else {
            grid[row][column] = TRIED;
        }

        boolean possible = false;

        toString(grid);

        Thread.sleep(500);

        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }

        if ((traverse(row - 1, column) || traverse(row + 1, column) || traverse(row, column + 1) || traverse(row, column - 1)) || (row == grid.length - 1 && column == grid[0].length - 1)) {
            grid[row][column] = PATH;
            possible = true;
        }

        if (row == 0 && column == 0) {
            toString(grid);
        }
        return possible;
    }

/***********************************************************************
* Method: testMaze
* Description: tests if maze is solvable
* Parameters: int row, column, starting point
* Pre-conditions: called to see if randomly generated maze has solution
* Post-conditions: maze checked
***********************************************************************/
    public boolean testMaze(int row, int column) throws InterruptedException {

        if (!valid(row, column)) {
            return false;
        } else {
            grid[row][column] = TRIED;
        }

        boolean possible = false;

        if ((testMaze(row - 1, column) || testMaze(row + 1, column) || testMaze(row, column + 1) || testMaze(row, column - 1)) || (row == grid.length - 1 && column == grid[0].length - 1)) {
            grid[row][column] = PATH;
            possible = true;
        }

        return possible;
    }

/***********************************************************************
* Method: valid
* Description: checks location for not wall
* Parameters: int row, column, point to check
* Pre-conditions: called to check location
* Post-conditions: location checked, and returned to solving methods
***********************************************************************/
    private boolean valid(int row, int column) throws InterruptedException {
        return (row < grid.length && row >= 0) && (column < grid[0].length && column >= 0) && grid[row][column] == 1;
    }

/***********************************************************************
* Method: toString
* Description: prints maze
* Parameters: int[][] arr array to print
* Pre-conditions: called to print maze
* Post-conditions: maze printed
***********************************************************************/
    private void toString(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
