package fr.eql.autom2.Libreplantest.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateProfilPage extends MasterPage {
	
	public CreateProfilPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(how = How.XPATH, using="//*[contains(@id, 'x4-cnt')]")
	private WebElement titleCreatePage;

	@FindBy(how = How.CLASS_NAME, using="focus-element z-textbox z-textbox-text-invalid")
	private WebElement fieldName;
	
	@FindBy(how = How.XPATH, using="//*[contains(@id, 'e5-btn')]")
	private WebElement menuDeroulantUserRole;

	@FindBy(how = How.CLASS_NAME, using="z-button-cm")
	private WebElement btnAddRole;
	
	public boolean assertTitleCreateProfilPage() {
		boolean assertResult = this.titleCreatePage.isDisplayed();
		return assertResult;
	}
	
	public void setNameUser(String name) {
		this.fieldName.clear();
		this.fieldName.sendKeys(name);
	}
	
	public void selectUserRole(String role) {
		
		Select menu = new Select(menuDeroulantUserRole);
		menu.selectByVisibleText(role);
		btnAddRole.click();
	}
	
	public void assertUserRoleExist(String name) {
		
	}
	
	public int numeroDeColonneParEntete(String header) {
		
		int ligneTrouvee = -1;
		int ligneCourante = 0;
		
		List<WebElement> entetes = this.driver.findElements(By.xpath("//div[contains(@id, 'g5-head')]/table/tbody[2]/tr/th"));
		for (WebElement entete : entetes) {
			if (header.equals(entete.getText())) {
				ligneTrouvee = ligneCourante;
				return ligneTrouvee;
			}
			
			ligneCourante++;
		}
		return ligneCourante;
	}
	
	public int trouverLigneContenantUserRoleParNOm(String nom) {
		List<WebElement> lignes = this.driver.findElements(By.xpath("//div[contains(@id, 'g5-body')]/table/tbody[2]/tr"));
		int ligneTrouvee = -1;
		int ligneCourante = 0;
		
		for (WebElement ligne : lignes) {
			WebElement premiereCase = ligne.findElement(By.xpath("td[1]/div/span"));
			if (nom.equals(premiereCase.getText())) {
				ligneTrouvee = ligneCourante;
				return ligneTrouvee;
			}
			
			ligneCourante++;
		}
		return ligneTrouvee;
	}
	
	public void cliquerSurIconeSuppressionRole(String nom) throws InvalidArgumentException {
		int numeroLigne = this.trouverLigneContenantUserRoleParNOm(nom);
		if (numeroLigne != -1) {
			WebElement lien = this.driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + (numeroLigne+1) + "]/td[2]/div/span"));
			lien.click();
		}
		
		throw new InvalidArgumentException("Ligne trouvée = " +numeroLigne);
	}
	
	
}