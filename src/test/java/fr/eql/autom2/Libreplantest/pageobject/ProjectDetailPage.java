package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectDetailPage extends MasterPage{
	
	//*[@id="tT7P34-box"]/tbody/tr[2]/td[2]
	private final String tableProjectDetailXPath = "//*[substring(@id, string-length(@id) - string-length('34-box') +1) = '34-box']/tbody/tr[2]/td[2]";
    @FindBy(xpath = tableProjectDetailXPath)//p7
    private WebElement tableProjectDetail;
	
	public ProjectDetailPage(WebDriver driver) {
		super(driver);
	}

	public String getTableProjectDetailXPath() {
		return tableProjectDetailXPath;
	}

	public WebElement getTableProjectDetail() {
		return tableProjectDetail;
	}
	
	
}
