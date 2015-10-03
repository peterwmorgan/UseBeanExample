package net.netxtra.listener;

import java.util.List;

import net.netxtra.entity.Country;
import net.netxtra.entity.Department;

public class UseBeanSessionData extends SessionData {
	
	private List<Department> departmentList = null;
	private List<Country> countryList = null;
	private String country = "England";
  
    
    public void setDepartmentList(List<Department> departmentList){
        this.departmentList = departmentList;
    }
    
    public List<Department> getDepartmentList(){
        return departmentList;
    }
    
    public void setCountryList(List<Country> countryList){
        this.countryList = countryList;
    }
    
    public List<Country> getCountryList(){
        return countryList;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getCountry(){
        return country;
    }
    
}
