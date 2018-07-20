package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreerUnParticipantPage extends MasterPage{

	@FindBy()
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
	@FindBy()
	private WebElement inputPrenom;
	@FindBy()
	private WebElement inputNom;
	@FindBy()
	private WebElement inputId;
	@FindBy()
	private WebElement comboboxType;
	@FindBy()
	private WebElement radioBoutonNonLie;
	@FindBy()
	private WebElement radioBoutonUtilisateurExistant;
	@FindBy()
	private WebElement radioBoutonCreerUnNouvelUtilisateur;
	@FindBy()
	private WebElement inputNomDUtilisatuer;
	@FindBy()
	private WebElement inputMotDePasse;
	@FindBy()
	private WebElement inputConfirmationDuMotDePasse;
	@FindBy()
	private WebElement inputEmailn;
	
	
	
	
	
	
	public CreerUnParticipantPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
}
