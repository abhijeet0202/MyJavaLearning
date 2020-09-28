package Java8.Stream;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class GroupingBy {
	
	public Map<Dish.Type, List<Dish>> groupingByDemo() {
		
		List<Dish> menu = Dish.getDishes();
		return menu.stream().collect(groupingBy(Dish::getType));
	}

}
