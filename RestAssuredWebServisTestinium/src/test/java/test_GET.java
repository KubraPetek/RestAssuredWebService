import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class test_GET {

	@Test
	void getDetails() {
		
		RestAssured.baseURI="http://ergast.com/mrd/methods";
		
		//Request Object
		RequestSpecification httpRequest=RestAssured.given();
		//Response Object
		
		Response response=httpRequest.request(Method.GET,"/drivers");
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is : "+responseBody);
		String driverId = response.jsonPath().getString("driverId");
		System.out.println("Response : "+driverId);
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode,200);
		
		
	}
	
	
}
