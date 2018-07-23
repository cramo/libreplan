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
	public CreateUnParticipantPage createParticipant() {
		boutonCreer.click();
		return PageFactory.initElements(driver, CreateUnParticipantPage.class);
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
	
}
