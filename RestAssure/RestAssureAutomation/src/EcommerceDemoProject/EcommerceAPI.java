package EcommerceDemoProject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import pocoFiles.BodyForLoginDetails;
import pocoFiles.OrderDetails;
import pocoFiles.Orders;

import pocoFiles.tokenClass;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;



public class EcommerceAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BodyForLoginDetails lognDetails = new BodyForLoginDetails();
		lognDetails.setUserEmail("ajaymareeduse@gmail.com");
		lognDetails.setUserPassword("Ajay@123");
		

		
		
		RequestSpecification req= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON)
        .build();
		RequestSpecification Request=given().spec(req).body(lognDetails);
		
		tokenClass Response=Request.when().post("/api/ecom/auth/login").
		then().assertThat().statusCode(200).extract().response().as(tokenClass.class);
		
		System.out.println(Response.getToken());
		String tokenvalue=Response.getToken();
		System.out.println(Response.getUserId());
		String userID=Response.getUserId();
		System.out.println(Response.getMessage());
		
		
		
		
		//Add product
		
		RequestSpecification Addrequest= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization", tokenvalue)
		        .build();
		
		
		RequestSpecification GivenBody= given().spec(Addrequest).
	     param("productName", "qwerty").
	     param("productAddedBy",userID).
	     param("productCategory", "fashion").
	     param("productSubCategory", "shirts").
	     param("productPrice", "11500").
	     param("productDescription", "Addias Originals").
	     param("productFor", "women")
	     .multiPart("productImage",new File("C:\\Users\\ajay.mareedu\\Pictures\\Screenshots\\testimage.png"));
	     
		String prodcutResponse=GivenBody.when().post("/api/ecom/product/add-product")
		.then().log().all().extract().response().asString();
		JsonPath js = new JsonPath(prodcutResponse);
		String ProdcuctID=js.get("productId");
		String Messge= js.get("message");
		System.out.println(ProdcuctID);
		System.out.println(Messge);
		
		
		
		
		//Create Order
		
		
		RequestSpecification CreateOrder1=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON)
		.addHeader("Authorization", tokenvalue).build();
		
		OrderDetails orderlist = new OrderDetails();
		orderlist.setCountry("India");
		orderlist.setProductOrderedId(ProdcuctID);
		
		List<OrderDetails> Orderslist1 = new ArrayList<OrderDetails>();
		Orderslist1.add(orderlist);
		
		
		Orders od = new Orders();
		od.setOrders(Orderslist1);
		
		
		
		RequestSpecification Req=given().log().all().spec(CreateOrder1).body(od);
		
		
		 String CreateOrderDetails =Req.log().all().post("/api/ecom/order/create-order")
	     .asString();
         System.out.println(CreateOrderDetails);
         
         

         JsonPath js1 = new JsonPath(CreateOrderDetails);
         String message =js1.get("message");
          System.out.println(message);
          
          
          List<String> productID = js1.get("productOrderId");
          System.out.println(productID);
          List<String> orders = js1.get("orders");
          System.out.println(orders);
	      //Delete Placed Order
	      
	      RequestSpecification DeleteOrder=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON)
	    			.addHeader("Authorization", tokenvalue).build();
	      
	      RequestSpecification del= given().spec(DeleteOrder).pathParam("ProdcuctID", ProdcuctID);
	     String DelResp= del.when().log().all().delete("https://rahulshettyacademy.com/api/ecom/product/delete-product/{ProdcuctID}")
	      .then().extract().response().asString();
	     System.out.println(DelResp);
	}

}
