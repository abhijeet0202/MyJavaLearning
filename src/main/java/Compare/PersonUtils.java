package Compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person1 {
	String firstName;
	String lastName;
	int age;
	String country;

	public Person1(String firstName, String lastName, int age, String country) {
		this.age = age;
		this.country = country;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Person1 [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", country=" + country
				+ "]";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}

public class PersonUtils {

	public static void sortPersons(List<Person1> persons, String[] sortBy) {
		List<PersonComparator> myEnum = new ArrayList<PersonUtils.PersonComparator>();
		for (int i = 0; i < sortBy.length; i++) {
			if (sortBy[i].equalsIgnoreCase("firstname")) {
				myEnum.add(PersonComparator.FIRST_NAME);
			} else if (sortBy[i].equalsIgnoreCase("lastname")) {
				myEnum.add(PersonComparator.LAST_NAME);
			} else if (sortBy[i].equalsIgnoreCase("age")) {
				myEnum.add(PersonComparator.AGE);
			} else if (sortBy[i].equalsIgnoreCase("country")) {
				myEnum.add(PersonComparator.COUNTRY);
			}
		}

		Collections.sort(persons, PersonComparator.getComparator(myEnum));
	}

	enum PersonComparator implements Comparator<Person1> {
		FIRST_NAME {
			public int compare(Person1 o1, Person1 o2) {
				return o1.getFirstName().compareTo(o2.getFirstName());
			}
		},
		LAST_NAME {
			public int compare(Person1 o1, Person1 o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		},
		COUNTRY {
			public int compare(Person1 o1, Person1 o2) {
				return o1.getCountry().compareTo(o2.getCountry());
			}
		},
		AGE {
			public int compare(Person1 o1, Person1 o2) {
				return Integer.valueOf(o1.getAge()).compareTo(o2.getAge());
			}
		};

		public static Comparator<Person1> getComparator(List<PersonComparator> multiSort) {
			return new Comparator<Person1>() {
				public int compare(Person1 o1, Person1 o2) {
					for (PersonComparator option : multiSort) {
						int result = option.compare(o1, o2);
						if (result != 0) {
							return result;
						}
					}
					return 0;
				}

			};
		}
	}

	public static void main(String[] args) {
		Person1 p1 = new Person1("Abhijeet", "Banerjee", 34, "India");
		Person1 p2 = new Person1("Mumshad", "Manamvath", 44, "Singapore");
		Person1 p3 = new Person1("Rabeya", "Dhoni", 24, "Australia");
		Person1 p4 = new Person1("Mahendra", "Zarf", 54, "Europe");

		List<Person1> persons = new ArrayList<>();
		persons.add(p4);
		persons.add(p2);
		persons.add(p1);
		persons.add(p3);

		// TestCAse 1
		String[] sortBy = new String[] { "firstname" };
		System.out.println(persons);
		PersonUtils.sortPersons(persons, sortBy);
		System.out.println(persons);

		// TestCAse 1
		sortBy = new String[] { "lastname","Age" };
		System.out.println(persons);
		PersonUtils.sortPersons(persons, sortBy);
		System.out.println(persons);
	}

}
