import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadInData {
	
	public static double readData(String fileName) {
		File file = new File(fileName);
		Scanner scan;
		double sum = 0;
		try {
			scan = new Scanner(file);
			int numOfValues = Integer.parseInt(scan.nextLine()); // Read in Val for # values
			for(int i = 0; i < numOfValues; i++) { // for-loop to get that many values
				sum += scan.nextDouble(); // add the values together (doubles)
			}
			scan.close();
			return sum; // return the sum of all the values in the file 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw new IllegalArgumentException("FileNotFound");
		
		} catch (NumberFormatException e) {
		e.printStackTrace();
		throw new IllegalArgumentException("Number Format error");
	
		} catch (InputMismatchException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("input did not match");
			
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Runtime error");
		
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException("exception error");
		}
		
		
		
	}
	
	public static void main(String[] args) {
		System.out.println(readData("Test3.txt"));
		System.out.println(readData("Test2.txt"));
		System.out.println(readData("Text4.txt")); // notice spelling of the file name! 
		System.out.println(readData("Test4.txt"));
	}

}
