package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class ProfilsPage extends MasterPage {
	
	public ProfilsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(how = How.XPATH, using="//*[contains(@id, 'j4-cap')]")
	private WebElement titlePage;

	@FindBy(how = How.CLASS_NAME, using="z-button-cm")
	private WebElement btnCreate;
	
	@FindBy(how = How.XPATH, using="//*[contains(@id, 'x4-cnt')]")
	private WebElement BreadcrumbProfils;

	public boolean assertTitleProfilsPage() {
		boolean assertResult = this.titlePage.isDisplayed();
		return assertResult;
	}
	
	public CreateProfilPage clickButtonCreate(WebDriver driver) {
		this.btnCreate.click();
		return PageFactory.initElements(driver, CreateProfilPage.class);
	}

}
