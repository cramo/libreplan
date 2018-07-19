package fr.eql.autom2.Libreplan.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class LibrePlanTest {

	WebDriver driver;
//	LoginPage login;
//	HomePage homePage;
//	SystemUserPage systemUserPage;
	Boolean verif;
//	EditUserPage editUserPage;
	String path;
	
	/**
	 * Méthode permettant de faire un screenshot
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void faireUnScreenShot() throws FileNotFoundException, IOException {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		path = "./target/screenshots/" + source.getName(); 
		Files.copy(Paths.get(source.getAbsolutePath()), new FileOutputStream(path));
	}

	@Before
	public void beforeTest() throws MalformedURLException {
		
		// Nettoie le cache de l'ordi (méthode de Marc)
		try {
			Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM plugin-container.exe");
			Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}		
		
		// Récupère le fichier geckodriver.exe
		System.setProperty("webdriver.gecko.driver", "C:\\Formation\\SquashTA-1.10.0-RELEASE-workspace\\geckodriver.exe");
		
		// Initialise la variable : driver et lance le navigateur
		driver = new FirefoxDriver();	
		
		// Agrandi la fenêtre
		this.driver.manage().window().maximize();

		// Navige à l'Url suivante
		driver.get("http://demo.libreplan.org/libreplan/common/layout/login.zul");

		
		// Initialise ma variable : login
		//login = PageFactory.initElements(driver, LoginPage.class);
 
	}


	@Test
	public void monTestOrangeHrm() throws FileNotFoundException, IOException {
/*
		try
		{
			// Rempli les champs
			login.remplirChampsLogin("admin", "admin");

			// Clique sur le bouton login
			homePage = login.cliquerLogin();

			// Clique sur le bouton : Users
			systemUserPage = homePage.cliqueSurUsers();
						
			// Recherche un élément
			systemUserPage.rechercheParUserRole("1"); // recherche Admin
			systemUserPage.checkSearchResult("admin"); // vérifie le résultat

			systemUserPage.rechercheParUserRole("2"); // recherche ESS
			systemUserPage.checkSearchNoResult("No Records Found"); // vérifie le résultat

			// Vérifie le username et l'employer name
			systemUserPage.rechercheParUserRole("1"); // recherche admin
			String username = systemUserPage.recupererEmployerName("E E E"); // récupère l'employer name
			assertEquals("vérifie l'employer name", "admin2",username); // vérifie l'employer name

			// Clique sur username
			editUserPage = systemUserPage.cliqueSurUsername(username);

			// Vérifie les informations
			verif = editUserPage.formulaireInactif();
			assertEquals("Vérifie que tous les champs de la page sont inactifs", false, verif);
			
			// Clique sur le bpouton : Cancel
			systemUserPage = editUserPage.cliqueSurCancel();
			
			// Active la checkbox
			systemUserPage.cliqueSurCheckbox(username);
			
			// Vérifie si la checkbox est coché
			verif = systemUserPage.verifStatusCheckbox();
			assertTrue(verif);
			
			systemUserPage.dragAndDrop();
		}
		catch (Exception e) {
			System.out.println("Nous avons une erreur !");
			
			// Fait un creenShot
			faireUnScreenShot();
		}
		*/
	}
	
	@After
	public void fermetureDuNavigateur() {	
		
		// Ferme toutes les fenêtres
		this.driver.quit();
		
	}
}
