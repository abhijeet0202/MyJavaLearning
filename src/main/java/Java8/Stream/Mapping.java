package Java8.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.reducing;

/*
 * Given a list of numbers, how would you return a list of the square of each number? For
example, given [1, 2, 3, 4, 5] you should return [1, 4, 9, 16, 25].
 */
public class Mapping {

	public List<Integer> mapDemo() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> squares = numbers.stream().map(n -> n * n).collect(toList());
		System.out.println(squares);
		return squares;
	}
	
	/*count the number of dishes in a stream using the map and reduce methods*/
	public Optional<Integer> countDishes(){
		List<Dish> myDish = Dish.getDishes();
				
		//Case 1:
				long totalCalories = myDish.stream().collect(reducing(
						0, Dish::getCalories, (i, j) -> i + j));
		//Case2 
		return myDish.stream().map(d -> 1).reduce((a,b) ->(a+b));
		
		
	}
}
