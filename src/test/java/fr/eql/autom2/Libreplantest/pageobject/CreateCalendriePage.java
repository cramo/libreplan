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

	public WebElement getBoutonEnregistrer() {
		return boutonEnregistrer;
	}

	public void setBoutonEnregistrer(WebElement boutonEnregistrer) {
		this.boutonEnregistrer = boutonEnregistrer;
	}

	public WebElement getBoutonEnregistrerEtContinuer() {
		return boutonEnregistrerEtContinuer;
	}

	public void setBoutonEnregistrerEtContinuer(WebElement boutonEnregistrerEtContinuer) {
		this.boutonEnregistrerEtContinuer = boutonEnregistrerEtContinuer;
	}

	public WebElement getBoutonAnnuler() {
		return boutonAnnuler;
	}

	public void setBoutonAnnuler(WebElement boutonAnnuler) {
		this.boutonAnnuler = boutonAnnuler;
	}

	public WebElement getInputNom() {
		return inputNom;
	}

	public void setInputNom(WebElement inputNom) {
		this.inputNom = inputNom;
	}

	public WebElement getOngletDonnesDeCalendrier() {
		return ongletDonnesDeCalendrier;
	}

	public void setOngletDonnesDeCalendrier(WebElement ongletDonnesDeCalendrier) {
		this.ongletDonnesDeCalendrier = ongletDonnesDeCalendrier;
	}

	public WebElement getTypeCalendrier() {
		return typeCalendrier;
	}

	public void setTypeCalendrier(WebElement typeCalendrier) {
		this.typeCalendrier = typeCalendrier;
	}

	public WebElement getCalDateDeDubut() {
		return CalDateDeDubut;
	}

	public void setCalDateDeDubut(WebElement calDateDeDubut) {
		CalDateDeDubut = calDateDeDubut;
	}

	public WebElement getCalDateDeFin() {
		return CalDateDeFin;
	}

	public void setCalDateDeFin(WebElement calDateDeFin) {
		CalDateDeFin = calDateDeFin;
	}

	public WebElement getComboboxEffortNormal1() {
		return comboboxEffortNormal1;
	}

	public void setComboboxEffortNormal1(WebElement comboboxEffortNormal1) {
		this.comboboxEffortNormal1 = comboboxEffortNormal1;
	}

	public WebElement getComboboxEffortNormal2() {
		return comboboxEffortNormal2;
	}

	public void setComboboxEffortNormal2(WebElement comboboxEffortNormal2) {
		this.comboboxEffortNormal2 = comboboxEffortNormal2;
	}

	public WebElement getComboboxEffortEnHeuresSupp1() {
		return comboboxEffortEnHeuresSupp1;
	}

	public void setComboboxEffortEnHeuresSupp1(WebElement comboboxEffortEnHeuresSupp1) {
		this.comboboxEffortEnHeuresSupp1 = comboboxEffortEnHeuresSupp1;
	}

	public WebElement getComboboxEffortEnHeuresSupp2() {
		return comboboxEffortEnHeuresSupp2;
	}

	public void setComboboxEffortEnHeuresSupp2(WebElement comboboxEffortEnHeuresSupp2) {
		this.comboboxEffortEnHeuresSupp2 = comboboxEffortEnHeuresSupp2;
	}

	public WebElement getRadiobuttonIllimite() {
		return radiobuttonIllimite;
	}

	public void setRadiobuttonIllimite(WebElement radiobuttonIllimite) {
		this.radiobuttonIllimite = radiobuttonIllimite;
	}

	public WebElement getComboboxTypeDException() {
		return comboboxTypeDException;
	}

	public void setComboboxTypeDException(WebElement comboboxTypeDException) {
		this.comboboxTypeDException = comboboxTypeDException;
	}
	
	

}
