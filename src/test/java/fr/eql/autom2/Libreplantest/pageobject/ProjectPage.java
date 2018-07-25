package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectPage extends MasterPage implements IProjectEditor {
	private final String tableListOfProjectXPath = "//*[substring(@id, string-length(@id) - string-length('h4-box') +1) = 'h4-box']/tbody/tr[2]/td[2]";//h4-box demo 34-box
	@FindBy(xpath = tableListOfProjectXPath)
	private WebElement tableListOfProject;
	
	//*[@id="r4zP06-box"]/tbody/tr[2]/td[2]
	//*[@id="r4zPv5-box"]/tbody/tr[2]/td[2]
	//*[substring(@id, string-length(@id) - string-length('-box') +1) = '-box']/tbody/tr[2]/td[2]
	//*[@id="r4zP46"]/div[3]
	//*[@id="q50Qn5"]/div[2]
	//*[@id="q50Qn5"]/div[3]
	//div[@class="z-window-modal-cl"]
	//div[@class="z-window-modal-cl"]/div/div/div/table[2]/tbody/tr/td/table/tbody/tr/td/span[@class="z-messagebox-btn z-button"]
	//*[@id="rW6Q06-box"]/tbody/tr[2]/td[2]
	private final String btnOkXPath = "//*[contains(text(), \"OK\") and @class=\"z-button-cm\"]";//h4-box demo 34-box
	@FindBy(xpath = btnOkXPath)
	private WebElement btnOk;
	
	public String getBtnOkXPath() {
		return btnOkXPath;
	}

	public WebElement getBtnOk() {
		return btnOk;
	}

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
