package DemoProject;

import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static io.restassured.RestAssured.*;

import files.Payload;
import files.Reusablemethods;


public class BasicRestAssure {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
	//given is the method to send the input data
    //when is the method to send the data to the server
    //then is the method to get the validations
		
		//Create a method to generate as restassure
		//Post the data in server
	
		
	   RestAssured.baseURI="https://rahulshettyacademy.com";
	   String response = given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
	   .body(Payload.bodyData())
	   .when().post("/maps/api/place/add/json")
	   .then().log().all().assertThat().statusCode(200).extract().response().asString();
	   System.out.println(response);
	   
		//Update the data which is stored in the server
	   
	  JsonPath js= Reusablemethods.Rawtojson(response);
	  String PlaceID= js.getString("place_id");
	  System.out.println(PlaceID);
	  given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
	   .body("{ \"place_id\":\""+PlaceID+"\", \"address\":\"Srinivasa reede road\", \"key\":\"qaclick123\"\r\n"
	   		+ "}")
	   .when().put("/maps/api/place/update/json")
	   .then().log().all().assertThat().statusCode(200).body("msg",equalTo("Address successfully updated"));
	 // Get the updated data 
	   
	  String UpdatedData=given().queryParam("key", "qaclick123").queryParam("place_id",PlaceID).header("Content-Type", "application/json;charset=UTF-8")
	   .when().get("/maps/api/place/get/json")
	   .then().log().all().assertThat().statusCode(200).extract().response().asString();
	   System.out.println(UpdatedData);
	  
	   
	  //Update the data in the body through external file
	   
	   RestAssured.baseURI="https://rahulshettyacademy.com";
	   String testexternalfile = given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
	   .body(new String (Files.readAllBytes(Path.of("C:\\Users\\ajay.mareedu\\Desktop\\New folder\\test.json"))))
	   .when().post("/maps/api/place/add/json")
	   .then().log().all().assertThat().statusCode(200).extract().response().asString();
	   System.out.println(testexternalfile);
	   
	   
	   
	   
	}

	}


