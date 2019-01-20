package com.classplusapp.classplus;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class ClassPlus {
	
	static WebDriver driver;

	@BeforeTest
	public void setUp () throws InterruptedException
	 {
	
		 System.setProperty("webdriver.chrome.driver", "/Users/Koushik/Desktop/chromedriver");	 
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://classplusapp.com");
		Thread.sleep(1000);
		//driver.findElement(By.("btn btn-lg btn-danger btn-block nomargin")).click();
        
	
	 }	
	
	@Test
	
	public static void homePage()
	{
		
	//driver.findElement(By.xpath("//h1[@class='font-body']"));
		
	String a=	driver.findElement(By.xpath("//h1[@class='customFont']")).getText();
	
	System.out.println(a);
		String b= "A Single Portal for all your Activities";	
	assertEquals(a,b);
	}
	
	@Test
	
	public void titleVerify()
	
	{
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	@Test
	
	public static void productPage() throws InterruptedException
	
	{
		
		driver.findElement(By.xpath("//ul[@class='one-page-menu sf-js-enabled']//li//a[@href='product.html']")).click();
	Thread.sleep(3000);
	WebElement ImageFile = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/img[1]"));

    Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
    if (!ImagePresent)
    {
         System.out.println("Image not displayed.");
    }
    else
    {
        System.out.println("Image displayed.");
    }
}
	
	@AfterTest
	
	public void closeBrowser()
	{
		driver.close();
	}
	
}







