package String;

class StringConstructor {

	public static void main(String[] args) {
		char arr[] = {'a', 'b', 'h', 'i', 'j', 'e', 'e', 't'};
		String str = new String(arr);
		System.out.println(str);
		
		String str1 = new String(str);
		System.out.println(str1);
		
		byte mybyte[] = {65, 66, 72, 73, 74, 69, 69, 84};
		String str3 = new String(mybyte);
		System.out.println(str3);
	}

}
