package fr.eql.autom2.Libreplan.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import fr.eql.autom2.Libreplantest.pageobject.MasterPage;
import fr.eql.autom2.Libreplantest.pageobject.AvancementTypePage;

public class CreationTypeAvancementTest extends MasterTest {

	Boolean verif;
	MasterPage menu;
	AvancementTypePage avancementTypePage;

	@Test
	public void monCreationTypeAvancementTest() throws FileNotFoundException, IOException, InterruptedException {

		// TimeOut automatique.
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


		// TODO : Etape 1 - Connexion à l'application - Profil Admin :
		System.out.println("Etape 1 - Connexion à l'application - Profil Admin :");		
		menu = PageFactory.initElements(driver, MasterPage.class);
		//assertEquals("Vérifie que l'onglet calendrier est affiché",true,menu.ongletCalendrier.isDisplayed()); (propriété non atteignable)


		// TODO : Etape 2 - Accéder à la page de gestion des types d'avancement 
		System.out.println("Etape 2 - Accéder à la page de gestion des types d'avancement ");
		// Accède à la page Type d'avencement
		avancementTypePage = menu.goToTypeDAvancementPage();	
		// Vérification la présence de la colonne Nom
		assertTrue(avancementTypePage.headNom.isDisplayed());
		// Vérification la présence de la colonne Active
		assertTrue(avancementTypePage.headActive.isDisplayed());
		// Vérification la présence de la colonne Predefini
		assertTrue(avancementTypePage.headPredefini.isDisplayed());
		// Vérification la présence de la colonne Operations
		assertTrue(avancementTypePage.headOperations.isDisplayed());	
		// Vérification la présence du bouton créer
		assertTrue(avancementTypePage.btnCreer.isDisplayed());


		// TODO : Etape 3 - Créer un type d'avancement - Accès au formulaire de création :
		System.out.println("Etape 3 - Créer un type d'avancement - Accès au formulaire de création :");	
		// vérifie si le bouton créer est visible
		assertEquals("vérifie que le bouton est affiché", true, avancementTypePage.btnCreer.isDisplayed()); 
		// clique sur le bouton Créer
		avancementTypePage.clickOnBtnCreer();

		// vérifie le titre
		assertEquals("vérifie le titre", "Modifier",avancementTypePage.lblModifierTitre.getText());
		// vérifie le Nom d'unité : champ de saisie non renseigné
		assertEquals("vérifie le champ nom unite","",avancementTypePage.txtNomUnite.getText());		
		// vérifie la Actif : case à cocher cochée par défaut
		assertEquals("vérifie la case Actif est coché", true,avancementTypePage.chkbActif.isSelected());	

		// ----- deux vérification non possible à cause du retour null des deux champs ------- //
		// vérifie la Valeur maximum par défaut : champ de saisie avec pour valeur par défaut "100,00"
		//System.out.println(avancementTypePage.txtValeurMax.getText() + valeur txtValeurMax); // renvoie null
		//assertEquals("vérifie la Valeur maximum par défaut","100,00",avancementTypePage.txtValeurMax.getText());
		// vérifie la précision
		//System.out.println(avancementTypePage.txtPrecision.getText() + "valeur txtpecision"); // valeur null
		//assertEquals("vérifie la précision","Précision",avancementTypePage.lblPrecision.getText());

		// vérifie Type : Valeur non modifiable "User"
		try {
			avancementTypePage.lblType.sendKeys("color");
		}catch(Exception e) {
			verif = false;
		}
		assertEquals("vérifie le type",false,verif);
		// Pourcentage : case à cocher décochée par défaut
		assertEquals("vérifie le pourcentage",false,avancementTypePage.chkbPourcentage.isSelected());
		// vérifier les boutons [Enregistrer], [Sauver et continuer] et [Annuler].
		assertEquals("vérifie la présences du bouton : [Enregistrer]",true,avancementTypePage.btnEnregistrer.isDisplayed());
		assertEquals("vérifie la présences du bouton : [Sauver et continuer]",true,avancementTypePage.btnSauverContinuer.isDisplayed());
		assertEquals("vérifie la présences du bouton : [Annuler]",true,avancementTypePage.btnAnnuler.isDisplayed());


		// TODO : Etape 4 - Créer un type d'avancement - sans pourcentage :
		System.out.println("Etape 4 - Créer un type d'avancement - sans pourcentage :");
		// initialise des variables
		String nomUnite = "Type avancement - Test 1";
		String valeurMax = "10,00";
		// Remplie les champs Nom Unite et Valeur Max
		avancementTypePage.fillFieldNomUniteValeurMax(nomUnite,valeurMax);
		// Clique sur le bouton enregistrer
		avancementTypePage.clickOnEnregistrer();		
		
		// Le message suivant est affiché : "Type d'avancement "Type avancement - Test 1" enregistré"
		assertEquals("vérifie le message", "Type d'avancement \"Type avancement - Test 1\" enregistré",
		avancementTypePage.lblConfirmationTest1.getText());
		// Nom : Type avancement - Test 1		
		assertEquals("vérifie le Nom","Type avancement - Test 1",avancementTypePage.lblNomTest1.getText());
		// Activé : Case décochée et non modifiable
		assertEquals("vérifie l'Activé est décochée",false,avancementTypePage.checkBoxActiveTest1.isSelected());
		assertEquals("vérifie l'Activé est non modifiable",false,avancementTypePage.checkBoxActiveTest1.isEnabled());
		// Prédéfini : Case décochée et non modifiable
		assertEquals("vérifie Prédéfini",false,avancementTypePage.checkBoxPredefiniTest1.isSelected());
		assertEquals("vérifie Prédéfini",false,avancementTypePage.checkBoxPredefiniTest1.isEnabled());
		// Opérations : colonne contenant une icône "Modifier" et "Supprimer"
		assertEquals("vérifie l'icône : Modifier",true,avancementTypePage.imgOperationsEditTest1.isDisplayed());
		assertEquals("vérifie l'icône : Supprimer",true,avancementTypePage.imgOperationsDeleteTest1.isDisplayed());


		// TODO : Etape 5 - Créer un type d'avancement - Accès au formulaire de création :
		System.out.println("Etape 5 - Créer un type d'avancement - Accès au formulaire de création :");
		// Vérifie si le bouton créer est visible
		assertEquals("vérifie que le bouton est affiché", true, avancementTypePage.btnCreer.isDisplayed());
		// Clique sur le bouton créer
		avancementTypePage.clickOnBtnCreer();


		// TODO : Etape 6 -Créer un type d'avancement - sans pourcentage (1/2) :
		System.out.println("Etape 6 - Créer un type d'avancement - sans pourcentage (1/2) :");
		// Remplie le champ Nom Unite et coche la case Pourcentage
		avancementTypePage.fillFieldNomUniteCheckPercentage("Type avancement - Test 2");
		// Vérifie que le champ Valuer Max est bien grisé
		assertFalse(avancementTypePage.txtValeurMax.isEnabled());


		// TODO : Etape 7 - Créer un type d'avancement - sans pourcentage (2/2) :
		System.out.println("Etape 7 - Créer un type d'avancement - sans pourcentage (2/2) :");
		// Clique sur le bouton Sauver et Continuer
		avancementTypePage.clickOnSauverContinuer();

		// Vérifie le message de confirmation 
		String lblMessage = "Type d'avancement \"Type avancement - Test 2\" enregistré";
		assertEquals("vérifie message de confirmation",lblMessage,avancementTypePage.lblConfirmationTest2.getText());
		// Vérifie le titre pour la modification
		String lblTitreModif = "Modifier Type d'avancement: Type avancement - Test 2";
		assertEquals("Vérifie le titre de la modification",lblTitreModif,avancementTypePage.lblTitreModif.getText());


		// TODO : Etape 8 - Retour à la page de gestion des types d'avancement :
		System.out.println("Etape 8 - Retour à la page de gestion des types d'avancement :");
		// Cliquer sur le bouton [Annuler]
		avancementTypePage.clickOnAnnuler();

		// Vérifie que nous sommes revenue sur le tableau Types d'avancement Liste
		String lblTitreType = "Types d'avancement Liste";
		assertEquals("Vérifie le titre du Type d'avancement",lblTitreType,avancementTypePage.lblTitreTypeAvance.getText());


		// TODO : Etape 9 - Conformité du type d'avancement ajouté :
		System.out.println("Etape 9 - Conformité du type d'avancement ajouté :");
		// Vérifie Nom : Type avancement - Test 2
		assertEquals("Vérifie l'élément : Nom","Type avancement - Test 2",avancementTypePage.lblTabNomTest2.getText());
		// Vérifie Activé : Case cochée et non modifiable
		assertEquals("Vérifie l'élément est coché : Activite",true,avancementTypePage.lblTabActive.isSelected());
		assertEquals("Vérifie l'élément est non modifiable : Activite",false,avancementTypePage.lblTabActive.isEnabled());
		// Prédéfini : Case décochée et non modifiable
		assertEquals("Vérifie l'élément est non coché : Predefini",false,avancementTypePage.lblTabPredefini.isSelected());
		assertEquals("Vérifie l'élément est non modifiable : Predefini",false,avancementTypePage.lblTabPredefini.isEnabled());
		//Opérations : contenant une icône "Modifier" et "Supprimer"
		assertEquals("Vérifie l'élément est présent : Activite",true,avancementTypePage.imgTabModifier.isDisplayed());
		assertEquals("Vérifie l'élément est présent : Activite",true,avancementTypePage.imgTabSuppr.isDisplayed());

		System.out.println("Fin du test");
	}

