package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MasterPage {
	// Déclaration de varaibles ou de propriétés
	protected final WebDriver driver;

	WebDriverWait wait;

	Actions actions;

	// Bouton Déconnexion
	@FindBy(how = How.XPATH, using="/html/body/div[1]/div/div[1]/div[1]/div[1]/div/div/div/table/tbody/tr/td[3]/a")
	public WebElement btnDeconnexion;	

	// Onglet CALENDRIER
	@FindBy(how = How.XPATH, using="/html/body/div[1]/div/div[1]/div[1]/div[1]/div/div/table/tbody/tr/td[2]/table/tbody/tr/td/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/div")
	public WebElement ongletCalendrier;	

	// Onglet RESSOURCES
	@FindBy(id="tFyPr-b")
	public WebElement ongletRessources;	

	// Onlget COUT
	@FindBy(id="tFyPp0-b")
	public WebElement ongletCout;	

	// Onlget CONFIGURATION
	@FindBy(id="tFyP81-b")
	public WebElement ongletConfiguration;	

	// Onglet COMMUNICATIONS
	@FindBy(id="tFyPm1-b")
	public WebElement ongletCommunications;	

	// Onglet RAPPORTS
	@FindBy(id="tFyP22-b")
	public WebElement ongletRapports;	

	// Onglet ZONE PERSONNELLE
	@FindBy(id="tFyPv2-b")
	public WebElement ongletZonePersonnelle;


	// Constructeur
	public MasterPage(WebDriver driver) {
		super();
		this.driver = driver;
		this.actions = new Actions(driver);		

		// Initialisation de l'Objet wait a 10s
		wait = new WebDriverWait(driver, 10);
	}


	/**
	 * Méthode permettant d'attendre 10s que le WebElement s'affiche
	 * @param webElement
	 */
	public void waitAction(WebElement webElement) {
		this.wait.until(ExpectedConditions.visibilityOf(webElement)); 
	}

}
