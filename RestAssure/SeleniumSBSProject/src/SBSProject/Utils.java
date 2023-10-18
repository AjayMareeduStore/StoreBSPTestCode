package SBSProject;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Utils {
	
	
	WebDriver driver = new EdgeDriver() ;
	Random randomGenerator = new Random();  
	int randomInt = randomGenerator.nextInt(1000);
public void RegistrationProcess() throws InterruptedException {


	driver.manage().deleteAllCookies();
	driver.get("https://www.shutterflyforbusiness.com/loginto");
	driver.manage().window().maximize();
	String CurrentpageURl =driver.getCurrentUrl();
	System.out.println(CurrentpageURl);
	if(CurrentpageURl.equalsIgnoreCase("https://www.shutterflyforbusiness.com/ldap-login?next=%2Floginto")) {
		driver.findElement(By.xpath("//input[@id='EmailAddress']")).sendKeys("ajay.mareedu");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Ajay@123");
		driver.findElement(By.xpath("//a[@name='log in']")).click();
       driver.findElement(By.linkText("Sign Up")).click();
	
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("StoreAutomation"+ randomInt +"@yopmail.com");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("ajay@123");
	driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Store");
	driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Automation");
	driver.findElement(By.xpath("//input[@id='tncflag']")).submit();
	
	}else if(CurrentpageURl.equalsIgnoreCase("https://www.shutterflyforbusiness.com/loginto"))
	{
		try {
		 driver.findElement(By.linkText("Sign Up")).click();
			Random randomGenerator = new Random();  
			int randomInt = randomGenerator.nextInt(1000);
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("StoreAutomation"+ randomInt +"@yopmail.com");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("ajay@123");
			driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Store");
			driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Automation");
			driver.findElement(By.xpath("//input[@id='tncflag']")).submit();
		}catch (org.openqa.selenium.NoSuchElementException e){
			
			
		}finally {
			
			if(CurrentpageURl.equalsIgnoreCase("https://www.shutterflyforbusiness.com/ldap-login?next=%2Floginto")) {
				driver.findElement(By.xpath("//input[@id='EmailAddress']")).sendKeys("ajay.mareedu");
				driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Ajay@123");
				driver.findElement(By.xpath("//a[@name='log in']")).click();
		       driver.findElement(By.linkText("Sign Up")).click();
		}
	
		}
	}


}


}
