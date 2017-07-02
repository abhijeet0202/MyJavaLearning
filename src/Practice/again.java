package Practice;

import java.io.IOException;

public class again {
	
	public static void main(String[] args) {
		again a = new again();
		try{a.check();
		}catch(Exception ex){
			System.out.println("catch block 1");
		}
		
	}
	void check() throws Exception{
		try{
			throw new IOException();
		}catch(IOException ex){
			System.out.println("cb2");
			throw new Exception();
		}
		catch(Exception ex){
			System.out.println("cb3");
		}
		finally{
			System.out.println("ret");
		}
	}

}
