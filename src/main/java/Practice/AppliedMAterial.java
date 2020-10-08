package Practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppliedMAterial {

	List<String> myList = new ArrayList<>();
	Map<String, String> myMay = new HashMap<String, String>();

	// Question1 : Start
//	int rows=4;
//	int cols=4;
//	static int initR=1;
//	static int initC=2;
//	static int finalR=3;
//	static int finalC=3;
//	public static List<Integer> costRows;
//	public static List<Integer> costCols;
	// Question1 : End

	// Question2 : Start
//	int rows = 3;
//	int cols = 3;
//	static int initR = 0;
//	static int initC = 0;
//	static int finalR = 1;
//	static int finalC = 2;
//	public static List<Integer> costRows;
//	public static List<Integer> costCols;
//
//	// Question2 : End
//	static int cost;

//	public static int minCost(int cost, int finalR, int finalC) {
//		if (finalC < initC || finalR < initR)
//			return Integer.MAX_VALUE;
//		else if (finalC == initC && finalR == initR)
//			return cost;
//		else
//			return cost + Math.min(minCost(costRows.get(finalR), finalR - 1, finalC),
//					minCost(costCols.get(finalC), finalR, finalC - 1));
//	}

	public static void main(String[] args) {
		
		int arr[] = new int[] {1,2,3,4,5};
		int ii =2;
		int j =4;
		
		//logic
		int myarr[] = new int[arr.length];
		myarr[0] = arr[0];
		for (int i=1;i <arr.length;i++) {
			myarr[i] = arr[i]+myarr[i-1];
		}
		
		//First create an extra array where we will keep sum of all the index
		if(ii <0) {
			int answer = myarr[j];
		}else {
			int answer = myarr[j]- myarr[ii-1];
		}
		
		
//		try {
//			Cipher.getMaxAllowedKeyLength("AES");
//		} catch (NoSuchAlgorithmException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// Question1 : Start
//		costRows = new ArrayList<Integer>();
//		costRows.add(3);
//		costRows.add(1);
//		costRows.add(2);
//		costRows.add(3);
//
//		costCols = new ArrayList<Integer>();
//		costCols.add(3);
//		costCols.add(7);
//		costCols.add(8);
//		costCols.add(9);
		// Question1 : END

		// Question2 : Start
//		
//		  costRows = new ArrayList<Integer>(); 
//		  costRows.add(0);
//		  costRows.add(2); 
//		  costRows.add(5);
//		  
//		 
//		 costCols = new ArrayList<Integer>();
//		 costCols.add(0);
//		 costCols.add(6);
//		 costCols.add(1);
//		 
//		
//		// Question2 : END
//		System.out.println(AppliedMAterial.minCost(0, finalR, finalC));

	}

}
