package Practice;

class Data{
	static int a =2;
	//int b =3;
	static void myfunc(int b){
		System.out.println("Inside static myfunc:"+a+" "+b);
	}
}
public class StaticDemoClass {

	public static void main(String[] args) {
		Data.a = 3;
		Data.myfunc(2);

	}

}
