package GUI;

import java.time.LocalDateTime;

public abstract class Maze {
    private String name, author;

    private LocalDateTime dateTimeCreated, dateTimeEdited;


    /**
     * Construct a maze object
     *
     * @param name name of the maze
     * @param author name of the creator of the maze
     */
    public Maze(String name, String author) {
        this.name = name;
        this.author = author;
        dateTimeCreated = LocalDateTime.now();
    }


    /**
     * Save maze design for later access
     */
    void save() {
        dateTimeEdited = LocalDateTime.now();
    };

    /**
     * Get the last date and time the maze was edited
     *
     * @return last date and time the maze was edited
     */
    public LocalDateTime getLastEdited() {
        return dateTimeEdited;
    }

    /**
     * Export the maze into an image in a local directory
     */
    void export() {
        //Open up file browser to select destination
    }

    public LocalDateTime getDateTimeCreated() {
        return dateTimeCreated;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public abstract void generateMaze(int x, int y);
}