package Practice;

class Company{
	int ab;
	Company(int a){
		ab = a;
	}
}
public class Hello1 {
 public static Company com;
 
		Hello1(Company comp){
			com = comp;
		}
	public static void main(String[] args) {
		Company comp = new Company(2);
		new Hello1(comp);
		System.out.println(Hello1.com.ab);
		
		new Hello1(new Company(6));
		System.out.println(Hello1.com.ab);
		System.out.println(Hello1.com.ab);
		
	}

}
