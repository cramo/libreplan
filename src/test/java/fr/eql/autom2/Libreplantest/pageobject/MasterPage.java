package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MasterPage {
	// Déclaration de varaibles ou de propriétés
	protected final WebDriver driver;
	
	WebDriverWait wait;
	
	Actions actions;
		
	@FindBy(how = How.XPATH, using=" ")
	public WebElement btnAdmin;
	
	@FindBy(how = How.XPATH, using=" ")
	public WebElement btnUserManagement;
	
	@FindBy(how = How.XPATH, using=" ")
	public WebElement btnUsers;
	
	// Constructeur
	public MasterPage(WebDriver driver) {
		super();
		this.driver = driver;
		this.actions = new Actions(driver);
	}
	
	/**
	 * Méthode permettant d'attendre 10s que le WebElement s'affiche
	 * @param webElement
	 */
	public void waitAction(WebElement webElement) {
		this.wait.until(ExpectedConditions.visibilityOf(webElement)); 
	}

}
