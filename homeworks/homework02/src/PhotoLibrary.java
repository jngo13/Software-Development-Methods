
/**
 * Homework 2 Justin Ngo, jmn4fms Sources: Big Java book
 */

import java.util.*;

public class PhotoLibrary {

    /**
     * Holds the name of the photo library
     */

    private String name;
    /**
     * Holds the id number of the photo library
     */
    private int id;

    /**
     * Contains the photographs in the photo library
     */
    private ArrayList<Photograph> photos;

    /**
     * Contains the albums in the photo library
     */
    private HashSet<Album> albums;

    /**
     * Constructs a photo library taking a name and id while also creating a new array list of photographs
     * 
     * @param n Name of the photo library
     * @param i id number of the photo library
     */
    public PhotoLibrary(String n, int i) {
        name = n;
        id = i;
        photos = new ArrayList<Photograph>();
        albums = new HashSet<Album>();
    }

    /**
     * Gets the name of the photo library
     * 
     * @return The name of the book
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the id of the photo library
     * 
     * @return The id of the photo library
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the array list of photographs in the photo library
     * 
     * @return The array list of photographs
     */
    public ArrayList<Photograph> getPhotos() {
        return photos;
    }

    /**
     * Gets the hash set of the albums in the photo library
     * 
     * @return The hash set of albums
     */
    public HashSet<Album> getAlbums() {
        return albums;
    }

    /**
     * Sets the name of the photo library
     * 
     * @param a The updated name of the photo library
     */
    public void setName(String a) {
        name = a;
    }

    /**
     * Adds photograph to the photo library array list if and only if it was not already in the list. Returns false if the
     * photo library already contains the photo and does not add the photo. Returns true if the photo is added successfully.
     * 
     * @param p The photograph to be added
     * @return True if the photograph is added. False if the photograph is not added
     */
    public boolean addPhoto(Photograph p) {
        if (photos.contains(p) == true) {
            return false;
        }
        photos.add(p);
        return true;
    }

    /**
     * Checks if the object contains p in its list of photos. Returns true if the photo library contains the photo. Returns
     * false if the photo library does not contain the photograph.
     * 
     * @param p the photograph to be checked in the photo library
     * @return True if the photo library contains or has the photo. False if the photo library does not contain or have the
     *         photo.
     */
    public boolean hasPhoto(Photograph p) {
        if (photos.contains(p) == true) {
            return true;
        }
        return false;
    }

    /**
     * Removes a photograph from the photo library and album if it exists within it. Returns true if the photograph is
     * successfully removed. Returns false otherwise.
     * 
     * @param p The photograph to be removed from the photo library and album.
     * @return True if the photograph is successfully removed. Returns false otherwise.
     */
    public boolean erasePhoto(Photograph p) {
        // If photo library contains photograph p then it removes the photograph
        if (hasPhoto(p) == true) {
            photos.remove(p);

            // for each loop searching for photograph in albums list and in each album. If an album in the album list contains the
            // photograph then it is removed.

            for (Album a : albums) {
                if (a.getPhotos().contains(p)) {
                    a.getPhotos().remove(p);
                }
            }

            return true; // Returns true if both are successfully searched for and removed
        }

        return false;// Returns false even if an album contains the photograph. The photograph in the album is not removed.
    }

    /**
     * Returns the number of photos in the photo library array list.
     * 
     * @return Integer value of number of photos in the photo library.
     */
    public int numPhotographs() {
        return photos.size();
    }

