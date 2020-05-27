
/**
 * Homework 3 Justin Ngo, jmn4fms Sources: Big Java book
 */

import java.util.Comparator;

public class CompareByCaption implements Comparator<Photograph> {

    /**
     * Compares two Photographs by caption (in alphabetical order). If the two captions are identical, then compare by
     * caption in alphabetical order.
     */
    public int compare(Photograph p1, Photograph p2) {
        if (p1.getCaption().compareToIgnoreCase(p2.getCaption()) == 0) {
            if (p1.getRating() > p2.getRating()) {
                return -1;
            } else if (p1.getRating() < p2.getRating()) {
                return 1;
            } else
                return 0;
        }

        return p1.getCaption().compareToIgnoreCase(p2.getCaption());
    }
}
