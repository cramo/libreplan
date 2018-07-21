package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompagnyViewPage extends MasterPage implements IProjectEditor{

	private String idGenerated;

	private ProjectEditor projectEditor;// = PageFactory.initElements(driver, ProjectEditor.class);
	
	public CompagnyViewPage(WebDriver driver) {
		super(driver);
		this.idGenerated = getIdGenerated();
		projectEditor = PageFactory.initElements(driver, ProjectEditor.class);
	}
	
	public String getIdGenerated() {
		WebElement web = driver.findElement(By.xpath("//div[1]"));
		String id = web.getAttribute("id");
		id = id.substring(0, 4);
		return id;
	}
	
	public void displayId() {
		System.out.println("ID = " +getIdGenerated());
	}

	public void clickCreateProject(){
		projectEditor.clickCreateProject();
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
