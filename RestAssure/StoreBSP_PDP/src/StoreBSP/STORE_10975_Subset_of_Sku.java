package StoreBSP;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;


public class STORE_10975_Subset_of_Sku {

	public static void main(String[] args) {
		
		
		
		
		RequestSpecification BaseURI=new RequestSpecBuilder().setBaseUri("https://stg-static.sf-cdn.com").build();
		RequestSpecification GivenData = given().spec(BaseURI).
        queryParam("buildNumber","2231695232351000").
        queryParam("buildNumber","2231695232351000").
        queryParam("context","/hp/sf/sf-us/snapfish-us").
        queryParam("ptype","books").
        queryParam("pcat","photo_books_3150_1691524581_snapfish_us").
        queryParam("filters","skuList~CommerceProduct_8079").
        queryParam("offset","0").
        queryParam("sku","CommerceProduct_8079").
        queryParam("deviceType","pc").
        queryParam("defaultSkuSelection","true").
        queryParam("skipFacets","true").
        queryParam("multisurface","true").
        queryParam("incSkuPreviews","true");
		
		String Response=GivenData.when().get("/photo-gift/api/v1/design-catalog/locale/en_US/cobrand/snapfish/website/snapfish_us")
		.then().extract().asString();
	     JsonPath js = new JsonPath(Response);
	     int count = js.getInt("designGroups.size()");
	     System.out.println(count);
	     
	     String DesignId=(js.get("designRootCategory.name"));
	     System.out.println(DesignId);
	     //Find the number of designs in each designgroup
	   
	     
	     //NameOFEachDesignGroup 
	     for (int i=0;i<count;i++) {
	    	 
	    	 
	    	String NameOFEachDesignGroup= js.get("designGroups[0].designs["+i+"].name");
	    	 System.out.println(NameOFEachDesignGroup);
	    	 
	     
	     
	     
	     
	     }
	     
			}
}
		
		
	
	


