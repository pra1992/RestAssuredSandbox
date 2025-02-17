package chaining;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Patch extends BaseRest {

	
	@Test(dependsOnMethods = "chaining.PUT.sendPutRequest")
	public void sendPatch() {
		
		Map<String, String> q = new HashMap<String, String>();
		q.put("jsonkey", "value");
		q.put("swagger filter criteria", "key1, key2, key3");
		File inputJson = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Payload.json");
		response = requestSpecification.contentType(ContentType.JSON).accept(ContentType.JSON).queryParams(q).body(inputJson).when().patch(PathParameter);
			
	}
	
}
