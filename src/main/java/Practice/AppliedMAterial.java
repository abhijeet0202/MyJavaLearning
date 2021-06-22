package Practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AppliedMAterial {
	
	static int noOfShops = 0;
	static int noOfQueries = 0;
	static int[] sweetnessLevel = new int[noOfShops];
	static int[] cost= null;
	static boolean[] isStocked = null;

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

	public long[] fix(long arr[]) {
		arr[1] = 7;
		return arr;

	}

	void start() {
		long[] a1 = { 3, 4, 5 };
		long[] a2 = fix(a1);
		System.out.println(a1[1]);
		System.out.println(a2[0] + a2[1]);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String line1 = scan.nextLine();
		String[] str = line1.split(" ");
		noOfShops = Integer.valueOf(str[0]);
		
		isStocked = new boolean[noOfShops];
		noOfQueries = Integer.valueOf(str[1]);

		String line2 = scan.nextLine();
		String[] cost1 = line2.split(" ");
		int j=0;
		cost = new int[noOfShops];
		for(String s: cost1) {
			cost[j] = Integer.valueOf(s);
			j++;
		}

		String line3 = scan.nextLine();
		String[] sweetnessLevel1 = line3.split(" ");
		j=0;
		sweetnessLevel = new int[noOfShops];
		for(String s: sweetnessLevel1) {
			sweetnessLevel[j] = Integer.parseInt(s);
			j++;
		}

		List<String> queries = new ArrayList<>();
		for (int i = 0; i < noOfQueries; i++) {
			queries.add(scan.nextLine());
		}

		for (String query : queries) {
			String[] queryBreakUp = query.split(" ");
			if (queryBreakUp[0].equals("1")) {
				tellSweteness(queryBreakUp[1], queryBreakUp[2], queryBreakUp[3]);
			} else {

				modifyStock(queryBreakUp[1], queryBreakUp[2]);
			}
		}
		System.out.println(queries);

	}

	public static void tellSweteness(String fIndex1, String lIndex1, String upperLimit1) {
		int count =0;
		int upperLimit = Integer.valueOf(upperLimit1);
		int fIndex = Integer.valueOf(fIndex1);
		int lIndex = Integer.valueOf(lIndex1);
		for (int i=fIndex-1; i<lIndex ;i++) {
			if (cost[i] <= upperLimit && !isStocked[i]) {
				count+=sweetnessLevel[i];
			}
		}
		System.out.println(count);
	}

	public static void modifyStock(String index, String isStock) {
		//int fIndex = Integer.valueOf(fIndex1);
		//int lIndex = Integer.valueOf(lIndex1);
		if(isStock.contains("0")) {
			isStocked[Integer.valueOf(index)-1] = true;
		}else {
			isStocked[Integer.valueOf(index)-1] = false;
		}
	}

}
