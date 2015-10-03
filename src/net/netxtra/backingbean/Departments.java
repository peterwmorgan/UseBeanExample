package net.netxtra.backingbean;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

//import net.netxtra.client.DepartmentClient;
import net.netxtra.entity.Department;
import net.netxtra.interfaces.BackingBean;
import net.netxtra.listener.SessionData;
import net.netxtra.listener.UseBeanSessionData;
import net.netxtra.persistence.DepartmentsJpa;

public class Departments implements BackingBean{
	
	private HttpSession session = null;
	private UseBeanSessionData useBeanSessionData = null;
	
	private String pageTitle = "<em>The</em>JSP UseBean";
	private String pageSubTitle = "Example";
	private String pageNarrativeHeading = "List of Departments for ";
	private String pageNarrativeImage = "images/image1.jpg";
	private String pageNarrative = "This is a page narrative and describes the contents of the page";
	private String pageBlockQuoteHeading = "Block Quote";
	private String pageBlockQuoteNarrative = "Block Quote Narrative";
	private String pageListHeading = "Department Listing";
	private List<Department> departmentList = null;


	private List<Department> findDepartments() {
	    try {
	    	DepartmentsJpa depts = new DepartmentsJpa();
	    	List<Department> deptList = depts.findDepartments();
	    	
	    	return (List<Department>) deptList;
	    } 
	    catch (NoResultException e) {
	      return null;
	    }
	 }
	
 	private UseBeanSessionData getUseBeanSessionData(){
		if (!(useBeanSessionData == null)){
			return useBeanSessionData;
		}
		
		useBeanSessionData = (UseBeanSessionData) getSession().getAttribute("useBeanSessionData");
		return useBeanSessionData;
	}
	
	@Override
	public HttpSession getSession(){
		return session;
	}
	
	@Override
	public void setSession(HttpSession session){
		this.session = session;
	}
	
	@Override
	public String getPageTitle(){
		return pageTitle;
	}
	
	@Override
	public void setPageTitle(String pageTitle){
		this.pageTitle = pageTitle;
	}
	
	@Override
	public String getPageSubTitle(){
		return pageSubTitle;
	}
	
	@Override
	public void setPageSubTitle(String pageSubTitle){
		this.pageSubTitle = pageSubTitle;
	}
	
	@Override
	public String getPageNarrativeHeading(){
		UseBeanSessionData usd = getUseBeanSessionData();
		if (!(usd.getCountry() == null)){
			if (usd.getCountry() == "England"){
				StringBuffer sb = new StringBuffer();
				sb.append(pageNarrativeHeading);
				sb.append(usd.getCountry());
				return sb.toString();
			};
		}
		return pageNarrativeHeading + "not known";
	}
	
	@Override
	public void setPageNarrativeHeading(String pageNarrativeHeading){
		this.pageNarrativeHeading = pageNarrativeHeading;
	}
	
	@Override
	public String getPageNarrativeImage() {
		return pageNarrativeImage;
	}
	
	@Override
	public void setPageNarrativeImage(String pageNarrativeImage){
		this.pageNarrativeImage = pageNarrativeImage;
	}
	
	@Override
	
	public String getPageNarrative(){
		return pageNarrative;
	}
	
	@Override
	public void setPageNarrative(String pageNarrative){
		this.pageNarrative = pageNarrative;
	}
	
	@Override
	public String getPageBlockQuoteHeading(){
		return pageBlockQuoteHeading;
	}
	
	@Override
	public void setPageBlockQuoteHeading(String pageBlockQuoteHeading){
		this.pageBlockQuoteHeading = pageBlockQuoteHeading;
	}
	
	@Override
	public String getPageBlockQuoteNarrative(){
		return pageBlockQuoteNarrative;
	}
	
	@Override
	public void setPageBlockQuoteNarrative(String pageBlockQuoteNarrative){
		this.pageBlockQuoteNarrative = pageBlockQuoteNarrative;
	}
	
	@Override
	public String getPageListHeading(){
		return pageListHeading;
	}
	
	@Override
	public void setPageListHeading(String pageListHeading){
		this.pageListHeading = pageListHeading;
	}
	
	public List<Department> getDepartmentList(){
    try {
		if (!(getUseBeanSessionData().getDepartmentList() == null)) {
			System.out.println("Getting Dept List from session");
			return getUseBeanSessionData().getDepartmentList();
		}
	
	   	List<Department> depts = findDepartments();
	    
	   	if (!(depts == null)){
	   		getUseBeanSessionData().setDepartmentList(depts);
	   		System.out.println("Dept set on session");
	   		return depts;
	    }
	}
	catch (Exception exc){
		exc.printStackTrace();
	}
		return null;
	}
	 
	public void setDepartmentList(List<Department> departmentList){
		this.departmentList = departmentList;
	}

}
