package fr.eql.autom2.Libreplan.junit;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.dbunit.DefaultPrepAndExpectedTestCase;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import fr.eql.autom2.Libreplantest.pageobject.CalendriersPage;
import fr.eql.autom2.Libreplantest.pageobject.CreateCalendriePage;
import fr.eql.autom2.Libreplantest.pageobject.MasterPage;
/**
 * 
 * @author Joy
 *
 */
public class CalendriersTest extends MasterTest{

	private String test1 = "Calendrier - Test 1";
	private String test2 = "Calendrier - Test 2";
	private String testCalendrierDerive = "Calendrier - Test Calendrier D�riv�";
	private String typeAttendu = "D�riv� du calendrier Calendrier - Test 1";
	
	
	@Test
	public void calendrierCAL01Test() {
		// Inplicite Wait
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		// 1 : v�rifier le page Calendrier
		MasterPage menu = PageFactory.initElements(driver, MasterPage.class);
		CalendriersPage calListePage = menu.goToCalendriersPage();
		WebElement ongletCalendrier = driver.findElement(By.xpath("(//div[@class='mainmenu z-menubar-hor']/table/tbody/tr/td[1]/descendant::button)[1]"));
		assertTrue("v�rifier la connexion succ�s", ongletCalendrier.isDisplayed());
		
		// Explicite Wait
		WebDriverWait waitCalPage = new WebDriverWait(driver, 5);
		WebElement buttonCreer = driver.findElement(By.xpath("(.//td[.//text()[contains(., 'Cr�er')]])[1]"));
		
		// 2 : verifier les champs dans le page Creer un Calendrier
		assertEquals("v�rifier si les header de la table de list calendrier sont correctlement pr�sents",
				true, calListePage.checkoutTableHeader());
		
		// 3 : creer un calendrier
		CreateCalendriePage cal = calListePage.createCalendrie();
		WebElement titreCreerCalendrier = driver.findElement(By.xpath("(//span[@class='z-tab-text'])[1]"));
		waitCalPage.until(ExpectedConditions.visibilityOf(titreCreerCalendrier));
		assertEquals("v�rifier l'onglet 'Donn�es de calendrier' et les 3 boutons sont pr�sents", true, cal.checkoutCreerCalendrier());
		
		// 4 : creer un calendrier passant
		cal.fillInNameOfCalendar(test1);
		WebElement textTest1 = driver.findElement(By.xpath("//div[@class='z-dottree-body']/descendant::span[.//text()[contains(., '"+test1+"')]]"));
		waitCalPage.until(ExpectedConditions.visibilityOf(buttonCreer));
		assertEquals("v�rifier si le calendrier cr�� est pr�sent dans la liste",  test1, textTest1.getText());
		
		// 5 : creer un calendrier derive (non passant)
		waitCalPage.until(ExpectedConditions.visibilityOf(buttonCreer));
		calListePage.createUneDerive(test1);
		waitCalPage.until(ExpectedConditions.visibilityOf(titreCreerCalendrier));
		cal.filleInCalendrieDeriveIncorrectly(test1);
		WebElement messageError1 = driver.findElement(By.xpath("//div[@class='message_WARNING']//span[text()[contains(., 'Test 1 existe d�j�')]]"));
		waitCalPage.until(ExpectedConditions.visibilityOf(messageError1));
		assertEquals("v�rifier si message alert est affich�", "Calendrier - Test 1 existe d�j�", messageError1.getText());
		
		// 6 : creer un calendrier derive
		cal.clicButtonAnnuler();
		calListePage.createUneDerive(test1);
		waitCalPage.until(ExpectedConditions.visibilityOf(titreCreerCalendrier));
		assertEquals("v�rifier si le champs Nom est vide et type est correct", true, cal.checkoutCreerCalendrieirDerive(typeAttendu));
		
		// 7 : creer un calendrier derive, avec bouton enregistrer et continuer(passant)
		cal.filleInCalendrieDeriveCorrectly(testCalendrierDerive);
		WebElement messageValider2 = driver.findElement(By.xpath("//div[@class='message_INFO']//span[text()[contains(., 'Test Calendrier D�riv�')]]"));
		waitCalPage.until(ExpectedConditions.visibilityOf(messageValider2));
		assertEquals("v�rifier si le message Info \"Calendrier de base \"Calendrier - Test Calendrier D�riv�\" enregistr�\"  est affich�"
				,"Calendrier de base \"Calendrier - Test Calendrier D�riv�\" enregistr�", messageValider2.getText());
		
		// 8 : retourner de liste calendrier
		cal.clicButtonAnnuler();
		WebElement calendrierDerive = driver.findElement(By.xpath("//div[@class='z-dottree-body']/descendant::span[.//text()[contains(., '"+testCalendrierDerive+"')]]"));
		assertEquals("v�rifier si le calendrier d�riv� est bien afficher dans la liste de calendriers"
				 		, testCalendrierDerive, calendrierDerive.getText());
		// 9 : verifier affichage ?? avec icon open d�plie/plie liste calendriers deriv�s
		WebElement boutonOuvert = driver.findElement(By.xpath("//div[@class='z-dottree-body']/descendant::span[.//text()[contains(., '"+test1+"')]]/preceding-sibling::span[1]"));
		boutonOuvert.click();
		assertFalse("v�rifier si 'Calendrier - Test Calendrier D�riv�' est masqu�", calendrierDerive.isDisplayed());
		
		// 10 : creer une copie de calendrier
		calListePage.createUneCopieCalendrie(test1);
		waitCalPage.until(ExpectedConditions.visibilityOf(titreCreerCalendrier));
//		assertTrue("v�rifier l'affichage de copie de calendrier Test 1", cal.checkoutCreerCopieCalendrier(test1, "Calendrier source"));
		
		
		// 11 : creer une copie de calendrier (non passant)
		cal.createCalendrieCopyIncorrectly();
		WebElement messageError2 = driver.findElement(By.xpath("//div[@class='message_WARNING']//span[text()[contains(., 'Test 1 existe d�j�')]]"));
		waitCalPage.until(ExpectedConditions.visibilityOf(messageError2));
		assertEquals("v�rifier si message alert est affich�", "Calendrier - Test 1 existe d�j�", messageError2.getText());
		
		// 12 : creer une copie de calendrieer (passant)
		cal.createCalendrieCopyCorrectly(test2);
		waitCalPage.until(ExpectedConditions.visibilityOf(buttonCreer));
		
		// verifier le calendrier Test 2 est pr�sent
		WebElement messageTest2 = driver.findElement(By.xpath("//div[@class='message_INFO']/span[.//text()[contains(., '"+test2+"')]]"));
		assertEquals("verifier le calendrier Test 2 est pr�sent", "Calendrier de base \""+ test2 + "\" enregistr�", messageTest2.getText());
	}
	
