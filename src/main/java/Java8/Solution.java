package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

class Filter {
	public static Predicate<String> nameStartingWithPrefix(String prefix) {
		return str -> str.startsWith(prefix);
	}
}

class Mapper {

	public static Function<String, CharacterCount> getDistinctCharactersCount() {
		//return str -> str.flatMap(Arrays::Stream).distinct().collect();
		return str ->  new CharacterCount(str, str.length());
	}

}

class CharacterCount {
	private final String name;
	private final Integer distinctCharacterCount;
	
	public CharacterCount(String name,Integer distinctCharacterCount) {
		this.name = name;
		this.distinctCharacterCount = distinctCharacterCount;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\""+this.name+"\" has"+ this.distinctCharacterCount+" distinct char";
	}
}

public class Solution {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		List<String> names = Arrays.asList("aaryanna", "aayanna", "airianna", "alassandra", "allanna", "allannah",
				"allessandra", "allianna", "allyanna", "anastaisa", "anastashia", "anastasia", "annabella", "annabelle",
				"annebelle");

		names.stream().filter(Filter.nameStartingWithPrefix(scanner.nextLine()))
				.map(Mapper.getDistinctCharactersCount()).forEachOrdered(System.out::println);
		//.forEachOrdered(System.out::println);
	}
}
