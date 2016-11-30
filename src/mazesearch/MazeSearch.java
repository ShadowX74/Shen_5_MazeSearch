/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazesearch;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ShadowX
 */
public class MazeSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            a_maze_ing();
        } catch (InterruptedException ex) {
            Logger.getLogger(MazeSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

/***********************************************************************
* Method: a_maze_ing
* Description: creates maze and solves it
* Parameters: N/A
* Pre-conditions: called in main
* Post-conditions: solved maze, program ends
***********************************************************************/
    public static void a_maze_ing() throws InterruptedException {
        Maze labyrinth = new Maze();
        labyrinth.generate();

        if (labyrinth.traverse(0,0)) {
            System.out.println("The maze was successfully solved!");
        } else {
            System.out.println("This is no possible path.");
        }
    }
}
