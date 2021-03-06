package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MasterPage {
	// D�claration de varaibles ou de propri�t�s
	protected final WebDriver driver;

	WebDriverWait wait;

	Actions actions;

	/**************************************
	 ******** Bouton d�connexion***********
	 *************************************/
	@FindBy(xpath="//div[@class='user-area']/descendant::a")
	protected WebElement btnDeconnexion;	

	/**************************************
	 * ******* Menu principal *************
	 *************************************/
	////////////////////////////////////////
	//////// Onglet CALENDRIER/////////////
	////////////////////////////////////////
	//*[substring(@id, string-length(@id) - string-length('7-b') +1) = '7-b']
	// (//div[@class='mainmenu z-menubar-hor']/table/tbody/tr/td[1]/descendant::button)[1]
	@FindBy(xpath="(//div[@class='mainmenu z-menubar-hor']/table/tbody/tr/td[1]/descendant::button)[1]")
	private WebElement ongletCalendrier;	
	/**
	 * sousmenu de CALENDRIER
	 */
	//----- Vue de la compagnie -----
	@FindBy(xpath="//div[@class='mainmenu z-menubar-hor']/table/tbody/tr/td[1]/descendant::div[@class='submenu z-menu-popup']/ul/li[1]/descendant::a")
	private WebElement sousmenuVueDeLaCompagnie;
	//----- Projets -----
	//body//div[@class='mainmenu z-menubar-hor']/table/tbody/tr/td[1]/descendant::div[@class='submenu z-menu-popup']/ul/li[2]/descendant::a
	@FindBy(xpath="//a[@href='/libreplan/planner/index.zul;orders_list']")
	private WebElement sousmenuProjets;
	
	////////////////////////////////////////
	//////// Onglet RESSOURCES/////////////
	////////////////////////////////////////
	@FindBy(xpath="(//div[@class='mainmenu z-menubar-hor']/table/tbody/tr/td[2]/descendant::button)[1]")
	private WebElement ongletRessources;	
	/**
	 * sousmenu de RESSOURCES
	 */
	//-----Participants-----
	@FindBy(xpath="//div[@class='mainmenu z-menubar-hor']/table/tbody/tr/td[2]/descendant::div[@class='submenu z-menu-popup']/ul/li[1]/descendant::a")
	private WebElement sousmenuParticipants;
	//-----Calendriers------
	@FindBy(xpath="//div[@class='mainmenu z-menubar-hor']/table/tbody/tr/td[2]/descendant::div[@class='submenu z-menu-popup']/ul/li[4]/descendant::a")
	private WebElement sousmenuCalendriers;
	//-----Crit�res-----
	@FindBy(xpath="//div[@class='mainmenu z-menubar-hor']/table/tbody/tr/td[2]/descendant::div[@class='submenu z-menu-popup']/ul/li[6]/descendant::a")
	private WebElement sousmenuCriteres;
	//-----Types d'avancement-----
	@FindBy(xpath="//div[@class='mainmenu z-menubar-hor']/table/tbody/tr/td[2]/descendant::div[@class='submenu z-menu-popup']/ul/li[7]/descendant::a")
	private WebElement sousmenuTypesDAvancement;
	
	
	////////////////////////////////////////
	////////////// Onlget COUT /////////////
	////////////////////////////////////////
	@FindBy(xpath="(//div[@class='mainmenu z-menubar-hor']/table/tbody/tr/td[3]/descendant::button)[1]")
	private WebElement ongletCout;	

	
	////////////////////////////////////////
	//////// Onlget CONFIGURATION///////////
	////////////////////////////////////////
	@FindBy(xpath="(//div[@class='mainmenu z-menubar-hor']/table/tbody/tr/td[4]/descendant::button)[1]")
	private WebElement ongletConfiguration;
	/**
	 * sousmenu de CONFIGURATION
	 */
	//-----Profils-----
	@FindBy(xpath="//div[@class='mainmenu z-menubar-hor']/table/tbody/tr/td[4]/descendant::div[@class='submenu z-menu-popup']/ul/li[3]/descendant::a")
	private WebElement sousmenuProfils;
	
		
	////////////////////////////////////////
	////////Onglet COMMUNICATIONS //////////
	////////////////////////////////////////
	@FindBy(xpath="(//div[@class='mainmenu z-menubar-hor']/table/tbody/tr/td[5]/descendant::button)[1]")
	private WebElement ongletCommunications;	

	
	////////////////////////////////////////
	////////// Onglet RAPPORTS /////////////
	////////////////////////////////////////
	@FindBy(xpath="(//div[@class='mainmenu z-menubar-hor']/table/tbody/tr/td[6]/descendant::button)[1]")
	private WebElement ongletRapports;	

	////////////////////////////////////////
	/////// Onglet ZONE PERSONNELLE ////////
	////////////////////////////////////////
	@FindBy(xpath="(//div[@class='mainmenu z-menubar-hor']/table/tbody/tr/td[7]/descendant::button)[1]")
	private WebElement ongletZonePersonnelle;


	// Constructeur
	public MasterPage(WebDriver driver) {
		super();
		this.driver = driver;
		this.actions = new Actions(driver);		

		// Initialisation de l'Objet wait a 10s
		wait = new WebDriverWait(driver, 10);
	}


	/**
	 * M�thode permettant d'attendre 10s que le WebElement s'affiche
	 * @param webElement
	 */
	public void waitAction(WebElement webElement) {
		this.wait.until(ExpectedConditions.visibilityOf(webElement)); 
	}
	
	/**
	 * Redirections Pages
	 */ 
	
	public ParticipantsPage goToParticipantsPage() {
		Actions actions = new Actions(driver);
		actions.moveToElement(ongletRessources)
				.moveToElement(sousmenuParticipants)
				.click()
				.build()
				.perform();
		return PageFactory.initElements(driver, ParticipantsPage.class);
	}
	
	public CalendarsPage goToCalendriersPage() {
		Actions actions = new Actions(driver);
		actions.moveToElement(ongletRessources)
				.moveToElement(sousmenuCalendriers)
				.click()
				.build()
				.perform();
		return PageFactory.initElements(driver, CalendarsPage.class);
	}
	
	public ProfilsPage goToProfilsPage() {
		String ID = driver.findElement(By.xpath("//body/div")).getAttribute("id");
		ID = ID.substring(0, 4);
		System.out.println(ID);
		Actions actions = new Actions(driver);
		actions.moveToElement(ongletConfiguration)
				.moveToElement(sousmenuProfils)
				.click()
				.build()
				.perform();
		return PageFactory.initElements(driver, ProfilsPage.class);
	}
	
	public AvancementTypePage goToTypeDAvancementPage() {
		Actions actions = new Actions(driver);
		actions.moveToElement(ongletRessources)
				.moveToElement(sousmenuTypesDAvancement)
				.click()
				.build()
				.perform();
		return PageFactory.initElements(driver, AvancementTypePage.class);
	}
	
	public ProjectPage goToProjectsPage() {
		Actions actions = new Actions(driver);
		actions.moveToElement(ongletCalendrier)
		.moveToElement(sousmenuProjets)
		.click()
		.build()
		.perform();
		/*actions.moveToElement(ongletCalendrier).build().perform();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(sousmenuProfils));
		sousmenuProjets.click();*/
		return PageFactory.initElements(driver, ProjectPage.class);
	}

}
