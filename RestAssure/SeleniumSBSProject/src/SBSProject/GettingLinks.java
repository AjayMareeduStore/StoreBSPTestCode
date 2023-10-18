package SBSProject;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GettingLinks {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.snapfish.com/photo-book");
		
		//get the number of links available in the page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement bookLinksdriver=driver.findElement(By.xpath("//div[@class='two-tile-lockup snapfish'][1]"));//limiting the driver scope
		
		System.out.println(bookLinksdriver.findElements(By.tagName("a")).size());//getting the link only a particular section
		
		for (int i = 1;i<bookLinksdriver.findElements(By.tagName("a")).size();i++){
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			
		  String openNewTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
		  bookLinksdriver.findElements(By.tagName("a")).get(i).sendKeys(openNewTab); 
		  
		}
		  
		  Thread.sleep(10000);
	      Set<String> switchMethod= driver.getWindowHandles();// Create a switch tab method
	      Iterator<String> iterator= switchMethod.iterator(); // Used to switch to other tabs
	      
	      while(iterator.hasNext()) {
	    	  
	    	  driver.switchTo().window(iterator.next()); // Used to switch to the other tabs
	    	  System.out.println(driver.getCurrentUrl());
	    	  
	      }
	}
	

}
