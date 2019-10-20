package Practice;

import java.util.Map;
import java.util.TreeMap;

public class Tomtom {

	public static void main(String[] args) {

		int arr[] = { 0, 3, 3, 7, 5, 3, 11, 1 };
		// int arr[] = {1,4,7,3,3,5};
		Tomtom.findPairWithMinSumBruteForce(arr);
	}

	public static void findPairWithMinSumBruteForce(int arr[]) {
		if (arr.length < 2)
			return;
		// Suppose 1st two element has minimum sum
		Map<Integer, Integer> obj = new TreeMap<>();
		int minimumSum = arr[0] + arr[1];
		int pair1stIndex = 0;
		int pair2ndIndex = 1;
		int minIndex = arr.length;
		int left, right;
		for (int i = 0; i < arr.length; i++) {
			/*if (i < arr.length - 1) {
				minimumSum = arr[i] + arr[i + 1];
				minIndex = arr.length;
			}*/
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j])
					continue;

				//int tempSum = arr[i] - arr[j];
				//int tempIndex = Math.abs(i - j);
				if (arr[i] < arr[j]) {
					left = arr[i];
					right = arr[j];
				} else {
					right = arr[i];
					left = arr[j];
				}
				for (int k = j+1; k < arr.length; k++) {
					if (arr[k] == left || arr[k] == right)
						continue;
					if (k==i || k==j) continue;
					if ((arr[k] > left) && (arr[k] < right)) {
						continue;
						
					}else {
						System.out
						.println(" The pair whose sum is closest to zero : " + left + " " + right + " arr[k]:"+ arr[k]);
					}
					//obj.put(minIndex, minimumSum);

				}
			}
			//System.out
					//.println(" The pair whose sum is closest to zero : " + arr[pair1stIndex] + " " + arr[pair2ndIndex]);
			// System.out.println(" TIndex : "+pair1stIndex+" "+ pair2ndIndex);
		}
		// System.out.println(" The pair whose sum is closest to zero :
		// "+arr[pair1stIndex]+" "+ arr[pair2ndIndex]);
		// System.out.println(" TIndex : "+pair1stIndex+" "+ pair2ndIndex);
		// System.out.println(obj);
	}
}
