package fr.eql.autom2.Libreplan.junit;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
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

	@After
	public void deleteDataAfterTestProfil() throws SQLException, ClassNotFoundException {

		// Pour la base de données
		ResultSet rs = null;
		String DRIVER = "org.postgresql.Driver";
		String JDBC_URL = "jdbc:postgresql://localhost:5432/libreplan";
		String USER = "postgres";
		String PASSWORD = "admin";
		String querySelect = "select * from profile_table";
		String queryRecupUser = "SELECT * FROM profile_table WHERE profile_name='Marc'";
		String queryGetId = "SELECT id from profile_table WHERE profile_name='Marc'";
		String queryDeleteID = null;
		String queryDelete1 = null;
		String id1 = null;
		int id2 = 0;

		//Load Postgre jdbc driver
		Class.forName(DRIVER);

		//Create Connection to DB		
		Connection con = DriverManager.getConnection(JDBC_URL,USER,PASSWORD);
		System.out.println("Connecté à la base");

		//Create Statement Object		
		Statement stmt = con.createStatement();

		// Nettoie la base pour 'Marc'
		try {		
			rs= stmt.executeQuery(queryRecupUser); // Recup 'Marc'

			if(rs != null) {
				rs= stmt.executeQuery(queryGetId); // Recup ID 'Marc'

				while (rs.next()) {
					id1 = rs.getString(1);
					id2 = Integer.parseInt(id1);

					queryDeleteID = "DELETE from profile_roles WHERE profile_id='"+id2+"'";

					stmt.executeQuery(queryDeleteID);	// Delete 'Marc'
					System.out.println("Profile_ID a été bien effacé de la base");
				}

			}		

		}catch(Exception e) {

		}
		try {
			if (rs != null) {
				queryDelete1 = "DELETE FROM profile_table WHERE profile_name='Marc'";
				stmt.executeQuery(queryDelete1);	// Delete 'Marc'
				System.out.println("Marc a bien été effacé de la base");
			}
		}catch(Exception e) {

		}

		rs= stmt.executeQuery(querySelect);	// Select all rows

		// While Loop to iterate through all data and print results		
		while (rs.next()){
			String id = rs.getString(1);								        
			String version = rs.getString(2);	
			String profile_name = rs.getString(3);								        			

			System. out.println(id+"  "+version+" "+profile_name);		
		}		
		// closing DB Connection		
		con.close();
		System.out.println("déconnecté de la base");

		// Ferme toutes les fenêtres
				this.driver.quit();
	}

}
