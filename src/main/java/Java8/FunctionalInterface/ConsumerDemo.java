package Java8.FunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

	public static <T> void forEachConsumer(List<T> asList, Consumer<T> myConsumer) {
		for(T i: asList) {
			myConsumer.accept(i);
		}
	}
	public static void main(String[] args) {
		//Example1
		forEachConsumer(Arrays.asList(1,2,3,4,5,6), (Integer i) -> System.out.println(i));

	}

}
