package Practice;

public class staticDemo {
	static int a =1;
	static int b =2;
		
	static void meth(){
		System.out.println("Inside meth"+a+" "+b);
	}
		
	static {
		System.out.println("Inside Static Block");
		a+=b;
	}

	public static void main(String[] args) {
		System.out.println("Inside Main Block");
		meth();
	}		

}
