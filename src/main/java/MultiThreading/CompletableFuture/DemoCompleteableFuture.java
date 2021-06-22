package MultiThreading.CompletableFuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DemoCompleteableFuture {

	public static void main(String[] args) {
		DemoFuture();

	}

	public static  void DemoCompletebleFuture() {
		//Chain of inputs and it output
		CompletableFuture.supplyAsync(()-> new Random().nextInt()) //Generating a number
		.thenApply(i -> new Random().nextInt(i)) //then using 1st output as 2nd input
		.thenAccept(i -> System.out.println(i)); // and finally using 2nd's input and last task input to print
	}
	
	
	public static  void DemoFuture() {
		ExecutorService exService = Executors.newSingleThreadExecutor();
		Future<Integer> myFuture = exService.submit(()-> new Random().nextInt());
		
		try {
			//Get The task Return Value
			int i = myFuture.get(); // BLOCKING
			System.out.println(i);
		}catch(Exception ex) {
			ex.getStackTrace();
		}
	}
}
