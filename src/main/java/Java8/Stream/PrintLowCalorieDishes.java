package Java8.Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class PrintLowCalorieDishes {

	public List<String> usingJava7() {
		List<Dish> lowCalorieDishes = new ArrayList<Dish>();
		List<Dish> menu = Dish.getDishes();
		for (Dish d : menu) {
			if (d.getCalories() < 400) {
				lowCalorieDishes.add(d);
			}
		}

		Collections.sort(lowCalorieDishes, new Comparator<Dish>() {
			@Override
			public int compare(Dish o1, Dish o2) {
				return Integer.compare(o1.getCalories(), o2.getCalories());
			}
		});

		List<String> lowCalorieDishesName = new ArrayList<>();
		for (Dish d : lowCalorieDishes) {
			lowCalorieDishesName.add(d.getName());
		}

		return lowCalorieDishesName;
	}

	public List<String> usingJavaStream() {
		List<Dish> menu = Dish.getDishes();

		return menu.stream().filter(d -> d.getCalories() < 400).sorted(comparing(Dish::getCalories)).map(Dish::getName)
				.collect(toList());
	}

	public List<String> usingJavaParallelStream() {
		List<Dish> menu = Dish.getDishes();

		return menu.parallelStream().filter(d -> d.getCalories() < 400).sorted(comparing(Dish::getCalories))
				.map(Dish::getName).collect(toList());
	}
}
