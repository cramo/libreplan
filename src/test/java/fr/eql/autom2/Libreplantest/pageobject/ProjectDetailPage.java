package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectDetailPage extends MasterPage {

	// *[@id="tT7P34-box"]/tbody/tr[2]/td[2]
	// *[@id="cQ4Q34-box"]/tbody/tr[2]/td[2]
	private final String tableProjectDetailXPath = "//*[substring(@id, string-length(@id) - string-length('34-box') +1) = '34-box']/tbody/tr[2]/td[2]";//h4-box demo 34-box
	@FindBy(xpath = tableProjectDetailXPath)
	private WebElement tableProjectDetail;

	// *[@id="aS6Qfs-hm"]/span
	private final String spanMenuWBSXPath = "//*[substring(@id, string-length(@id) - string-length('-hm') +1) = '-hm']/span[.=\"WBS (tâches)\"]";//-hm demo -hm
	@FindBy(xpath = spanMenuWBSXPath)
	private WebElement spanMenuWBS;

	// *[@id="h5qDb4-box"]/tbody/tr[2]/td[2]
	private final String tableDashboardXPath = "//tr[21]/td/span/table/tbody/tr[2]/td[2]";
	@FindBy(xpath = tableDashboardXPath)
	private WebElement tableDashboard;

	// *[@id="r43Sdo0-box"]/tbody/tr[2]/td[2]/img
	// *[@id="xF6Uro0-box"]/tbody/tr[2]/td[2]/img

	// *[@id="xF6Uro0"]
	// *[substring(@id, string-length(@id) - string-length('o0') +1) =
	// 'o0']/../span[@title=\"Enregistrer le projet\"]
	private final String btnSaveXPath = "//span[@title=\"Enregistrer le projet\"]";
	@FindBy(xpath = btnSaveXPath)
	private WebElement btnSave;

	// span[@title="Enregistrer le projet"]/table/tbody/tr/td/img
	// *[@id="xF6Uso0"]
	private final String btnSaveImageXPath = "//span[@title=\"Enregistrer le projet\"]/table/tbody/tr/td/img";
	@FindBy(xpath = btnSaveImageXPath)
	private WebElement btnSaveImage;

	// *[@id="xF6Uso0"]
	private final String btnCancelXPATH = "//span[@title=\"Annuler l'édition\"]";
	@FindBy(xpath = btnCancelXPATH)
	private WebElement btnCancel;

	// span[@title="Enregistrer le projet"]/table/tbody/tr/td/img
	// *[@id="xF6Uso0"]
	private final String btnCancelImageXPath = "//span[@title=\"Annuler l'édition\"]/table/tbody/tr/td/img";
	@FindBy(xpath = btnCancelImageXPath)
	private WebElement btnCancelImage;
	
	public String getBtnSaveXPATH() {
		return btnSaveXPath;
	}

	public String getBtnSaveImageXPATH() {
		return btnSaveImageXPath;
	}

	public WebElement getBtnSaveImage() {
		return btnSaveImage;
	}

	public String getBtnCancelXPATH() {
		return btnCancelXPATH;
	}

	public String getBtnCancelImageXPATH() {
		return btnCancelImageXPath;
	}

	public WebElement getBtnCancelImage() {
		return btnCancelImage;
	}

	public WebElement getBtnSave() {
		return btnSave;
	}

	public String getTableDashboardXPath() {
		return tableDashboardXPath;
	}

	public WebElement getTableDashboard() {
		return tableDashboard;
	}

	public ProjectDetailPage(WebDriver driver) {
		super(driver);
	}

	public String getTableProjectDetailXPath() {
		return tableProjectDetailXPath;
	}

	public WebElement getTableProjectDetail() {
		return tableProjectDetail;
	}

	public String getSpanMenuWBSXPath() {
		return spanMenuWBSXPath;
	}

	public WebElement getSpanMenuWBS() {
		return spanMenuWBS;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}

}
