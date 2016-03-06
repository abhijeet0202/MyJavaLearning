package ExceptionHandling;

public class ThrowsDemo {

	public static void main(String[] args) {
		try{
			throwsFunc();
		}
		catch (NullPointerException ex){
			System.out.println("helo");
		}
		catch (IllegalAccessException ex){
			System.out.println("helo");
		}
		catch (ArithmeticException ex){
			System.out.println("helo");
		}
		
	}
	
	 static void throwsFunc() throws IllegalAccessException,NullPointerException,ArithmeticException {
		System.out.println("Inside throwsFunc");
		throw new ArithmeticException();
	}

}
