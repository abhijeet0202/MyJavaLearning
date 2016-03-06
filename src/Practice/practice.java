package Practice;

class Knowing{
	final static long tooth = 343L;
	
	static long doit(long tooth){
		System.out.println(++tooth +" ");
		return ++tooth;
	}
}
public class practice {

	public static void main(String[] args) {
		//System.out.println(++tooth +" ");
		final  long tooth = 343L;
		
		new Knowing().doit(tooth);
		
		System.out.println(tooth +" ");
		
	}

}
