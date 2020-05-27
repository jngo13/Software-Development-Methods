import java.util.ArrayList;

/**
 * Homework 2 Justin Ngo, jmn4fms Sources: Big Java book
 */

public class Album extends PhotographContainer {

    /**
     * Constructs an album taking in the name of the album while also creating a hash set of the album.
     * 
     * @param n
     */
    public Album(String n) {
        super(n);
        photos = new ArrayList<Photograph>();
    }

}
