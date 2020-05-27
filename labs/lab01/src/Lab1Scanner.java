import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Lab1Scanner {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner theInput = new Scanner(System.in);

		int sum = 0;
		for (int i = 0; i < 5; i++) {
			System.out.println("Type in number " + (i + 1) + ":");
			int x = theInput.nextInt();
			sum += x;
		}

		double average = sum / 5;
		System.out.println(average);

		/*
		 * File theFile = new File("data1.txt"); Scanner fileScnr = new
		 * Scanner(theFile);
		 * 
		 * while(fileScnr.hasNext()) { System.out.print(fileScnr.next());
		 * System.out.print(" "); } System.out.println();
		 * System.out.println("The file size is " + theFile.length() + " bytes");
		 * System.out.println("The full name of the file is: " +
		 * theFile.getAbsolutePath());
		 */
	}

}
