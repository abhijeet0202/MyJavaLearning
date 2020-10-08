package Java8.Stream;

import org.junit.Test;

public class TestStreamPractice {

	@Test
	public void testPrintLowCalorieDishes() {
		PrintLowCalorieDishes printLowCalorieDishes = new PrintLowCalorieDishes();
		
		System.out.println(printLowCalorieDishes.usingJava7());
		System.out.println(printLowCalorieDishes.usingJavaStream());
		System.out.println(printLowCalorieDishes.usingJavaParallelStream());
	}

	@Test
	public void testGr() {
		GroupingBy groupingBy = new GroupingBy();
		System.out.println(groupingBy.groupingByDemo());
	}
	
	@Test
	public void testReduce_addOptionalFindMaxUsingReduce() {
		Reduce reduce = new Reduce();
		System.out.println(reduce.addOptionalFindMaxUsingReduce());
	}

	@Test
	public void testReduce_addOptionalFindMinUsingReduce() {
		Reduce reduce = new Reduce();
		System.out.println(reduce.addOptionalFindMinUsingReduce());
	}
}
