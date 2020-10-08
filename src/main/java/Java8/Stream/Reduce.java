package Java8.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reduce {

	/**
	 * sum the elements of a list of numbers
	 */

	public Integer addTotalUsingReduce() {
		List<Integer> myList = Arrays.asList(4, 5, 7, 1, 9, 21, 3);
		return myList.stream().reduce(0, (i, j) -> (i + j));
	}
	
	public Optional<Integer> addOptionalTotalUsingReduce() {
		List<Integer> myList = Arrays.asList(4, 5, 7, 1, 9, 21, 3);
		return myList.stream().reduce((i, j) -> (i + j));
	}
	
	public Optional<Integer> addOptionalFindMaxUsingReduce() {
		List<Integer> myList = Arrays.asList(4, 5, 7, 1, 9, 21, 3);
		return myList.stream().reduce((i, j) -> Math.max(i, j));
	}
	
	public Optional<Integer> addOptionalFindMinUsingReduce() {
		List<Integer> myList = Arrays.asList(4, 5, 7, 1, 9, 21, 3);
		return myList.stream().reduce((i, j) -> i<j?i:j);
	}
}
