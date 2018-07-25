package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAParticipantPage extends MasterPage{

	@FindBy(xpath=".//span[@class='save-button global-action z-button']/descendant::td[text()=\"Enregistrer\"]")
	private WebElement boutonEnregistrer;
	@FindBy()
	private WebElement boutonSauverEtContinuer;
	@FindBy()
	private WebElement boutonAnnuler;
	@FindBy(id = "z_ddstkup")
	private WebElement iframeChampVide;
	@FindBy()
	private WebElement iframeChampVideBoutonFermer;
	/**
	 * onglet Données personnelles
	 */
	@FindBy(xpath="//div[@class='z-tabs z-tabs-scroll']//span[text()[contains(.,'Données personnelles')]]")
	private WebElement ongletDonneesPersonnelles;
	@FindBy(xpath="//span[text()=\"Code\"]/../../following-sibling::td//descendant::input[@type=\"text\"]")
	private WebElement inputCode;
	@FindBy(xpath="//span[text()=\"Code\"]/../../following-sibling::td//descendant::input[@type=\"checkbox\"]")
	private WebElement checkboxGenererLeCode;
	@FindBy(xpath="//span[text()=\"Prénom\"]/../../following-sibling::td//descendant::input[@type=\"text\"]")
	private WebElement inputPrenom;
	@FindBy(xpath="//span[text()=\"Nom\"]/../../following-sibling::td//descendant::input[@type=\"text\"]")
	private WebElement inputNom;
	@FindBy(xpath="//span[text()=\"ID\"]/../../following-sibling::td//descendant::input[@type=\"text\"]")
	private WebElement inputId;
	@FindBy(xpath="//tr[@valign=\"top\"]//select")
	private WebElement comboboxType;
	@FindBy(xpath="//label[text()=\"Non lié\"]/preceding-sibling::input")
	private WebElement radioBoutonNonLie;
	@FindBy(xpath="//label[text()=\"Utilisateur existant\"]/preceding-sibling::input")
	private WebElement radioBoutonUtilisateurExistant;
	@FindBy(xpath="//label[text()=\"Créer un nouvel utilisateur\"]/preceding-sibling::input")
	private WebElement radioBoutonCreerUnNouvelUtilisateur;
	@FindBy()
	private WebElement inputNomDUtilisatuer;
	@FindBy()
	private WebElement inputMotDePasse;
	@FindBy()
	private WebElement inputConfirmationDuMotDePasse;
	@FindBy()
	private WebElement inputEmailn;

	public CreateAParticipantPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Méthode actions
	 */
	
	
	/**
	 * Vérifications
	 */
	public Boolean checkoutCreateParticipantPage() {
		return ongletDonneesPersonnelles.isDisplayed();
	}

	// getter & setter
	public WebElement getBoutonEnregistrer() {
		return boutonEnregistrer;
	}

	public void setBoutonEnregistrer(WebElement boutonEnregistrer) {
		this.boutonEnregistrer = boutonEnregistrer;
	}

	public WebElement getBoutonSauverEtContinuer() {
		return boutonSauverEtContinuer;
	}

	public void setBoutonSauverEtContinuer(WebElement boutonSauverEtContinuer) {
		this.boutonSauverEtContinuer = boutonSauverEtContinuer;
	}

	public WebElement getBoutonAnnuler() {
		return boutonAnnuler;
	}

	public void setBoutonAnnuler(WebElement boutonAnnuler) {
		this.boutonAnnuler = boutonAnnuler;
	}

	public WebElement getIframeChampVide() {
		return iframeChampVide;
	}

	public void setIframeChampVide(WebElement iframeChampVide) {
		this.iframeChampVide = iframeChampVide;
	}

	public WebElement getIframeChampVideBoutonFermer() {
		return iframeChampVideBoutonFermer;
	}

	public void setIframeChampVideBoutonFermer(WebElement iframeChampVideBoutonFermer) {
		this.iframeChampVideBoutonFermer = iframeChampVideBoutonFermer;
	}

	public WebElement getOngletDonneesPersonnelles() {
		return ongletDonneesPersonnelles;
	}

	public void setOngletDonneesPersonnelles(WebElement ongletDonneesPersonnelles) {
		this.ongletDonneesPersonnelles = ongletDonneesPersonnelles;
	}

	public WebElement getInputCode() {
		return inputCode;
	}

	public void setInputCode(WebElement inputCode) {
		this.inputCode = inputCode;
	}

	public WebElement getCheckboxGenererLeCode() {
		return checkboxGenererLeCode;
	}

	public void setCheckboxGenererLeCode(WebElement checkboxGenererLeCode) {
		this.checkboxGenererLeCode = checkboxGenererLeCode;
	}

	public WebElement getInputPrenom() {
		return inputPrenom;
	}

	public void setInputPrenom(WebElement inputPrenom) {
		this.inputPrenom = inputPrenom;
	}

	public WebElement getInputNom() {
		return inputNom;
	}

	public void setInputNom(WebElement inputNom) {
		this.inputNom = inputNom;
	}

	public WebElement getInputId() {
		return inputId;
	}

	public void setInputId(WebElement inputId) {
		this.inputId = inputId;
	}

	public WebElement getComboboxType() {
		return comboboxType;
	}

	public void setComboboxType(WebElement comboboxType) {
		this.comboboxType = comboboxType;
	}

	public WebElement getRadioBoutonNonLie() {
		return radioBoutonNonLie;
	}

	public void setRadioBoutonNonLie(WebElement radioBoutonNonLie) {
		this.radioBoutonNonLie = radioBoutonNonLie;
	}

	public WebElement getRadioBoutonUtilisateurExistant() {
		return radioBoutonUtilisateurExistant;
	}

	public void setRadioBoutonUtilisateurExistant(WebElement radioBoutonUtilisateurExistant) {
		this.radioBoutonUtilisateurExistant = radioBoutonUtilisateurExistant;
	}

	public WebElement getRadioBoutonCreerUnNouvelUtilisateur() {
		return radioBoutonCreerUnNouvelUtilisateur;
	}

	public void setRadioBoutonCreerUnNouvelUtilisateur(WebElement radioBoutonCreerUnNouvelUtilisateur) {
		this.radioBoutonCreerUnNouvelUtilisateur = radioBoutonCreerUnNouvelUtilisateur;
	}

	public WebElement getInputNomDUtilisatuer() {
		return inputNomDUtilisatuer;
	}

	public void setInputNomDUtilisatuer(WebElement inputNomDUtilisatuer) {
		this.inputNomDUtilisatuer = inputNomDUtilisatuer;
	}

	public WebElement getInputMotDePasse() {
		return inputMotDePasse;
	}

	public void setInputMotDePasse(WebElement inputMotDePasse) {
		this.inputMotDePasse = inputMotDePasse;
	}

	public WebElement getInputConfirmationDuMotDePasse() {
		return inputConfirmationDuMotDePasse;
	}

	public void setInputConfirmationDuMotDePasse(WebElement inputConfirmationDuMotDePasse) {
		this.inputConfirmationDuMotDePasse = inputConfirmationDuMotDePasse;
	}

	public WebElement getInputEmailn() {
		return inputEmailn;
	}

	public void setInputEmailn(WebElement inputEmailn) {
		this.inputEmailn = inputEmailn;
	}
	
	
	
	
}
