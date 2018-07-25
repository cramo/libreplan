package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParticipantsPage extends MasterPage{

	@FindBy(xpath="(.//td[.//text()[contains(., 'Créer')]])[1]")
	private WebElement boutonCreer;
	@FindBy(xpath="//table[@class='filtering-area z-hbox']/descendant::span[text()[contains(., 'Filtré par')]]/../following-sibling::td[2]//input")
	private WebElement inputFiltre;
	@FindBy(xpath="//table[@class='filtering-area z-hbox']/descendant::span[text()[contains(., 'Filtré par')]]/../following-sibling::td[2]//input/following-sibling::i")
	private WebElement iconFiltre;
	@FindBy(xpath="//table[@class='filtering-area z-hbox']/descendant::span[text()[contains(., 'Détails personnels')]]/../following-sibling::td[2]/input")
	private WebElement inputDetailsPersonnels;
	@FindBy(xpath="//table[@class='filtering-area z-hbox']/descendant::td[text()[contains(.,'')]]")
	private WebElement boutonPlusDOptions;
	@FindBy(xpath="//table[@class='filtering-area z-hbox']/descendant::td[text()[contains(.,'Filtre')]]")
	private WebElement boutonFiltre;
	/**
	 * dans le bloc Plus d'option
	 */
	@FindBy()
	private WebElement calPeriodeActiveDepuis;
	@FindBy()
	private WebElement calPeriodeA;
	@FindBy()
	private WebElement comboboxType;
	/**
	 * Tableau participants
	 */
	@FindBy(xpath="//tbody//div[text()[contains(.,'Surnom')]]")
	private WebElement headSurnom;
	@FindBy(xpath="//tbody//div[text()[contains(.,'Prénom')]]")
	private WebElement headPrenom;
	@FindBy(xpath="//tbody//div[text()[contains(.,'ID')]]")
	private WebElement headId;
	@FindBy(xpath="//tbody//div[text()[contains(.,'Code')]]")
	private WebElement headCode;
	@FindBy(xpath="//tbody//div[text()[contains(.,'En file')]]")
	private WebElement headEnFile;
	@FindBy(xpath="//tbody//div[text()[contains(.,'Opération')]]")
	private WebElement headOperations;
	// en bas de tableau
	@FindBy()
	private WebElement boutonSuivant;
	@FindBy()
	private WebElement boutonPrecedant;
	@FindBy()
	private WebElement boutonJusquAuDernierPage;
	@FindBy()
	private WebElement boutonJusquAuPermierPage;
	
	
	
	public ParticipantsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Méthode actions
	 */
	public CreateAParticipantPage createParticipant() {
		boutonCreer.click();
		return PageFactory.initElements(driver, CreateAParticipantPage.class);
	}
	
	/**
	 * Vérifications
	 */
	public Boolean checkoutParticipantsPage() {
		return headSurnom.isDisplayed()
				&& headPrenom.isDisplayed()
				&& headId.isDisplayed()
				&& headCode.isDisplayed()
				&& headEnFile.isDisplayed()
				&& headOperations.isDisplayed()
				&& inputFiltre.isDisplayed()
				&& iconFiltre.isDisplayed()
				&& inputDetailsPersonnels.isDisplayed()
				&& boutonPlusDOptions.isDisplayed()
				&& boutonFiltre.isDisplayed()
				&& boutonCreer.isDisplayed();
	}
	
	// getter & setter
	public WebElement getBoutonCreer() {
		return boutonCreer;
	}
	public void setBoutonCreer(WebElement boutonCreer) {
		this.boutonCreer = boutonCreer;
	}
	public WebElement getInputFiltre() {
		return inputFiltre;
	}
	public void setInputFiltre(WebElement inputFiltre) {
		this.inputFiltre = inputFiltre;
	}
	public WebElement getIconFiltre() {
		return iconFiltre;
	}
	public void setIconFiltre(WebElement iconFiltre) {
		this.iconFiltre = iconFiltre;
	}
	public WebElement getInputDetailsPersonnels() {
		return inputDetailsPersonnels;
	}
	public void setInputDetailsPersonnels(WebElement inputDetailsPersonnels) {
		this.inputDetailsPersonnels = inputDetailsPersonnels;
	}
	public WebElement getBoutonPlusDOptions() {
		return boutonPlusDOptions;
	}
	public void setBoutonPlusDOptions(WebElement boutonPlusDOptions) {
		this.boutonPlusDOptions = boutonPlusDOptions;
	}
	public WebElement getBoutonFiltre() {
		return boutonFiltre;
	}
	public void setBoutonFiltre(WebElement boutonFiltre) {
		this.boutonFiltre = boutonFiltre;
	}
	public WebElement getCalPeriodeActiveDepuis() {
		return calPeriodeActiveDepuis;
	}
	public void setCalPeriodeActiveDepuis(WebElement calPeriodeActiveDepuis) {
		this.calPeriodeActiveDepuis = calPeriodeActiveDepuis;
	}
	public WebElement getCalPeriodeA() {
		return calPeriodeA;
	}
	public void setCalPeriodeA(WebElement calPeriodeA) {
		this.calPeriodeA = calPeriodeA;
	}
	public WebElement getComboboxType() {
		return comboboxType;
	}
	public void setComboboxType(WebElement comboboxType) {
		this.comboboxType = comboboxType;
	}
	public WebElement getHeadSurnom() {
		return headSurnom;
	}
	public void setHeadSurnom(WebElement headSurnom) {
		this.headSurnom = headSurnom;
	}
	public WebElement getHeadPrenom() {
		return headPrenom;
	}
	public void setHeadPrenom(WebElement headPrenom) {
		this.headPrenom = headPrenom;
	}
	public WebElement getHeadId() {
		return headId;
	}
	public void setHeadId(WebElement headId) {
		this.headId = headId;
	}
	public WebElement getHeadCode() {
		return headCode;
	}
	public void setHeadCode(WebElement headCode) {
		this.headCode = headCode;
	}
	public WebElement getHeadEnFile() {
		return headEnFile;
	}
	public void setHeadEnFile(WebElement headEnFile) {
		this.headEnFile = headEnFile;
	}
	public WebElement getHeadOperations() {
		return headOperations;
	}
	public void setHeadOperations(WebElement headOperations) {
		this.headOperations = headOperations;
	}
	public WebElement getBoutonSuivant() {
		return boutonSuivant;
	}
	public void setBoutonSuivant(WebElement boutonSuivant) {
		this.boutonSuivant = boutonSuivant;
	}
	public WebElement getBoutonPrecedant() {
		return boutonPrecedant;
	}
	public void setBoutonPrecedant(WebElement boutonPrecedant) {
		this.boutonPrecedant = boutonPrecedant;
	}
	public WebElement getBoutonJusquAuDernierPage() {
		return boutonJusquAuDernierPage;
	}
	public void setBoutonJusquAuDernierPage(WebElement boutonJusquAuDernierPage) {
		this.boutonJusquAuDernierPage = boutonJusquAuDernierPage;
	}
	public WebElement getBoutonJusquAuPermierPage() {
		return boutonJusquAuPermierPage;
	}
	public void setBoutonJusquAuPermierPage(WebElement boutonJusquAuPermierPage) {
		this.boutonJusquAuPermierPage = boutonJusquAuPermierPage;
	}
	
	
	
}
