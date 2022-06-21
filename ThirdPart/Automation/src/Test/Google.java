package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Classes.GoogleHome;



public class Google {

	
WebDriver driver;
private static String PAGE_URL="https://www.google.com/";
GoogleHome homepage;

	
@BeforeClass
public void setup()
	{
	System.setProperty("webdriver.chrome.driver", "src/Drivers/chromedriver2.exe");
	//System.setProperty("webdriver.chrome.driver", "C:\\bin\\chromedriver.exe");

	ChromeOptions options = new ChromeOptions();
	options.addArguments("start-maximized");
	options.addArguments("--lang=en-GB");
	driver = new ChromeDriver(options);
	driver.get(PAGE_URL);
	homepage=new GoogleHome(driver);
	
	}

@AfterClass 
public void close()

	{
		
		driver.close();
	}


@Test(priority=1)
public void TestCase1()
{
	
	homepage.userEnterText("facebook");
	homepage.userClickSearch();
	Assert.assertEquals("https://www.facebook.com/", homepage.getText());
	driver.navigate().back();
}


@Test(priority=2)
public void TestCase2()
{
	
	homepage.userEnterText("/**/-+/*-");
	homepage.userClickSearch();
	Assert.assertEquals("Suggestions:", homepage.getText1());
	driver.navigate().back();
}

@Test(priority=3)
public void TestCase3()
{
	
	homepage.userEnterText("");
	homepage.userClickSearch();
	Assert.assertEquals("https://www.google.com/", driver.getCurrentUrl());
	driver.navigate().back();
}




}
