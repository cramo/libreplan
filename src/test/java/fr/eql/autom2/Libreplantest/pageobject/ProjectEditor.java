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
    /*@FindBy(xpath = "//*[substring(@id, string-length(@id) - string-length('p3-real') +1) = 'p3-real']")
    private WebElement btnCreateProject;*/

    private final String inputNameXPath = "//*[substring(@id, string-length(@id) - string-length('_8') +1) = '_8']";
    @FindBy(xpath = inputNameXPath)//p7
    private WebElement inputName;

    @FindBy(xpath = "//*[substring(@id, string-length(@id) - string-length('48-real') +1) = '48-real']")//v7-real
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
        wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(By.xpath(inputNameXPath)), ExpectedConditions.visibilityOfElementLocated(By.xpath(inputNameXPath))));;
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

    public boolean getCheckboxCodeGenerate() {
        return this.checkboxCodeGenerate.isSelected();
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

    public void setSelectCalendar(String value) {
        Select s = new Select(this.selectCalendar);
        s.selectByValue(value);
    }

    public Select getSelectCalendar() {
        Select s = new Select(this.selectCalendar);
        return s;
    }

    public ProjectEditor(WebDriver driver) {
        super(driver);
    }

    /*public void clickCreateProject() {
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[substring(@id, string-length(@id) - string-length('p3-real') +1) = 'p3-real']")));
        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[substring(@id, string-length(@id) - string-length('p3-real') +1) = 'p3-real']")));
        btnCreateProject.click();
    }*/

    public void createProject() {
        /* element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[substring(@id, string-length(@id) - string-length('_8') +1) = '_8']")));
        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[substring(@id, string-length(@id) - string-length('_8') +1) = '_8']")));
        setInputName("test");*/
        /*WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[substring(@id, string-length(@id) - string-length('48-real') +1) = '48-real']")));
        WebElement element4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[substring(@id, string-length(@id) - string-length('48-real') +1) = '48-real']")));*/
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //setInputModel("test2");

        //setInputClient("test4");
    }

    public void saveProject() {

    }

    public void cancelEdition() {

    }

}
