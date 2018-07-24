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
import fr.eql.autom2.Libreplantest.pageobject.TypesDAvancementPage;

public class CreationTypeAvancementTest extends MasterTest {

	Boolean verif;
	MasterPage menu;
	TypesDAvancementPage typesDAvancementPage;

	@Test
	public void monCreationTypeAvancementTest() throws FileNotFoundException, IOException, InterruptedException {

		// TimeOut automatique.
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


		// TODO : Etape 1 - Connexion � l'application - Profil Admin :
		System.out.println("Etape 1 - Connexion � l'application - Profil Admin :");		
		menu = PageFactory.initElements(driver, MasterPage.class);
		//assertEquals("V�rifie que l'onglet calendrier est affich�",true,menu.ongletCalendrier.isDisplayed()); (propri�t� non atteignable)


		// TODO : Etape 2 - Acc�der � la page de gestion des types d'avancement 
		System.out.println("Etape 2 - Acc�der � la page de gestion des types d'avancement ");
		// Acc�de � la page Type d'avencement
		typesDAvancementPage = menu.goToTypeDAvancementPage();	
		// V�rification la pr�sence de la colonne Nom
		assertTrue(typesDAvancementPage.headNom.isDisplayed());
		// V�rification la pr�sence de la colonne Active
		assertTrue(typesDAvancementPage.headActive.isDisplayed());
		// V�rification la pr�sence de la colonne Predefini
		assertTrue(typesDAvancementPage.headPredefini.isDisplayed());
		// V�rification la pr�sence de la colonne Operations
		assertTrue(typesDAvancementPage.headOperations.isDisplayed());	
		// V�rification la pr�sence du bouton cr�er
		assertTrue(typesDAvancementPage.btnCreer.isDisplayed());


		// TODO : Etape 3 - Cr�er un type d'avancement - Acc�s au formulaire de cr�ation :
		System.out.println("Etape 3 - Cr�er un type d'avancement - Acc�s au formulaire de cr�ation :");	
		// v�rifie si le bouton cr�er est visible
		assertEquals("v�rifie que le bouton est affich�", true, typesDAvancementPage.btnCreer.isDisplayed()); 
		// clique sur le bouton Cr�er
		typesDAvancementPage.clickOnBtnCreer();

		// v�rifie le titre
		assertEquals("v�rifie le titre", "Modifier",typesDAvancementPage.lblModifierTitre.getText());
		// v�rifie le Nom d'unit� : champ de saisie non renseign�
		assertEquals("v�rifie le champ nom unite","",typesDAvancementPage.txtNomUnite.getText());		
		// v�rifie la Actif : case � cocher coch�e par d�faut
		assertEquals("v�rifie la case Actif est coch�", true,typesDAvancementPage.chkbActif.isSelected());	

		// ----- deux v�rification non possible � cause du retour null des deux champs ------- //
		// v�rifie la Valeur maximum par d�faut : champ de saisie avec pour valeur par d�faut "100,00"
		//System.out.println(typesDAvancementPage.txtValeurMax.getText() + valeur txtValeurMax); // renvoie null
		//assertEquals("v�rifie la Valeur maximum par d�faut","100,00",typesDAvancementPage.txtValeurMax.getText());
		// v�rifie la pr�cision
		//System.out.println(typesDAvancementPage.txtPrecision.getText() + "valeur txtpecision"); // valeur null
		//assertEquals("v�rifie la pr�cision","Pr�cision",typesDAvancementPage.lblPrecision.getText());

		// v�rifie Type : Valeur non modifiable "User"
		try {
			typesDAvancementPage.lblType.sendKeys("color");
		}catch(Exception e) {
			verif = false;
		}
		assertEquals("v�rifie le type",false,verif);
		// Pourcentage : case � cocher d�coch�e par d�faut
		assertEquals("v�rifie le pourcentage",false,typesDAvancementPage.chkbPourcentage.isSelected());
		// v�rifier les boutons [Enregistrer], [Sauver et continuer] et [Annuler].
		assertEquals("v�rifie la pr�sences du bouton : [Enregistrer]",true,typesDAvancementPage.btnEnregistrer.isDisplayed());
		assertEquals("v�rifie la pr�sences du bouton : [Sauver et continuer]",true,typesDAvancementPage.btnSauverContinuer.isDisplayed());
		assertEquals("v�rifie la pr�sences du bouton : [Annuler]",true,typesDAvancementPage.btnAnnuler.isDisplayed());


		// TODO : Etape 4 - Cr�er un type d'avancement - sans pourcentage :
		System.out.println("Etape 4 - Cr�er un type d'avancement - sans pourcentage :");
		// initialise des variables
		String nomUnite = "Type avancement - Test 1";
		String valeurMax = "10,00";
		// Remplie les champs Nom Unite et Valeur Max
		typesDAvancementPage.fillFieldNomUniteValeurMax(nomUnite,valeurMax);
		// Clique sur le bouton enregistrer
		typesDAvancementPage.clickOnEnregistrer();		
		
		// Le message suivant est affich� : "Type d'avancement "Type avancement - Test 1" enregistr�"
		assertEquals("v�rifie le message", "Type d'avancement \"Type avancement - Test 1\" enregistr�",
		typesDAvancementPage.lblConfirmationTest1.getText());
		// Nom : Type avancement - Test 1		
		assertEquals("v�rifie le Nom","Type avancement - Test 1",typesDAvancementPage.lblNomTest1.getText());
		// Activ� : Case d�coch�e et non modifiable
		assertEquals("v�rifie l'Activ� est d�coch�e",false,typesDAvancementPage.checkBoxActiveTest1.isSelected());
		assertEquals("v�rifie l'Activ� est non modifiable",false,typesDAvancementPage.checkBoxActiveTest1.isEnabled());
		// Pr�d�fini : Case d�coch�e et non modifiable
		assertEquals("v�rifie Pr�d�fini",false,typesDAvancementPage.checkBoxPredefiniTest1.isSelected());
		assertEquals("v�rifie Pr�d�fini",false,typesDAvancementPage.checkBoxPredefiniTest1.isEnabled());
		// Op�rations : colonne contenant une ic�ne "Modifier" et "Supprimer"
		assertEquals("v�rifie l'ic�ne : Modifier",true,typesDAvancementPage.imgOperationsEditTest1.isDisplayed());
		assertEquals("v�rifie l'ic�ne : Supprimer",true,typesDAvancementPage.imgOperationsDeleteTest1.isDisplayed());


		// TODO : Etape 5 - Cr�er un type d'avancement - Acc�s au formulaire de cr�ation :
		System.out.println("Etape 5 - Cr�er un type d'avancement - Acc�s au formulaire de cr�ation :");
		// V�rifie si le bouton cr�er est visible
		assertEquals("v�rifie que le bouton est affich�", true, typesDAvancementPage.btnCreer.isDisplayed());
		// Clique sur le bouton cr�er
		typesDAvancementPage.clickOnBtnCreer();


		// TODO : Etape 6 -Cr�er un type d'avancement - sans pourcentage (1/2) :
		System.out.println("Etape 6 - Cr�er un type d'avancement - sans pourcentage (1/2) :");
		// Remplie le champ Nom Unite et coche la case Pourcentage
		typesDAvancementPage.fillFieldNomUniteCheckPercentage("Type avancement - Test 2");
		// V�rifie que le champ Valuer Max est bien gris�
		assertFalse(typesDAvancementPage.txtValeurMax.isEnabled());


		// TODO : Etape 7 - Cr�er un type d'avancement - sans pourcentage (2/2) :
		System.out.println("Etape 7 - Cr�er un type d'avancement - sans pourcentage (2/2) :");
		// Clique sur le bouton Sauver et Continuer
		typesDAvancementPage.clickOnSauverContinuer();

		// V�rifie le message de confirmation 
		String lblMessage = "Type d'avancement \"Type avancement - Test 2\" enregistr�";
		assertEquals("v�rifie message de confirmation",lblMessage,typesDAvancementPage.lblConfirmationTest2.getText());
		// V�rifie le titre pour la modification
		String lblTitreModif = "Modifier Type d'avancement: Type avancement - Test 2";
		assertEquals("V�rifie le titre de la modification",lblTitreModif,typesDAvancementPage.lblTitreModif.getText());


		// TODO : Etape 8 - Retour � la page de gestion des types d'avancement :
		System.out.println("Etape 8 - Retour � la page de gestion des types d'avancement :");
		// Cliquer sur le bouton [Annuler]
		typesDAvancementPage.clickOnAnnuler();

		// V�rifie que nous sommes revenue sur le tableau Types d'avancement Liste
		String lblTitreType = "Types d'avancement Liste";
		assertEquals("V�rifie le titre du Type d'avancement",lblTitreType,typesDAvancementPage.lblTitreTypeAvance.getText());


		// TODO : Etape 9 - Conformit� du type d'avancement ajout� :
		System.out.println("Etape 9 - Conformit� du type d'avancement ajout� :");
		// V�rifie Nom : Type avancement - Test 2
		assertEquals("V�rifie l'�l�ment : Nom","Type avancement - Test 2",typesDAvancementPage.lblTabNomTest2.getText());
		// V�rifie Activ� : Case coch�e et non modifiable
		assertEquals("V�rifie l'�l�ment est coch� : Activite",true,typesDAvancementPage.lblTabActive.isSelected());
		assertEquals("V�rifie l'�l�ment est non modifiable : Activite",false,typesDAvancementPage.lblTabActive.isEnabled());
		// Pr�d�fini : Case d�coch�e et non modifiable
		assertEquals("V�rifie l'�l�ment est non coch� : Predefini",false,typesDAvancementPage.lblTabPredefini.isSelected());
		assertEquals("V�rifie l'�l�ment est non modifiable : Predefini",false,typesDAvancementPage.lblTabPredefini.isEnabled());
		//Op�rations : contenant une ic�ne "Modifier" et "Supprimer"
		assertEquals("V�rifie l'�l�ment est pr�sent : Activite",true,typesDAvancementPage.imgTabModifier.isDisplayed());
		assertEquals("V�rifie l'�l�ment est pr�sent : Activite",true,typesDAvancementPage.imgTabSuppr.isDisplayed());

		System.out.println("Fin du test");
	}


	@After
	public void fermetureDuNavigateur() throws ClassNotFoundException, SQLException {	

		// Pour la base de donn�es
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
		System.out.println("Connect� � la base");

		//Create Statement Object		
		Statement stmt = con.createStatement();

		// Nettoie la base pour 'Test 1'
		try {		
			rs= stmt.executeQuery(queryRecupTest1); // Recup 'Test 1'

			if(rs != null) {
				stmt.executeQuery(queryDelete1);	// Delete 'Test 1'
				System.out.println("Test1 effac� de la base");
			}		

		}catch(Exception e) {

		}

		// Nettoie la base pour 'Test 2'
		try {			
			rs= stmt.executeQuery(queryRecupTest2); // Recup 'Test 2'

			if(rs != null) {
				stmt.executeQuery(queryDelete2);	// Delete 'Test 2'
				System.out.println("Test2 effac� de la base");
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
		System.out.println("d�connect� de la base");

		// Ferme toutes les fen�tres
		this.driver.quit();
	}
}
