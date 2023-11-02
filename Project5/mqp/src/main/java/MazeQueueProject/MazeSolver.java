package MazeQueueProject;

import java.util.Scanner;

import project4.ArrayQueue;

/**
 * This class can solve a maze and print it out in the desiredway
 *
 * @author Anderson Levasseur
 * @version 1.0
 * @File MazeSolver.java
 * @Created November 2023
 * @Copyright ©Copyright Cedarville University, its Computer Science faculty,
 *            and the authors. All rights reserved.
 * @Summary_of_Modifications
 *                           1 November 2023 built out class
 * 
 * @Description
 *              This class can be used to solve a maze.
 * @see Maze.java
 */
public class MazeSolver {
    Maze maze;

    public MazeSolver(Maze maze) {
        this.maze = maze;
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int rows = inputScanner.nextInt();
        int cols = inputScanner.nextInt();
        inputScanner.nextLine();
        ArrayQueue<String> inputData = new ArrayQueue<String>();
        for (int i = 0; i < rows; i++) {
            inputData.enqueue(inputScanner.nextLine());
        }
        Maze maze = new Maze(rows, cols, inputData);
        MazeSolver solved = new MazeSolver(maze);
        solved.solveMaze();
        String solution = solved.printSolution(maze.getTargetNode());
        System.out.println(solution);
        inputScanner.close();
    }

    /**
     * Solves the maze using a depth first search
     * 
     * @returns Nothing
     */
    public void solveMaze() {
        ArrayQueue<Node> moveQueue = new ArrayQueue<Node>();
        moveQueue.enqueue(this.maze.startNode());

        while (!moveQueue.isEmpty()) {
            Node currentNode = moveQueue.dequeue();
            int currRow = currentNode.getRow();
            int currCol = currentNode.getCol();
            if (currentNode.getType() == NodeType.E) {
                return;
            }
            // Checks the node above currentNode and adds it to the moveQueue if the node
            // exists and isn't a wall
            if (currRow - 1 >= 0) {
                Node next = this.maze.getNode(currRow - 1, currCol);
                if (next.getParent() == null && next.getType() != NodeType.W) {
                    next.setParent(currentNode);
                    next.setDist(currentNode.getDist() + 1);

                    moveQueue.enqueue(next);
                }
            }
            // Checks the node below currentNode and adds it to the moveQueue if the node
            // exists and isn't a wall
            if (currRow + 1 < this.maze.numOfRows()) {
                Node next = this.maze.getNode(currRow + 1, currCol);
                if (next.getParent() == null && next.getType() != NodeType.W) {
                    next.setParent(currentNode);
                    next.setDist(currentNode.getDist() + 1);

                    moveQueue.enqueue(next);
                }
            }
            // Checks the node to the left currentNode and adds it to the moveQueue if the
            // node exists and isn't a wall
            if (currCol - 1 >= 0) {
                Node next = this.maze.getNode(currRow, currCol - 1);
                if (next.getParent() == null && next.getType() != NodeType.W) {
                    next.setParent(currentNode);
                    next.setDist(currentNode.getDist() + 1);
                    moveQueue.enqueue(next);
                }
            }
            // Checks the node to the right currentNode and adds it to the moveQueue if the
            // node exists and isn't a wall
            if (currCol + 1 < this.maze.numOfCols()) {
                Node next = this.maze.getNode(currRow, currCol + 1);
                if (next.getParent() == null && next.getType() != NodeType.W) {
                    next.setParent(currentNode);
                    next.setDist(currentNode.getDist() + 1);
                    moveQueue.enqueue(next);
                }
            }
        }
        return;
    }

    /**
     * Prints the path through the maze and the distance
     * 
     * @param target - the end location of the maze
     * @return String containing the path through the maze and the distance from the
     *         beginning to the end
     * @ExampleReturnStatement <0 0>\n<1 0>\nTotal distance = 2
     */
    public String printSolution(Node target) {
        if (target.getParent() == null) {
            if (target == maze.getTargetNode()) {
                return "Please solve before printing";
            }
            return "Maze not solvable.";
        }
        if (target.getType() == NodeType.B) {
            return "<" + Integer.toString(target.getRow()) + " " + Integer.toString(target.getCol()) + ">\n";
        }
        String ans = printSolution(target.getParent());
        if (target.getType() == NodeType.E) {
            return ans += "<" + Integer.toString(target.getRow()) + " " + Integer.toString(target.getCol()) + ">\n"
                    + "Total distance = " + Integer.toString(target.getDist());
        }
        return ans += "<" + Integer.toString(target.getRow()) + " " + Integer.toString(target.getCol()) + ">\n";
    }
}
