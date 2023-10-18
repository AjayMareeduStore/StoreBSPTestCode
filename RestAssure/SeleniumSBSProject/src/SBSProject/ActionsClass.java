package SBSProject;

import java.awt.RenderingHints.Key;
import java.util.Iterator;
import java.util.Set;

import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardEndHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {

	public static void main(String[] args) {

		
		//This below method is used to perform the mouse and keyboard actions
        WebDriver driver = new ChromeDriver();
		Actions actions= new Actions(driver);
		actions.moveToElement(null).keyDown(Keys.SHIFT).sendKeys("").build().perform();
		
		//How to handle Action withkeyboard
		actions.moveToElement(null).keyDown(Keys.SHIFT).sendKeys("").build().perform();
		
		//Handle right click on mouse
		actions.contextClick(null);
		
		// How can we shift to other browsers,
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

		driver.findElement(By.cssSelector(".blinkingText")).click();

		Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]

		Iterator<String>it = windows.iterator();

		String parentId = it.next();

		String childId = it.next();

		driver.switchTo().window(childId);

		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());

		driver.findElement(By.cssSelector(".im-para.red")).getText();

		String emailId= driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];

		driver.switchTo().window(parentId);
		
		//How to hadle frames
		
		driver.switchTo().frame(emailId); // this step used to switch to frame and get the required details
		driver.getTitle();
		driver.switchTo().defaultContent(); // this step will be used to get back to the normal page from frames
		
		//How to drag and drop
		// actions.dragAndDrop(Need to provide the targated file to drag, Need to provide targated location);
	}
	
	
	
	

}
