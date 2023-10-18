package OAuthAuthentications;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;

import graphql.Assert;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import pocoFiles.GetJasonDetails;
import pocoFiles.WebAutomation;


public class oAuthDemo {

	public static void main(String[] args) throws InterruptedException {
		
		//preparing a code to hit the url which generates the code which is usefull for the generating access token
		//Using Selenium
		
		/*System.setProperty("webdriver.chrome.driver", "C://Users//ajay.mareedu//chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElementByCssSelector("input[type='email']").sendKeys("ajaymareedu666");
		driver.findElementByCssSelector("input[type='email']").sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElementByCssSelector("input[type='password']").sendKeys("ajayharshi9G@");
		driver.findElementByCssSelector("input[type='password']").sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		String Currenturl =driver.getCurrentUrl();*/
		String Currenturl=("https://rahulshettyacademy.com/getCourse.php?code=4%2F0AfJohXlUWIZjoXvUhLIZjTwLeRCoL_jGiPYR3bZDgOzhJcCL4DaTkgsmhezCVVzqAx0MFQ&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none");
		String Halfcode=Currenturl.split("code=")[1];
		String Code=Halfcode.split("&scope")[0];
		System.out.println(Code);
		
		String [] expectedlist= {"50","400","40"};
		String GrabCode=given().urlEncodingEnabled(false).
		queryParams("code", Code).
		queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
		queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W").
		queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php").
		queryParams("grant_type", "authorization_code").
		when().post("https://www.googleapis.com/oauth2/v4/token").asString();
		JsonPath js = new JsonPath (GrabCode);
		String AccessToken=js.get("access_token");
		System.out.println(AccessToken);
	
		//getting actual response with valid token
		
		GetJasonDetails gs=given().queryParam("access_token",AccessToken).expect().defaultParser(Parser.JSON).
         when()
        .get("https://rahulshettyacademy.com/getCourse.php").as(GetJasonDetails.class);
         System.out.println(gs.getInstructor());
		
		System.out.println(gs.getCourses().getWebAutomation().get(0).getCourseTitle());
		int WebAuto=gs.getCourses().getWebAutomation().size();
		
		for (int i=0;i<WebAuto;i++){
			
			String title=gs.getCourses().getWebAutomation().get(i).getCourseTitle();
			System.out.println(title);
			
			if (title.equalsIgnoreCase("Cypress")) {
				
				String reqprice=gs.getCourses().getWebAutomation().get(i).getPrice();
				System.out.println(reqprice);
				break;
			}
			
			
				
		}
		ArrayList<String> a = new ArrayList<String>();
		List<WebAutomation> x= gs.getCourses().getWebAutomation();
		
		
		for (int j=0;j<WebAuto;j++) {
		
		a.add(x.get(j).getPrice());
		
	
			
	}
	
		
		
		List<String> Mylist=  Arrays.asList(expectedlist);
			
		Assert.assertTrue(a.equals(Mylist));	
System.out.println("My test case has passed successfully");
	}
	}
