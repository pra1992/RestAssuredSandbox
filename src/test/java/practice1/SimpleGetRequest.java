package practice1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SimpleGetRequest {
	
	@Test
	public void  sendGETRequest() {
		
		RestAssured.baseURI = "https://instance.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("prasanthsnkr@gmail.com", "Appukuttu@0112");
		Response response = RestAssured.given().get();
		System.out.println("Response Code is "+ response.statusCode());
		System.out.println("Response is " + response.prettyPrint());
		
		
		
	}

}
