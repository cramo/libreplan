package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompagnyViewPage extends MasterPage implements IProjectEditor{

	private final String btnCreateProjectXPath = "//*[substring(@id, string-length(@id) - string-length('p3-real') +1) = 'p3-real']";//p3-real demo p3-real
	@FindBy(xpath = btnCreateProjectXPath)
	private WebElement btnCreateProject;
	
    private final String tableProjectPlanificationXPath = "//*[substring(@id, string-length(@id) - string-length('f4-box') +1) = 'f4-box']/tbody/tr[2]/td[2]";//f4-box demo 14-box
    @FindBy(xpath = tableProjectPlanificationXPath)
    private WebElement tableProjectPlanification;
    
    private ProjectEditor projectEditor;

    public String getTableProjectPlanificationXPath() {
		return tableProjectPlanificationXPath;
	}

	public WebElement getTableProjectPlanification() {
		return tableProjectPlanification;
	}
	
	public CompagnyViewPage(WebDriver driver) {
		super(driver);
		projectEditor = PageFactory.initElements(driver, ProjectEditor.class);
	}

	public String getBtnCreateProjectXPath() {
		return btnCreateProjectXPath;
	}

	public ProjectEditor clickCreateProject(){
		//wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(By.xpath(btnCreateProjectXPath)), ExpectedConditions.visibilityOfElementLocated(By.xpath(btnCreateProjectXPath))));
		btnCreateProject.click();
		return PageFactory.initElements(driver, ProjectEditor.class);
	}

	public void createProject() {
		projectEditor.createProject();		
	}

	public void saveProject() {
		projectEditor.saveProject();
	}

	public void cancelEdition() {
		projectEditor.cancelEdition();
	}	
}
