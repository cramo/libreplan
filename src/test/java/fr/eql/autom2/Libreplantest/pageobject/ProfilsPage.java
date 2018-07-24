package fr.eql.autom2.Libreplantest.pageobject;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class ProfilsPage extends MasterPage {
	
	private String idPrefix;
	
    private final String btnCreateProfilXpath = "//*[substring(@id, string-length(@id) - string-length('v4-box') +1) = 'v4-box']/tbody/tr[2]/td[@class='z-button-cm']";
	@FindBy(xpath = btnCreateProfilXpath)
	private WebElement btnCreateProfil;
	
    private final String saveProfilMessageXpath = "//*[substring(@id, string-length(@id) - string-length('a8-chdex') +1) = 'a8-chdex']/td/div/span";
	@FindBy(xpath = saveProfilMessageXpath)
	private WebElement saveProfilMessage; 
	
    private final String saveEditProfilMessageXpath = "//*[substring(@id, string-length(@id) - string-length('77-chdex') +1) = '77-chdex']/td/div/span";
	@FindBy(xpath = saveEditProfilMessageXpath)
	private WebElement saveEditProfilMessage;

	public ProfilsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String idVariable() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String ID = driver.findElement(By.xpath("//body/div")).getAttribute("id");
		ID = ID.substring(0, 4);
	return ID;
	}
	
/*	
	@FindBy(how = How.XPATH, using="//*[contains(@id, 'j4-cap')]")
	private WebElement titlePage;

	@FindBy(how = How.CLASS_NAME, using="z-button-cm")
	private WebElement btnCreate;*/

	public boolean assertTitleProfilsPage() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String ID = driver.findElement(By.xpath("//*[contains(@id, 'j4-cap')]")).getAttribute("id");
		ID = ID.substring(0, 4);
		System.out.println(ID);
		System.out.println(idVariable()+"j4-cap");
		WebElement titlePage=(WebElement) driver.findElement(By.xpath("//*[@id='"+ID+"j4-cap']"));
		boolean assertResult = titlePage.isDisplayed();
		return assertResult;
	}
	
	public CreateProfilPage clickButtonCreate(WebDriver driver) {
		btnCreateProfil.click();
		return PageFactory.initElements(driver, CreateProfilPage.class);
	}
	
	public boolean assertSaveProfilMessage(String messageNameProfil) {
		if (saveProfilMessage.getText().equals(messageNameProfil));
		return true;
	}
	
	public boolean assertSaveEditProfilMessage(String messageNameProfil) {
		if (saveEditProfilMessage.getText().equals(messageNameProfil));
		return true;
	}
	
	public Set<String> getArrayListProfils() {
		Set<String> listProfilsNames = new HashSet<String>();
		List<WebElement> arrayBeforeDelete = driver.findElements(By.xpath("//div[contains(@id, 'k4-body')]/table/tbody[2]/tr"));
		for (WebElement roleName : arrayBeforeDelete) {
			WebElement numeroCase = roleName.findElement(By.xpath("td[1]/div/span"));
			listProfilsNames.add(numeroCase.getText());
		}
		return listProfilsNames;
	}
	
	
	public int trouverLigneContenantNomProfil(Set<String> namesProfils) {
		int nombreTrouvee = -1;
		int ligneCourante = 0;
		List<WebElement> lignes = driver.findElements(By.xpath("//div[contains(@id, 'k4-body')]/table/tbody[2]/tr"));
		
		for (WebElement webElement : lignes) {
			WebElement numeroCase = webElement.findElement(By.xpath("td[1]/div/span"));
			String textRole = numeroCase.getText();
			if (namesProfils.contains(textRole)) {
				nombreTrouvee = ligneCourante;
			}
			ligneCourante++;
		}
		
		return nombreTrouvee;
	}
	
	public EditProfilPage cliquerSurIconeModificationProfil(Set<String> namesProfils) {
		int numeroLigne = this.trouverLigneContenantNomProfil(namesProfils);
		if (numeroLigne != -1) {
			WebElement lien = this.driver.findElement(By.xpath("//*[substring(@id, string-length(@id) - string-length('k4-body') +1) = 'k4-body']/table/tbody[2]/tr[" + (numeroLigne+1) + "]/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/span/table/tbody/tr[2]/td[2]"));
			lien.click();
		}
		return PageFactory.initElements(driver, EditProfilPage.class);
	}

}
