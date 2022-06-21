package Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleHome {

	

	protected WebDriver driver;

	private By searchBar = By.name("q");
	
	private By GoogleSearch = By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[3]/center[1]/input[1]");
	
	private By firstLink = By.xpath("//body/div[@id='main']/div[@id='cnt']/div[@id='rcnt']/div[@id='center_col']/div[@id='res']/div[@id='search']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]");

	private By invalidText = By.xpath("//p[contains(text(),'Suggestions:')]");


	protected WebDriverWait wait;


	public GoogleHome(WebDriver driver)
	{
	 this.driver = driver;
	 wait=new WebDriverWait(driver, 15);
	PageFactory.initElements(driver, this);
	}
		
	public void userEnterText(String Text)
		{
			 wait.until(ExpectedConditions.visibilityOfElementLocated((searchBar)));	
			 driver.findElement(searchBar).sendKeys(Text);
		}
	
	
	public void userClickSearch()
	{
		 wait.until(ExpectedConditions.elementToBeClickable((GoogleSearch)));	
		 driver.findElement(GoogleSearch).click();
	}
	
	
	public String getText()
	{
		 wait.until(ExpectedConditions.visibilityOfElementLocated((firstLink)));	
		 return driver.findElement(firstLink).getAttribute("href");
	}
	
	
	

	public String getText1()
	{
		 wait.until(ExpectedConditions.visibilityOfElementLocated((invalidText)));	
		 return driver.findElement(invalidText).getText();
	}
	
	
}
