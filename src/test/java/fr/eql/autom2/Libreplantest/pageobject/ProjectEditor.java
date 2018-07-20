package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectEditor implements IProjectEditor {
	@FindBy(xpath = "//*[contains(@id,'p3-real')]")
	private WebElement btnCreateProject;

	@FindBy(xpath = "//*[contains(@id,'p7')]")
	private WebElement inputName;

	@FindBy(xpath = "//*[contains(@id,'v7-real')]")
	private WebElement inputModel;

	@FindBy(xpath = "//*[contains(@id,'v7-btn')]")
	private WebElement btnSearchModel;

	@FindBy(xpath = "//*[contains(@id,'38')]")
	private WebElement inputCode;

	@FindBy(xpath = "//*[contains(@id,'48-real')]")
	private WebElement checkboxCodeGenerate;

	@FindBy(xpath = "//*[contains(@id,'k9-real')]")
	private WebElement dateboxBegin;
	
	@FindBy(xpath = "//*[contains(@id,'k9-btn')]")
	private WebElement btnDateboxBegin;

	@FindBy(xpath = "//*[contains(@id,'n9-real')]")
	private WebElement dateboxDeadline;
	
	@FindBy(xpath = "//*[contains(@id,'n9-btn')]")
	private WebElement btnDateboxDeadline;

	@FindBy(xpath = "//*[contains(@id,'s9-real')]")
	private WebElement inputClient;

	@FindBy(xpath = "//*[contains(@id,'s9-btn')]")
	private WebElement btnSearchClient;

	@FindBy(xpath = "//*[contains(@id,'0a-real')]")
	private WebElement selectCalendar;

	@FindBy(xpath = "//*[contains(@id,'string')]")
	private WebElement btnAccept;

	@FindBy(xpath = "//*[contains(@id,'string')]")
	private WebElement btnCancel;

	public void setInputName(String str) {
		this.inputName.clear();
		this.inputName.sendKeys(str);
	}

	public void setInputModel(String str) {
		this.inputName.clear();
		this.inputName.sendKeys(str);
	}

	public void setInputCode(String str) {
		this.inputName.clear();
		this.inputName.sendKeys(str);
	}

	public WebElement getCheckboxCodeGenerate() {
		return checkboxCodeGenerate;
	}

	public void setCheckboxCodeGenerate(WebElement checkboxCodeGenerate) {
		this.checkboxCodeGenerate = checkboxCodeGenerate;
	}

	public void setDateboxBegin(WebElement dateboxBegin) {
		this.dateboxBegin = dateboxBegin;
	}

	public void setDateboxDeadline(WebElement dateboxDeadline) {
		this.dateboxDeadline = dateboxDeadline;
	}

	public void setInputClient(String str) {
		this.inputName.clear();
		this.inputName.sendKeys(str);
	}

	public void setSelectCalendar(WebElement selectCalendar) {
		this.selectCalendar = selectCalendar;
	}

	public ProjectEditor() {

	}
	
	public void clickCreateProject() {
		btnCreateProject.click();
	}

	public void createProject() {	

	}

	public void saveProject() {

	}

	public void cancelEdition() {

	}

}
