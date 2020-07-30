package Practice;

import java.util.HashMap;
import java.util.Map;

public class CodilityDemo {

	public static void main(String[] args) {
		CodilityDemo codilityDemo = new CodilityDemo();
		int arr[] = new int[] {4,3,3,4,1,2,2,3,6,5,4,5};
		String yes = codilityDemo.solution(arr);
		System.out.println(yes);
	}
	public String solution(int[] A) {
		int three_A = 0;
		int two_A = 0;
		int One_A = 0;
		Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < A.length; i++) {
			if (myMap.containsKey(A[i])) {
				int count = myMap.get(A[i]);
				myMap.put(A[i], ++count);
			} else {
				myMap.put(A[i], 1);
			}
		}
		for (Map.Entry<Integer, Integer> myEntry : myMap.entrySet()) {
			int count = myEntry.getValue();
			if (count == 3) {
				three_A++;
			}
			if (count == 2) {
				two_A++;
			}
			if (count == 1) {
				One_A++;
			}
		}
		if (three_A == 2 && two_A == 2 && One_A == 2) {
			return "YES";
		}
		return "NO";
	}
}
