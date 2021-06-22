package Java8.FunctionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

	public static void main(String[] args) {
		simplePredicate();

		chainOfPredicate();

		predicateInFunctionArgument(10, (i) -> i > 7);

		List<User> users = new ArrayList<User>();
		users.add(new User("John", "admin"));
		users.add(new User("Peter", "member"));
		List<User> admins = process(users, (User u) -> u.getRole().equals("admin"));
		System.out.println(admins);

	}

	// Example 1
	public static void simplePredicate() {
		// Creating predicate
		Predicate<Integer> lesserthan = i -> (i < 18);

		// Calling Predicate method
		System.out.println(lesserthan.test(10));

	}

	// Example 2
	public static void chainOfPredicate() {
		Predicate<Integer> greaterThanTen = (i) -> i > 10;

		// Here we are using "and" a default method of Predicate which will check both
		// the expression is TRUE OR not.
		// Similarly it also have OR which checks either one is true or not
		Predicate<Integer> lowerThanTwenty = (i) -> i < 20;
		boolean result = greaterThanTen.and(lowerThanTwenty).test(15);
		System.out.println(result);

		// "negate" is another default method used to simply negate our outcome(result),
		// if actual return true ir will return false and viceversa
		boolean result2 = greaterThanTen.and(lowerThanTwenty).negate().test(15);
		System.out.println(result2);
	}

	// Example 3
	public static void predicateInFunctionArgument(int number, Predicate<Integer> predicate) {
		if (predicate.test(number)) {
			System.out.println("Number " + number);
		}
	}

	// Example4
	public static List<User> process(List<User> users, Predicate<User> predicat) {
		List<User> result = new ArrayList<User>();
		for (User user : users)
			if (predicat.test(user))
				result.add(user);
		return result;
	}
}

class User {
	String name, role;

	User(String a, String b) {
		name = a;
		role = b;
	}

	String getRole() {
		return role;
	}

	String getName() {
		return name;
	}

	public String toString() {
		return "User Name : " + name + ", Role :" + role;
	}
}