package Java8.Stream;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static java.util.Comparator.comparing;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestTrader {
	static List<Transaction> myTrans = null;

	@BeforeClass
	public static void setUp() {
		myTrans = Transaction.generateTransactions();
	}

	@Test
	/*
	 * Find all transactions in 2011 and sort by value (small to high)
	 */
	public void testTransaction2011_SortByValue() {
		List<Transaction> report = myTrans.stream().filter(t -> (t.getYear() == 2011))
				.sorted(comparing(Transaction::getValue)).collect(toList());
		System.out.println(report);
	}

	@Test
	/* What are all the unique cities where the traders work? */
	public void testUniqueCityWhereTraderWorks() {
		List<String> uniqueTrder = myTrans.stream().map(t -> t.getTrader().getCity()).distinct().collect(toList());
		System.out.println(uniqueTrder);

		Set<String> setTrader = myTrans.stream().map(t -> t.getTrader().getCity()).collect(toSet());
		System.out.println(setTrader);
	}

	@Test
	/* Find all traders from Cambridge and sort them by name */
	public void testFindAllTradersFromCambridge() {
		List<Trader> uniqueTrder = myTrans.stream().map(Transaction::getTrader)
				.filter(t -> t.getCity().equals("Cambridge")).distinct().sorted(comparing(Trader::getName))
				.collect(toList());
		System.out.println(uniqueTrder);

	}

	@Test
	/* Return a string of all traders’ names sorted alphabetically */
	public void testReturnsNamesAlphabatically() {
		List<String> uniqueTrder = myTrans.stream().map(t -> t.getTrader().getName()).sorted().collect(toList());
		System.out.println(uniqueTrder);

	}

	@Test
	/* Are any traders based in Milan */
	public void testTradersFromMilan() {
		boolean isTrue = myTrans.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
		System.out.println(isTrue);

	}

	@Test
	/* Print all transactions’ values from the traders living in Cambridge */
	public void testTransactionValuesFromTheTradersInCambridge() {
		List<Integer> isTrue = myTrans.stream().filter(t -> t.getTrader().getCity().equals("Cambridge"))
				.map(Transaction::getValue).collect(toList());
		System.out.println(isTrue);

	}

	@Test
	/* What’s the highest value of all the transactions? */
	public void testHighestValueOfAllTheTransactions() {
		Optional<Integer> isTrue = myTrans.stream().map(t -> t.getValue()).reduce(Integer::max);
		System.out.println(isTrue.get());

	}
	
	@Test
	/* Find the transaction with the smallest value */
	public void testSamlledValueOfAllTheTransactions() {
		Optional<Integer> isTrue = myTrans.stream().map(t -> t.getValue()).reduce(Integer::min);
		System.out.println(isTrue.get());

	}
}
