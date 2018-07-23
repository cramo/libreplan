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
	String arrayRole[] = {"Super utilisateur", "Calendrier", "Créer des projets", "consommateur de web service"};
	String arrayRoleAfterDelete[] = {"Calendrier", "Créer des projets", "consommateur de web service"};
	String arrayRoleEmpty[] = {};
	int arrayNumberLinesRoleAfterDelete[] = {3, 2, 4};
	
	@Test
	public void test1() {
		// Inplicite Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		MasterPage menu = PageFactory.initElements(driver, MasterPage.class);
		ProfilsPage page = menu.goToProfilsPage();
		boolean result = page.assertTitleProfilsPage();
		assertEquals("vérifier que le titre est affiché", true, result);
		
		// Cliquer sur le bouton "Créer" pour accéder à la page de création d'un nouveau profil 
		page.clickButtonCreate(driver);
		
		// Vérification du titre de la apge et l'ajout d'un nouveau profil 
		CreateProfilPage createProfilPage = PageFactory.initElements(driver, CreateProfilPage.class);
		// Assert sur le titre de la page 
		boolean result1 = createProfilPage.assertTitleCreateProfilPage();
		assertEquals("Vérifier que le titre Créer profil est bien affiché", true, result1);
		
		// Creation de l'utilisateur 
		createProfilPage.addNewUserRole("Célia", "Participants");
		
		// Vérifier qu'en passant la souris sur l'icone "Supprimer" du tableau des profils, l'infobulle affiche bien le message " Supprimer" 
		createProfilPage.AssertSurIconeSuppressionRole("Participants", 1);
		
		// Ajout de plusieurs rôles utilisateurs 
		for (int i = 0; i < arrayName.length; i++) {
			createProfilPage.addNewUserRole(arrayName[i], arrayRole[i]);
		}
		
		Set<String> setRoles = new HashSet<String>();
		for (String string : arrayRole) {
			setRoles.add(string);
		}
		// recherche 
		assertTrue("Vérifier que les noms de rôles ont bien été ajouté au tableau", createProfilPage.trouverLigneContenantUserRoleParNOm(setRoles));

		// Ajouter un rôle déja existant et vérifier que ce dernier n'a pas été ajouté au tableau 
		createProfilPage.addNewUserRole("Salim", "Super utilisateur");
		assertTrue("Vérifier que le super utilisateur est présent qu'une seule fois dans la liste ", createProfilPage.trouverLigneContenantUserRoleParNOm(setRoles));

		// Supprimer un rôle dans le tableau 
		Set<String> roleDelete = new HashSet<String>();
		roleDelete.add("Super utilisateur");
		createProfilPage.cliquerSurIconeSuppressionRole(roleDelete);
		
		// Créer une collection de Set qui contient les rôles après la suppression 
		Set<String> setRolesAfterDelete = new HashSet<String>();
		for (String string : arrayRoleAfterDelete) {
			setRolesAfterDelete.add(string);
		}
		
		// Vérifier que le tableau ne contient plus la valeur " Super utilisateur" 
		assertTrue("Vérifier que le rôle a bien été supprimé", createProfilPage.trouverLigneContenantUserRoleParNOm(roleDelete));
	
		// Supprimer tous les rôles présents sur le tableau 
		for (int i = 0; i < arrayRoleAfterDelete.length; i++) {
			createProfilPage.cliquerSurIconeSuppressionRole(roleDelete);
		}
		
		// Vérifier que les rôles supprimés ne sont plus dans le tableau 
		assertFalse("Vérifier que les rôles supprimés ne sont plus présents dans le tableau", createProfilPage.trouverLigneContenantUserRoleDeletet(setRolesAfterDelete));
		
		// 
		
	}
}
