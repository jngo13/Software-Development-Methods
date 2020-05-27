
/**
 * Homework 2 Justin Ngo, jmn4fms Sources: Big Java book
 */

import java.util.*;

public class Album {

    /**
     * Holds the album's name
     */
    private String name;

    /**
     * Contains a hash set of photographs in the album
     */
    private HashSet<Photograph> photos;

    /**
     * Constructs an album taking in the name of the album while also creating a hash set of the album.
     * 
     * @param n
     */
    public Album(String n) {
        name = n;
        photos = new HashSet<Photograph>();
    }

    /**
     * Gets the name of the photo album
     * 
     * @return The name of the photo album
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the photos in the album
     * 
     * @return the hash set of the photos in the album
     */
    public HashSet<Photograph> getPhotos() {
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
     * Adds photograph p to the list of photos in the album. If p is already in the album or is null, returns false. If p is
     * not in the album and added successfully, returns true.
     * 
     * @param p The photo to be added to the album
     * @return Returns false if p is already in the album or is null. Returns true if p is not in the album and added
     *         successfully.
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
     * Checks if the object contains p in its set of photos. Returns true if the photos set contains the photo. Returns
     * false if the photos set does not contain the photograph.
     * 
     * @param p the photograph to be checked in the photos set
     * @return True if the photos set contains or has the photo. False if the photos set does not contain or have the photo.
     */
    public boolean hasPhoto(Photograph p) {
        if (photos.contains(p) == true) {
            return true;
        } else
            return false;
    }

    /**
     * Removes a photograph from the photos set if it exists within it already. Returns true if the photograph is
     * successfully removed. Returns false otherwise.
     * 
     * @param p The photograph to be removed from the photos set.
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
     * Returns the number of photos in the photos set.
     * 
     * @return Integer value of number of photos in the photo library.
     */
    public int numPhotographs() {
        return photos.size();
    }

    /**
     * Returns true if album object's name value is equal to the name value of the album object taken in by the method.
     * Otherwise returns false.
     */
    public boolean equals(Object o) {
        if (o != null && o instanceof Album) {
            Album otherAlbum = (Album) o;

            if (this.name == otherAlbum.name) {
                return true;
            }
        }
        return false;
    }

    /**
     * Prints out the album object. Generates a String that shows the values of the name and the photos in the album.
     */
    public String toString() {
        return "Album name: " + name + "\nPhotos: " + photos;
    }

    /**
     * Overrides the default hashCode method in the object class to produce a unique integer hash code for an album.
     */
    public int hashCode() {
        return name.hashCode();
    }

}
