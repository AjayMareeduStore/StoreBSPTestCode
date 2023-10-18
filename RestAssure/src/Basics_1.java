import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class Basics_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	          //given
		      //when
              //then
		RestAssured.baseURI="https://rahulshettyacademy.com";
	    given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
	    .body("{\r\n"
	    		+ "\"location\": {\r\n"
	    		+ "\"lat\": -38.383494, \"lng\": 33.427362\r\n"
	    		+ "},\r\n"
	    		+ "\"accuracy\": 50,\r\n"
	    		+ "\r\n"
	    		+ "\"name\": \"Maseed Road\", \"phone_number\": \"9966027297\", \"address\": \"13 147 ntr nagar\", \"types\": [\r\n"
	    		+ "\"Sathupally\",\r\n"
	    		+ "\"shop\" ],\r\n"
	    		+ "\"website\": \"http://google.com\",\r\n"
	    		+ "\"language\": \"telugu\" }").when().post("/maps/api/place/add/json")
	    .then().log().all().assertThat().statusCode(200);
		
		
		
		
		
		
		
		
	}

}
