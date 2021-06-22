package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionDemo {

	public static <T, R> List<R> lengthOfEachString(List<T> str, Function<T, R> fun) {
		List<R> myList = new ArrayList<R>();
		for(T t:str) {
			myList.add(fun.apply(t));
		}
		return myList;
	}
	public static void main(String[] args) {
		
		List<Integer> sizeOfEachString = lengthOfEachString(Arrays.asList("Abhijeet", "Banerjee"), (String s)-> s.length());;
		System.out.println(sizeOfEachString);
	}

}