	public void deleteDonnees() {
		WebElement popup = driver.findElement(By.xpath("//div[@class='z-window-modal z-window-modal-shadow']"));
		WebElement boutonOk = driver.findElement(By.xpath("//div[@class='z-window-modal z-window-modal-shadow']//td[text()[contains(., 'OK')]]"));
		Actions sup = new Actions(driver);
		sup.moveToElement(popup)
				.moveToElement(boutonOk)
				.click()
				.build()
				.perform();
	}
	
	@After
	// supprimer les calendries cr�es pour le test
	public void deletedCalendriers() {
		// supprimer Calendrier - Test 2
		WebElement deleteTest2 = driver.findElement(By.xpath("(.//span[.//text()[contains(., '"+test2+"')]]/../../following-sibling::td[3]/descendant::td[.//img])[4]"));
		deleteTest2.click();
		this.deleteDonnees();
		// supprimer Calendrier - Calendrier Test D�riv�
		driver.navigate().refresh();
		WebElement deleteTestDerive = driver.findElement(By.xpath("(.//span[.//text()[contains(., '"+testCalendrierDerive+"')]]/../../following-sibling::td[3]/descendant::td[.//img])[4]"));
		deleteTestDerive.click();
		this.deleteDonnees();
		// supprimer Calendrier - Test 1
		driver.navigate().refresh();
		WebElement deleteTest1 = driver.findElement(By.xpath("(.//span[.//text()[contains(., '"+test1+"')]]/../../following-sibling::td[3]/descendant::td[.//img])[4]"));
		deleteTest1.click();
		this.deleteDonnees();
		driver.close();
	}
}
