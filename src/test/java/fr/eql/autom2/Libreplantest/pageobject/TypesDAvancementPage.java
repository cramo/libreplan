package fr.eql.autom2.Libreplantest.pageobject;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TypesDAvancementPage extends MasterPage{

	@FindBy(xpath="//td[contains(text(),\"Créer\")]")
	public WebElement btnCreer;

	@FindBy(xpath="//input[contains(@id,'55')]")
	public WebElement txtNomUnite;

	@FindBy(xpath="//input[contains(@id,'b5')]")
	public WebElement txtValeurMax;

	@FindBy(xpath="//td[contains(text(),'Enregistrer')]")
	public WebElement btnEnregistrer;

	@FindBy(xpath="//*[contains(@id,'k5-real')]")
	public WebElement chkbPourcentage;	
	
	@FindBy(xpath="//tr[2]//input[@type=\"checkbox\" and contains(@id,\"5-real\")]")
	public WebElement chkbActif;	

	@FindBy(xpath="//*[contains(text(),'Sauver et continuer') and @class='z-button-cm']")
	public WebElement btnSauverContinuer;

	@FindBy(xpath="//*[contains(text(),'Type avancement - Test 2\" enregistré')]")
	public WebElement lblConfirmationTest2;
	
	@FindBy(xpath="//*[contains(text(),\"Modifier Type d'avancement: Type avancement - Test 2\")]")
	public WebElement lblTitreModif;
	
	@FindBy(xpath="//*[contains(text(),\"Annuler\") and @class=\"z-button-cm\"]")
	public WebElement btnAnnuler;
	
	@FindBy(xpath="//*[contains(text(),\"Types d'avancement Liste\") and @class=\"z-window-embedded-header\"]")
	public WebElement lblTitreTypeAvance;
	
	@FindBy(xpath="//*[contains(text(),\"Type avancement - Test 2\") and @class=\"z-label\"]")
	public WebElement lblTabNom;
	
	@FindBy(xpath="//tr[6]//span[@class=\"z-checkbox\"]/input[@checked=\"checked\"]")
	public WebElement lblTabActive;
	
	@FindBy(xpath="//tr[6]//td[3]//span[@class=\"z-checkbox\"]/input[@type=\"checkbox\"]")
	public WebElement lblTabPredefini;
	
	@FindBy(xpath="//tr[6]//img[@src=\"/libreplan/common/img/ico_editar1.png\"]")
	public WebElement imgTabModifier;
	
	@FindBy(xpath="//tr[6]//img[@src=\"/libreplan/common/img/ico_borrar1.png\"]")
	public WebElement imgTabSuppr;
	
	@FindBy(xpath="//*[contains(text(),\"Nom\") and @class=\"z-column-cnt\"]")
	public WebElement headNom;
	
	@FindBy(xpath="//*[contains(text(),\"Activé\") and @class=\"z-column-cnt\"]")
	public WebElement headActive;
	
	@FindBy(xpath="//*[contains(text(),\"Prédéfini\") and @class=\"z-column-cnt\"]")
	public WebElement headPredefini;
	
	@FindBy(xpath="//*[contains(text(),\"Opérations\") and @class=\"z-column-cnt\"]")
	public WebElement headOperations;	
	
	// Label
	@FindBy(xpath="//*[contains(text(),\"Modifier\") and @class=\"z-tab-text\"]")
	public WebElement lblModifierTitre;
	
//	@FindBy(xpath="//*[contains(text(),\"Nom d'unité\") and @class=\"z-label\"]")
//	public WebElement lblNomUnite;
//	
//	@FindBy(xpath="//*[contains(text(),\"Actif\") and @class=\"z-label\"]")
//	public WebElement lblActif;
//	
//	@FindBy(xpath="//*[contains(text(),\"Valeur maximum par défaut\") and @class=\"z-label\"]")
//	public WebElement lblMaxParDefaut;
//	
//	@FindBy(xpath="//*[contains(text(),\"Précision\") and @class=\"z-label\"]")
//	public WebElement lblPrecision	;
//	
//	@FindBy(xpath="//div[@class=\"z-tabpanels\"]//span[contains(text(),\"Type\") and @class=\"z-label\"]")
//	public WebElement lblType;
//	
//	@FindBy(xpath="//span[contains(text(),\"Pourcentage\") and @class=\"z-label\"]")
//	public WebElement lblPourcentage;
	
	
	

	// CONSTRUCTEUR
	public TypesDAvancementPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Méthode permettant de cliquer sur le bouton : créer
	 */
	public void clickOnBtnCreer() {
		// clique sur le bouton créer
		btnCreer.click();
	}

	public void remplirChampNomUniteValeurMax(String nomUnite, String valeurMax) {
		// vérifie que l'lément est affiché
		txtNomUnite.isDisplayed();

		// rempli le champ nom d'unité
		txtNomUnite.sendKeys(nomUnite);

		// vérifie si le champ valeur max est affiché
		txtValeurMax.isDisplayed();

		// nettoie le champ
		txtValeurMax.clear();

		// modifie la valuer du champ valuer max
		txtValeurMax.sendKeys(valeurMax);
	}

	public void remplirChampNomUniteCocherPercentage(String nomUnite) {
		// vérifie que l'lément est affiché
		txtNomUnite.isDisplayed();

		// rempli le champ nom d'unité
		txtNomUnite.sendKeys(nomUnite);

		// coche la checkbox
		chkbPourcentage.click();
	}

	public String recupNomUnite() {
		// Récupère le texte du champ
		String recup = txtNomUnite.getText();		
		return recup;
	}

	public String recupValeurMax() {
		// Récupère le texte du champ
		String recup = txtValeurMax.getText();
		return recup;
	}

	public void clickOnEnregistrer() {		
		// clique sur le bouton enregistré
		btnEnregistrer.click();	
	}

	public void clickOnSauverContinuer() {
		// clique sur le bouton sauver et continuer
		btnSauverContinuer.click();
	}
	
	public void clickOnAnnuler() {
		// clique sur le bouton annuler
		btnAnnuler.click();
	}
}
