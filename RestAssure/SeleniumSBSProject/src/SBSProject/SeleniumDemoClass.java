package SBSProject;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class SeleniumDemoClass {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();
		//Handling the pop-ups
		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
	   //Handling synchronaizatio issue
	
		
			

	}

}
