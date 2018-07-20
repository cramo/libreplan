package fr.eql.autom2.Libreplantest.pageobject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends MasterPage {
	// D�claration de varaibles ou de propri�t�s

	@FindBy(id="hR4Qt4-cave")
	public WebElement barTransversale;

	// Constructeur
	public HomePage(WebDriver driver) {
		super(driver);			
	}
	
	/**
	 * M�thode permettant de se d�connecter
	 */
	public LoginPage signOut() {
		// Attend que le bouton d�connexion soit cliquable
		this.wait.until(ExpectedConditions.elementToBeClickable(btnDeconnexion)); 
		
		// Clique sur le bouton d�connexion
		btnDeconnexion.click();
		
		return PageFactory.initElements(driver, LoginPage.class);
	}


	public void clickOnLink_VueDeLaCompagnie() {
		
		this.wait.until(ExpectedConditions.visibilityOf(ongletCalendrier)); 

		ongletCalendrier.isDisplayed();
		
		// Se d�place sur l'onlget Calendrier
		this.actions.moveToElement(ongletCalendrier).build().perform();	

		// Switch sur la iFrame
		//this.driver.switchTo().frame(0);
		//System.out.println("iframe");
		
		// R�cup�re le lien de l'iFrame
		WebElement iFrameLink_VueDeLaCompagnie = this.driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div[1]/div/div/table/tbody/tr/td[2]/table/tbody/tr/td/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/div/div/ul/li[1]/div/div/div/a"));
		System.out.println("webelement");
		
		// Clique sur le lien
		iFrameLink_VueDeLaCompagnie.click();
		System.out.println("click");

		// Sortie du iFrame
		//this.driver.switchTo().defaultContent();

		//return PageFactory.initElements(driver, SystemUserPage.class);
	}

	/**
	 * M�thode permettant de cliquer sur le bouton : Users
	 */
	//	public SystemUserPage cliqueSurUsers() {		
	//		// Se d�place sur les boutons jusqu'� cliquer dessus
	//		actions.moveToElement(btnAdmin).build().perform();		
	//		actions.moveToElement(btnUserManagement).build().perform();
	//
	//		wait.until(ExpectedConditions.elementToBeClickable(btnUsers));
	//		wait.until(ExpectedConditions.elementToBeClickable(btnUsers));
	//
	//		btnUsers.click();
	//
	//		return  PageFactory.initElements(driver, SystemUserPage.class);
	//	}

	/**
	 * M�thode permettant de faire un ScreenShot
	 * @return
	 */
	public String captureScreen(){ 
		String path = null;

		try { 
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
			path = "./target/screenshots/" + source.getName(); 
			Files.copy(Paths.get(source.getAbsolutePath()), new FileOutputStream(path));


		} catch(IOException e) { 

		} 

		return path; 
	}

}
