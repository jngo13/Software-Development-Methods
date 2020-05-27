import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Homework 5 Card Creator This class defines the thread task that will "come up with" and submit greeting card ideas to
 * the print queue. We have added the code necessary to read from the file, but it's up to you to handle turning off the
 * printer (keeping track of how many threads are open) and adding the read-in line from the inspiration file to the
 * queue.
 * 
 * @author jmn4fms
 */
public class CardCreator implements Runnable {

    /**
     * Print queue to add new card ideas
     */
    private PrintQueue printQueue;

    /**
     * Inspiration file name
     */
    private String filename;

    /*
     * Counts how many card creator methods are created and keeps track in order to turn off
     */
    private static int count;

    /*
     * Card creator constructor
     */
    public CardCreator(PrintQueue d, String filename) {
        printQueue = d;
        this.filename = filename;
        count++; // increment count field
    }

    /**
     * Run method that is the main method for the thread
     */
    @Override
    public void run() {
        Scanner s = null;
        try {
            s = new Scanner(new FileReader(filename));

            while (s.hasNextLine()) {
                // TODO: Read the next line from the inspiration file
                String str = s.nextLine();
                // TODO: Enqueue the line into the print queue
                printQueue.enqueue(str);
                Thread.sleep(1000); // Sleeps for 1 second or 1000ms before submitting next slogan
            }
        } catch (IOException e) {
            System.out.println("Could not read file");
        } catch (Exception e) {
            // System.out.println("Exception");
        } finally {
            if (s != null)
                s.close();

            count--; // decrements count

            // TODO: Turn off the print queue (if applicable)
            // i.e., if you're the last card creator left
            if (count == 0) {
                printQueue.turnOff(); // Turns off when no cards left
            }

        }
    }
}
