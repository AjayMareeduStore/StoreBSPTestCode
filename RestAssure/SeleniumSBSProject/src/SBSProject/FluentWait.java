package SBSProject;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWait {

	public FluentWait(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		
//		
//		 Wait<WebDriver> wait1 = new FluentWait(driver)
//			       .withTimeout(Duration.ofSeconds(30L))
//			       .pollingEvery(Duration.ofSeconds(5L))
//			       .ignoring(NoSuchElementException.class);
//
//			   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
//			     public WebElement apply(WebDriver driver) {
//			       
//			     if (driver.findElement(By.id("foo")) {
//			    	 
//			    	 return driver.findElement(By.id("foo")); 
//			    	 else {
//			    		 
//			    		 
//			    		 return null;
//			    	 }
//			     } });
		
		
		driver.findElement(By.xpath("//div[@class='modal-content']/div/button[2]")).click();
		driver.findElement(By.cssSelector("select.form-control")).click();
		
		

	}


	}


