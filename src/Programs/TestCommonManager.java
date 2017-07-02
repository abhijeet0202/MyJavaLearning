/**
 * 
 */
package Programs;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author I17996
 *
 */
public class TestCommonManager {

	/**
	 * Test method for {@link Programs.CommonManager#CommonManager(int, java.lang.String)}.
	 */
	@Test
	public void testCommonManager() {
		CommonManager ceo = new CommonManager(1,"Ceo");
		CommonManager manager1 = new CommonManager(1,"Ceo");
		CommonManager manager2 = new CommonManager(1,"Ceo");
		CommonManager employee1 = new CommonManager(1,"Ceo");
		CommonManager employee2 = new CommonManager(1,"Ceo");
		CommonManager employee3 = new CommonManager(1,"Ceo");
		CommonManager employee4 = new CommonManager(1,"Ceo");
		
		manager1.getReports().add(employee1);
		manager1.getReports().add(employee2);
		manager2.getReports().add(employee3);
		manager2.getReports().add(employee4);
		
		ceo.getReports().add(manager1);
		ceo.getReports().add(manager2);
		
		CommonManager common = ceo.closestCommonManager(ceo, employee4, employee3);
		assertEquals(common, manager2);
	}
	
	@Test
	public void testCommonManager1() {
		CommonManager ceo = new CommonManager(1,"Ceo");
		CommonManager manager1 = new CommonManager(1,"Ceo");
		CommonManager manager2 = new CommonManager(1,"Ceo");
		CommonManager employee1 = new CommonManager(1,"Ceo");
		CommonManager employee2 = new CommonManager(1,"Ceo");
		CommonManager employee3 = new CommonManager(1,"Ceo");
		CommonManager employee4 = new CommonManager(1,"Ceo");
		
		manager1.getReports().add(employee1);
		manager1.getReports().add(employee2);
		manager2.getReports().add(employee3);
		manager2.getReports().add(employee4);
		
		ceo.getReports().add(manager1);
		ceo.getReports().add(manager2);
		
		CommonManager common = ceo.closestCommonManager(ceo, employee1, employee3);
		assertEquals(common, ceo);
	}

}
