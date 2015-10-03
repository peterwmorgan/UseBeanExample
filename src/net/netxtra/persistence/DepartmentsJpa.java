package net.netxtra.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import net.netxtra.entity.Department;

public class DepartmentsJpa {
	
	
	private final String PERSISTENCE_UNIT = "JpaPersistence";
	
	public static void main(String[] args) {
		
		DepartmentsJpa depts = new DepartmentsJpa();
		EntityManager em = depts.setEntityManager(); 
		List<Department> deptList = depts.findDepartments();
		
		java.util.ListIterator<Department> li = deptList.listIterator();
	
		Department dept = null;
		
		while (li.hasNext()){
			dept = (Department) li.next();
			System.out.println(dept.getDepartmentName());
		}

		depts.setDepartment(depts.setDepartment());
	}

	private Department setDepartment(){
		Department dept = new Department();
	//	dept.setDepartmentId(291);
		dept.setDepartmentName("MyDepartmentName");
		dept.setLocationId(201);
		dept.setManagerId(1800);
		return dept;
	}
	
	@SuppressWarnings("unchecked")
	public List<Department> findDepartments() {
	    try {
	    	System.out.println("Getting Departments");
	    	EntityManager em = setEntityManager();
	    	return (List<Department>) em.createNamedQuery("Department.findAll").getResultList();
	    } 
	    catch (NoResultException e) {
	      return null;
	    }
	 }
	
	public Department findDepartmentById(int departmentRef) {
	    try {
	    	EntityManager em = setEntityManager();
	    	return (Department) em.createNamedQuery("DepartmentFindById").setParameter("departmentRef", departmentRef).getSingleResult();
	    } 
	    catch (NoResultException e) {
	      return null;
	    }
	 }
	
	public void setDepartment(Department dept) {
	    try {
	    	EntityManager em = setEntityManager();
	    	em.getTransaction().begin();
	    	em.persist(dept);
	    	em.getTransaction().commit();
	    	em.close();
	    	
	    } 
	    catch (NoResultException e) {
	    	e.printStackTrace();
	    }
	 }
	
	public EntityManager setEntityManager(){
		   	return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
	}
	
}
