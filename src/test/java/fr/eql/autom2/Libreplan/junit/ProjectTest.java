package fr.eql.autom2.Libreplan.junit;

import fr.eql.autom2.Libreplantest.pageobject.CalendriersPage;
import fr.eql.autom2.Libreplantest.pageobject.CompagnyViewPage;
import fr.eql.autom2.Libreplantest.pageobject.LoginPage;
import fr.eql.autom2.Libreplantest.pageobject.MasterPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ProjectTest {
    private WebDriver driver;
    private CompagnyViewPage compagnyViewPage;
    private WebDriverWait wait;
    private String calendrierXPath = "//*[substring(@id, string-length(@id) - string-length('7-b') +1) = '7-b']";//7-b

    @Before
    public void beforeTest() {
        //ou mettre les wait until, junit ou classes
        //bonne pratique ou pas de modifier les get set a sa sauce ?
        try {
            Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
            Runtime.getRuntime().exec("taskkill /F /IM plugin-container.exe");
            Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
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
    public void firstTest(){
        //assert sur l'affichage du calendrier
        wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(By.xpath(calendrierXPath)), ExpectedConditions.visibilityOfElementLocated(By.xpath(calendrierXPath))));
        WebElement calendar = driver.findElement(By.xpath(calendrierXPath));
        assertEquals(true, calendar.isDisplayed());
        compagnyViewPage.clickCreateProject();
        compagnyViewPage.createProject();
    }

    @After
    public void afterTest() {
        //this.driver.quit();
    }
}

