package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectEditor implements IProjectEditor {
	@FindBy(xpath = "//*[@id=\"dX7Pq3-box\"]/tbody/tr[2]/td[2]")
	private WebElement createProjectButton;

	public void createProject() {
		// TODO Auto-generated method stub
		
	}

	public void saveProject() {
		// TODO Auto-generated method stub
		
	}

	public void cancelEdition() {
		// TODO Auto-generated method stub
		
	}

}
