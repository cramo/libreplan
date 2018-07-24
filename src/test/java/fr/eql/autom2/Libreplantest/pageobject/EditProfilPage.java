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

public class EditProfilPage extends MasterPage {
	
	public EditProfilPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
    private final String titleEditPageXpath = "//*[substring(@id, string-length(@id) - string-length('x4-cnt') +1) = 'x4-cnt']";
	@FindBy(xpath = titleEditPageXpath)
	private WebElement titleEditPage;

    private final String fieldNameXpath = "//*[substring(@id, string-length(@id) - string-length('a5') +1) = 'a5']";
    @FindBy(xpath = fieldNameXpath)
	private WebElement fieldName;
	
    private final String menuDeroulantUserRoleXpath = "//*[substring(@id, string-length(@id) - string-length('e5-real') +1) = 'e5-real']";
    @FindBy(xpath = menuDeroulantUserRoleXpath)
	private WebElement menuDeroulantUserRole;

    private final String btnAddRoleXpath = "//*[substring(@id, string-length(@id) - string-length('f5-box') +1) = 'f5-box']/tbody/tr[2]/td[@class='z-button-cm']";
	@FindBy(xpath = btnAddRoleXpath)
	private WebElement btnAddRole;

    private final String btnSaveXpath = "//*[substring(@id, string-length(@id) - string-length('k5-box') +1) = 'k5-box']/tbody/tr[2]/td[@class='z-button-cm']";
	@FindBy(xpath = btnSaveXpath)
	private WebElement btnSave;

	
	public boolean assertTitleEditProfil() {
		if (titleEditPage.getText().equals("Modifier Profil: Salim"));
		return true;
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
	
	public void addNewUserRole (String role) {
		menuDeroulantUserRole.clear();
		menuDeroulantUserRole.sendKeys(role);
		btnAddRole.click();
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
	
	public int trouverLigneContenantIconeDeleteRoleParNom(Set<String> roles) {
		int nombreTrouvee = -1;
		int ligneCourante = 0;
		List<WebElement> lignes = driver.findElements(By.xpath("//div[contains(@id, 'g5-body')]/table/tbody[2]/tr"));
		
		for (WebElement webElement : lignes) {
			WebElement numeroCase = webElement.findElement(By.xpath("td[1]/div/span"));
			String textRole = numeroCase.getText();
			if (roles.contains(textRole)) {
				nombreTrouvee = ligneCourante;
			}
			ligneCourante++;
		}
		
		return nombreTrouvee;
	}
	
	public void cliquerSurIconeSuppressionRole(Set<String> roles) {
		int numeroLigne = this.trouverLigneContenantIconeDeleteRoleParNom(roles);
		if (numeroLigne != -1) {
			WebElement lien = this.driver.findElement(By.xpath("//*[substring(@id, string-length(@id) - string-length('g5-body') +1) = 'g5-body']/table/tbody[2]/tr[" + (numeroLigne+1) + "]/td[2]/div/span/table/tbody/tr[2]/td[2]"));
			lien.click();
		}
	}
	
	public Set<String> getListRoles() {
		Set<String> listBeforeDelete = new HashSet<String>();
		List<WebElement> arrayBeforeDelete = driver.findElements(By.xpath("//div[contains(@id, 'g5-body')]/table/tbody[2]/tr"));
		for (WebElement roleName : arrayBeforeDelete) {
			WebElement numeroCase = roleName.findElement(By.xpath("td[1]/div/span"));
			listBeforeDelete.add(numeroCase.getText());
		}
		return listBeforeDelete;
	}
	
	public ProfilsPage clickButtonSave() {
		btnSave.click();
		return PageFactory.initElements(driver, ProfilsPage.class);
		
	}
	

	
	

	
}