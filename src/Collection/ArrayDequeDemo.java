/**
 * 
 */
package Collection;

import java.util.ArrayDeque;

/**
 * @author abhibane
 *
 */
final class ArrayDequeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayDeque<String> ad = new ArrayDeque<String>(); 
		
		ad.push("D");
		ad.push("A");
		ad.push("E");
		ad.push("B");
		ad.push("F");
		ad.push("C");
		
		System.out.println("Total Elements in ArrayDeque: "+ad);
		
		System.out.println("Popping Data:");
		
		while (ad.peek() != null)
			System.out.println("Element Popped: "+ad.pop());
	}

}
