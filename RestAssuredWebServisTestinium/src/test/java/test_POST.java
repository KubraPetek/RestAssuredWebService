import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class test_POST {

	@Test
	void getDetails() {
		
		RestAssured.baseURI="http://ergast.com/api/f1";
		
		//Request Object
		RequestSpecification httpRequest=RestAssured.given();
		//Response Object
		
		JSONObject requestParams=new JSONObject();
		requestParams.put("parametre","değer");
		requestParams.put("parametre","değer");
		requestParams.put("parametre","değer");
		requestParams.put("parametre","değer");
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());
		
		Response response=httpRequest.request(Method.POST,"///register");
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is : "+responseBody);
		
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode,201);
		
		
	}
}
