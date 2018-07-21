package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.WebDriver;

public class QueuedRessourcesPage extends MasterPage implements IProjectEditor{
	public QueuedRessourcesPage(WebDriver driver) {
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
