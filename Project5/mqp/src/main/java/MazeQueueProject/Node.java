package MazeQueueProject;

/**
 * This class is a singular location in a maze
 *
 * @author Anderson Levasseur
 * @version 1.0
 * @File Node.java
 * @Created November 2023
 * @Copyright ©Copyright Cedarville University, its Computer Science faculty,
 *            and the authors. All rights reserved.
 * @Summary_of_Modifications
 *                           1 November 2023 built out class
 * 
 * @Description
 *              This class is a singular location in a maze and could
 *              potentially be a private class in the Maze.java file
 * @see Maze.java
 */

public class Node {
    private int r, c, distance;
    private Node parent;
    private Enum<NodeType> type;

    public Node(int R, int C, Enum<NodeType> type) {
        this.r = R;
        this.c = C;
        this.type = type;
        this.parent = null;

    }

    public int getRow() {
        return r;
    }

    public int getCol() {
        return c;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Enum<NodeType> getType() {
        return type;
    }

    public void setType(Enum<NodeType> type) {
        this.type = type;
    }

    public int getDist() {
        return distance;
    }

    public void setDist(int distance) {
        this.distance = distance;
    }

}

enum NodeType {
    /*
     * B - Beginning
     * E - End
     * W - Wall
     * o - Open(not wall)
     * P - Path
     */
    B, E, W, o, P;
}
