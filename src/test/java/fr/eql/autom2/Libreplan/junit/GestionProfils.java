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
	String arrayRole[] = {"Super utilisateur", "Calendrier", "Cr�er des projets", "consommateur de web service"};
	String arrayRoleAfterDelete[] = {"Participants", "Calendrier", "Cr�er des projets", "consommateur de web service"};
	String arrayAllRolesExist[] = {"Super utilisateur", "Calendrier", "Cr�er des projets", "consommateur de web service", "Participants"};
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
		assertEquals("v�rifier que le titre est affich�", true, result);
		
		// Cliquer sur le bouton "Cr�er" pour acc�der � la page de cr�ation d'un nouveau profil 
		page.clickButtonCreate(driver);
		
		// V�rification du titre de la apge et l'ajout d'un nouveau profil 
		CreateProfilPage createProfilPage = PageFactory.initElements(driver, CreateProfilPage.class);
		// Assert sur le titre de la page 
		boolean result1 = createProfilPage.assertTitleCreateProfilPage();
		assertEquals("V�rifier que le titre Cr�er profil est bien affich�", true, result1);
		
		// Creation de l'utilisateur Salim avec le r�le "Participants" 
		createProfilPage.setNameUser(nameRole);
		createProfilPage.selectUserRole("Participants");
		
		// V�rifier qu'en passant la souris sur l'icone "Supprimer" du tableau des profils, l'infobulle affiche bien le message " Supprimer" 
		createProfilPage.AssertSurIconeSuppressionRole("Participants", 1);
		
		// Ajout de plusieurs r�les utilisateurs 
		for (int i = 0; i < arrayRole.length; i++) {
			createProfilPage.addNewUserRole(arrayRole[i]);
		}
		
		Set<String> setRoles = new HashSet<String>();
		for (String string : arrayAllRolesExist) {
			setRoles.add(string);
		}
		System.out.println(setRoles);
		// Recherche des r�sultats 
		assertTrue("V�rifier que les noms de r�les ont bien �t� ajout� au tableau", createProfilPage.trouverLigneContenantUserRoleParNOm(setRoles));

		// Ajouter un r�le d�ja existant et v�rifier que ce dernier n'a pas �t� ajout� au tableau 
		createProfilPage.addNewUserRole(roleNameExist);
		assertTrue("V�rifier que le super utilisateur est pr�sent qu'une seule fois dans la liste ", createProfilPage.trouverLigneContenantUserRoleParNOm(setRoles));
		
		// Avoir la liste des r�les avant la suppression 
		Set<String> rolesBeforeDelete = createProfilPage.assertAfterDelete1();
		
		// Supprimer un r�le dans le tableau 
		Set<String> roleDelete = new HashSet<String>();
		roleDelete.add("Super utilisateur");
		createProfilPage.cliquerSurIconeSuppressionRole(roleDelete);
		
		// Avoir la liste des r�les apr�s la suppression de Super utilisateur 
		Set<String> listOfRolesAfterDeleteSuperUser = createProfilPage.assertAfterDelete1();
		
		// Comparer les deux listes 
		rolesBeforeDelete.removeAll(roleDelete);
		boolean assertSuperUserDelete = rolesBeforeDelete.size() == listOfRolesAfterDeleteSuperUser.size();
		assertTrue("V�rifier que le r�le Super utilisateur n'existe plus dans la liste des r�les", assertSuperUserDelete);
		
		
		// Avoir la liste des r�les avant la suppression 
		Set<String> rolesBeforeDelete4Roles = createProfilPage.assertAfterDelete1();
		
		// R�cup�rer la liste des �l�ments � supprimer � partir d'un tableau et on les affecte dans une collecte SET  
		Set<String> setRolesDelete = new HashSet<String>();
		for (String string : arrayRoleAfterDelete) {
			setRolesDelete.add(string);
		}
		
		// Boucle pour supprimer tous les r�les 
		for (int i = 0; i < arrayRoleAfterDelete.length; i++) {
			createProfilPage.cliquerSurIconeSuppressionRole(setRolesDelete);
		}
		
		// Avoir la liste des r�les apr�s la suppression des 4 r�les 
		Set<String> listOfRolesAfterDelet4Roles = createProfilPage.assertAfterDelete1();
		
		// Comparer les deux listes apr�s la suppression des 4 r�les utilisateurs 		
		rolesBeforeDelete4Roles.clear();
		boolean assertDelete4Roles = rolesBeforeDelete4Roles.size() == listOfRolesAfterDelet4Roles.size();
		assertTrue("V�rifier que les r�les supprim�s ne sont plus pr�sents dans le tableau", assertDelete4Roles);
		
		// Cliquer sur le bouton Enregistrer et V�rifier que le message de confirmation s'affiche correctement
		createProfilPage.clickButtonSave();
		ProfilsPage pageProfil = PageFactory.initElements(driver, ProfilsPage.class);
		boolean assertProfilMessage = pageProfil.assertSaveProfilMessage("Profil "+nameRole+" enregistr�");
		assertTrue("V�rifier que le message de confirmation de l'enregistrement du profil s'affiche correctement", assertProfilMessage); 
		
		// V�rifier la pr�sence du profil ajout� dans la liste des profils
		Set<String> profilsList = pageProfil.getArrayListProfils();
		boolean assertNameProfil = profilsList.contains(nameRole);
		assertTrue("V�rifier que le profil Salim est pr�sent dans la liste des profils", assertNameProfil);
		
		// Cliquer sur l'icone de modification du profil cr�� et v�rifier que la page " Modifier Profil: Salim" 
		Set<String> nameRoleSet = new HashSet();
		nameRoleSet.add(nameRole);
		pageProfil.cliquerSurIconeModificationProfil(nameRoleSet);
		
		// V�rifier le titre de la page : 
		boolean assertEditProfilPage = editProfilPage.assertTitleEditProfil();
		assertTrue("V�rifier que la page Modifier Profil est bien affich�", assertEditProfilPage);
		
		// V�rifier qu'aucun r�le n'est affich� dans le tableau du bloc "Association avec les r�les" 
		Set<String> listRolesEmpty = editProfilPage.getListRoles();
		boolean resultListRolesEmpty = listRolesEmpty.isEmpty();
		assertTrue("V�rifier que la liste des r�les dans le tableau est vide", resultListRolesEmpty);
		
		// Ajout de plusieurs r�les utilisateurs 
		for (int i = 0; i < arrayRole.length; i++) {
			editProfilPage.addNewUserRole(arrayRole[i]);
		}
		
		Set<String> setRolesEditProfil = new HashSet<String>();
		for (String string : arrayRole) {
			setRolesEditProfil.add(string);
		}
		System.out.println(setRoles);
		// Recherche des r�sultats 
		assertTrue("V�rifier que les noms de r�les ont bien �t� ajout� au tableau", editProfilPage.trouverLigneContenantUserRoleParNOm(setRolesEditProfil));
		
		// Modifier le champ nom du profil et cliquer sur le bouton Enregistrer 
		editProfilPage.setNameUser(nameRoleEdit);
		editProfilPage.clickButtonSave(); 
		
		// V�rifier que le message de confirmation que le nouveau nom de profil a bien �t� enregistr� 
		boolean assertEditProfilMessage = pageProfil.assertSaveEditProfilMessage("Profil "+nameRoleEdit+" enregistr�");
		assertTrue("V�rifier que le message de confirmation de l'enregistrement du profil s'affiche correctement", assertEditProfilMessage);
		
		// V�rifier la pr�sence du profil modifi� dans la liste des profils
		Set<String> profilsListAfterEdit = pageProfil.getArrayListProfils();
		boolean assertNameProfilEdit = profilsListAfterEdit.contains(nameRoleEdit);
		assertTrue("V�rifier que le profil Salim est pr�sent dans la liste des profils", assertNameProfilEdit);
		
	}

}
