package Java8.Stream;

import java.util.List;
import static java.util.stream.Collectors.toList;

public class Matching {
	List<Dish> menu = Dish.getDishes();
	/* Checking to see if a predicate matches at least one element */

	public boolean demoFindMatchAny() {
		return menu.stream().anyMatch(Dish::isVegetarian);
	}
	
	/*•	Checking to see if a predicate matches all elements*/
	public boolean demoFindMatchAll() {
		return menu.stream().allMatch(d ->d.getCalories() < 600);
	}
	
	/*•	Checking to see if a predicate matches all elements*/
	public boolean demoFindNoneMatch() {
		return menu.stream().noneMatch(d ->d.getCalories() < 600);
	}
}
