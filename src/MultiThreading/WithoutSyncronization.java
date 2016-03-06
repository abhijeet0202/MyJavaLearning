package MultiThreading;



class Callme{

	synchronized void call(String msg){
		System.out.print("["+msg);
		try{
			Thread.sleep(1000);
		}catch (InterruptedException ex){
			System.out.println(ex.getMessage());
		}
		System.out.println("]");
	}
}

class Caller implements Runnable{
	Thread t;
	String msg;
	Callme callMe;

	Caller(Callme callMe,String msg){
		this.callMe = callMe;
		this.msg = msg;
		t = new Thread(this);
		t.start();			
	}

	@Override
	public void run() {
		callMe.call(msg);			
	}
}
public class WithoutSyncronization {
	public static void main(String[] args) {
		
		Callme callMe = new Callme();
		Caller call1 = new Caller(callMe, "Hello");
		
		Caller call3 = new Caller(callMe, "Abhijeet");
		Caller call2 = new Caller(callMe, "Hi");

	try{
		call1.t.join();
		call2.t.join();
		call3.t.join();
	}catch( InterruptedException e){
		System.out.println(e.getMessage());
	}
	}
	

}
