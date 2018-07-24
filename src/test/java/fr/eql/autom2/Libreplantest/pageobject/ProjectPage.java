package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectPage extends MasterPage implements IProjectEditor {
	private final String tableListOfProjectXPath = "//*[substring(@id, string-length(@id) - string-length('34-box') +1) = '34-box']/tbody/tr[2]/td[2]";//h4-box demo 34-box
	@FindBy(xpath = tableListOfProjectXPath)
	private WebElement tableListOfProject;
	
	public String getTableListOfProjectXPath() {
		return tableListOfProjectXPath;
	}

	public WebElement getTableListOfProject() {
		return tableListOfProject;
	}

	public ProjectPage(WebDriver driver) {
		super(driver);
	}

	public void createProject() {
		ProjectEditor projectEditor = new ProjectEditor(driver);
		projectEditor.createProject();
	}

	public void saveProject() {
		ProjectEditor projectEditor = new ProjectEditor(driver);
		projectEditor.saveProject();
	}

	public void cancelEdition() {
		ProjectEditor projectEditor = new ProjectEditor(driver);
		projectEditor.cancelEdition();
	}
}
