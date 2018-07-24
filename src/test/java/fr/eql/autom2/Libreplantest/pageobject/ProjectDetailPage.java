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
	
	//div[@class=\"z-window-modal-header z-window-modal-header-move\"]
	//*[@id="n38Vf4-cap"]
	//div[@class="z-window-modal-hm"]/div/div
	private final String divConfirmCancelXPath = "//div[@class=\"z-window-modal-hm\"]/div";////div[@class="z-window-modal-header z-window-modal-header-move"]/div demo //div[@class=\"z-window-modal-hm\"]/div
	@FindBy(xpath = divConfirmCancelXPath)
	private WebElement divConfirmCancel;
	
	private final String divConfirmCancelXPathBis = "//div[@class=\"z-window-modal-hm\"]/div/text()";
	@FindBy(xpath = divConfirmCancelXPath)
	private WebElement divConfirmCancelBis;

	private final String divTextCancelXPath = "//div[@class=\"z-window-modal-cl\"]//*[contains(text(),'Les modifications non enregistrées seront perdues. Êtes-vous sûr ?')]";
	@FindBy(xpath = divTextCancelXPath)
	private WebElement divTextCancel;
	
	//*[@id="uANTn4-box"]/tbody/tr[2]
	private final String btnConfirmOkXPath = "//div[@class=\"z-window-modal-cl\"]//*[contains(text(),'OK')]";
	@FindBy(xpath = btnConfirmOkXPath)
	private WebElement btnConfirmOk;
	
	private final String btnConfirmCancelXPath = "//div[@class=\"z-window-modal-cl\"]//*[contains(text(),'Annuler')]";
	@FindBy(xpath = btnConfirmCancelXPath)
	private WebElement btnConfirmCancel;
	
	public WebElement getDivConfirmCancelBis() {
		return divConfirmCancelBis;
	}
	
	public String getDivConfirmCancelXPathBis() {
		return divConfirmCancelXPathBis;
	}

	public WebElement getBtnConfirmCancel() {
		return btnConfirmCancel;
	}
	
	public String getBtnSaveXPath() {
		return btnSaveXPath;
	}

	public String getDivTextCancelXPath() {
		return divTextCancelXPath;
	}

	public WebElement getDivTextCancel() {
		return divTextCancel;
	}

	public String getBtnConfirmOkXPath() {
		return btnConfirmOkXPath;
	}

	public WebElement getBtnConfirmOk() {
		return btnConfirmOk;
	}

	public String getBtnConfirmCancelXPath() {
		return btnConfirmCancelXPath;
	}

	public WebElement getbtnConfirmCancel() {
		return btnConfirmCancel;
	}

	public String getBtnSaveImageXPath() {
		return btnSaveImageXPath;
	}

	public String getBtnCancelImageXPath() {
		return btnCancelImageXPath;
	}

	public String getDivConfirmCancelXPath() {
		return divConfirmCancelXPath;
	}

	public WebElement getDivConfirmCancel() {
		return divConfirmCancel;
	}

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
