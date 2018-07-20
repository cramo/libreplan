package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendriersPage extends MasterPage 
{

	@FindBy(xpath="(.//td[.//text()[contains(., 'Créer')]])[1]")
	private WebElement boutonCreer;
//	@FindBy(xpath="(.//span[.//text()[contains(., 'Test 1')]]/../../following-sibling::td[3]/descendant::td[.//img])[2]")
//	private WebElement iconCreerUneCopie;
	

	public CalendriersPage(WebDriver driver) {
		super(driver);
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
	
	

}
