package Practice;

public class Shadow {
	
	int i = 10;
	
	public void printMe(int i) {
		System.out.println(i);
		System.out.println(this.i);
	}

	public static void main(String[] args) {
		Shadow shadow = new Shadow();
		shadow.printMe(20);
	}

}
