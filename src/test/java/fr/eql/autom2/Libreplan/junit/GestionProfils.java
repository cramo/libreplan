package fr.eql.autom2.Libreplan.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import fr.eql.autom2.Libreplantest.pageobject.CreateProfilPage;
import fr.eql.autom2.Libreplantest.pageobject.EditProfilPage;
import fr.eql.autom2.Libreplantest.pageobject.MasterPage;
import fr.eql.autom2.Libreplantest.pageobject.ProfilsPage;

public class GestionProfils extends MasterTest {
	
	String nameRole = "Salim";
	String roleNameExist = "Super utilisateur";
	String arrayRole[] = {"Super utilisateur", "Calendrier", "Créer des projets", "consommateur de web service"};
	String arrayRoleAfterDelete[] = {"Participants", "Calendrier", "Créer des projets", "consommateur de web service"};
	String arrayAllRolesExist[] = {"Super utilisateur", "Calendrier", "Créer des projets", "consommateur de web service", "Participants"};
	String arrayRoleEmptyAfterAllDelete[] = {};
	String nameRoleEdit = "Marc";
	
	MasterTest masterTest = new MasterTest();
	
	@Test
	public void test1() {
		// Inplicite Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		MasterPage menu = PageFactory.initElements(driver, MasterPage.class);
		ProfilsPage page = menu.goToProfilsPage();
		EditProfilPage editProfilPage = PageFactory.initElements(driver, EditProfilPage.class);
		boolean result = page.assertTitleProfilsPage();
		assertEquals("vérifier que le titre est affiché", true, result);
		
		// Cliquer sur le bouton "Créer" pour accéder à la page de création d'un nouveau profil 
		page.clickButtonCreate(driver);
		
		// Vérification du titre de la apge et l'ajout d'un nouveau profil 
		CreateProfilPage createProfilPage = PageFactory.initElements(driver, CreateProfilPage.class);
		// Assert sur le titre de la page 
		boolean result1 = createProfilPage.assertTitleCreateProfilPage();
		assertEquals("Vérifier que le titre Créer profil est bien affiché", true, result1);
		
		// Creation de l'utilisateur Salim avec le rôle "Participants" 
		createProfilPage.setNameUser(nameRole);
		createProfilPage.selectUserRole("Participants");
		
		// Vérifier qu'en passant la souris sur l'icone "Supprimer" du tableau des profils, l'infobulle affiche bien le message " Supprimer" 
		createProfilPage.AssertSurIconeSuppressionRole("Participants", 1);
		
		// Ajout de plusieurs rôles utilisateurs 
		for (int i = 0; i < arrayRole.length; i++) {
			createProfilPage.addNewUserRole(arrayRole[i]);
		}
		
		Set<String> setRoles = new HashSet<String>();
		for (String string : arrayAllRolesExist) {
			setRoles.add(string);
		}
		System.out.println(setRoles);
		// Recherche des résultats 
		assertTrue("Vérifier que les noms de rôles ont bien été ajouté au tableau", createProfilPage.trouverLigneContenantUserRoleParNOm(setRoles));

		// Ajouter un rôle déja existant et vérifier que ce dernier n'a pas été ajouté au tableau 
		createProfilPage.addNewUserRole(roleNameExist);
		assertTrue("Vérifier que le super utilisateur est présent qu'une seule fois dans la liste ", createProfilPage.trouverLigneContenantUserRoleParNOm(setRoles));
		
		// Avoir la liste des rôles avant la suppression 
		Set<String> rolesBeforeDelete = createProfilPage.assertAfterDelete1();
		
		// Supprimer un rôle dans le tableau 
		Set<String> roleDelete = new HashSet<String>();
		roleDelete.add("Super utilisateur");
		createProfilPage.cliquerSurIconeSuppressionRole(roleDelete);
		
		// Avoir la liste des rôles après la suppression de Super utilisateur 
		Set<String> listOfRolesAfterDeleteSuperUser = createProfilPage.assertAfterDelete1();
		
		// Comparer les deux listes 
		rolesBeforeDelete.removeAll(roleDelete);
		boolean assertSuperUserDelete = rolesBeforeDelete.size() == listOfRolesAfterDeleteSuperUser.size();
		assertTrue("Vérifier que le rôle Super utilisateur n'existe plus dans la liste des rôles", assertSuperUserDelete);
		
		
		// Avoir la liste des rôles avant la suppression 
		Set<String> rolesBeforeDelete4Roles = createProfilPage.assertAfterDelete1();
		
		// Récupérer la liste des éléments à supprimer à partir d'un tableau et on les affecte dans une collecte SET  
		Set<String> setRolesDelete = new HashSet<String>();
		for (String string : arrayRoleAfterDelete) {
			setRolesDelete.add(string);
		}
		
		// Boucle pour supprimer tous les rôles 
		for (int i = 0; i < arrayRoleAfterDelete.length; i++) {
			createProfilPage.cliquerSurIconeSuppressionRole(setRolesDelete);
		}
		
		// Avoir la liste des rôles après la suppression des 4 rôles 
		Set<String> listOfRolesAfterDelet4Roles = createProfilPage.assertAfterDelete1();
		
		// Comparer les deux listes après la suppression des 4 rôles utilisateurs 		
		rolesBeforeDelete4Roles.clear();
		boolean assertDelete4Roles = rolesBeforeDelete4Roles.size() == listOfRolesAfterDelet4Roles.size();
		assertTrue("Vérifier que les rôles supprimés ne sont plus présents dans le tableau", assertDelete4Roles);
		
		// Cliquer sur le bouton Enregistrer et Vérifier que le message de confirmation s'affiche correctement
		createProfilPage.clickButtonSave();
		ProfilsPage pageProfil = PageFactory.initElements(driver, ProfilsPage.class);
		boolean assertProfilMessage = pageProfil.assertSaveProfilMessage("Profil "+nameRole+" enregistré");
		assertTrue("Vérifier que le message de confirmation de l'enregistrement du profil s'affiche correctement", assertProfilMessage); 
		
		// Vérifier la présence du profil ajouté dans la liste des profils
		Set<String> profilsList = pageProfil.getArrayListProfils();
		boolean assertNameProfil = profilsList.contains(nameRole);
		assertTrue("Vérifier que le profil Salim est présent dans la liste des profils", assertNameProfil);
		
		// Cliquer sur l'icone de modification du profil créé et vérifier que la page " Modifier Profil: Salim" 
		Set<String> nameRoleSet = new HashSet();
		nameRoleSet.add(nameRole);
		pageProfil.cliquerSurIconeModificationProfil(nameRoleSet);
		
		// Vérifier le titre de la page : 
		boolean assertEditProfilPage = editProfilPage.assertTitleEditProfil();
		assertTrue("Vérifier que la page Modifier Profil est bien affiché", assertEditProfilPage);
		
		// Vérifier qu'aucun rôle n'est affiché dans le tableau du bloc "Association avec les rôles" 
		Set<String> listRolesEmpty = editProfilPage.getListRoles();
		boolean resultListRolesEmpty = listRolesEmpty.isEmpty();
		assertTrue("Vérifier que la liste des rôles dans le tableau est vide", resultListRolesEmpty);
		
		// Ajout de plusieurs rôles utilisateurs 
		for (int i = 0; i < arrayRole.length; i++) {
			editProfilPage.addNewUserRole(arrayRole[i]);
		}
		
		Set<String> setRolesEditProfil = new HashSet<String>();
		for (String string : arrayRole) {
			setRolesEditProfil.add(string);
		}
		System.out.println(setRoles);
		// Recherche des résultats 
		assertTrue("Vérifier que les noms de rôles ont bien été ajouté au tableau", editProfilPage.trouverLigneContenantUserRoleParNOm(setRolesEditProfil));
		
		// Modifier le champ nom du profil et cliquer sur le bouton Enregistrer 
		editProfilPage.setNameUser(nameRoleEdit);
		editProfilPage.clickButtonSave(); 
		
		// Vérifier que le message de confirmation que le nouveau nom de profil a bien été enregistré 
		boolean assertEditProfilMessage = pageProfil.assertSaveEditProfilMessage("Profil "+nameRoleEdit+" enregistré");
		assertTrue("Vérifier que le message de confirmation de l'enregistrement du profil s'affiche correctement", assertEditProfilMessage);
		
		// Vérifier la présence du profil modifié dans la liste des profils
		Set<String> profilsListAfterEdit = pageProfil.getArrayListProfils();
		boolean assertNameProfilEdit = profilsListAfterEdit.contains(nameRoleEdit);
		assertTrue("Vérifier que le profil Salim est présent dans la liste des profils", assertNameProfilEdit);
		
	}

}
