package SBSProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class calendar {

	public static void main(String[] args) {
// TODO Auto-generated method stub

	//	System.setProperty("webdriver.chrome.driver", "C://work//chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().window().maximize();
//April 23
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
		driver.findElement(By.id("form-field-travel_comp_date"));
		
		while (!driver.findElement(By.xpath("//div[@class='flatpickr-current-month']")).getText()
				.contains("Dec")) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
		}

		List<WebElement> dates = driver.findElements(By.className("day"));
//Grab common attribute//Put into list and iterate
		//int count = driver.findElements(By.className("day")).size();

		for (int i = 0; i < dates.size(); i++) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			String text = driver.findElements(By.className("flatpickr-day ")).get(i).getText();
			if (text.equalsIgnoreCase("21")) {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.findElements(By.className("flatpickr-day ")).get(i).click();
				break;
			}

		}
	}

}