package fr.eql.autom2.Libreplantest.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCalendriePage extends MasterPage
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
	@FindBy(xpath="//span[@class='z-tab-text']")
	private WebElement ongletDonnesDeCalendrier;
	@FindBy(xpath="//tr[@class='calendar-data z-row z-grid-odd']//td[2]//span[1]")
	private WebElement typeCalendrier;
	
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
	
	
	public CreateCalendriePage(WebDriver driver) {
		super(driver);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * Méthodes actions
	 */
	public CalendarsPage fillInNameOfCalendar(String nom) {
		inputNom.sendKeys(nom);
		boutonEnregistrer.click();
		return PageFactory.initElements(driver, CalendarsPage.class);
	}
	
	public CalendarsPage filleInCalendrieDeriveIncorrectly(String nom) {
		inputNom.sendKeys(nom);
		boutonEnregistrerEtContinuer.click();
		return PageFactory.initElements(driver, CalendarsPage.class);
	}
	
	public CalendarsPage filleInCalendrieDeriveCorrectly(String nom) {
		inputNom.clear();
		inputNom.sendKeys(nom);
		boutonEnregistrerEtContinuer.click();
		return PageFactory.initElements(driver, CalendarsPage.class);
	}
	
	public CalendarsPage clicButtonAnnuler() {
		boutonAnnuler.click();
		return PageFactory.initElements(driver, CalendarsPage.class);
	}
	
	public CalendarsPage createCalendrieCopyIncorrectly() {
		boutonEnregistrer.click();
		return PageFactory.initElements(driver, CalendarsPage.class);
	}
	
	public CalendarsPage createCalendrieCopyCorrectly(String nom) {
		inputNom.clear();
		inputNom.sendKeys(nom);
		boutonEnregistrer.click();
		return PageFactory.initElements(driver, CalendarsPage.class);
	}
	
	// vérifications 
	public Boolean checkoutCreerCalendrier() {
		return ongletDonnesDeCalendrier.isDisplayed()
				&& boutonAnnuler.isDisplayed()
				&& boutonEnregistrer.isDisplayed()
				&& boutonEnregistrerEtContinuer.isDisplayed();
	}
	
	public Boolean checkoutCreerCalendrieirDerive(String type) {
		return inputNom.getText().isEmpty()
				&& typeCalendrier.getText().equals(type);
	}
	
	public Boolean checkoutCreerCopieCalendrier(String nom, String type) {
		return inputNom.getAttribute("innerHTML").equals(nom)
				&& typeCalendrier.getText().equals(type);
	}
	

}
