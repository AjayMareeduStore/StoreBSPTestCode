package DemoProject;
import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

public class JiraTest {
   
	// This issues for https validation	relaxedHTTPSValidation
	public static void main(String[] args) {
	    
		SessionFilter session = new SessionFilter();
		RestAssured.baseURI= "http://localhost:8080";
		given().relaxedHTTPSValidation().header("Content-Type","application/json")
		.body("{\"username\": \"ajaymareedu666\", \"password\": \"ajayharshi9J@\"}")
		.filter(session).when().post("/rest/auth/1/session")
		.then().log().all().assertThat().statusCode(200).extract().response();
	
	
		given().relaxedHTTPSValidation().header("Content-Type","application/json")
		.body("{\"username\": \"ajaymareedu666\", \"password\": \"ajayharshi9J@\"}")
		.filter(session).when().post("/rest/auth/1/session")
		.then().log().all().assertThat().statusCode(200).extract().response();
		RestAssured.baseURI= "http://localhost:8080";
		given().relaxedHTTPSValidation().header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"fields\": {\r\n"
				+ "        \"project\": {\r\n"
				+ "            \"key\": \"RES\"\r\n"
				+ "                   },\r\n"
				+ "         \"summary\": \"Creating an issue\",\r\n"
				+ "          \"description\": \"Creating my second bug\",\r\n"
				+ "           \"issuetype\": {\r\n"
				+ "            \"name\": \"Bug\"\r\n"
				+ "           }\r\n"
				+ "          }\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "}")
		.filter(session).when().post("/rest/api/2/issue")
		.then().log().all().assertThat().statusCode(201).extract().response();
		
		
		/*String CommentNew= "I am adding comment my self";		
		String Mycomment =given().pathParam("id","10200").header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"body\": \""+CommentNew+"\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").filter(session).when().post("/rest/api/2/issue/{id}/comment")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
		JsonPath Js1= new JsonPath(Mycomment);
		String CommentID= Js1.get("id"); 
		System.out.println(CommentID);

		//This is to add the attachment into the created issue / Multipart need to come in the code
		
		given().header("X-Atlassian-Token","no-check").filter(session).pathParam("id","10200").
		header("Content-Type","multipart/form-data")
		.multiPart("file",new File("testfile.txt")).when().post("/rest/api/2/issue/{id}/attachments")
		.then().log().all().assertThat().statusCode(200);
		
		
		//get the details from jira
		
		 String FetchDetails = given().filter(session).pathParam("id","10200")
	    .queryParam("fields", "comment")
		.when().log().all().get("/rest/api/2/issue/{id}")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(FetchDetails);
		
		JsonPath js = new JsonPath (FetchDetails);
		int commentscount =js.getInt("fields.comment.comments.size()");
		
		for (int i=0; i<commentscount; i++) {
			
			String receivedID = js.get("fields.comment.comments["+i+"].id").toString();
			
			if(receivedID.equalsIgnoreCase(CommentID)) {
				
				
				String ExtractedComment= js.get("fields.comment.comments["+i+"].body").toString();
				Assert.assertEquals(ExtractedComment, CommentNew);
				
			}
		
			
			
			
		}
		
		*/
		
	}

}
