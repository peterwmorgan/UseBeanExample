/**
 * 
 */
package net.netxtra.interfaces;

import javax.servlet.http.HttpSession;

/**
 * @author Pete
 * 
 * @version 1.00
 *
 */
public interface BackingBean {
	
	  public void setSession(HttpSession session);
	  public HttpSession getSession();
	  public void setPageTitle(String pageTitle);
	  public String getPageTitle();
	  public void setPageSubTitle(String pageSubTitle);
	  public String getPageSubTitle();
	  public String getPageNarrativeHeading();
	  public void setPageNarrativeHeading(String pageNarrativeHeading);
	  public String getPageNarrativeImage();
	  public void setPageNarrativeImage(String pageNarrativeImage);
	  public void setPageNarrative(String pageNarrative);
	  public String getPageNarrative();
	  public void setPageBlockQuoteHeading(String pageBlockQuoteHeading);
	  public String getPageBlockQuoteHeading();
	  public void setPageBlockQuoteNarrative(String pageBlockQuoteNarrative);
	  public String getPageBlockQuoteNarrative();
	  public void setPageListHeading(String pageListHeading);
	  public String getPageListHeading();

}
