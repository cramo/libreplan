package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectDetailPage extends MasterPage {

	// *[@id="tT7P34-box"]/tbody/tr[2]/td[2]
	//*[@id="cQ4Q34-box"]/tbody/tr[2]/td[2]
	private final String tableProjectDetailXPath = "//*[substring(@id, string-length(@id) - string-length('34-box') +1) = '34-box']/tbody/tr[2]/td[2]";
	@FindBy(xpath = tableProjectDetailXPath)
	private WebElement tableProjectDetail;

	//*[@id="aS6Qfs-hm"]/span
	private final String spanMenuWBSXPath = "//*[substring(@id, string-length(@id) - string-length('-hm') +1) = '-hm']/span[.=\"WBS (tâches)\"]";
	@FindBy(xpath = spanMenuWBSXPath)
	private WebElement spanMenuWBS;
	
	//*[@id="h5qDb4-box"]/tbody/tr[2]/td[2]
	private final String tableDashboardXPath = "//*[substring(@id, string-length(@id) - string-length('b4-box') +1) = 'b4-box']/tbody/tr[2]/td[2]";
	@FindBy(xpath = tableDashboardXPath)
	private WebElement tableDashboard;

	public String getTableDashboardXPath() {
		return tableDashboardXPath;
	}

	public WebElement getTableDashboard() {
		return tableDashboard;
	}

	public ProjectDetailPage(WebDriver driver) {
		super(driver);
	}

	public String getTableProjectDetailXPath() {
		return tableProjectDetailXPath;
	}

	public WebElement getTableProjectDetail() {
		return tableProjectDetail;
	}

	public String getSpanMenuWBSXPath() {
		return spanMenuWBSXPath;
	}

	public WebElement getSpanMenuWBS() {
		return spanMenuWBS;
	}

}
