package fr.eql.autom2.Libreplan.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import fr.eql.autom2.Libreplantest.pageobject.CreateProfilPage;
import fr.eql.autom2.Libreplantest.pageobject.MasterPage;
import fr.eql.autom2.Libreplantest.pageobject.ProfilsPage;

public class GestionProfils extends MasterTest {
	
	String arrayName[] = {"Salim", "Mario", "Joy", "Marc"};
	String arrayRole[] = {"Super utilisateur", "Calendrier", "Cr�er des projets", "consommateur de web service"};
	String arrayRoleAfterDelete[] = {"Calendrier", "Cr�er des projets", "consommateur de web service"};
	String arrayRoleEmpty[] = {};
	int arrayNumberLinesRoleAfterDelete[] = {3, 2, 4};
	
	@Test
	public void test1() {
		// Inplicite Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		MasterPage menu = PageFactory.initElements(driver, MasterPage.class);
		ProfilsPage page = menu.goToProfilsPage();
		boolean result = page.assertTitleProfilsPage();
		assertEquals("v�rifier que le titre est affich�", true, result);
		
		// Cliquer sur le bouton "Cr�er" pour acc�der � la page de cr�ation d'un nouveau profil 
		page.clickButtonCreate(driver);
		
		// V�rification du titre de la apge et l'ajout d'un nouveau profil 
		CreateProfilPage createProfilPage = PageFactory.initElements(driver, CreateProfilPage.class);
		// Assert sur le titre de la page 
		boolean result1 = createProfilPage.assertTitleCreateProfilPage();
		assertEquals("V�rifier que le titre Cr�er profil est bien affich�", true, result1);
		
		// Creation de l'utilisateur 
		createProfilPage.addNewUserRole("C�lia", "Participants");
		
		// V�rifier qu'en passant la souris sur l'icone "Supprimer" du tableau des profils, l'infobulle affiche bien le message " Supprimer" 
		createProfilPage.AssertSurIconeSuppressionRole("Participants", 1);
		
		// Ajout de plusieurs r�les utilisateurs 
		for (int i = 0; i < arrayName.length; i++) {
			createProfilPage.addNewUserRole(arrayName[i], arrayRole[i]);
		}
		
		Set<String> setRoles = new HashSet<String>();
		for (String string : arrayRole) {
			setRoles.add(string);
		}
		// recherche 
		assertTrue("V�rifier que les noms de r�les ont bien �t� ajout� au tableau", createProfilPage.trouverLigneContenantUserRoleParNOm(setRoles));

		// Ajouter un r�le d�ja existant et v�rifier que ce dernier n'a pas �t� ajout� au tableau 
		createProfilPage.addNewUserRole("Salim", "Super utilisateur");
		assertTrue("V�rifier que le super utilisateur est pr�sent qu'une seule fois dans la liste ", createProfilPage.trouverLigneContenantUserRoleParNOm(setRoles));

		// Supprimer un r�le dans le tableau 
		Set<String> roleDelete = new HashSet<String>();
		roleDelete.add("Super utilisateur");
		createProfilPage.cliquerSurIconeSuppressionRole(roleDelete);
		
		// Cr�er une collection de Set qui contient les r�les apr�s la suppression 
		Set<String> setRolesAfterDelete = new HashSet<String>();
		for (String string : arrayRoleAfterDelete) {
			setRolesAfterDelete.add(string);
		}
		
		// V�rifier que le tableau ne contient plus la valeur " Super utilisateur" 
		assertTrue("V�rifier que le r�le a bien �t� supprim�", createProfilPage.trouverLigneContenantUserRoleParNOm(roleDelete));
	
		// Supprimer tous les r�les pr�sents sur le tableau 
		for (int i = 0; i < arrayRoleAfterDelete.length; i++) {
			createProfilPage.cliquerSurIconeSuppressionRole(roleDelete);
		}
		
		// V�rifier que les r�les supprim�s ne sont plus dans le tableau 
		assertFalse("V�rifier que les r�les supprim�s ne sont plus pr�sents dans le tableau", createProfilPage.trouverLigneContenantUserRoleDeletet(setRolesAfterDelete));
		
		// 
		
	}
}
