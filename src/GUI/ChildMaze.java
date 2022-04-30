package GUI;

public class ChildMaze extends Maze  {
    //Number of cells in x and y coordinates
    private int x, y;

    /**
     * Construct a maze object
     *
     * @param name   name of the maze
     * @param author name of the creator of the maze
     * @param x      number of cells on x-axis
     * @param y      number of cells on y-axis
     */
    public ChildMaze(String name, String author, int x, int y) {
        super(name, author);
        this.x = x;
        this.y = y;
    }

    /**
     * Method to call the algorithm to generate a maze based on the cell size
     * @param x number of cells on x-axis
     * @param y number of cells on y-axis
     */
    @Override
    public void generateMaze(int x, int y) {

    }
}