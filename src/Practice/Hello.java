/**
 * 
 */
package Practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.UUID;

/**
 * @author abhibane
 *
 */
public class Hello {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("hello Abhijeet");

		byte x =1;
		double y =2.2;
		getFactor(x,y);
		getGUID();
	}

	public static double getFactor(byte x, double y) {
		return (long)x / y * 3;
	}

	public static void getGUID() {
		try{
			
		File file = new File("out.txt");
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		System.setOut(ps);
		for (int i = 0; i< 200000; i++)
			System.out.println(UUID.randomUUID());
		}
		catch(FileNotFoundException ex){}
	}
}
