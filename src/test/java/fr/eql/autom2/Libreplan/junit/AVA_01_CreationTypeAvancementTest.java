package fr.eql.autom2.Libreplan.junit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import fr.eql.autom2.Libreplantest.pageobject.CompagnyViewPage;
import fr.eql.autom2.Libreplantest.pageobject.LoginPage;

public class AVA_01_CreationTypeAvancementTest {

	WebDriver driver;
	LoginPage login;
	CompagnyViewPage compagnyView;
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
		driver.get("http://localhost:8180/libreplan");

		// Initialise ma variable : login
		login = PageFactory.initElements(driver, LoginPage.class); 
	}

	@Test
	public void CreationTypeAvancementTest() throws FileNotFoundException, IOException {

		try
		{
			// Créé un temps d'attente
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			// Clique sur le bouton login
			compagnyView = login.cliquerLogin();

			// Acceder à la page type d'avancement
			compagnyView.goToTypeDAvancementPage();


		}
		catch (Exception e) {
			System.out.println("Nous avons une erreur !");

			// Fait un creenShot
			faireUnScreenShot();
		}
	}
	

	@After
	public void fermetureDuNavigateur() {	

		// Ferme toutes les fenêtres
		//this.driver.quit();

	}

}
