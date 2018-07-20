package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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

	public void setInputName(String name) {
		this.inputName.clear();
		this.inputName.sendKeys(name);
	}

	public void setInputModel(String model) {
		this.inputName.clear();
		this.inputName.sendKeys(model);
	}

	public void setInputCode(String code) {
		this.inputName.clear();
		this.inputName.sendKeys(code);
	}

	public boolean getCheckboxCodeGenerate() {
		return this.checkboxCodeGenerate.isSelected();
	}

	public void setCheckboxCodeGenerate(State state) {
		if (state == State.ON) {
			if (!this.checkboxCodeGenerate.isEnabled())
				this.checkboxCodeGenerate.click();
		} else if (state == State.OFF) {
			if (this.checkboxCodeGenerate.isEnabled())
				this.checkboxCodeGenerate.click();
		}
	}

	public void setDateboxBegin(String begin) {
		this.inputName.clear();
		this.inputName.sendKeys(begin);
	}

	public void setDateboxDeadline(String deadline) {
		this.inputName.clear();
		this.inputName.sendKeys(deadline);
	}

	public void setInputClient(String str) {
		this.inputName.clear();
		this.inputName.sendKeys(str);
	}

	public void setSelectCalendar(String value) {
		Select s = new Select(this.selectCalendar);
		s.selectByValue(value);
	}
	
	public Select getSelectCalendar(){
		Select s = new Select(this.selectCalendar);
		return s;
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
