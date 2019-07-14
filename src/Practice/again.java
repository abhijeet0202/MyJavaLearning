package Practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class again {
	
	public static void main(String[] args) {
		List<String> obj = new ArrayList<>();
		obj.add("Abhi");
		
		Iterator<String> ite = obj.iterator();
		
		obj.remove(0);
		
		while(ite.hasNext()){
			System.out.println(ite.next());
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
