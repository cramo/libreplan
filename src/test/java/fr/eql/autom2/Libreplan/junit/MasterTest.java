package fr.eql.autom2.Libreplan.junit;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import fr.eql.autom2.Libreplantest.pageobject.LoginPage;

public class MasterTest {

	protected WebDriver driver;
	protected Boolean verif;
	protected String path;
	
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
	
}
