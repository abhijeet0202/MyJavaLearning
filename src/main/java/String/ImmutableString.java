package String;

public class ImmutableString {
	String[] str;
	public String[] sendImmutableList() {
		str = new String[] {"Abhijeet", "Banerjee"};
		
		String[] result = new String[str.length];
		for(int i=0;i<str.length;i++) {
			
			result[i] = str[i];
		}
		return str;
	}

	public static void main(String[] args) {
		String myname = "abhijeet";
		System.out.println(myname);
		
		String mySecondNm = myname;
		System.out.println(myname+ " "+mySecondNm );
		
		myname = myname.concat(" banerjee");
		System.out.println(myname+" "+mySecondNm);
		
		myname.concat("21786");  //This will not add any thing: Assignment missing
		System.out.println(myname+" "+mySecondNm);
		
		
		//Test Immuatble list
		ImmutableString im = new ImmutableString();
		String[] s = im.sendImmutableList();
		s[0] = "RAbeya";
		
		String[] fresh = im.sendImmutableList();
		for(int i=0; i<s.length;i++) {
			System.out.println("Still Not Changed:::"+fresh[i]);
		System.out.println(" Changed:::"+s[i]);
		}
	}

}
