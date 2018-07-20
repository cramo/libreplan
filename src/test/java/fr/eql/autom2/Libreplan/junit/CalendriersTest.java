package fr.eql.autom2.Libreplan.junit;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import fr.eql.autom2.Libreplantest.pageobject.CalendriersPage;
import fr.eql.autom2.Libreplantest.pageobject.CreerCalendriePage;
import fr.eql.autom2.Libreplantest.pageobject.MasterPage;

public class CalendriersTest extends MasterTest{

	private String test1 = "Test 1";
	private String test2 = "Test 2";
	private String testCalendrierDerive = "Test Calendrier Dérivé";
	
	@Test
	public void calendrierCAL01Test() {
		// Inplicite Wait
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		MasterPage menu = PageFactory.initElements(driver, MasterPage.class);
		CalendriersPage calListePage = menu.goToCalendriersPage();
		
		// TODO : verifier les champs dans le page Creer un Calendrier
		
		// TODO : creer un calendrier
		CreerCalendriePage cal = calListePage.createCalendrie();
		
		// TODO : creer un calendrier passant
		cal.fillInNameOfCalendar(test1);
		
		
		// TODO : creer un calendrier derive (non passant)
		calListePage.createUneDerive(test1);
		cal.filleInCalendrieDeriveIncorrectly(test1);
		
		// TODO : creer un calendrier derive (passant)
		cal.filleInCalendrieDeriveCorrectly(testCalendrierDerive);
		
		// TODO : retourner de liste calendrier
		cal.clicButtonAnnuler();
		
		// TODO : verifier affichage ?? avec icon open déplie/plie liste calendriers derivés
		
		// TODO : creer une copie de calendrier (non passant)
		calListePage.createUneCopieCalendrie(test1);
		cal.createCalendrieCopyIncorrectly();
		
		// TODO : creer une copie de calendrieer (passant)
		cal.createCalendrieCopyCorrectly(test2);
		
		// TODO : verifier le calendrier Test 2 est présent
		WebElement messageTest2 = driver.findElement(By.xpath("//div[@class='message_INFO']/span[.//text()[contains(., 'Calendrier de base \"Test 2\" enregistré')]]"));
		assertEquals("verifier le calendrier Test 2 est présent", "Calendrier de base \"Test 2\" enregistré", messageTest2.getText());
		
		// TODO : supprimer les calendriers crées
		

	}
	
	// explicite wait
	public void waitGoToCreerCalendrierPage() {
		
	}
	
	public void waitGotToCalendriersPage() {
		
	}
	
	// supprimer les calendries crées pour le test
	public void deletedCalendriers() {
		
	}
}
