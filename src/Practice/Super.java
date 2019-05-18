package Practice;

class SuperClass{
	int a;
	
	void print() {
		System.out.println("SuperClass.print()" + a);
	}
	public SuperClass() {
		a= 2;
		System.out.println("Default Constructor :" + a);
	}
	
	public SuperClass(int a1) {
		a= a1;
		System.out.println("Parmetrized Constructor :" + a);
	}
	
}

public class Super extends SuperClass{
	int a;
	
	void print() {
		super.print();
		System.out.println("Super.print() : " + a);
	}
	public Super() {
		a= 3;
		System.out.println(" Super Default Constructor :" + a);
	}
	
	public Super(int a1) {
		super(a1);
		a= a1;
		System.out.println("Super Parmetrized Constructor :" + a);
	}
	
	
	public static void main(String[] args) {
		SuperClass sp = new Super();
		//Super sp1 = new Super();
		//System.out.println(sp.a +"    " +sp1.a);
		System.out.println(sp.a);
		sp.print();
		//super.print();
		//System.out.println(super.a);

	}

}
