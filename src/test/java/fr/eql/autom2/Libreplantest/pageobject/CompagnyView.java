package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompagnyView extends MasterPage implements IProjectEditor{

	public CompagnyView(WebDriver driver) {
		super(driver);
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
