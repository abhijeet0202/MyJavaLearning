/**
 * 
 */
package Maps;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author abhibane
 *
 */
final class TreeMapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeMap<String, Double> tmObj = new TreeMap<String, Double>();
		
		tmObj.put("John Doe", 3434.34);
		tmObj.put("Tom Smith", 123.22);
		tmObj.put("Jane Baker", 1378.00);
		tmObj.put("Tod Hall", 99.22);
		tmObj.put("Ralph Smith", -19.08);
		
		Set<Map.Entry<String, Double>> set = tmObj.entrySet();
		
		for (Map.Entry<String,Double> myset :set){
			System.out.println(myset.getKey() + ":" + myset.getValue());
		}
		
		double balance = tmObj.get("John Doe");
		tmObj.put("John Doe", balance + 1000.00);
		
		System.out.println(tmObj);

	}

}
