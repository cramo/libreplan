package fr.eql.autom2.Libreplantest.pageobject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
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
	
    private final String titleCreatePageXpath = "//*[substring(@id, string-length(@id) - string-length('x4-cnt') +1) = 'x4-cnt']";
    @FindBy(xpath = titleCreatePageXpath)
	private WebElement titleCreatePage;

    private final String fieldNameXpath = "//*[substring(@id, string-length(@id) - string-length('a5') +1) = 'a5']";
    @FindBy(xpath = fieldNameXpath)
	private WebElement fieldName;
	
    private final String menuDeroulantUserRoleXpath = "//*[substring(@id, string-length(@id) - string-length('e5-real') +1) = 'e5-real']";
    @FindBy(xpath = menuDeroulantUserRoleXpath)
	private WebElement menuDeroulantUserRole;

    private final String btnAddRoleXpath = "//*[substring(@id, string-length(@id) - string-length('f5-box') +1) = 'f5-box']/tbody/tr[2]/td[@class='z-button-cm']";
	@FindBy(xpath = btnAddRoleXpath)
	private WebElement btnAddRole;
	
    private final String InfosBulleDeleteIconXpath = "//*[substring(@id, string-length(@id) - string-length('r4-cell') +1) = 'r4-cell']/span";
	@FindBy(xpath = InfosBulleDeleteIconXpath)
	private WebElement InfosBulleDeleteIcon;
	
	public boolean assertTitleCreateProfilPage() {
		boolean assertResult = this.titleCreatePage.isDisplayed();
		return assertResult;
	}
	
	public void setNameUser(String name) {
		this.fieldName.clear();
		this.fieldName.sendKeys(name);
	}
	
	public void selectUserRole(String role) {
		
		menuDeroulantUserRole.clear();
		menuDeroulantUserRole.sendKeys(role);
		btnAddRole.click();
	}
	
	public void addNewUserRole (String name, String role) {
		this.fieldName.clear();
		this.fieldName.sendKeys(name);
		menuDeroulantUserRole.clear();
		menuDeroulantUserRole.sendKeys(role);
		btnAddRole.click();
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

	public boolean trouverLigneContenantUserRoleParNOm(Set<String> roles) {
//	Set<String> rolesTrouves = new HashSet<String>();
	int nombreTrouvee = 0;
	List<WebElement> lignes = driver.findElements(By.xpath("//div[contains(@id, 'g5-body')]/table/tbody[2]/tr"));
	int ligneTrouvee = -1;
	int ligneCourant = 0;
	for (WebElement webElement : lignes) {
		WebElement numeroCase = webElement.findElement(By.xpath("td[1]/div/span"));
		String textRole = numeroCase.getText();
		if(roles.contains(textRole)) {
			ligneTrouvee = ligneCourant;
//			rolesTrouves.add(textRole);
			nombreTrouvee++;
		}
		ligneCourant++;
	}
	
//	return rolesTrouves.size() == roles.size();
	return nombreTrouvee == roles.size();
}
	
	public boolean trouverLigneContenantUserRoleDeletet(Set<String> roles) {
		int nombreTrouvee = 0;
		List<WebElement> lignes = driver.findElements(By.xpath("//div[contains(@id, 'g5-body')]/table/tbody[2]/tr"));
		int ligneTrouvee = -1;
		int ligneCourant = 0;
		for (WebElement webElement : lignes) {
			WebElement numeroCase = webElement.findElement(By.xpath("td[1]/div/span"));
			String textRole = numeroCase.getText();
			if(roles.contains(textRole)) {
				ligneTrouvee = ligneCourant;
				nombreTrouvee++;
			}
			ligneCourant++;
		}
		
		return false;
	}
	
	public int trouverLigneContenantIconeDeleteRoleParNom(Set<String> roles) {
		int nombreTrouvee = 0;
		List<WebElement> lignes = driver.findElements(By.xpath("//div[contains(@id, 'g5-body')]/table/tbody[2]/tr"));
		int ligneTrouvee = -1;
		int ligneCourante = 0;
		for (WebElement webElement : lignes) {
			WebElement numeroCase = webElement.findElement(By.xpath("td[1]/div/span"));
			String textRole = numeroCase.getText();
			if (roles.contains(textRole)) {
				ligneTrouvee = ligneCourante;
				nombreTrouvee++;
			}
			ligneCourante++;
		}
		
		return nombreTrouvee;
	}
	
	
	public int trouverLigneContenantUserRoleParNOm2(String nom, int numeroLigneUser) {
		List<WebElement> lignes = this.driver.findElements(By.xpath("//div[contains(@id, 'g5-body')]/table/tbody[2]/tr["+numeroLigneUser+"]"));
		int ligneTrouvee = -1;
		int ligneCourante = 0;
		for (WebElement ligne : lignes) {
			WebElement numeroCase = ligne.findElement(By.xpath("td[1]/div/span"));
			if (nom.equals(numeroCase.getText())) {
				ligneTrouvee = ligneCourante;
				return ligneTrouvee;
			}
			
			ligneCourante++;
		}
		return ligneTrouvee;
	}
	
	public void cliquerSurIconeSuppressionRole(Set<String> roles) {
		int numeroLigne = this.trouverLigneContenantIconeDeleteRoleParNom(roles);
		if (numeroLigne != -1) {
			WebElement lien = this.driver.findElement(By.xpath("//*[substring(@id, string-length(@id) - string-length('g5-body') +1) = 'g5-body']/table/tbody[2]/tr[" + (numeroLigne+1) + "]/td[2]/div/span/table/tbody/tr[2]/td[2]"));
			lien.click();
		}
		
//		throw new InvalidArgumentException("Ligne trouvée = " +numeroLigne);
	}
	
	public boolean AssertSurIconeSuppressionRole(String nom, int numeroLigneUser) throws InvalidArgumentException {
		int numeroLigne = this.trouverLigneContenantUserRoleParNOm2(nom, numeroLigneUser);
		if (numeroLigne != -1) {
			WebElement lien = this.driver.findElement(By.xpath("//*[substring(@id, string-length(@id) - string-length('g5-body') +1) = 'g5-body']/table/tbody[2]/tr[" + (numeroLigne+1) + "]/td[2]/div[1]/span"));
			String title1 = lien.getAttribute("title");
			boolean result = title1.contains("Supprimer");
			return result;
		}
		throw new InvalidArgumentException("Ligne trouvée = " +numeroLigne);
	}
	
	public Set<String> assertAfterDelete(Set<String> roles) {
		Set<String> listBeforeDelete = new HashSet<String>();
		List<WebElement> arrayBeforeDelete = driver.findElements(By.xpath("//div[contains(@id, 'g5-body')]/table/tbody[2]/tr"));
		for (WebElement roleName : arrayBeforeDelete) {
			WebElement numeroCase = roleName.findElement(By.xpath("td[1]/div/span"));
			String textRole = numeroCase.getText();
			if (roles.contains(textRole)) {
				listBeforeDelete.add(textRole);
			}
		}
		return listBeforeDelete;
	}

	
	
}