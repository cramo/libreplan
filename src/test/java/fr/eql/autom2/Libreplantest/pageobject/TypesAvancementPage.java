package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TypesAvancementPage extends MasterPage{
	
	@FindBy(how = How.XPATH, using="//td[contains(text(),\"Creer\")]")
	private WebElement btnCreer;

	public TypesAvancementPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	
}
