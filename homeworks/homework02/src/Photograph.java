
/**
 * Homework 2 Justin Ngo, jmn4fms Sources: Big Java book
 */

import java.util.*;

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
     * Contains the date the photograph was taken. Given in the format YYYY-MM-DD.
     */
    private String dateTaken;

    /**
     * Holds the rating of the photograph on a scale from 0 to 5. No other values allowed.
     */
    private int rating;

    /**
     * Constructs a photograph taking in a caption and a file name. Sets default date taken to 1901-01-01 and rating to 0.
     * 
     * @param c caption of the photograph
     * @param f file name of the photograph
     */
    public Photograph(String c, String f) {
        caption = c;
        filename = f;

        dateTaken = "1901-01-01";
        rating = 0;
    }

    /**
     * Constructs a photograph taking in a caption, file name, date taken, and rating. If the rating and/or date taken are
     * invalid then these values are set to a default date taken to 1901-01-01 and/or rating to 0.
     * 
     * @param caption,   caption of the photograph
     * @param filename,  file name of the photograph
     * @param dateTaken, date taken for the photograph
     * @param rating,    rating of the photograph
     */
    public Photograph(String caption, String filename, String dateTaken, int rating) {
        if (rating < 0 || rating > 5) {
            rating = 0;
        } else {
            this.rating = rating;
        }
        // Checks if date taken is null or empty string before going through and checking the actual contents of the string
        if (dateTaken == null) {
            this.dateTaken = "1901-01-01";
        } else if (dateTaken.equals("")) {
            this.dateTaken = "1901-01-01";
        }
        // Sets dateTaken to default date if date does not have hyphens at appropriate indexes, has a length greater than 10, or
        // if the date does not contain numbers. Also if the month > 12 or month < 0 and day >31 or day <0.
        else if (!dateTaken.substring(4, 5).equals("-") || !dateTaken.substring(7, 8).equals("-") || dateTaken.length() != 10
                || !dateTaken.substring(0, 4).matches("[0-9]+") || !dateTaken.substring(5, 7).matches("[0-9]+")
                || !dateTaken.substring(8).matches("[0-9]+") || Integer.parseInt(dateTaken.substring(5, 7)) > 12
                || Integer.parseInt(dateTaken.substring(5, 7)) < 1 || Integer.parseInt(dateTaken.substring(8)) > 31
                || Integer.parseInt(dateTaken.substring(8)) < 1 || Integer.parseInt(dateTaken.substring(0, 4)) <= 0) {

            this.dateTaken = "1901-01-01";

        }
        // Month-Days Checker: If Month With <30 days has more than 30 days sets date to default
        else if ((Integer.parseInt(dateTaken.substring(5, 7)) == 2 || Integer.parseInt(dateTaken.substring(5, 7)) == 4
                || Integer.parseInt(dateTaken.substring(5, 7)) == 6 || Integer.parseInt(dateTaken.substring(5, 7)) == 9
                || Integer.parseInt(dateTaken.substring(5, 7)) == 11) && Integer.parseInt(dateTaken.substring(8)) > 30) {

            this.dateTaken = "1901-01-01";
        }

        // Leap Year Checker
        else if ((isLeapYear(Integer.parseInt(dateTaken.substring(5, 7))) == true
                && Integer.parseInt(dateTaken.substring(5, 7)) == 2) && Integer.parseInt(dateTaken.substring(8)) > 29) {

            this.dateTaken = "1901-01-01";

        } else if (((isLeapYear(Integer.parseInt(dateTaken.substring(5, 7))) == false
                && Integer.parseInt(dateTaken.substring(5, 7)) == 2)) && Integer.parseInt(dateTaken.substring(8)) > 28) {
            this.dateTaken = "1901-01-01";
        }

        else

        {
            this.dateTaken = dateTaken;
        }

        this.caption = caption;
        this.filename = filename;

    }

    /**
     * Returns true if year is a leap year. False otherwise.
     * 
     * @param year The year to be checked if it is a leap year.
     * @return True if year is a leap year. False otherwise.
     */
    public static boolean isLeapYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
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
     * Gets the date taken of the photograph
     * 
     * @return The rating of the photograph
     */
    public String getDateTaken() {
        return dateTaken;
    }

    /**
     * Gets the rating of the photograph
     * 
     * @return The rating of the photograph
     */
    public int getRating() {
        return rating;
    }

    /**
     * Sets the caption of the photograph
     * 
     * @param c The updated caption of the photograph
     */
    public void setCaption(String c) {
        caption = c;
    }

    /**
     * Sets the rating of the photograph. If the rating is invalid (greater than 5 or less than 0) then the rating is set to
     * 0.
     * 
     * @param r The updated rating of the photograph
     */
    public void setRating(int r) {
        if (r == 0 || r == 1 || r == 2 || r == 3 || r == 4 || r == 5) {
            rating = r;
        } else {
            rating = 0;
        }
    }

    /**
     * Overrides the default hashCode method in the object class to produce a unique integer hash code for a photograph.
     */
    public int hashCode() {
        return filename.hashCode();
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

    // Main method tests
    public static void main(String[] args) {
        Photograph test = new Photograph("justin", "justin.jpg", "1901-00-04", 5);
        // System.out.println(test.getDateTaken());
        // System.out.println(test.getRating());
        // System.out.println(isLeapYear(2016));
        System.out.println(test.getDateTaken());

    }
}
