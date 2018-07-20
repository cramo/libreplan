package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompagnyViewPage extends MasterPage implements IProjectEditor{
	public String idGenerated;
	
	public CompagnyViewPage(WebDriver driver) {
		super(driver);
		getIdGenerated();
	}
	
	public String getIdGenerated() {
		WebElement web = driver.findElement(By.xpath("//div[1]"));
		String id = web.getAttribute("id");
		id.substring(0, 3);
		return id;
	}
	
	public void displayId() {
		System.out.println("ID =" +getIdGenerated());
	}
	
	public void createProject() {
		ProjectEditor projectEditor = new ProjectEditor();
		projectEditor.createProject();		
	}

	public void saveProject() {
		ProjectEditor projectEditor = new ProjectEditor();
		projectEditor.saveProject();
	}

	public void cancelEdition() {
		ProjectEditor projectEditor = new ProjectEditor();
		projectEditor.cancelEdition();
	}	
}
