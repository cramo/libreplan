package fr.eql.autom2.Libreplan.junit;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import fr.eql.autom2.Libreplantest.pageobject.CreateUnParticipantPage;
import fr.eql.autom2.Libreplantest.pageobject.MasterPage;
import fr.eql.autom2.Libreplantest.pageobject.ParticipantsPage;

public class ParticipantTest extends MasterTest{

	@Test
	public void participantsGRE01Test() {
		// Inplicite Wait
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				
		// 1 : verifier connexion
		MasterPage menu = PageFactory.initElements(driver, MasterPage.class);
		WebElement ongletCalendrier = driver.findElement(By.xpath("(//div[@class='mainmenu z-menubar-hor']/table/tbody/tr/td[1]/descendant::button)[1]"));
		assertTrue("v�rifier la connexion succ�s", ongletCalendrier.isDisplayed());
		
		// 2 : Acceder � la page Participants
		ParticipantsPage participantsPage  = menu.goToParticipantsPage();

		// Explicite wait
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement boutonCree = driver.findElement(By.xpath("(.//td[.//text()[contains(., 'Cr�er')]])[1]"));
		wait.until(ExpectedConditions.visibilityOf(boutonCree));
		assertTrue("V�rifier si les �l�ments de page Participants sont pr�sents", participantsPage.checkoutParticipantsPage());
		
		// 3 : Cr�er un participant - acc�s au formulaire de cr�ation
		CreateUnParticipantPage creerUnParticipantPage = participantsPage.createParticipant();
		WebElement boutonEnregistrer = driver.findElement(By.xpath(".//span[@class='save-button global-action z-button']/descendant::td[text()=\"Enregistrer\"]"));
		wait.until(ExpectedConditions.visibilityOf(boutonEnregistrer));
		assertTrue("V�rifier l'onglet Donn�es personnelles est pr�sent", creerUnParticipantPage.checkoutCreateParticipantPage());
		
		// TODO : Cr�er un participant - conformit� de l'onglet "Donn�es personnelles"
		
		// TODO : Cr�er un participant - bouton [Enregistrer]
		
		// TODO : Utilsation du filtre "D�tails personnels"
		
		// TODO : Filtre "Plus d'options" - conformit� des options
		
		// TODO : Navigations pages de participants ">"
		
		// TODO : Navigations pages de participants "<"
		
		// TODO : Navigations pages de participants ">|"

		// TODO : Navigations pages de participants "|<"
		
		// TODO : connexion � l'aaplication - utilisatuer cr�e
		
		
	}
}
