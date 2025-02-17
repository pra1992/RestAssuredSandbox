package chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DELETE extends BaseRest {
	
	
	@Test(dependsOnMethods = "chaining.PUT.sendPutRequest")
	public void deleteRequest() {
		response = RestAssured.when().delete(PathParameter);
	}

}
