package net.netxtra.test;
/** Unit test to check that departments can be successfully added
 *  @date November 2015
 * 
 */
import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;

import net.netxtra.entity.Department;
import net.netxtra.persistence.DepartmentsJpa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 */

/**
 * @author Pete
 *
 */
public class DepartmentAddTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("BeforeClass");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		DepartmentsJpa depts = new DepartmentsJpa();
		System.out.println("SetUp");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("TearDown");
	}

	@Test
	public void test() {
		DepartmentsJpa depts = new DepartmentsJpa();
		EntityManager em = depts.setEntityManager(); 
		List<Department> deptList = depts.findDepartments();
		
		java.util.ListIterator<Department> li = deptList.listIterator();
	
		org.junit.Assert.assertTrue(li.hasNext());
	}

}
