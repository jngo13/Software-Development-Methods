
/**
 * Homework 1 Justin Ngo, jmn4fms Sources: Big Java book
 */

public class Photograph {

    /**
     * Holds the caption of the photograph
     */
    private String caption;

    /**
     * Holds the file name of the photograph
     */
    private String filename;

    /**
     * Constructs a photograph taking in a caption and a file name.
     * 
     * @param c caption of the photograph
     * @param f file name of the photograph
     */
    public Photograph(String c, String f) {
        caption = c;
        filename = f;
    }

    /**
     * Gets the caption of the photograph
     * 
     * @return The caption of the photograph
     */
    public String getCaption() {
        return caption;
    }

    /**
     * Gets the file name of the photograph
     * 
     * @return The file name of the photograph
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Returns true if the Photographs caption and file name is equal to the Photograph object taken in by the method.
     * Otherwise returns false.
     */
    public boolean equals(Object o) {
        if (o != null && o instanceof Photograph) {
            Photograph otherPhoto = (Photograph) o;

            if (this.caption == otherPhoto.caption && this.filename == otherPhoto.filename) {
                return true;
            }
        }
        return false;
    }

    /**
     * Prints out Photograph object. Generates a string that shows the values of the Photograph caption and file name.
     */
    public String toString() {
        return "Photograph with caption: " + caption + " and file name: " + filename;
    }

}
