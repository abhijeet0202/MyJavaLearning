package Practice;

public class OverloadingDemo {
	
	public void print(Object o){
		System.out.println("Object");
	}
	
	public void print(String str){
		System.out.println("String");
	}
	
	/*public void print(StringBuffer str){
		System.out.println("StringBuffer");
	}*/

	public static void main(String[] args) {
		OverloadingDemo demo = new OverloadingDemo();
		demo.print(null);

	}

}
