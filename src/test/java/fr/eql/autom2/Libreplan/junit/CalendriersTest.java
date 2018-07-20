package fr.eql.autom2.Libreplan.junit;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import fr.eql.autom2.Libreplantest.pageobject.CalendriersPage;
import fr.eql.autom2.Libreplantest.pageobject.MasterPage;

public class CalendriersTest extends MasterTest{

	@Test
	public void calendrierCAL01Test() {
		// Inplicite Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		MasterPage menu = PageFactory.initElements(driver, MasterPage.class);
		CalendriersPage calListePage = menu.goToCalendriersPage();
		

	}
}
