
/**
 * Homework 5 Implement the following methods on recursion as defined in the homework 5 document.
 * 
 * @author jmn4fms
 */
public class Recursion {

    /*
     * Takes in a string and returns true if the string is a palindrome and false otherwise
     */
    public static boolean palindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true; // if the recursion gets down to 1 or no more letters returns true that it is a palindrome
        }
        if (s.substring(0, 1).equals(s.substring(s.length() - 1))) { // if the first letter of the string is equal to the last
                                                                     // continue recursing
            return palindrome(s.substring(1, s.length() - 1));
        }
        return false; // returns false if recursion does not continue and the string is not a palindrome
    }

    /*
     * Takes in a string and returns the reverse of the string
     */
    public static String reverseString(String s) {
        if (s.length() < 1)
            return s; // returns the final reversed string
        return reverseString(s.substring(1)) + s.substring(0, 1); // recurses the first letter of the string to the end
    }

    /*
     * Returns an int for the total number of handshakes for n people in a room in which each person shakes hands once with
     * every other person.
     */
    public static int handshakes(int n) {
        // n==0 indicates all the handshakes have taken place
        if (n == 0) {
            return 0;
        }
        return (n - 1) + handshakes(n - 1);
    }

    /*
     * Solves Ackermann's function and returns a long.
     */
    public static long ackermann(long m, long n) {
        if (m == 0) {
            return n + 1;
        } else if (m > 0 && n == 0) {
            return ackermann(m - 1, 1);
        } else {
            return ackermann(m - 1, ackermann(m, n - 1));
        }

    }

    public static void main(String[] args) {
        // Two tests per method, comment expected and actual output

        // palindrome tests
        System.out.println(palindrome("abba")); // Expected: true
        System.out.println(palindrome("racecar")); // Expected: true
        System.out.println(palindrome("smith")); // Expected: false
        System.out.println(palindrome("redder")); // Expected: true
        System.out.println(palindrome("calculus")); // Expected: false

        // reverseString tests
        System.out.println(reverseString("racecar")); // Expected: "racecar"
        System.out.println(reverseString("CS2110")); // Expected: "0112SC"
        System.out.println(reverseString("I love CS!")); // Expected: "!SC evol I"
        System.out.println(reverseString("kayak")); // Expected: "kayak"
        System.out.println(reverseString("Will is the best roommate!")); // Expected: "!etammoor tseb eht si lliW"

        // handshakes tests
        System.out.println(handshakes(0)); // Expected: 0
        System.out.println(handshakes(3)); // Expected: 3
        System.out.println(handshakes(6)); // Expected: 15
        System.out.println(handshakes(2)); // Expected: 1
        System.out.println(handshakes(5)); // Expected: 10

        // Ackermann tests
        System.out.println(ackermann(0, 0)); // Expected: 1
        System.out.println(ackermann(2, 0)); // Expected: 3
        System.out.println(ackermann(3, 4)); // Expected: 125
        System.out.println(ackermann(2, 1)); // Expected: 5
        System.out.println(ackermann(3, 2)); // Expected: 29
    }
}