    /**
     * Returns true if PhotoLibrary object's id value is equal to the id value of the PhotoLibrary object taken in by the
     * method. Otherwise returns false.
     */
    public boolean equals(Object o) {
        if (o != null && o instanceof PhotoLibrary) {
            PhotoLibrary otherPL = (PhotoLibrary) o;

            if (this.id == otherPL.id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Prints out PhotoLibrary object. Generates a String that shows the values of the fields name, id, photos, and albums.
     */
    public String toString() {
        return "Photograph library with name: " + name + " \nid: " + id + "\nphotos: " + photos + "\n albums: " + albums;
    }

    /**
     * Returns an array list of photographs that both PhotoLibrary a and PhotoLibrary b have posted to their feeds.
     * 
     * @param a The first PhotoLibrary
     * @param b The second PhotoLibrary
     * @return Array List of photographs that both PhotoLibrary a and PhotoLibrary b have posted to their feeds.
     */
    public static ArrayList<Photograph> commonPhotos(PhotoLibrary a, PhotoLibrary b) {

        ArrayList<Photograph> combo = new ArrayList<Photograph>(); // Constructs the array list containing the photographs to be
                                                                   // returned

        if (a.numPhotographs() >= b.numPhotographs()) { // if number of photographs in a is greater than b, run the loop to the
                                                        // length of a
            for (int i = 0; i < a.numPhotographs(); i++) {
                for (int k = 0; k < b.numPhotographs(); k++) { // nested for loops to compare each picture in a to b
                    if (a.getPhotos().get(i).equals(b.getPhotos().get(k)))
                        if (combo.contains(b.getPhotos().get(k)) == false) {
                            combo.add(a.getPhotos().get(i));
                        }
                }
            }
        } else {
            for (int i = 0; i < b.numPhotographs(); i++) { // if number of photographs in b is greater than a, run the loop to the
                                                           // length of b
                for (int k = 0; k < a.numPhotographs(); k++) { // nested for loops to compare each picture in b to a
                    if (b.getPhotos().get(i).equals(a.getPhotos().get(k)))
                        if (combo.contains(a.getPhotos().get(k)) == false) {
                            combo.add(b.getPhotos().get(i));
                        }
                }
            }
        }

        return combo;
    }

    /**
     * Returns a measure of how similar the photo feeds are between PhotoLibrary a and PhotoLibrary b in terms of numerical
     * value between 0.0 and 1.0. If either PhotoLibrary does not have any photos, the result is 0.0.
     * 
     * @param a The first PhotoLibrary being compared.
     * @param b The second PhotoLibrary being compared.
     * @return Double value measure of similarity between 0.0 and 1.0.
     */
    public static double similarity(PhotoLibrary a, PhotoLibrary b) {
        if (a.numPhotographs() == 0 || b.numPhotographs() == 0) {
            return 0;
        }
        double smaller = -1;// creates smaller variable. Initialized negative to indicate error if not dividing properly.
        if (a.numPhotographs() >= b.numPhotographs()) { // sets variable smaller to be size of smaller PhotoLibrary for division
                                                        // before returning.
            smaller = b.numPhotographs();
        } else
            smaller = a.numPhotographs();
        return (commonPhotos(a, b).size() / (double) smaller);
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

    /**
     * Creates a new Album with name albumName and adds it to the list of albums only if an album with that name does not
     * already exist. Returns true if the add was successful, false otherwise.
     * 
     * @param albumName The name of the album to be added.
     * @return Returns true if the album was successfully added, false otherwise.
     */
    public boolean createAlbum(String albumName) {
        Album alb = new Album(albumName);
        if (albums.contains(alb)) {
            return false;
        } else {
            albums.add(alb);
            return true;
        }
    }

    /**
     * Removes the Album with name albumName if an Album with that name exists in the set of albums. Returns true if the
     * remove was successful, false otherwise.
     * 
     * @param albumName The name of the album to be added.
     * @return Returns true if the album was successfully removed, false otherwise.
     */
    public boolean removeAlbum(String albumName) {
        for (Album a : albums) {
            if (a.getName().equals(albumName)) {
                albums.remove(a);
                return true;
            }
        }
        return false;
    }

    /**
     * Add the Photograph p to the Album in the set of albums that has name albumName if and only if it is in the
     * PhotoLibrary's list of photos and it was not already in that album. Returns true if the Photograph was added; returns
     * false if it was not added.
     * 
     * @param p         The photograph to be added to the album.
     * @param albumName The albumName of the album the photograph is to be added.
     * @return Returns true if the Photograph was added; returns false if it was not added.
     */
    public boolean addPhotoToAlbum(Photograph p, String albumName) {
        if (hasPhoto(p) == true) {
            for (Album a : albums) {
                if (a.getName().equals(albumName)) {
                    a.addPhoto(p);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Removes the Photograph p from the Album in the set of albums that has name albumName. Return true if the photo was
     * successfully removed, otherwise returns false.
     * 
     * @param p         The photograph to be removed from the album.
     * @param albumName The albumName of the album the photograph is to be removed.
     * @return Return true if the photo was successfully removed, otherwise returns false.
     */
    public boolean removePhotoFromAlbum(Photograph p, String albumName) {
        for (Album a : albums) {
            if (a.getName().equals(albumName)) {
                if (a.getPhotos().contains(p)) {
                    a.removePhoto(p);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Given an album name, returns the Album with that name from the list of albums. If the album with that name is not
     * found, returns null.
     * 
     * @param albumName The album name of the album being searched for in the list of albums.
     * @return Returns true if the photo was successfully removed. Returns false otherwise.
     */
    private Album getAlbumByName(String albumName) {
        for (Album a : albums) {
            if (a.getName().equals(albumName)) {
                return a;
            }
        }
        return null;
    }

    // Main method tests
    public static void main(String[] args) {
        Photograph waterfall = new Photograph("look at this waterfall", "waterfall.jpg", "2008-10-03", 4);
        Photograph party = new Photograph("fun night", "party.jpg", "2016-03-19", 3);
        Album test = new Album("justin");
        test.addPhoto(waterfall);
        // test.addPhoto(party);
        PhotoLibrary photolib = new PhotoLibrary("library", 12);
        photolib.albums.add(test);

        boolean testresult = photolib.removePhotoFromAlbum(party, "justin");
        System.out.println(testresult);

    }
}
