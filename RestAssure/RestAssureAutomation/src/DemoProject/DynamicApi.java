package DemoProject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import files.Payload;
import files.Reusablemethods;

public class DynamicApi {
	
/*@Test
	
	public void AddbookToLibrary() {
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response = given().header("Content-Type","application/json")
		.body(Payload.libraryAddbook())
		.when().post("/Library/Addbook.php")
		.then().log().all().statusCode(200).extract().response().asString();
	    JsonPath js = Reusablemethods.Rawtojson(response);
	    String BookId = js.get("ID");
	    System.out.println(BookId);
	}*/

	//Dynamic Update the Payload and retreving and addto new book
	@Test(dataProvider="Dataprovider")
	
	public static void UpdateLibrary(String isbn,String aisle) {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		 String Updatebook =given().header("Content-Type","application/json")
		.body(Payload.libraryDynamicAddbook(isbn,aisle))
		.when().post("/Library/Addbook.php")
		.then().assertThat().statusCode(200).extract().response().asString();		
		JsonPath js =Reusablemethods.Rawtojson(Updatebook);
		String UpdatedID=js.get("ID");
		String Resp2= js.get("Msg");
		System.out.println(UpdatedID);
		System.out.println(Resp2);
		
		String DelBook=given().header("Content-Type","text/plain")
		.body(Payload.Delbook(UpdatedID)).when().delete("/Library/DeleteBook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js1=Reusablemethods.Rawtojson(DelBook);
		String Resp=js1.getString("msg");
		System.out.println(Resp);		
		
	
	}
		
	@DataProvider(name="Dataprovider")
	 public Object[][] DataProvider() {
		
		
		return new Object[][] {{"kjkkk","8798"},{"fggfg","85798"},{"dfgfdg","5574"},{"mumum","3345"},{"ytfdf","87698"},{"knhmhkk","34444"}};
	
	}


	

}
