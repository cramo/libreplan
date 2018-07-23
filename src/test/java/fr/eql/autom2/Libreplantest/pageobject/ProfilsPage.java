package fr.eql.autom2.Libreplantest.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class ProfilsPage extends MasterPage {
	
	private String idPrefix;
	
    private final String btnCreateProfilXpath = "//*[substring(@id, string-length(@id) - string-length('v4-box') +1) = 'v4-box']/tbody/tr[2]/td[@class='z-button-cm']";
	@FindBy(xpath = btnCreateProfilXpath)
	private WebElement btnCreateProfil;
	
	
	
	
	public ProfilsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String idVariable() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String ID = driver.findElement(By.xpath("//body/div")).getAttribute("id");
		ID = ID.substring(0, 4);
	return ID;
	}
	
/*	
	@FindBy(how = How.XPATH, using="//*[contains(@id, 'j4-cap')]")
	private WebElement titlePage;

	@FindBy(how = How.CLASS_NAME, using="z-button-cm")
	private WebElement btnCreate;*/

	public boolean assertTitleProfilsPage() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String ID = driver.findElement(By.xpath("//*[contains(@id, 'j4-cap')]")).getAttribute("id");
		ID = ID.substring(0, 4);
		System.out.println(ID);
		System.out.println(idVariable()+"j4-cap");
		WebElement titlePage=(WebElement) driver.findElement(By.xpath("//*[@id='"+ID+"j4-cap']"));
		boolean assertResult = titlePage.isDisplayed();
		return assertResult;
	}
	
	public CreateProfilPage clickButtonCreate(WebDriver driver) {
		btnCreateProfil.click();
		return PageFactory.initElements(driver, CreateProfilPage.class);
	}

}
