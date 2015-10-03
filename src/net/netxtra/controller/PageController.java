package net.netxtra.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import net.netxtra.backingbean.Departments;
import net.netxtra.entity.Country;
import net.netxtra.entity.Department;

public class PageController {
	
	private EntityManager em = setEntityManager();
	private final String PERSISTENCE_UNIT = "JpaPersistence";
	

	@SuppressWarnings("unchecked")
	public List<Country> findCountries() {
	    try {
	    	System.out.println("Getting Countries");
	    	return (List<Country>) em.createNamedQuery("Country.findAll").getResultList();
	    } 
	    catch (NoResultException e) {
	      return null;
	    }
	 }

	@SuppressWarnings("unchecked")
	public List<Department> findDepartments() {
	    try {
	    	System.out.println("Getting Departments");
	    	return (List<Department>) em.createNamedQuery("Department.findAll").getResultList();
	    } 
	    catch (NoResultException e) {
	      return null;
	    }
	 }
	
	public Department findDepartmentById(int departmentRef) {
	    try {
	    	return (Department) em.createNamedQuery("DepartmentFindById").setParameter("departmentRef", departmentRef).getSingleResult();
	    } 
	    catch (NoResultException e) {
	      return null;
	    }
	 }
	
	public EntityManager setEntityManager(){
		   	return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
	}
}
