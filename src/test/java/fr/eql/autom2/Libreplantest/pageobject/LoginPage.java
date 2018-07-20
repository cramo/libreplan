package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	// Déclaration de propriété, variables et autre..
	protected final WebDriver driver;

	WebDriverWait wait;

	Boolean verif;

	@FindBy(how = How.XPATH, using="//*[@id='textfield']")
	private WebElement txtUsername;

	@FindBy(how = How.XPATH, using="//*[@id='textfield2']")
	private WebElement txtPassword;

	@FindBy(how = How.XPATH, using="//*[@id='button']")
	private WebElement btnLogin;

	// Constructeur
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
	}

	/**
	 * Méthode permettant de remplir les champs username et password
	 * 
	 * @param txtUsername
	 * @param txtPassword
	 */
	public void remplirChampsLogin(String txtUsername, String txtPassword) {
		// Condition vérifiant la présence des éléments
		if(this.txtUsername.isDisplayed() == false || this.txtPassword.isDisplayed() == false)
		{
			// Attend 10s qu'il s'affiche
			this.txtUsername = wait.until(ExpectedConditions.elementToBeClickable(By.id("txtUsername")));
			this.txtUsername.sendKeys(txtUsername);
			this.txtPassword.sendKeys(txtPassword);
		} else {
			// Nettoyer ce qui déjà dans les champs
			this.txtUsername.clear();
			this.txtPassword.clear();
			// Rempli les champs username et password
			this.txtUsername.sendKeys(txtUsername);
			this.txtPassword.sendKeys(txtPassword);
		}
	}

	/**
	 * Méthode permettant de cliquer sur login
	 */
	public CompagnyViewPage cliquerLogin() {
		// Vérifie si le bouton est visible
		verif = btnLogin.isDisplayed();

		// Condition vérifiant si le bouton est affiché
		if(verif == true) btnLogin.click();
		
		return  PageFactory.initElements(driver, CompagnyViewPage.class);
	}


}
