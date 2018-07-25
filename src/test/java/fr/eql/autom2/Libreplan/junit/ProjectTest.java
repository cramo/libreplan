package fr.eql.autom2.Libreplan.junit;

import fr.eql.autom2.Libreplantest.pageobject.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ProjectTest {
	private WebDriver driver;
	private WebDriverWait wait;
	private final String calendarXPath = "//*[substring(@id, string-length(@id) - string-length('7-b') +1) = '7-b']";// 7-b
	private CompagnyViewPage compagnyViewPage;
	private ProjectEditor projectEditor;
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MMM yyyy");
	private LocalDateTime time = LocalDateTime.now();
	private ProjectDetailPage projectDetailPage;
	private MasterPage masterPage;
	private ProjectPage projectPage;
	private List<String> data;

	@Before
	public void beforeTest() {
		// ou mettre les wait until, junit ou classes > classes
		// bonne pratique ou pas de modifier les get set a sa sauce ? > nop
		// use a builder pour les params ou faire un page object de create un project
		// entourer le wait d'un if en vérif son boolean et en faisant un else fails()
		// ?
		// regarder les url des pages pour voir si ce sont des nouvelles pages > bof

		/*
		 * System.out.println("innerHTML =" + el.getAttribute("innerHTML"));
		 * System.out.println("value =" + el.getAttribute("textContent"));
		 */

		// TODO : Rename classes like the english version of the app

		try {
			Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM plugin-container.exe");
			Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver.exe");
		 * driver = new ChromeDriver();
		 */
		System.setProperty("webdriver.gecko.driver", "C:\\dev\\geckodriver.exe");
		driver = new FirefoxDriver();
		// driver.get("http://demo.libreplan.org/libreplan/planner/index.zul");
		driver.get("http://localhost:8180/libreplan/");
		wait = new WebDriverWait(driver, 5);
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.remplirChampsLogin("admin", "admin");
		compagnyViewPage = login.cliquerLogin();
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		masterPage = PageFactory.initElements(driver, MasterPage.class);
		data = new ArrayList<String>();
	}

	@Test
	public void firstTest() {
		// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// ProjectPage projectPage = masterPage.goToProjectsPage();
		// 1er pas
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/libreplan/planner/index.zul;orders_list']")));
		// projectPage = masterPage.goToProjectsPage();
		calendarIsDisplayed();
		// 2ieme pas
		projectEditor = compagnyViewPage.clickCreateProject();
		createNewProjectElementsArePresent();
		// 3ieme pas
		fillingCreateProjectObject();
		projectDetailPage = projectEditor.clickAcceptCreateProject();
		detailProjectPageDisplayed();
		// 4ieme pas
		verifyOrderOfVerticalTabs();
		// 5ieme pas
		verifyOrderOfHorizontalTabs();
		// 6ieme pas
		saveAndCancelButtonVerifications();
		// 7ieme pas
		clickAndVerifyCancelPopup();
		// 8ieme pas
		projectDetailPage.getBtnConfirmCancel().click();
		detailProjectPageDisplayed();
		// 9ieme pas
		clickAndVerifyCancelPopup();
		// 10ieme pas
		clickOkAndVerifyElements();
		// 11ieme pas
		goToProfilAndVerif();
		// 12ieme pas
		// masterPage = PageFactory.initElements(driver, MasterPage.class);
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/libreplan/planner/index.zul;orders_list']")));
		System.out.println("salut");
		try {
			verifyProjectInformations();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			verifyIcons();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fin test 1");
	}

	private void verifyIcons() throws InterruptedException {
		// Thread.sleep(5000);
		// projectPage = masterPage.goToProjectsPage();
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[substring(@id,
		// string-length(@id) - string-length('i6') +1) =
		// 'i6']/tr/td/div/table/tbody/tr/td/table/tbody/tr")));
		// Thread.sleep(2000);
		// *[substring(@id, string-length(@id) - string-length('i6') +1) = 'i6']/tr/td
		//Thread.sleep(5000);
		List<WebElement> lines = driver.findElements(By.xpath(
				"//*[substring(@id, string-length(@id) - string-length('i6') +1) = 'i6']/tr/td/div/table/tbody/tr/td/table/tbody/tr/td"));
		List<WebElement> previous = driver.findElements(
				By.xpath("//*[substring(@id, string-length(@id) - string-length('i6') +1) = 'i6']/tr/td/div/span"));
		int i = 0;
		int result = 0;
		System.out.println("str = " + data);
		System.out.println("lignes = " + lines.size());
		for (WebElement ligne : lines) {
			System.out.println("une ligne = " + ligne.getText());
			i++;
			if (i == 3) {
				//Thread.sleep(1000);
				ligne.click();
				//Thread.sleep(2000);
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(projectPage.getBtnOkXPath())));
				System.out.println("xhedh");
				//*[@id="i5GQn5"]
				WebElement popup = driver.findElement(By.xpath("//*[ @class=\"z-window-modal z-window-modal-shadow\"]"));
				WebElement boutonOk = driver.findElement(By.xpath("//*[contains(text(), \"OK\") and @class=\"z-button-cm\"]"));
				Actions sup = new Actions(driver);
				sup.moveToElement(popup)
						.moveToElement(boutonOk)
						.click()
						.build()
						.perform();
				break;
				
				/*wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), \"OK\") and @class=\"z-button-cm\"]")),
						ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), \"OK\") and @class=\"z-button-cm\"]"))));
				WebElement btn = driver.findElement(By.xpath("//*[contains(text(), \"OK\") and @class=\"z-button-cm\"]"));
				assertEquals(true, btn.isDisplayed());
				btn.click();
				
				driver.switchTo().window("Delete");*/
//				wait.until(//ExpectedConditions.and(ExpectedConditions.elementToBeClickable(By.xpath(projectPage.getBtnOkXPath())),
//						ExpectedConditions.visibilityOfElementLocated(By.xpath(projectPage.getBtnOkXPath())));
				//assertEquals(true, projectPage.getBtnOk().isDisplayed());
				//projectPage.getBtnOk().click();
				
				//break;
			}
		}
	}

	private boolean horizontalMenuIsNotPresent() {
		try {
			WebElement el = driver.findElement(By.xpath("//span[@class=\"z-tab-text\"]"));
		} catch (java.util.NoSuchElementException | org.openqa.selenium.NoSuchElementException e) {
			return true;
		}
		return false;
	}

	private void calendarIsDisplayed() {
		wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(By.xpath(calendarXPath)),
				ExpectedConditions.visibilityOfElementLocated(By.xpath(calendarXPath))));
		WebElement calendar = driver.findElement(By.xpath(calendarXPath));
		assertEquals(true, calendar.isDisplayed());
	}

	private void createNewProjectElementsArePresent() {
		wait.until(ExpectedConditions.and(
				ExpectedConditions.elementToBeClickable(By.xpath(projectEditor.getInputNameXPath())),
				ExpectedConditions.visibilityOfElementLocated(By.xpath(projectEditor.getInputNameXPath()))));
		assertEquals(true, projectEditor.getInputName().isDisplayed());
		assertEquals("", projectEditor.getInputName().getText());
		assertEquals(true, projectEditor.getInputModel().isDisplayed());
		assertEquals("", projectEditor.getInputModel().getText());
		assertEquals(true, projectEditor.getInputCode().isDisplayed());
		assertEquals("ORDER", projectEditor.getInputCode().getAttribute("value").substring(0, 5));
		assertEquals(true, projectEditor.getCheckboxCodeGenerate().isDisplayed());
		assertEquals(true, projectEditor.getCheckboxCodeGenerate().isSelected());
		assertEquals(true, projectEditor.getDateboxBegin().isDisplayed());
		assertEquals(dtf.format(time), projectEditor.getDateboxBegin().getAttribute("value"));
		assertEquals(true, projectEditor.getBtnDateboxBegin().isDisplayed());
		assertEquals(true, projectEditor.getDateboxDeadline().isDisplayed());
		assertEquals("", projectEditor.getDateboxDeadline().getText());
		assertEquals(true, projectEditor.getBtnDateboxDeadline().isDisplayed());
		assertEquals(true, projectEditor.getInputClient().isDisplayed());
		assertEquals("", projectEditor.getInputClient().getText());
		assertEquals(true, projectEditor.getSelectCalendar().isDisplayed());
		assertEquals("Default", projectEditor.getSelectCalendar().getAttribute("value"));
		assertEquals(true, projectEditor.getBtnAccept().isDisplayed());
		assertEquals(true, projectEditor.getBtnCancel().isDisplayed());
	}

	private void fillingCreateProjectObject() {
		Random rand = new Random();
		//int n = rand.nextInt(999999) + 1;
		projectEditor.setInputName("PROJET_TEST1" /*+ n*/);
		data.add(("PROJET_TEST1" /*+ n*/));
		wait.until(ExpectedConditions.and(
				ExpectedConditions.elementToBeClickable(By.xpath(projectEditor.getCheckboxCodeGenerateXPath())),
				ExpectedConditions.visibilityOfElementLocated(By.xpath(projectEditor.getCheckboxCodeGenerateXPath()))));
		projectEditor.setCheckboxCodeGenerate(State.OFF);
		wait.until(ExpectedConditions.and(
				ExpectedConditions.elementToBeClickable(By.xpath(projectEditor.getInputCodeXPath())),
				ExpectedConditions.visibilityOfElementLocated(By.xpath(projectEditor.getInputCodeXPath()))));
		projectEditor.setInputCode("PRJTEST001" /*+ n*/);
		data.add(("PRJTEST001" /*+ n*/));
		wait.until(ExpectedConditions.and(
				ExpectedConditions.elementToBeClickable(By.xpath(projectEditor.getDateboxBeginXPath())),
				ExpectedConditions.visibilityOfElementLocated(By.xpath(projectEditor.getDateboxBeginXPath()))));
		projectEditor.setDateboxBegin(dtf.format(time.plusDays(5)));
		data.add(dtf.format(time.plusDays(5)));
		wait.until(ExpectedConditions.and(
				ExpectedConditions.elementToBeClickable(By.xpath(projectEditor.getDateboxDeadlineXPath())),
				ExpectedConditions.visibilityOfElementLocated(By.xpath(projectEditor.getDateboxDeadlineXPath()))));
		projectEditor.setDateboxDeadline(dtf.format(time.plusDays(15)));
		data.add(dtf.format(time.plusDays(15)));
		data.add("");
		data.add("0 �");
		data.add("0");
		data.add("PRE-VENTES");
	}

	private void detailProjectPageDisplayed() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(projectDetailPage.getTableDashboardXPath())));
		assertEquals(true, projectDetailPage.getSpanMenuWBS().isDisplayed());
		assertEquals("WBS (t�ches)", projectDetailPage.getSpanMenuWBS().getText());
		assertEquals(true, projectDetailPage.getTableProjectDetail().isDisplayed());
		assertEquals("D�tail du projet", projectDetailPage.getTableProjectDetail().getText());
	}

	private void verifyOrderOfVerticalTabs() {
		List<WebElement> tabs = driver.findElements(By.xpath(
				"//*[substring(@id, string-length(@id) - string-length('r3') +1) = 'r3']/tbody/tr/td/table/tbody/tr/td/span/table/tbody/tr[2]/td[2]"));// r3
																																						// demo
																																						// r3
		// System.out.println("lignes = " + tabs.size());
		List<String> str = new ArrayList<String>();
		str.add("Planification de projet");
		str.add("D�tail du projet");
		str.add("Chargement des ressources");
		str.add("Allocation avanc�e");
		str.add("Tableau de bord");
		str.add("test");
		int i = 0;
		for (WebElement tab : tabs) {
			// System.out.println("tab = " + tab.getText());
			if (tab.getText().equals(str.get(i))) {
				i++;
				// System.out.println("if = " + i);
			}
			// System.out.println("boucle = " + i);
		}
		// System.out.println("result = " + i);
		assertEquals(5, i);
	}

	private void verifyOrderOfHorizontalTabs() {// *[@id="n38Vrv-cave"]
		List<WebElement> tabs = driver.findElements(By.xpath("//span[@class=\"z-tab-text\"]")); // gc-cave // demo//
																								// v-hm
		// ul/li[9]/div/div/div[contains(@id, 'v-hm')]/span
		// System.out.println("lignes = " + tabs.size());
		List<String> str = new ArrayList<String>();
		str.add("WBS (t�ches)");
		str.add("Donn�es g�n�rales");
		str.add("Co�t");
		str.add("Avancement");
		str.add("Libell�s");
		str.add("Exigence de crit�re");
		str.add("Mat�riels");
		str.add("Formulaires qualit� des t�ches");
		str.add("Autorisation");
		str.add("kokok");
		int i = 0;
		for (WebElement tab : tabs) {
			// System.out.println("tab = " + tab.getAttribute("innerHTML"));
			if (tab.getAttribute("innerHTML").equals(str.get(i))) {
				i++;
				// System.out.println("if = " + i);
			}
			// System.out.println("boucle = " + i);
		}
		// System.out.println("result = " + i);
		assertEquals(9, i);
	}

	private void saveAndCancelButtonVerifications() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(projectDetailPage.getBtnSaveImageXPATH())));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(projectDetailPage.getBtnCancelImageXPATH())));
		assertEquals("Enregistrer le projet", projectDetailPage.getBtnSave().getAttribute("title"));
		assertEquals("Annuler l'�dition", projectDetailPage.getBtnCancel().getAttribute("title"));
		assertEquals(true, projectDetailPage.getBtnSaveImage().isDisplayed());
		assertEquals(true, projectDetailPage.getBtnCancelImage().isDisplayed());
	}

	private void clickAndVerifyCancelPopup() {
		projectDetailPage.getBtnCancel().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(projectDetailPage.getDivTextCancelXPath())));
		assertEquals("Confirmer la fen�tre de sortie", projectDetailPage.getDivConfirmCancelBis().getText());
		assertEquals("Les modifications non enregistr�es seront perdues. �tes-vous s�r ?",
				projectDetailPage.getDivTextCancel().getText());
		assertEquals("OK", projectDetailPage.getBtnConfirmOk().getText());
		assertEquals("Annuler", projectDetailPage.getbtnConfirmCancel().getText());
	}

	private void clickOkAndVerifyElements() {
		projectDetailPage.getBtnConfirmOk().click();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(compagnyViewPage.getBtnCreateProjectXPath())));
		assertEquals(true, compagnyViewPage.getTableProjectPlanification().isDisplayed());
		assertEquals("Planification des projets", compagnyViewPage.getTableProjectPlanification().getText());
		boolean bool = horizontalMenuIsNotPresent();
		assertEquals(true, bool);
	}

	private void goToProfilAndVerif() {
		masterPage = PageFactory.initElements(driver, MasterPage.class);
		ProjectPage projectPage = masterPage.goToProjectsPage();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(projectPage.getTableListOfProjectXPath())));
		assertEquals(true, projectPage.getTableListOfProject().isDisplayed());
		assertEquals("Liste des projets", projectPage.getTableListOfProject().getText());
	}

	private void verifyProjectInformations() throws InterruptedException {
		// Thread.sleep(5000);
		// projectPage = masterPage.goToProjectsPage();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[substring(@id, string-length(@id) - string-length('45-cave') +1) = '45-cave']")));
		// Thread.sleep(2000);
		List<WebElement> lines = driver.findElements(
				By.xpath("//*[substring(@id, string-length(@id) - string-length('i6') +1) = 'i6']/tr/td/div/span"));
		int i = 0;
		int result = 0;
		System.out.println("str = " + data);
		System.out.println("lignes = " + lines.size());
		for (WebElement ligne : lines) {
			System.out.println("une ligne = " + ligne.getText());
			if (data.get(0).equals(lines.get(i).getText())) {
				System.out.println("trouv�");
				result = i;
				// i = i + 7;
				int n = 0;
				assertEquals(lines.get(result).getText(), data.get(n));
				assertEquals(lines.get(result + 1).getText(), data.get(n + 1));
				assertEquals(lines.get(result + 2).getText(), data.get(n + 2));
				assertEquals(lines.get(result + 3).getText(), data.get(n + 3));
				assertEquals(lines.get(result + 4).getText(), data.get(n + 4));
				assertEquals(lines.get(result + 5).getText(), data.get(n + 5));
				assertEquals(lines.get(result + 6).getText(), data.get(n + 6));
				assertEquals(lines.get(result + 7).getText(), data.get(n + 7));
				break;
			}
			i++;
		}
	}

	@After
	public void afterTest() throws InterruptedException, SQLException, ClassNotFoundException {
		// Pour la base de donn�es
		/*
		 * ResultSet rs = null; String DRIVER = "org.postgresql.Driver"; String JDBC_URL
		 * = "jdbc:postgresql://localhost:5432/libreplan"; String USER = "postgres";
		 * String PASSWORD = "admin"; String querySelect = "select * from advance_type";
		 * String queryRecupTest1 =
		 * "SELECT * FROM advance_type WHERE unit_name='Type avancement - Test 1'";
		 * String queryRecupTest2 =
		 * "SELECT * FROM advance_type WHERE unit_name='Type avancement - Test 2'";
		 * String queryDelete1 =
		 * "DELETE FROM advance_type WHERE unit_name='Type avancement - Test 1'"; String
		 * queryDelete2 =
		 * "DELETE FROM advance_type WHERE unit_name='Type avancement - Test 2'";
		 * 
		 * //Load Postgre jdbc driver Class.forName(DRIVER);
		 * 
		 * //Create Connection to DB Connection con =
		 * DriverManager.getConnection(JDBC_URL,USER,PASSWORD);
		 * System.out.println("Connect� � la base");
		 * 
		 * //Create Statement Object Statement stmt = con.createStatement();
		 * 
		 * // Nettoie la base pour 'Test 1' try { rs=
		 * stmt.executeQuery(queryRecupTest1); // Recup 'Test 1'
		 * 
		 * if(rs != null) { stmt.executeQuery(queryDelete1); // Delete 'Test 1'
		 * System.out.println("Test1 effac� de la base"); }
		 * 
		 * }catch(Exception e) {
		 * 
		 * } con.close();
		 */

		// *[@id="kXEPk7-box"]/tbody/tr[2]/td[2]/img
		// *[@id="jYFPk7-box"]/tbody/tr[2]/td[2]/img

		// Thread.sleep(5000);
		this.driver.quit();
	}
}
