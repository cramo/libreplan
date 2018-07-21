package fr.eql.autom2.Libreplan.junit;

import fr.eql.autom2.Libreplantest.pageobject.CalendriersPage;
import fr.eql.autom2.Libreplantest.pageobject.CompagnyViewPage;
import fr.eql.autom2.Libreplantest.pageobject.LoginPage;
import fr.eql.autom2.Libreplantest.pageobject.MasterPage;
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

public class ProjectTest {
    private WebDriver driver;

    @Test
    public void Test() {
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
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.libreplan.org/libreplan/planner/index.zul");
        LoginPage login = PageFactory.initElements(driver, LoginPage.class);
        login.remplirChampsLogin("admin", "admin");
        CompagnyViewPage compagnyViewPage = login.cliquerLogin();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        compagnyViewPage.clickCreateProject();


    }
}

