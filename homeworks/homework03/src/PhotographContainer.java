import java.util.ArrayList;

/**
 * Homework 3 Justin Ngo, jmn4fms Sources: Big Java book
 */

public abstract class PhotographContainer {

    /**
     * Holds the photograph container's name
     */
    protected String name;

    /**
     * ArrayList of photos in the container
     */
    protected ArrayList<Photograph> photos;

    /**
     * Constructs a photograph container taking in the name of the photograph container while also creating an array list of
     * the album.
     * 
     * @param n
     */
    public PhotographContainer(String n) {
        name = n;
        photos = new ArrayList<Photograph>();
    }

    /**
     * Gets the name of the photo container
     * 
     * @return The name of the photo container
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the photos in the album
     * 
     * @return the array list of the photos in the album
     */
    public ArrayList<Photograph> getPhotos() {
        return photos;
    }

    /**
     * Sets the name of the photo album
     * 
     * @param n The updated name of the photo album
     */
    public void setName(String n) {
        name = n;
    }

    /**
     * Adds photograph p to the list of photos in the photograph container. If p is already in the photograph container or
     * is null, returns false. If p is not in the photograph container and added successfully, returns true.
     * 
     * @param p The photo to be added to the photograph container
     * @return Returns false if p is already in the photograph container or is null. Returns true if p is not in the
     *         photograph container and added successfully.
     */
    public boolean addPhoto(Photograph p) {
        if (photos.contains(p) || p == null) {
            return false;
        } else {
            photos.add(p);
            return true;
        }
    }

    /**
     * Checks if the object contains p in its list of photos. Returns true if the photos list contains the photo. Returns
     * false if the photos list does not contain the photograph.
     * 
     * @param p the photograph to be checked in the photograph container
     * @return True if the photos list contains or has the photo. False if the photos list does not contain or have the
     *         photo.
     */
    public boolean hasPhoto(Photograph p) {
        if (photos.contains(p) == true) {
            return true;
        } else
            return false;
    }

