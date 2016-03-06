package MultiThreading;

public class PersonalThread extends Thread{

	public static void main(String[] args) {
		PersonalThread pt = new PersonalThread();
		Thread x = new Thread(pt);
		x.start();
	}
	
	public void run(){
		for (int i =0 ; i< 3; i++){
			System.out.println(" .." +i);
		}
	}

}
