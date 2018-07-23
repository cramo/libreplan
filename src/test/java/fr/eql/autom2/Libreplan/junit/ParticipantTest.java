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
		assertTrue("vérifier la connexion succès", ongletCalendrier.isDisplayed());
		
		// 2 : Acceder à la page Participants
		ParticipantsPage participantsPage  = menu.goToParticipantsPage();

		// Explicite wait
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement boutonCree = driver.findElement(By.xpath("(.//td[.//text()[contains(., 'Créer')]])[1]"));
		wait.until(ExpectedConditions.visibilityOf(boutonCree));
		assertTrue("Vérifier si les éléments de page Participants sont présents", participantsPage.checkoutParticipantsPage());
		
		// 3 : Créer un participant - accès au formulaire de création
		CreateUnParticipantPage creerUnParticipantPage = participantsPage.createParticipant();
		WebElement boutonEnregistrer = driver.findElement(By.xpath(".//span[@class='save-button global-action z-button']/descendant::td[text()=\"Enregistrer\"]"));
		wait.until(ExpectedConditions.visibilityOf(boutonEnregistrer));
		assertTrue("Vérifier l'onglet Données personnelles est présent", creerUnParticipantPage.checkoutCreateParticipantPage());
		
		// TODO : Créer un participant - conformité de l'onglet "Données personnelles"
		
		// TODO : Créer un participant - bouton [Enregistrer]
		
		// TODO : Utilsation du filtre "Détails personnels"
		
		// TODO : Filtre "Plus d'options" - conformité des options
		
		// TODO : Navigations pages de participants ">"
		
		// TODO : Navigations pages de participants "<"
		
		// TODO : Navigations pages de participants ">|"

		// TODO : Navigations pages de participants "|<"
		
		// TODO : connexion à l'aaplication - utilisatuer crée
		
		
	}
}
