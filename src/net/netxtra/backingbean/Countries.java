package net.netxtra.backingbean;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

import net.netxtra.controller.PageController;
import net.netxtra.entity.Country;
import net.netxtra.entity.Department;
import net.netxtra.interfaces.BackingBean;
import net.netxtra.listener.SessionData;

//public class Countries extends PageController implements BackingBean{

	public class Countries extends PageController {
	private EntityManager em = setEntityManager();
	private final String PERSISTENCE_UNIT = "JpaPersistence";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Countries countries = new Countries();
		EntityManager em = countries.setEntityManager(); 
		List<Country> countryList = countries.findCountries();
		
		java.util.ListIterator<Country> li = countryList.listIterator();
	
		Country country = null;
		
		while (li.hasNext()){
			country = (Country) li.next();
			System.out.println(country.getCountryName());
		}

	

	}

//	public void getSessionData(){
//		HttpSession hs = request.getSession();
//		SessionData sd = hs.getAttribute("useBeanSessionData");
//		
//	}
//	@Override
	public void setPageTitle(String pageTitle) {
		// TODO Auto-generated method stub
		
	}

//	@Override
	public String getPageTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Country> getCountryList(){
		return (List<Country>) em.createNamedQuery("Country.findAll").getResultList();
	//	return findCountries();
	}
	
	public void setCountryList(List<Country> countryList){
		this.setCountryList(countryList);
	}
}
