package Java8.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FlatMap {
	/*
	 * Given two lists of numbers, how would you return all pairs of numbers? For
	 * example, given a list [1, 2, 3] and a list [3, 4] you should return [(1, 3),
	 * (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. For simplicity, you can represent a
	 * pair as an array with two elements.
	 */
	public List<int[]> flatMapDemo() {
		/*
		 * You could use two maps to iterate on the two lists and generate the pairs.
		 * But this would return a Stream<Stream<Integer[]>>. What you need to do is
		 * flatten the generated streams to result in a Stream<Integer[]>. This is what
		 * flatMap is for:
		 */
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);
		List<int[]> pairs = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[] { i, j }))
				.collect(toList());
		System.out.println(pairs);
		return pairs;
	}

	/**
	 * How would you extend the previous example to return only pairs whose sum is
	 * divisible by 3? For example, (2, 4) and (3, 3) are valid.
	 */

	public List<int[]> flatMapDemo1() {
		/*
		 * Answer: You saw earlier that filter can be used with a predicate to filter
		 * elements from a stream. Because after the flatMap operation you have a stream
		 * of int[] that represent a pair, you just need a predicate to check to see if
		 * the sum is divisible by 3:
		 */
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);
		List<int[]> pairs = numbers1.stream()
				.flatMap(i -> numbers2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[] { i, j }))
				.collect(toList());
		System.out.println(pairs);
		return pairs;
	}

	/*
	 * For example, given the list of words ["Hello", "World"] you’d like to return
	 * the list ["H", "e", "l", "o", "W", "r", "d"]. UNIQUE WORD
	 */
	public List<String> findUniqueCharacters(){
		String[] arrayOfWords = {"GoodBye", "World"};
		Stream<String> streamOfWords = Arrays.stream(arrayOfWords);
		List<String> uniqueCharacter = streamOfWords.map(w -> w.split(""))
				.flatMap(Arrays::stream)
				.distinct()
				.collect(Collectors.toList());
		
		return uniqueCharacter;
	}
}
