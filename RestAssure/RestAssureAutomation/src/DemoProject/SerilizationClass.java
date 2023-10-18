package DemoProject;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.methods.RequestBuilder;

import files.SerializationPaylaod;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pocoFiles.Location;
import pocoFiles.Serialzation;

public class SerilizationClass extends SerializationPaylaod {

	public static void main(String[] args) {
	
Serialzation bodydata= new Serialzation();
		
		bodydata.setAccuracy(50);
		bodydata.setAddress("test address");
		bodydata.setLanguage("English");
		bodydata.setName("AjayMareedu");
		bodydata.setPhone_number("98797979797");
		List<String> Mylist = new ArrayList<String>();
		Mylist.add("Near Adress");
		Mylist.add("TESTlIST");
		bodydata.setTypes(Mylist);
		Location L = new Location();
		L.setLat(-9879879);
		L.setLng(+878788);
		bodydata.setLocation(L);
		
		RequestSpecification BaseURI=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("Key", "qaclick123")
		.build();

		RequestSpecification response = given().spec(BaseURI)
				.body(bodydata);
	   ResponseSpecification Resp =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
			   .build();
		Response response1 = response.when().post("/maps/api/place/add/json")
				.then().spec(Resp).extract().response();
		String Res = response1.asString();
		System.out.println(Res);
		

	}

}
