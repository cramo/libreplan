package fr.eql.autom2.Libreplantest.pageobject;

import fr.eql.autom2.Libreplan.junit.MasterTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProjectEditor extends MasterPage implements IProjectEditor {

    private final String inputNameXPath = "//*[substring(@id, string-length(@id) - string-length('_8') +1) = '_8']";//p7 demo _8
    @FindBy(xpath = inputNameXPath)
    private WebElement inputName;

    private final String inputModelXPath = "//*[substring(@id, string-length(@id) - string-length('48-real') +1) = '48-real']";//v7-real demo 48-real
    @FindBy(xpath = inputModelXPath)
    private WebElement inputModel;

    private final String btnSearchModelXPath = "//*[substring(@id, string-length(@id) - string-length('v7-btn') +1) = 'v7-btn']";//v7-btn demo v7-btn
    @FindBy(xpath = btnSearchModelXPath)
    private WebElement btnSearchModel;

    private final String inputCodeXPath = "//*[substring(@id, string-length(@id) - string-length('j8') +1) = 'j8']";//38 demo j8
    @FindBy(xpath = inputCodeXPath)
    private WebElement inputCode;

    private final String checkboxCodeGenerateXPath = "//*[substring(@id, string-length(@id) - string-length('k8-real') +1) = 'k8-real']";//48-real demo k8-real
    @FindBy(xpath = checkboxCodeGenerateXPath)
    private WebElement checkboxCodeGenerate;

    private final String dateboxBeginXPath = "//*[substring(@id, string-length(@id) - string-length('n8-real') +1) = 'n8-real']";//k9-real demo n8-real
    @FindBy(xpath = dateboxBeginXPath)
    private WebElement dateboxBegin;

    private final String btnDateboxBeginXPath = "//*[substring(@id, string-length(@id) - string-length('n8-btn') +1) = 'n8-btn']";//k9-btn demo n8-btn
    @FindBy(xpath = btnDateboxBeginXPath)
    private WebElement btnDateboxBegin;

    private final String dateboxDeadlineXPath = "//*[substring(@id, string-length(@id) - string-length('q8-real') +1) = 'q8-real']";//n9-real demo q8-real
    @FindBy(xpath = dateboxDeadlineXPath)
    private WebElement dateboxDeadline;

    private final String btnDateboxDeadlineXPath = "//*[substring(@id, string-length(@id) - string-length('q8-btn') +1) = 'q8-btn']";//n9-btn demo q8-btn
    @FindBy(xpath = btnDateboxDeadlineXPath)
    private WebElement btnDateboxDeadline;

    private final String inputClientXPath = "//*[substring(@id, string-length(@id) - string-length('v8-real') +1) = 'v8-real']";//s9-real demo v8-real
    @FindBy(xpath = inputClientXPath)
    private WebElement inputClient;

    private final String btnSearchClientXPath = "//*[substring(@id, string-length(@id) - string-length('v8-btn') +1) = 'v8-btn']";//s9-btn demo v8-btn
    @FindBy(xpath = btnSearchClientXPath)
    private WebElement btnSearchClient;

    private final String selectCalendarXPath = "//*[substring(@id, string-length(@id) - string-length('59-real') +1) = '59-real']";//0a-real demo 59-real
    @FindBy(xpath = selectCalendarXPath)
    private WebElement selectCalendar;

    private final String btnAcceptXPath = "//*[substring(@id, string-length(@id) - string-length('79-box') +1) = '79-box']/tbody/tr[2]/td[2]";//2a-box demo 79-box
    //*[@id="dHAQ79-box"]/tbody/tr[2]/td[2]
    @FindBy(xpath = btnAcceptXPath)
    private WebElement btnAccept;

    private final String btnCancelXPath = "//*[substring(@id, string-length(@id) - string-length('89-box') +1) = '89-box']/tbody/tr[2]/td[2]";//3a-box demo 89-box
    //*[@id="dHAQ89-box"]/tbody/tr[2]/td[2]
    @FindBy(xpath = btnCancelXPath)
    private WebElement btnCancel;

	public WebElement getInputName() {
        return inputName;
    }

    public WebElement getInputModel() {
        return inputModel;
    }

    public WebElement getBtnSearchModel() {
        return btnSearchModel;
    }

    public WebElement getInputCode() {
        return inputCode;
    }

    public WebElement getCheckboxCodeGenerate() {
        return checkboxCodeGenerate;
    }

    public WebElement getDateboxBegin() {
        return dateboxBegin;
    }

    public WebElement getBtnDateboxBegin() {
        return btnDateboxBegin;
    }

    public WebElement getDateboxDeadline() {
        return dateboxDeadline;
    }

    public WebElement getBtnDateboxDeadline() {
        return btnDateboxDeadline;
    }

    public WebElement getInputClient() {
        return inputClient;
    }

    public WebElement getBtnSearchClient() {
        return btnSearchClient;
    }

    public WebElement getBtnAccept() {
        return btnAccept;
    }

    public WebElement getBtnCancel() {
        return btnCancel;
    }

    public String getInputNameXPath() {
        return inputNameXPath;
    }

    public String getInputModelXPath() {
        return inputModelXPath;
    }

    public String getBtnSearchModelXPath() {
        return btnSearchModelXPath;
    }

    public String getInputCodeXPath() {
        return inputCodeXPath;
    }

    public String getCheckboxCodeGenerateXPath() {
        return checkboxCodeGenerateXPath;
    }

    public String getDateboxBeginXPath() {
        return dateboxBeginXPath;
    }

    public String getBtnDateboxBeginXPath() {
        return btnDateboxBeginXPath;
    }

    public String getDateboxDeadlineXPath() {
        return dateboxDeadlineXPath;
    }

    public String getBtnDateboxDeadlineXPath() {
        return btnDateboxDeadlineXPath;
    }

    public String getInputClientXPath() {
        return inputClientXPath;
    }

    public String getBtnSearchClientXPath() {
        return btnSearchClientXPath;
    }

    public String getSelectCalendarXPath() {
        return selectCalendarXPath;
    }

    public String getBtnAcceptXPath() {
        return btnAcceptXPath;
    }

    public String getBtnCancelXPath() {
        return btnCancelXPath;
    }

    public void setInputName(String name) {
        this.inputName.clear();
        this.inputName.sendKeys(name);
    }

    public void setInputModel(String model) {
        this.inputModel.clear();
        this.inputModel.sendKeys(model + System.getProperty("line.separator")); //\n\r
    }

    public void setInputCode(String code) {
        this.inputCode.clear();
        this.inputCode.sendKeys(code);
    }

    public void setCheckboxCodeGenerate(State state) {
        if (state == State.ON) {
            if (!this.checkboxCodeGenerate.isEnabled()) this.checkboxCodeGenerate.click();
        } else if (state == State.OFF) {
            if (this.checkboxCodeGenerate.isEnabled()) this.checkboxCodeGenerate.click();
        }
    }

    public void setDateboxBegin(String begin) {
        this.dateboxBegin.clear();
        this.dateboxBegin.sendKeys(begin);
    }

    public void setDateboxDeadline(String deadline) {
        this.dateboxDeadline.clear();
        this.dateboxDeadline.sendKeys(deadline);
    }

    public void setInputClient(String str) {
        this.inputClient.clear();
        this.inputClient.sendKeys(str);
    }

    /*public void setSelectCalendar(String value) {
        Select s = new Select(this.selectCalendar);
        s.selectByValue(value);
    }

    public Select getSelectCalendar() {
        Select s = new Select(this.selectCalendar);
        return s;
    }*/

    public WebElement getSelectCalendar(){
        return selectCalendar;
    }
    
    public ProjectDetailPage clickAcceptCreateProject() {
    	this.btnAccept.click();
    	return PageFactory.initElements(driver, ProjectDetailPage.class);
    }

    public ProjectEditor(WebDriver driver) {
        super(driver);
    }

    public void createProject() {

    }

    public void saveProject() {

    }

    public void cancelEdition() {

    }

}
