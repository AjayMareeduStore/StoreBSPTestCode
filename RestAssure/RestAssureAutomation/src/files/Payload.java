package files;

public class Payload {

	
	public static String bodyData() {
		
		return("{\r\n"
				+ "\"location\": {\r\n"
				+ "\"lat\": -38.383494, \"lng\": 33.427362\r\n"
				+ "},\r\n"
				+ "\"accuracy\": 50,\r\n"
				+ "\r\n"
				+ "\"name\": \"Maseed Road\", \"phone_number\": \"9966027297\", \"address\": \"13 147 ntr nagar\", \"types\": [\r\n"
				+ "\"Sathupally\",\r\n"
				+ "\"shop\" ],\r\n"
				+ "\"website\": \"http://google.com\",\r\n"
				+ "\"language\": \"telugu\" }");
		
		
	}
	
	public static String Complexjason() {
		
		
		return ("{\r\n"
				+ "  \"dashboard\": {\r\n"
				+ "    \"purchaseAmount\": 910,\r\n"
				+ "    \"website\": \"rahulshettyacademy.com\"\r\n"
				+ "  },\r\n"
				+ "  \"courses\": [\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Selenium Python\",\r\n"
				+ "      \"price\": 50,\r\n"
				+ "      \"copies\": 6\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Cypress\",\r\n"
				+ "      \"price\": 40,\r\n"
				+ "      \"copies\": 4\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"RPA\",\r\n"
				+ "      \"price\": 45,\r\n"
				+ "      \"copies\": 10\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}");
		
		
	}
	
	

	public static String libraryAddbook() {
		String addbook ="{\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\"biicd\",\r\n"
				+ "\"aisle\":\"200926\",\r\n"
				+ "\"author\":\"John foer\"\r\n"
				+ "}";
		return addbook;
	
	}
	

	public static String libraryDynamicAddbook(String isbn, String aisle) {
		String addbook ="{\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"John foer\"\r\n"
				+ "}";
		return addbook;
	
	}
	
	public static String Delbook(String UpdatedID) {
		
		String DelBook="{\r\n"
				+ "    \"ID\": \""+UpdatedID+"\"\r\n"
				+ "}";
		return DelBook;
		
		
	}
	public static String JiraCreateissue(String CommentNew) {
		
		
		return ("{\\r\\n\"\r\n"
				+ "				+ \"    \\\"body\\\": \\\"\""+CommentNew+"\"\\\",\\r\\n\"\r\n"
				+ "				+ \"    \\\"visibility\\\": {\\r\\n\"\r\n"
				+ "				+ \"        \\\"type\\\": \\\"role\\\",\\r\\n\"\r\n"
				+ "				+ \"        \\\"value\\\": \\\"Administrators\\\"\\r\\n\"\r\n"
				+ "				+ \"    }\\r\\n\"\r\n"
				+ "				+ \"}");
		
	}
	public static String ExternalURl(String payload) {
		
		return ""+payload+"";
	
		
	}
	
}
	

