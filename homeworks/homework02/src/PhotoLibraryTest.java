import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class PhotoLibraryTest {

    PhotoLibrary justin;
    PhotoLibrary elise;

    Photograph waterfall;
    Photograph party;
    Photograph birthday;
    Photograph milkshakes;
    Photograph thecorner;
    Photograph rotunda;
    Photograph fruitpunch;
    Photograph sunset;

    @Before
    public void setUp() {
        justin = new PhotoLibrary("Justin", 318);
        elise = new PhotoLibrary("Elise", 206);

        // Tests Photograph constructor
        waterfall = new Photograph("look at this waterfall", "waterfall.jpg", "2008-10-03", 4);
        party = new Photograph("fun night", "party.jpg", "2016-03-19", 3);
        birthday = new Photograph("happy birthday Anh", "bday.jpg", "2019-09-13", 4);
        milkshakes = new Photograph("cookies and cream", "milkshakes.jpg", "2019-09-14", 5);
        thecorner = new Photograph("night at the corner", "corner.png", "2018-06-22", 2);
        rotunda = new Photograph("wahoowa!", "rotunda.jpg", "2010-12-31", 1);
        fruitpunch = new Photograph("mmm this fruit punch is good", "fruitpunch.png", "2012-01-01", 0);

        sunset = new Photograph("sunset from kellogg", "sunset.jpg", "2019-08-23", 5);

        // Tests addPhoto()
        justin.addPhoto(waterfall);
        justin.addPhoto(party);
        justin.addPhoto(birthday);
        justin.addPhoto(milkshakes);
        justin.addPhoto(thecorner);
        justin.addPhoto(rotunda);
        justin.addPhoto(fruitpunch);
        // System.out.println("addPhoto duplicate test: " + justin.addPhoto(thecorner));
        // System.out.println();

        elise.addPhoto(birthday);
        elise.addPhoto(milkshakes);
        elise.addPhoto(rotunda);
        elise.addPhoto(fruitpunch);
        elise.addPhoto(sunset);
    }

    @Test
    public void testGetPhotos() {
        ArrayList<Photograph> actual = justin.getPhotos(4);
        ArrayList<Photograph> expected = new ArrayList<Photograph>();
        expected.add(waterfall);
        expected.add(birthday);
        expected.add(milkshakes);

        assertEquals("Array list does not contain photos of equal rating or greater\n", expected, actual);
    }

    @Test
    public void testGetPhotosNull() {
        ArrayList<Photograph> actual = justin.getPhotos(6);
        ArrayList<Photograph> expected = null;

        assertEquals("Get photos does not have selection statement for invalid ranking parameter\n", expected, actual);
    }

    @Test
    public void testGetPhotosInMonth() {
        ArrayList<Photograph> actual = justin.getPhotosInMonth(9, 2019);
        ArrayList<Photograph> expected = new ArrayList<Photograph>();
        expected.add(birthday);
        expected.add(milkshakes);

        assertEquals("Does not return photos from the month taken in\n", expected, actual);
    }

    @Test
    public void testGetPhotosInMonth2() {
        ArrayList<Photograph> actual = justin.getPhotosInMonth(5, 2019);
        ArrayList<Photograph> expected = new ArrayList<Photograph>();

        assertEquals("Does not return empty array list for month with no photos taken\n", expected, actual);

    }

    @Test
    public void testGetPhotosBetween() {
        ArrayList<Photograph> actual = justin.getPhotosBetween("2016-03-20", "2019-09-14");
        ArrayList<Photograph> expected = new ArrayList<Photograph>();
        expected.add(thecorner);
        expected.add(birthday);
        expected.add(milkshakes);

        assertEquals("Does not return photos with dates taken between given string dates\n", expected, actual);

    }

    @Test
    public void testGetPhotosBetween2() {
        ArrayList<Photograph> actual = justin.getPhotosBetween("1024-03-20", "2019-09-13");
        ArrayList<Photograph> expected = new ArrayList<Photograph>();
        expected.add(waterfall);
        expected.add(rotunda);
        expected.add(fruitpunch);
        expected.add(party);
        expected.add(thecorner);
        expected.add(birthday);

        assertEquals("Does not return photos with dates taken between given string dates\n", expected, actual);
    }

    @Test
    public void testGetPhotosBetweenFormat() {
        ArrayList<Photograph> actual = justin.getPhotosBetween("2019103-20", "2019-09113");
        ;
        assertEquals("Takes in invalid date format missing hyphen \n", null, actual);

        ArrayList<Photograph> actual2 = justin.getPhotosBetween("201a-03-20", "2019-0b-13");
        ;
        assertEquals("Takes in invalid date format allowing letters \n", null, actual2);

        ArrayList<Photograph> actual3 = justin.getPhotosBetween("2019-13-20", "2019-09-31");
        ;
        assertEquals("Takes in invalid dates \n", null, actual3);

        ArrayList<Photograph> actual4 = justin.getPhotosBetween("2019-02-28", "2018-01-01");
        ;
        assertEquals("Takes in invalid date format \n", null, actual4);

    }

    @Test
    public void testErasePhoto() {

        assertTrue(justin.erasePhoto(rotunda));

    }

    @Test
    public void testErasePhoto2() {

        assertFalse(justin.erasePhoto(sunset));
    }

    @Test
    public void similarity() {
        double actual = PhotoLibrary.similarity(justin, elise);
        double expected = 0.8;

        assertEquals("Similarity value not calculated correctly", expected, actual, 0.01);
    }

    @Test
    public void similarity2() {
        double actual = PhotoLibrary.similarity(justin, justin);
        double expected = 1.0;

        assertEquals("Similarity value not calculated correctly to make sure same object is e", expected, actual, 0.01);
    }

}

// Unimplemented Main Method Tests From Homework 1
// Tests equals() in Photograph
// System.out.println("Photograph equals() test 1: " + waterfall.equals(party));
// System.out.println("Photograph equals() test 2: " + waterfall.equals(waterfall));
// System.out.println();

// Tests toString() in Photograph
// System.out.println("Photograph toString() test 1: " + waterfall.toString()); System.out.println("Photograph
// toString() test 2: " + party.toString()); System.out.println();

// Tests hasPhoto()
// System.out.println("hasPhoto() test 1: " + justin.hasPhoto(waterfall));
// System.out.println("hasPhoto() test 2: " + justin.hasPhoto(milkshakes));
// System.out.println(); // Tests erasePhoto()
// System.out.println(justin);
// System.out.println("erasePhoto() test 1: " + justin.erasePhoto(waterfall));
// System.out.println(justin);
// System.out.println("erasePhoto() test 2: " + justin.erasePhoto(rotunda));
// System.out.println();

// Tests numPhotographs()
// System.out.println("numPhotographs() test 1: " + justin.numPhotographs());
// System.out.println("numPhotographs() test 1: " + elise.numPhotographs());
// System.out.println();

// Tests PhotoLibrary equals()
// System.out.println("equals() test 1: " + justin.equals(justin));
// System.out.println("equals() test 2: " + justin.equals(elise));
// System.out.println();

// Tests toString()
// System.out.println(justin.toString());
// System.out.println(elise.toString());
// System.out.println();
// Tests commonPhotos()
// System.out.println(commonPhotos(justin, elise));
// System.out.println(commonPhotos(justin, justin));
// System.out.println();
