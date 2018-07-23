package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUnParticipantPage extends MasterPage{

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

	public CreateUnParticipantPage(WebDriver driver) {
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
	
	
}
