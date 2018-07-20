package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.WebDriver;

public class LoadingRessourcesPage extends MasterPage implements IProjectEditor {
	public LoadingRessourcesPage(WebDriver driver) {
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
