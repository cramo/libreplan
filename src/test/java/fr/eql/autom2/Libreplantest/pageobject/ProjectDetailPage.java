package fr.eql.autom2.Libreplantest.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectDetailPage extends MasterPage {

	private final String tableProjectDetailXPath = "//*[substring(@id, string-length(@id) - string-length('h4-box') +1) = 'h4-box']/tbody/tr[2]/td[2]";//h4-box demo 34-box
	@FindBy(xpath = tableProjectDetailXPath)
	private WebElement tableProjectDetail;

	private final String spanMenuWBSXPath = "//*[substring(@id, string-length(@id) - string-length('-hm') +1) = '-hm']/span[.=\"WBS (tâches)\"]";//-hm demo -hm
	@FindBy(xpath = spanMenuWBSXPath)
	private WebElement spanMenuWBS;

	private final String tableDashboardXPath = "//tr[21]/td/span/table/tbody/tr[2]/td[2]";
	@FindBy(xpath = tableDashboardXPath)
	private WebElement tableDashboard;

	private final String btnSaveXPath = "//span[@title=\"Enregistrer le projet\"]";
	@FindBy(xpath = btnSaveXPath)
	private WebElement btnSave;

	private final String btnSaveImageXPath = "//span[@title=\"Enregistrer le projet\"]/table/tbody/tr/td/img";
	@FindBy(xpath = btnSaveImageXPath)
	private WebElement btnSaveImage;

	private final String btnCancelXPATH = "//span[@title=\"Annuler l'édition\"]";
	@FindBy(xpath = btnCancelXPATH)
	private WebElement btnCancel;

	private final String btnCancelImageXPath = "//span[@title=\"Annuler l'édition\"]/table/tbody/tr/td/img";
	@FindBy(xpath = btnCancelImageXPath)
	private WebElement btnCancelImage;
	
	private final String divConfirmCancelXPath = "//div[@class=\"z-window-modal-hm\"]/div";////div[@class="z-window-modal-header z-window-modal-header-move"]/div demo //div[@class=\"z-window-modal-hm\"]/div
	@FindBy(xpath = divConfirmCancelXPath)
	private WebElement divConfirmCancel;
	
	private final String divConfirmCancelXPathBis = "//div[@class=\"z-window-modal-hm\"]/div/text()";
	@FindBy(xpath = divConfirmCancelXPath)
	private WebElement divConfirmCancelBis;

	private final String divTextCancelXPath = "//div[@class=\"z-window-modal-cl\"]//*[contains(text(),'Les modifications non enregistrées seront perdues. Êtes-vous sûr ?')]";
	@FindBy(xpath = divTextCancelXPath)
	private WebElement divTextCancel;
	
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
