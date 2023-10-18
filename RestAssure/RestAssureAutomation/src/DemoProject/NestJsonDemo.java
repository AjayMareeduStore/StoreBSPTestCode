package DemoProject;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class NestJsonDemo {

	public static void main(String[] args) {


		JsonPath js = new JsonPath(Payload.Complexjason());
		int count =js.getInt("courses.size()");
		System.out.println(count);
		
		
	  int pruchaseAmount= js.getInt("dashboard.purchaseAmount");
		System.out.println(pruchaseAmount);
		
      String firstpurchaseAmount = js.getString("courses[0].title");
      System.out.println(firstpurchaseAmount);
      
      for (int i=0; i<count; i++) {
    	  
    	  
    	  String allcourses = js.get("courses["+i+"].title");
    	  System.out.println(allcourses);
    	  int allprices = js.get("courses["+i+"].price");
    	  System.out.println(allprices);
    	  
    	  if (allcourses.equalsIgnoreCase("RPA")) {
    		  
    		  
    		  int copies = js.get("courses["+i+"].copies");
  	          System.out.println(copies);
    		  break;
    	  }
      }
      
      
      
      
      
      
      
	}
	

}
//1. Print No of courses returned by API

//2.Print Purchase Amount

//3. Print Title of the first course

//4. Print All course titles and their respective Prices

//5. Print no of copies sold by RPA Course
//
//6. Verify if Sum of all Course prices matches with Purchase Amount