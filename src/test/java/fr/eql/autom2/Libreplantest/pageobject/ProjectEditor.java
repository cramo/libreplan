package fr.eql.autom2.Libreplantest.pageobject;

import fr.eql.autom2.Libreplan.junit.MasterTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProjectEditor extends MasterPage implements IProjectEditor {
	//@FindBy(xpath = "//*[substring(@id, string-length(@id) - string-length('p3-real') +1)]")
	//*[@id="yHsVq3-box"]/tbody/tr[2]/td[2]/img
	//@FindBy(xpath = "[//*[contains(@id, 'p3-real')]")
	//@FindBy(xpath = "//*[contains(@id,'q3-chdex')")
	//@FindBy(xpath = "//tr[2]/td[2]/img")
	@FindBy(xpath = "//*[substring(@id, string-length(@id) - string-length('p3-real') +1) = 'p3-real']")
	private WebElement btnCreateProject;

	@FindBy(xpath = "//*[substring(@id, string-length(@id) - string-length('p7') +1) = 'p7']")
	private WebElement inputName;

	@FindBy(xpath = "//*[substring(@id, string-length(@id) - string-length('v7-real') +1) = 'v7-real']")
	private WebElement inputModel;

	@FindBy(xpath = "//*[substring(@id, string-length(@id) - string-length('v7-btn') +1) = 'v7-btn']")
	private WebElement btnSearchModel;

	@FindBy(xpath = "//*[substring(@id, string-length(@id) - string-length('38') +1) = '38']")
	private WebElement inputCode;

	@FindBy(xpath = "//*[substring(@id, string-length(@id) - string-length('48-real') +1) = '48-real']")
	private WebElement checkboxCodeGenerate;

	@FindBy(xpath = "//*[substring(@id, string-length(@id) - string-length('k9-real') +1) = 'k9-real']")
	private WebElement dateboxBegin;

	@FindBy(xpath = "//*[substring(@id, string-length(@id) - string-length('k9-btn') +1) = 'k9-btn']")
	private WebElement btnDateboxBegin;

	@FindBy(xpath = "//*[substring(@id, string-length(@id) - string-length('n9-real') +1) = 'n9-real']")
	private WebElement dateboxDeadline;

	@FindBy(xpath = "//*[substring(@id, string-length(@id) - string-length('n9-btn') +1) = 'n9-btn']")
	private WebElement btnDateboxDeadline;

	@FindBy(xpath = "//*[substring(@id, string-length(@id) - string-length('s9-real') +1) = 's9-real']")
	private WebElement inputClient;

	@FindBy(xpath = "//*[substring(@id, string-length(@id) - string-length('s9-btn') +1) = 's9-btn']")
	private WebElement btnSearchClient;

	@FindBy(xpath = "//*[substring(@id, string-length(@id) - string-length('0a-real') +1) = '0a-real']")
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

	public ProjectEditor(WebDriver driver) {
		super(driver);
	}

	public void clickCreateProject() {
		WebElement element1 = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[substring(@id, string-length(@id) - string-length('p3-real') +1) = 'p3-real']")));
		WebElement element2 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[substring(@id, string-length(@id) - string-length('p3-real') +1) = 'p3-real']")));
		btnCreateProject.click();
	}

	public void createProject() {
		setInputName("test");

	}

	public void saveProject() {

	}

	public void cancelEdition() {

	}

}
