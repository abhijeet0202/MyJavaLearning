package String;

import java.util.ArrayList;
import java.util.List;

class indexOf {

	public static int count(List<String> str, int k) {
		int count = 0;
		//k=k+49;
		for (String s : str) {
			char[] ch = s.toCharArray();
			//Character.isDigit(ch);
			if (Character.isDigit(s.charAt(0)) &&  k > s.charAt(0)) {
				++count;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String str = "My Name is Abhijeet, Studying String's character Searching, which is important";

		// Character Search
		System.out.println(str.indexOf('a'));
		System.out.println(str.lastIndexOf('a'));

		// String Search
		System.out.println(str.indexOf("is"));
		System.out.println(str.lastIndexOf("is"));

		// String Search after given index
		System.out.println(str.indexOf("is", 10));
		System.out.println(str.lastIndexOf("is", 46));

		List<String> myData = new ArrayList<String>();
		myData.add("1");
		myData.add("2");
		myData.add("3");
		myData.add("Four");

		indexOf.count(myData, 2);

	}

}