    /**
     * Removes a photograph from the photos list if it exists within it already. Returns true if the photograph is
     * successfully removed. Returns false otherwise.
     * 
     * @param p The photograph to be removed from the photos list.
     * @return True if the photograph is successfully removed. Returns false otherwise.
     */
    public boolean removePhoto(Photograph p) {
        if (hasPhoto(p) == true) {
            photos.remove(p);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the number of photos in the photos list.
     * 
     * @return Integer value of number of photos in the photo list.
     */
    public int numPhotographs() {
        return photos.size();
    }

    /**
     * Returns true if album object's name value is equal to the name value of the photograph container object taken in by
     * the method. Otherwise returns false.
     */
    public boolean equals(Object o) {
        if (o != null && o instanceof PhotographContainer) {
            PhotographContainer otherpc = (PhotographContainer) o;

            if (this.name == otherpc.name) {
                return true;
            }
        }
        return false;
    }

    /**
     * Prints out the album object. Generates a String that shows the values of the name and the photos in the album.
     */
    public String toString() {
        return "Photograph container name: " + name + "\nPhotos: " + photos;
    }

    /**
     * Overrides the default hashCode method in the object class to produce a unique integer hash code for an album.
     */
    public int hashCode() {
        return name.hashCode();
    }

    /**
     * Returns an ArrayList of photos from the photos feed that have a rating greater than or equal to the given parameter.
     * If the rating is incorrectly formatted, return null. If there are no photos of that rating or higher, return an empty
     * array list.
     * 
     * @param rating The rating of the photograph
     * @return An array list of photographs with a rating greater than or equal to the rating taken in by the method.
     */
    public ArrayList<Photograph> getPhotos(int rating) {
        ArrayList<Photograph> greater = new ArrayList<Photograph>();
        if (rating > 5 || rating < 0) {
            return null;
        }
        for (Photograph p : photos) {
            if (p.getRating() >= rating) {
                greater.add(p);
            }
        }
        return greater;
    }

    /**
     * Return an ArrayList of photos from the photos feed that were taken in the year provided. If the month and year are
     * incorrectly formatted, return null. If there are no photos taken that month, return an empty ArrayList
     * 
     * @param year The year the photos being searched for.
     * @return An array list of photographs that were taken in a year.
     */
    public ArrayList<Photograph> getPhotosInYear(int year) {
        ArrayList<Photograph> photosInYear = new ArrayList<Photograph>();
        String stryear = Integer.toString(year);

        if (year < 1000 || year > 9999) {
            return null;
        }
        for (Photograph p : photos) {
            if (p.getDateTaken().substring(0, 4).equals(stryear)) {
                photosInYear.add(p);
            }
        }
        return photosInYear;
    }

    /**
     * Returns an ArrayList of photos from the photos feed that were taken in the month and year provided. If the month or
     * year are incorrectly formatted, return null. If there are no photos taken that month, return an empty ArrayList.
     * 
     * @param month The month of the photos being searched.
     * @param year  The year of the photos being searched.
     * @return An array list of photographs that were taken in a given month and year.
     */
    public ArrayList<Photograph> getPhotosInMonth(int month, int year) {

        ArrayList<Photograph> photosInYear = getPhotosInYear(year);
        ArrayList<Photograph> photosInMonth = new ArrayList<Photograph>();
        String strmonth = "0" + Integer.toString(month);

        if (year < 1000 || year > 9999 || month < 1 || month > 12) {
            return null;
        }

        for (Photograph p : photosInYear) {
            if (p.getDateTaken().substring(5, 7).equals(strmonth)) {
                photosInMonth.add(p);
            }
        }
        return photosInMonth;
    }

    /**
     * Returns an ArrayList of photos from the photos feed that were taken between beginDate and endDate (inclusive). If the
     * begin and end dates are incorrectly formatted, or beginDate is after endDate, return null. If there are no photos
     * taken during the period, return an empty array list.
     * 
     * @param beginDate The beginning date of photos being searched.
     * @param endDate   The ending date of the photos being searched.
     * @return An array list of photographs that were taken between beginDate and endDate (inclusive).
     */
    public ArrayList<Photograph> getPhotosBetween(String beginDate, String endDate) {
        ArrayList<Photograph> photosBetween = new ArrayList<Photograph>();

        // if statement to check formatting of String before taking substring and parsing
        if (beginDate.length() != 10 || endDate.length() != 10) {
            return null;
        }

        // if statement checking format of date for hyphens, numbers and not letters, and valid date inputs
        else if (!beginDate.substring(4, 5).equals("-") || !endDate.substring(4, 5).equals("-")
                || !beginDate.substring(7, 8).equals("-") || !endDate.substring(7, 8).equals("-")
                || !beginDate.substring(0, 4).matches("[0-9]+") || !beginDate.substring(5, 7).matches("[0-9]+")
                || !beginDate.substring(8).matches("[0-9]+") || !endDate.substring(0, 4).matches("[0-9]+")
                || !endDate.substring(5, 7).matches("[0-9]+") || !endDate.substring(8).matches("[0-9]+")
                || Integer.parseInt(beginDate.substring(5, 7)) > 12 || Integer.parseInt(endDate.substring(5, 7)) > 12
                || Integer.parseInt(beginDate.substring(5, 7)) < 1 || Integer.parseInt(endDate.substring(5, 7)) < 1
                || Integer.parseInt(beginDate.substring(8)) < 1 || Integer.parseInt(endDate.substring(8)) < 1
                || Integer.parseInt(beginDate.substring(8)) > 31 || Integer.parseInt(endDate.substring(8)) > 31
                || Integer.parseInt(beginDate.substring(0, 4)) <= 0 || Integer.parseInt(endDate.substring(0, 4)) <= 0) {
            return null;
        }

        // Turns String beginDate into int components for comparison later in method
        int beginYear = Integer.parseInt(beginDate.substring(0, 4));
        int beginMonth = Integer.parseInt(beginDate.substring(5, 7));
        int beginDay = Integer.parseInt(beginDate.substring(8));

        // Turns String endDate into int components for comparison later in method
        int endYear = Integer.parseInt(endDate.substring(0, 4));
        int endMonth = Integer.parseInt(endDate.substring(5, 7));
        int endDay = Integer.parseInt(endDate.substring(8));

        // if statements to check endDate is after beginDate, returns null if beginDate is after endDate
        if (beginYear > endYear) {
            return null;
        }
        if (beginYear == endYear && beginMonth > endMonth) {
            return null;
        }
        if (beginYear == endYear && beginMonth == endMonth && beginDay > endDay) {
            return null;
        }

        // Nested for loops to add all the photos to array list within the input year(s) regardless of before beginDate or after
        // endDate
        for (int i = beginYear; i <= endYear; i++) {
            for (Photograph p : getPhotosInYear(i)) {
                photosBetween.add(p);
            }
        }

        // Removes photographs from the photosBetween array list if they are before the beginDate
        ArrayList<Photograph> toRemove = new ArrayList<Photograph>();

        for (Photograph p : photosBetween) {
            if (Integer.parseInt((p.getDateTaken()).substring(5, 7)) <= beginMonth
                    && Integer.parseInt((p.getDateTaken()).substring(0, 4)) == beginYear) {
                if (Integer.parseInt((p.getDateTaken()).substring(8)) < beginDay) {
                    toRemove.add(p);
                }
            }
        }

        // Removes photographs from the photosBetween array list if they are after the endDate
        for (Photograph p : photosBetween) {
            if (Integer.parseInt((p.getDateTaken()).substring(5, 7)) >= endMonth
                    && Integer.parseInt((p.getDateTaken()).substring(0, 4)) == endYear) {
                if (Integer.parseInt((p.getDateTaken()).substring(8)) > endDay) {
                    toRemove.add(p);
                }
            }
        }

        // Removes all photographs in toRemove array list from photosBetween
        photosBetween.removeAll(toRemove);

        return photosBetween;
    }
}
