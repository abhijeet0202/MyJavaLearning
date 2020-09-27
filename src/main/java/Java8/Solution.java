package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

class Filter {
	public static Predicate<String> nameStartingWithPrefix(String prefix) {
	}
}

class Mapper {

	public static Function<String, CharacterCount> getDistinctCharactersCount() {
	}

}

class CharacterCount {

}

public class Solution {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		List<String> names = Arrays.asList("aaryanna", "aayanna", "airianna", "alassandra", "allanna", "allannah",
				"allessandra", "allianna", "allyanna", "anastaisa", "anastashia", "anastasia", "annabella", "annabelle",
				"annebelle");

		names.stream().filter(Filter.nameStartingWithPrefix(scanner.nextLine()))
				.map(Mapper.getDistinctCharactersCount()).forEachOrdered(System.out::println);
	}
}
