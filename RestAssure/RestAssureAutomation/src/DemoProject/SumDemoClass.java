package DemoProject;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class SumDemoClass {
	
	
	
  @Test
  
  public void Sumofthecourses() {
	  
	  JsonPath js = new JsonPath (Payload.Complexjason());
	  int count =js.getInt("courses.size()");
	  System.out.println(count);
	
	  
		 
	  int pruchaseAmount= js.getInt("dashboard.purchaseAmount");
	  System.out.println(pruchaseAmount);
	  
	       int sum = 0;
	  for (int i=0; i<count; i++) {
		  
		  int allprices = js.get("courses["+i+"].price");
		  int allcopies = js.get("courses["+i+"].copies");
		  int amount = allprices*allcopies;
		  System.out.println(amount);
		  sum = sum+amount;
		  System.out.println(sum);
    	  
		 
	  }
	   
	  
	  
	   Assert.assertEquals(sum, pruchaseAmount);
	  
	  
	  
	  
	  
	  
	  }
	  
	  
  }
	
	
	
	
	
	
	
	


