
/**
 * Homework 1 Justin Ngo, jmn4fms Sources: Big Java book
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
     * Constructs a photo library taking a name and id while also creating a new array list of photographs
     * 
     * @param n Name of the photo library
     * @param i id number of the photo library
     */
    public PhotoLibrary(String n, int i) {
        name = n;
        id = i;
        photos = new ArrayList<Photograph>();
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
     * Removes a photograph from the photo library if it exists within it. Returns true if the photograph is successfully
     * removed. Returns false otherwise.
     * 
     * @param p The photograph to be removed from the photo library.
     * @return True if the photograph is successfully removed. Returns false otherwise.
     */
    public boolean erasePhoto(Photograph p) {
        if (hasPhoto(p) == true) {
            photos.remove(p);
            return true;
        }
        return false;
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
     * Prints out PhotoLibrary object. Generates a String that shows the values of the fields name, id, and photos.
     */
    public String toString() {
        return "Photograph library with name: " + name + " and id: " + id + " and photos " + photos;
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

    public static void main(String[] args) {
        // Tests PhotoLibrary constructor
        PhotoLibrary justin = new PhotoLibrary("Justin", 13);
        PhotoLibrary elise = new PhotoLibrary("Elise", 206);

        // Tests Photograph constructor
        Photograph waterfall = new Photograph("look at this waterfall", "waterfall.jpg");
        Photograph party = new Photograph("fun night", "party.jpg");
        Photograph birthday = new Photograph("happy birthday Anh", "bday.jpg");
        Photograph milkshakes = new Photograph("cookies and cream", "milkshakes.jpg");
        Photograph thecorner = new Photograph("night at the corner", "corner.png");
        Photograph rotunda = new Photograph("wahoowa!", "rotunda.jpg");
        Photograph fruitpunch = new Photograph("mmm this fruit punch is good", "fruitpunch.png");

        // Tests addPhoto()
        justin.addPhoto(waterfall);
        justin.addPhoto(party);
        justin.addPhoto(birthday);
        justin.addPhoto(milkshakes);
        justin.addPhoto(thecorner);

        System.out.println("addPhoto duplicate test: " + justin.addPhoto(thecorner));
        System.out.println();

        elise.addPhoto(birthday);
        elise.addPhoto(milkshakes);
        elise.addPhoto(rotunda);
        elise.addPhoto(fruitpunch);

        // Tests equals() in Photograph
        System.out.println("Photograph equals() test 1: " + waterfall.equals(party));
        System.out.println("Photograph equals() test 2: " + waterfall.equals(waterfall));
        System.out.println();

        // Tests toString() in Photograph
        System.out.println("Photograph toString() test 1: " + waterfall.toString());
        System.out.println("Photograph toString() test 2: " + party.toString());
        System.out.println();

        // Tests hasPhoto()
        System.out.println("hasPhoto() test 1: " + justin.hasPhoto(waterfall));
        System.out.println("hasPhoto() test 2: " + justin.hasPhoto(milkshakes));
        System.out.println();

        // Tests erasePhoto()
        System.out.println(justin);
        System.out.println("erasePhoto() test 1: " + justin.erasePhoto(waterfall));
        System.out.println(justin);
        System.out.println("erasePhoto() test 2: " + justin.erasePhoto(rotunda));
        System.out.println();

        // Tests numPhotographs()
        System.out.println("numPhotographs() test 1: " + justin.numPhotographs());
        System.out.println("numPhotographs() test 1: " + elise.numPhotographs());
        System.out.println();

        // Tests PhotoLibrary equals()
        System.out.println("equals() test 1: " + justin.equals(justin));
        System.out.println("equals() test 2: " + justin.equals(elise));
        System.out.println();

        // Tests toString()
        System.out.println(justin.toString());
        System.out.println(elise.toString());
        System.out.println();

        // Tests commonPhotos()
        System.out.println(commonPhotos(justin, elise));
        System.out.println(commonPhotos(justin, justin));
        System.out.println();

        // Tests similarity()
        System.out.println("similarity() test 1 result:" + similarity(justin, elise) + " expected: 0.5");
        System.out.println("similarity() test 2 result:" + similarity(justin, justin) + " expected 1.0");

    }

}
