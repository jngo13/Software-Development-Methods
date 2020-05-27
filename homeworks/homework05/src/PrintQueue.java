import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Homework 5 PrintQueue Implement the class below as specified in the homework 5 document.
 * 
 * @author jmn4fms
 */

// Don't forget to include the appropriate import statements

public class PrintQueue {

    private LinkedList<String> toPrint;     // the printer's list of documents
    private Lock documentChangeLock;  // a ReentrantLock lock
    private Condition hasPrintTask;   // a condition object
    private boolean isOn;             // boolean variable describing if the
                                      // queue is on (accepting jobs)

    // TODO: Handle locking and conditions around the
    // enqueueing and dequeuing of documents
    // in this PrintQueue's document list (toPrint)
    // Note: See example in the zip folder 'Thread Example 6 - Bank Deadlock'

    /**
     * Constructor
     */
    public PrintQueue() {
        toPrint = new LinkedList<String>(); // create the list of documents
        isOn = true; // turn on the print queue
        documentChangeLock = new ReentrantLock(); // Creates lock
        hasPrintTask = documentChangeLock.newCondition(); // Sets new condition
    }

    /**
     * Adds the greeting given by the String parameter onto the end of the print queue.
     * 
     * @param greeting to be added to the print queue
     */
    public void enqueue(String s) {
        documentChangeLock.lock();
        try {
            toPrint.add(s); // add to the list of documents
            hasPrintTask.signalAll(); // for the await
        } finally {
            documentChangeLock.unlock();
        }
    }

    /**
     * Removes the head element off the queue and returns it.
     * 
     * @return the head element of the queue to be removed
     */
    public String dequeue() {
        documentChangeLock.lock(); // lock
        String str = null;
        try {
            while (isOn && toPrint.isEmpty()) {
                hasPrintTask.await(); // waits to proceed based on condition
            }
            str = toPrint.remove();
        } catch (Exception e) {
            // System.out.println("Exception");
        } finally {
            documentChangeLock.unlock();
        }
        return str; // return the first document
    }

    /**
     * Turns off the print queue. The last running creator should turn off the queue so that the printer thread(s) know to
     * stop.
     */
    public void turnOff() {
        documentChangeLock.lock();
        isOn = false;
        hasPrintTask.signalAll(); // for the await
        documentChangeLock.unlock();
    }

    /**
     * If the PrintQueue is still accepting jobs returns true, otherwise false if it has been "turned off"
     * 
     * @return true if the PrintQueue is still accepting jobs, false if it has been "turned off"
     */
    public boolean isOn() {
        if (isOn) {
            return true;
        }
        return false;
    }

}
