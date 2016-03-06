package Practice;

import java.io.IOException;

public class FactorialProgram {

	public static void main(String[] args) throws IOException{
		long i =-1;
		//int num = System.in.read();
		long num = 51;
		System.out.println(num);
		Recursion rec = new Recursion();
		i =rec.factorial( num);
		System.out.println("Factorial of num:"+num+ " is :"+i);
	
	}
}	
	class Recursion{
		long result =-1;
		
		long factorial(long n){
			if ( n == 0)
				return 1;
				result = factorial(n -1)* n;
				return result;
	}

	}		