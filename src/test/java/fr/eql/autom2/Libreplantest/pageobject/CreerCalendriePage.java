package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreerCalendriePage extends MasterPage
{
	/**
	 * Elements communs
	 */
	@FindBy(xpath="(.//span[@class='save-button global-action z-button']/descendant::td[.//text()[contains(., 'Enregistrer')]])[1]")
	private WebElement boutonEnregistrer;
	@FindBy(xpath="(.//span[@class='saveandcontinue-button global-action z-button']/descendant::td[.//text()[contains(., 'Enregistrer')]])[1]")
	private WebElement boutonEnregistrerEtContinuer;
	@FindBy(xpath="(.//span[@class='cancel-button global-action z-button']/descendant::td[.//text()[contains(., 'Annuler')]])[1]")
	private WebElement boutonAnnuler;
	@FindBy(xpath=".//span[.//text()[contains(., 'Nom')]]/../../following-sibling::td/div/input")
	private WebElement inputNom;
	/**
	 * Onglet Exceptions 
	 */
	@FindBy()
	private WebElement CalDateDeDubut;
	@FindBy()
	private WebElement CalDateDeFin;
	@FindBy()
	private WebElement comboboxEffortNormal1;
	@FindBy()
	private WebElement comboboxEffortNormal2;
	@FindBy()
	private WebElement comboboxEffortEnHeuresSupp1;
	@FindBy()
	private WebElement comboboxEffortEnHeuresSupp2;
	@FindBy()
	private WebElement radiobuttonIllimite;
	@FindBy()
	private WebElement comboboxTypeDException;
	/**
	 * Onglet Semaine de Travail
	 */
	
	
	public CreerCalendriePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Méthodes
	 */
	public CalendriersPage fillInNameOfCalendar(String nom) {
		inputNom.sendKeys(nom);
		boutonEnregistrer.click();
		return PageFactory.initElements(driver, CalendriersPage.class);
	}
	
	public CalendriersPage filleInCalendrieDeriveIncorrectly(String nom) {
		inputNom.sendKeys(nom);
		boutonEnregistrerEtContinuer.click();
		return PageFactory.initElements(driver, CalendriersPage.class);
	}
	
	public CalendriersPage filleInCalendrieDeriveCorrectly(String nom) {
		inputNom.clear();
		inputNom.sendKeys(nom);
		boutonEnregistrerEtContinuer.click();
		return PageFactory.initElements(driver, CalendriersPage.class);
	}
	
	public CalendriersPage clicButtonAnnuler() {
		boutonAnnuler.click();
		return PageFactory.initElements(driver, CalendriersPage.class);
	}
	
	public CalendriersPage createCalendrieCopyIncorrectly() {
		boutonEnregistrer.click();
		return PageFactory.initElements(driver, CalendriersPage.class);
	}
	
	public CalendriersPage createCalendrieCopyCorrectly(String nom) {
		inputNom.clear();
		inputNom.sendKeys(nom);
		boutonEnregistrer.click();
		return PageFactory.initElements(driver, CalendriersPage.class);
	}
}
