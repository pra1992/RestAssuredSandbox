package chaining;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PUT extends BaseRest{

	@Test(dependsOnMethods = "chaining.SimpleGetRequestWithQueryParam.sendGetRequest")
	public void sendPutRequest() {

		Map<String,String> q = new HashMap<String, String>();
		q.put("jsonkey", "value");
		q.put("swagger filter", "key1, key2, key3");
		File inputJson = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Payload.json");
		//for both POST and PUT Calls, we can have the Path parameter as per documentation, and we need to pass along with action
		response = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).queryParams(q).body(inputJson).when().put(PathParameter);
		//w.r.t service now, PUT and PATCH are same implementation except we need to replace PUT with PATCH
		
	}
}
