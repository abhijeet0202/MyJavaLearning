package Practice;

class Student{}
public class Hello1 extends Thread{
	
	static String s = "Ins";
	public static void method(String s){
		s+= "Add";
	}

	public static void main(String[] args) {
		if (36<36){
			System.out.println("Enter");}
			else
				System.out.println("Not");
		
		//System.out.println(some());
		/*int y[] = new int[2];
		int a, []b;
		b =y;
		System.out.println(b[2]);*/
		
		/*Student st = new Student();
		String str = "Student";
		System.out.println(str instanceof Student);*/
		/*int x =10,y =20;
		System.out.println(x-y);
		
		int odd = x%2;
		if (odd){
			System.out.println("odd");
		}
		else{
			System.out.println("ndn");
		}*/
		
		/*Object o = new Object();
		Set s = new HashSet<>();*/
		Hello1 j = new Hello1();
		s = "New";
		String s = "Local";
		method(s);
		System.out.println(s);
		System.out.println(j.s);
		
		///////////
		parse("inva");
		
	}
	
	public static void parse(String str){
		try{
			float f = Float.parseFloat(str);
		}catch(NumberFormatException ex){
			//f =0;
			
		}finally{
			//System.out.println(f);
		}
	}
	public void run(){
		System.out.println("Thr");
	}

//	static Boolean some() {
//		while(true){
//			
//		try {			return true;} 
//		finally {	break;	}
//		}
//		return false;
//	}
}
