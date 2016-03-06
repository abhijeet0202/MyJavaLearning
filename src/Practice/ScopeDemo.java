package Practice;

public class ScopeDemo {

	public static void main(String[] args) {
		int bar = 1;
		System.out.println("Value of Bar is : "+bar);
		{
			bar = 2;
			System.out.println("Value of Bar is : "+bar);
		}
		System.out.println("Value of Bar is : "+bar);
	}

}
