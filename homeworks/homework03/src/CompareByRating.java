
/**
 * Homework 3 Justin Ngo, jmn4fms Sources: Big Java book
 */

import java.util.Comparator;

public class CompareByRating implements Comparator<Photograph> {

    /**
     * Compares two Photographs by rating (in descending order). If two ratings are identical, then comp0are by caption in
     * alphabetical order.
     */
    public int compare(Photograph p1, Photograph p2) {
        if (p1.getRating() == p2.getRating()) {
            return p1.getCaption().compareToIgnoreCase(p2.getCaption());
        } else if (p1.getRating() > p2.getRating()) {
            return -1;
        } else if (p1.getRating() < p2.getRating()) {
            return 1;
        }
        return 0;
    }
}
