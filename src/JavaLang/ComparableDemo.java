package JavaLang;

class Student implements Comparable<Student>{
	String name;
	int age;
	
	Student(String name,int age){
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Student obj) {
		return this.age == obj.age? 1:0;
	}
	
	
}
public class ComparableDemo {

	public static void main(String[] args) {
		Student st = new Student("Abhijeet",30);
		Student st1 = new Student("Banerjee",31);
		
		if(st.compareTo(st1) == 1){
			System.out.println("Both HAve Same Age");
		}
		

	}

}
