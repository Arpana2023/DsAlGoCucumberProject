package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GraphPageLocators 
{

	// graphpageLocators
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Graph']") public WebElement graphLink;
	@FindBy(xpath = "//a[normalize-space()='Graph Representations']") public WebElement graphRepresentationslink;
	@FindBy(xpath = "//a[@class='btn btn-info']")public WebElement GraphTryherelink;
	@FindBy(xpath = "//a[@class='list-group-item list-group-item-light text-info']") public WebElement GraphPracQuesLink;
	@FindBy(xpath = "//textarea[@tabindex='0']") public WebElement editorInput;
	@FindBy(xpath = "//button[@type='button']") public WebElement runButton;
	@FindBy(id = "output")WebElement output;

}