	@After
	public void fermetureDuNavigateur() throws ClassNotFoundException, SQLException {	

		// Pour la base de données
		ResultSet rs = null;
		String DRIVER = "org.postgresql.Driver";
		String JDBC_URL = "jdbc:postgresql://localhost:5432/libreplan";
		String USER = "postgres";
		String PASSWORD = "admin";
		String querySelect = "select * from advance_type";
		String queryRecupTest1 = "SELECT * FROM advance_type WHERE unit_name='Type avancement - Test 1'";
		String queryRecupTest2 = "SELECT * FROM advance_type WHERE unit_name='Type avancement - Test 2'";
		String queryDelete1 = "DELETE FROM advance_type WHERE unit_name='Type avancement - Test 1'";
		String queryDelete2 = "DELETE FROM advance_type WHERE unit_name='Type avancement - Test 2'";

		//Load Postgre jdbc driver
		Class.forName(DRIVER);

		//Create Connection to DB		
		Connection con = DriverManager.getConnection(JDBC_URL,USER,PASSWORD);
		System.out.println("Connecté à la base");

		//Create Statement Object		
		Statement stmt = con.createStatement();

		// Nettoie la base pour 'Test 1'
		try {		
			rs= stmt.executeQuery(queryRecupTest1); // Recup 'Test 1'

			if(rs != null) {
				stmt.executeQuery(queryDelete1);	// Delete 'Test 1'
				System.out.println("Test1 effacé de la base");
			}		

		}catch(Exception e) {

		}

		// Nettoie la base pour 'Test 2'
		try {			
			rs= stmt.executeQuery(queryRecupTest2); // Recup 'Test 2'

			if(rs != null) {
				stmt.executeQuery(queryDelete2);	// Delete 'Test 2'
				System.out.println("Test2 effacé de la base");
			}

		}catch(Exception e) {

		}
		rs= stmt.executeQuery(querySelect);	// Select all rows

		// While Loop to iterate through all data and print results		
		while (rs.next()){
			String id = rs.getString(1);								        
			String version = rs.getString(2);	
			String unit_name = rs.getString(3);								        
			String default_max = rs.getString(4);
			String updatable = rs.getString(5);								        
			String unit_precision = rs.getString(6);	
			String active = rs.getString(7);								        
			String percentage = rs.getString(8);
			String quality_from = rs.getString(9);								        
			String ready_only = rs.getString(10);			

			System. out.println(id+"  "+version+" "+unit_name +" "+default_max+" "+updatable+" "+unit_precision+" "+active+" "+percentage+" "+quality_from+" "+ready_only);		
		}		
		// closing DB Connection		
		con.close();
		System.out.println("déconnecté de la base");

		// Ferme toutes les fenêtres
		this.driver.quit();
	}
}
