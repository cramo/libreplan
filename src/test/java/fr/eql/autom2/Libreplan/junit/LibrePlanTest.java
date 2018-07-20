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
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import fr.eql.autom2.Libreplantest.pageobject.CalendriersPage;
import fr.eql.autom2.Libreplantest.pageobject.LoginPage;
import fr.eql.autom2.Libreplantest.pageobject.MasterPage;

public class LibrePlanTest {

	WebDriver driver;
	Boolean verif;
	String path;
	
	

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
//		Mario //System.setProperty("webdriver.gecko.driver", "C:\\Formation\\SquashTA-1.10.0-RELEASE-workspace\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\formation\\geckodriver.exe");
		// Initialise la variable : driver et lance le navigateur
		driver = new FirefoxDriver();	
		
		// Agrandi la fenêtre
		this.driver.manage().window().maximize();

		// Navige à l'Url suivante
		//driver.get("http://demo.libreplan.org/libreplan/common/layout/login.zul");
		driver.get("http://localhost:8180/libreplan/");
		
		// Initialise ma variable : login
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.remplirChampsLogin("admin", "admin");
		login.cliquerLogin();
		
	}
//	@After
//	public void fermetureDuNavigateur() {	
//		// Ferme toutes les fenêtres
//		this.driver.quit();
//	}
	
	
	
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
}
