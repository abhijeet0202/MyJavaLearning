package Inheritance;

interface I1 {
	default public void m() {
		System.out.println("I1");
	}
}

interface I2 {
	default public void m() {
		System.out.println("I2");
	}
}

class A implements I1 {
	public void callM() {
		m();
	}
}

class B extends A implements I2 {
	public void superCall() {
		super.m();
	}

	@Override
	public void m() {
		// TODO Auto-generated method stub
		I2.super.m();
	}
}

public class DefaultCheck {
	
	public static void main(String[] args) {
		B a = new B();
		a.superCall();
	}
	

}
