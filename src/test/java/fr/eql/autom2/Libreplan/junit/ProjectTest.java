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
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.xml.transform.Result;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ProjectTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String calendarXPath = "//*[substring(@id, string-length(@id) - string-length('7-b') +1) = '7-b']";//7-b
    private CompagnyViewPage compagnyViewPage;
    private ProjectEditor projectEditor;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
    private LocalDateTime time = LocalDateTime.now();
    private ProjectDetailPage projectDetailPage;

    @Before
    public void beforeTest() {
        //ou mettre les wait until, junit ou classes > classes
        //bonne pratique ou pas de modifier les get set a sa sauce ? > nop
        //use a builder pour les params ou faire un page object de create un project
        //entourer le wait d'un if en vÃ©rif son boolean et en faisant un else fails() ?
        //regarder les url des pages pour voir si ce sont des nouvelles pages > bof

        //TODO : Rename classes like the english version of the app

        try {
            Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
            Runtime.getRuntime().exec("taskkill /F /IM plugin-container.exe");
            Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://demo.libreplan.org/libreplan/planner/index.zul");
        wait = new WebDriverWait(driver, 10);
        LoginPage login = PageFactory.initElements(driver, LoginPage.class);
        login.remplirChampsLogin("admin", "admin");
        compagnyViewPage = login.cliquerLogin();
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void firstTest() throws InterruptedException {
        //1er pas
        calendarIsDisplayed();
        //2ieme pas
        projectEditor = compagnyViewPage.clickCreateProject();
        createNewProjectElementsArePresent();
        //3ieme pas
        fillingCreateProjectObject();
        projectDetailPage = projectEditor.clickAcceptCreateProject();
        detailProjectPageDisplayed();
        //4ieme pas
        verifyOrderOfTabs();
      //*[@id="xSrE14-box"]/tbody/tr[2]/td[2]
      //*[@id="xSrE34-box"]/tbody/tr[2]/td[2]
      //*[@id="xSrE54-box"]/tbody/tr[2]/td[2]
      //*[@id="xSrE54-box"]/tbody/tr[2]/td[2]
      //*[@id="xSrEb4-box"]/tbody/tr[2]/td[2] 
    	/*String hex = "b4";
        int value = Integer.parseInt(hex, 16);
        System.out.println(value);*/
    }

    private void calendarIsDisplayed() {
        wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(By.xpath(calendarXPath)), ExpectedConditions.visibilityOfElementLocated(By.xpath(calendarXPath))));
        WebElement calendar = driver.findElement(By.xpath(calendarXPath));
        assertEquals(true, calendar.isDisplayed());
    }

    private void createNewProjectElementsArePresent() {
        wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(By.xpath(projectEditor.getInputNameXPath())), ExpectedConditions.visibilityOfElementLocated(By.xpath(projectEditor.getInputNameXPath()))));
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
		int  n = rand.nextInt(500) + 1;
		projectEditor.setInputName("PROJET_TEST1" + n);
        wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(By.xpath(projectEditor.getCheckboxCodeGenerateXPath())), ExpectedConditions.visibilityOfElementLocated(By.xpath(projectEditor.getCheckboxCodeGenerateXPath()))));
        projectEditor.setCheckboxCodeGenerate(State.OFF);
        wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(By.xpath(projectEditor.getInputCodeXPath())), ExpectedConditions.visibilityOfElementLocated(By.xpath(projectEditor.getInputCodeXPath()))));
        projectEditor.setInputCode("PRJTEST001" + n);
        wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(By.xpath(projectEditor.getDateboxBeginXPath())), ExpectedConditions.visibilityOfElementLocated(By.xpath(projectEditor.getDateboxBeginXPath()))));
        projectEditor.setDateboxBegin(dtf.format(time.plusDays(5)));
        wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(By.xpath(projectEditor.getDateboxDeadlineXPath())), ExpectedConditions.visibilityOfElementLocated(By.xpath(projectEditor.getDateboxDeadlineXPath()))));
        projectEditor.setDateboxDeadline(dtf.format(time.plusDays(15)));	
	}
	
	private void detailProjectPageDisplayed() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(projectDetailPage.getTableDashboardXPath())));
        assertEquals(true, projectDetailPage.getSpanMenuWBS().isDisplayed());
        assertEquals("WBS (tâches)", projectDetailPage.getSpanMenuWBS().getText());
        assertEquals(true, projectDetailPage.getTableProjectDetail().isDisplayed());
        assertEquals("Détail du projet", projectDetailPage.getTableProjectDetail().getText());
	}
	
	private void verifyOrderOfTabs() {
		List<WebElement> tabs = driver.findElements(By.xpath("//*[substring(@id, string-length(@id) - string-length('r3') +1) = 'r3']/tbody/tr/td/table/tbody/tr/td/span/table/tbody/tr[2]/td[2]"));
		System.out.println("lignes = " + tabs.size());
		List<String> str = new ArrayList<String>();
		str.add("Planification de projet");
		str.add("Détail du projet");
		str.add("Chargement des ressources");
		str.add("Allocation avancée");
		str.add("Tableau de bord");
		str.add("test");
		int i = 0;
		for(WebElement tab : tabs){
			System.out.println("tab = " + tab.getText());
			if(tab.getText().equals(str.get(i))){
				i++;
				System.out.println("if = " + i);
			}
			System.out.println("boucle = " + i);
		}
		System.out.println("result = " + i);
		assertEquals(5, i); 	
	}

    @After
    public void afterTest() throws InterruptedException {
    	//Thread.sleep(2000);
        this.driver.quit();
    }
}

