package MazeQueueProject;

import project4.ArrayQueue;

/**
 * This class builds a maze and operates on it
 *
 * @author Anderson Levasseur
 * @version 1.0
 * @File Maze.java
 * @Created November 2023
 * @Copyright ©Copyright Cedarville University, its Computer Science faculty,
 *            and the authors. All rights reserved.
 * @Summary_of_Modifications
 *                           1 November 2023 built out class
 * 
 * @Description
 *              This class can be used to create a maze.
 * @see Maze.java
 */
public class Maze {
    private Node[][] maze;
    private int rowSize, colSize;
    private Node startNode, targetNode;

    public Maze(int row, int col, ArrayQueue<String> inputData) {
        rowSize = row;
        colSize = col;
        this.maze = new Node[rowSize][colSize];
        buildMaze(inputData);
    }

    /**
     * 
     * @return number of rows in the maze as an integer
     */
    public int numOfRows() {
        return rowSize;
    }

    /**
     * 
     * @return number of columns in the maze as an integer
     */
    public int numOfCols() {
        return colSize;

    }

    private void buildMaze(ArrayQueue<String> in) {
        int size = in.size();
        for (int i = 0; i < size; i++) {
            String inin = in.dequeue();
            for (int j = 0; j < inin.length(); j++) {
                setNode(i, j, inin.charAt(j));
            }
        }

    }

    private void setNode(int R, int C, char node) {
        Node newNode;
        switch (node) {
            case '.':
                newNode = new Node(R, C, NodeType.o);
                this.maze[R][C] = newNode;
                break;
            case 'X':
                newNode = new Node(R, C, NodeType.W);
                this.maze[R][C] = newNode;
                break;
            case 'S':
                newNode = new Node(R, C, NodeType.B);
                this.maze[R][C] = newNode;
                this.startNode = newNode;
                break;
            case 'T':
                newNode = new Node(R, C, NodeType.E);
                this.maze[R][C] = newNode;
                this.targetNode = newNode;
                break;
        }
    }

    public Node getNode(int R, int C) {
        return this.maze[R][C];
    }

    public Node getTargetNode() {
        return targetNode;
    }
/**
 * 
 * @return the Node that is the start of the maze
 */
    public Node startNode() {
        return startNode;
    }
}