package fr.eql.autom2.Libreplantest.pageobject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
	// Déclaration de varaibles ou de propriétés

	WebDriverWait wait;

	@FindBy(how = How.XPATH, using=" ")
	public WebElement lblDasboard;

	// Constructeur
	public HomePage(WebDriver driver) {
		super(driver);

		// Initialisation de l'Objet wait
		wait = new WebDriverWait(driver, 10);
	}

	/**
	 * Méthode permettant de cliquer sur le bouton : Users
	 */
//	public SystemUserPage cliqueSurUsers() {		
//		// Se déplace sur les boutons jusqu'à cliquer dessus
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
