import java.util.Arrays;

public class Queue<E> {
    private static final int INITSIZE = 10; // initial array size
    private E[] items;
    private int numItems;
    private int head; // the index of beginning of the queue
    private int tail; // the index of end of the queue
    /*
     * NOTE: tail refers to the next available index to insert an element, so in a sense the index after the last element of
     * the queue For example, if queue = [0, 3, 2, 4, null, null, ...] ^head ^ tail
     */

    /**
     * Constructor
     */
    public Queue() {
        items = (E[]) new Object[INITSIZE];
        numItems = 0;
        head = 0;
        tail = 0;
    }

    /**
     * Adds the element to the end of the queue
     * 
     * @param object to add to the queue
     */
    public void enqueue(E obj) {
        growIfNecessary();
        // System.out.println(tail);
        items[tail] = obj;
        numItems++;
        tail++;
    }

    /**
     * Removes from the front of the queue Return null if the queue is empty
     * 
     * @return the value removed
     */
    public E dequeue() {
        head++;
        numItems--;
        return items[head - 1];
    }

    /**
     * @return whether the queue is empty or not
     */
    public boolean isEmpty() {
        if (items[head] == null) {
            return true;
        }
        return false;
    }

    public void growIfNecessary() {
        if (head == tail && numItems > 0) {
            // double the length of the original stack
            E[] newItems = (E[]) new Object[2 * items.length];

            int index = 0; // index to insert in the new array
            int count = 0;
            while (count < numItems) {
                newItems[index] = items[head];

                // increment head and index
                index++;
                head++;
                count++;

                // if head is past the length of the array, loop back around to 0
                if (head >= items.length) {
                    head = 0;
                }
            }

            // set the queue to be the new queue
            items = newItems;

            // set the head of the queue to be 0
            head = 0;

            // set the tail of the queue to be numItems
            tail = numItems;
        }
    }

    /**
     * Prints the queue
     */
    public void printQueue() {
        String queue = "";
        int index = head;
        int count = 0;
        while (count < numItems) {
            queue += items[index] + " ";
            count++;
            index++;
            if (index >= items.length - 1) {
                index = 0;
            }
        }

        System.out.println("Queue of Size " + numItems + ": " + queue);
        System.out.println("Queue in Array Form: " + Arrays.toString(items));
    }

    /**
     * Reverses the given queue using a stack Use the stack that you implemented earlier in the lab
     * 
     * @param queue: the queue you want to flip
     */
    public static <T> Queue reverseQueue(Queue<T> queue) {
        Queue<T> reversed = new Queue<>();
        Stack<T> stack = new Stack<>();
        // System.out.println(queue.numItems);
        while (!queue.isEmpty()) {
            stack.push(queue.dequeue());
        }
        while (!stack.isEmpty()) {
            reversed.enqueue(stack.pop());
        }
        return reversed;
    }

    // for main method testing
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.printQueue();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.printQueue();
        queue.dequeue();
        queue.printQueue();
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.printQueue();
        Queue<Integer> reversed = reverseQueue(queue);
        reversed.printQueue();
    }
}
