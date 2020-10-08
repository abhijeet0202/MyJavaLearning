package Java8.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Finding {
	List<Dish> menu = Dish.getDishes();

	public Optional<Dish> demoFindAny() {
		return menu.stream().filter(Dish::isVegetarian).findAny();
	}

	/*
	 * given a list of numbers, finds the first square that’s divisible by 3:
	 */
	public Optional<Integer> demoFindFirst(){
		List<Integer> myInt = Arrays.asList(1,2,5,7,9);
		return myInt.stream().map(i -> i*i).filter(i->i%3==0).findFirst();
	}
}
