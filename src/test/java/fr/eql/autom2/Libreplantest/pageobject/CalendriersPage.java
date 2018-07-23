package fr.eql.autom2.Libreplantest.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendriersPage extends MasterPage 
{

	@FindBy(xpath="(.//td[.//text()[contains(., 'Créer')]])[1]")
	private WebElement boutonCreer;
	@FindBy(xpath="//div[@class='z-dottree-header']/descendant::div[.//text()[contains(., 'Nom')]]")
	private WebElement headNom;
	@FindBy(xpath="//div[@class='z-dottree-header']/descendant::div[.//text()[contains(., 'Hérité de la date')]]")
	private WebElement headHeriteDeLaDate;
	@FindBy(xpath="//div[@class='z-dottree-header']/descendant::div[.//text()[contains(., 'Héritages à jour')]]")
	private WebElement headHeritageAJour;
	@FindBy(xpath="//div[@class='z-dottree-header']/descendant::div[.//text()[contains(., 'Opérations')]]")
	private WebElement HeadOperations;
	

	public CalendriersPage(WebDriver driver) {
		super(driver);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public CreerCalendriePage createCalendrie() {
		boutonCreer.click(); 
		return PageFactory.initElements(driver, CreerCalendriePage.class);
	}
	
	public CreerCalendriePage createUneDerive(String test) {
		WebElement iconCreerUneDerive = driver.findElement(By.xpath("(.//span[.//text()[contains(., '"+test+"')]]/../../following-sibling::td[3]/descendant::td[.//img])[1]"));
		iconCreerUneDerive.click(); 
		return PageFactory.initElements(driver, CreerCalendriePage.class);
	}
	
	public CreerCalendriePage createUneCopieCalendrie(String test) {
		WebElement iconCreerUneCopie = driver.findElement(By.xpath("(.//span[.//text()[contains(., '"+test+"')]]/../../following-sibling::td[3]/descendant::td[.//img])[2]"));
		iconCreerUneCopie.click();
		return PageFactory.initElements(driver, CreerCalendriePage.class);
	}
	
	public Boolean checkoutTableHeader() {
		return headNom.isDisplayed() 
				&& headHeriteDeLaDate.isDisplayed()
				&& headHeritageAJour.isDisplayed()
				&& HeadOperations.isDisplayed()
				&& boutonCreer.isDisplayed();
	}

}
