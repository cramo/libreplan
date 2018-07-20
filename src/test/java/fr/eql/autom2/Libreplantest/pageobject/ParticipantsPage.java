package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ParticipantsPage extends MasterPage{

	@FindBy()
	private WebElement boutonCreer;
	@FindBy()
	private WebElement inputDetailsPersonnels;
	@FindBy()
	private WebElement boutonPlusDOptions;
	@FindBy()
	private WebElement boutonFiltre;
	/**
	 * dans le bloc Plus d'option
	 */
	@FindBy()
	private WebElement calPeriodeActiveDepuis;
	@FindBy()
	private WebElement calPeriodeA;
	@FindBy()
	private WebElement comboboxType;
	/**
	 * Tableau participants
	 */
	@FindBy()
	private WebElement boutonSuivant;
	@FindBy()
	private WebElement boutonPrecedant;
	@FindBy()
	private WebElement boutonJusquAuDernierPage;
	@FindBy()
	private WebElement boutonJusquAuPermierPage;
	
	
	
	public ParticipantsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
}
