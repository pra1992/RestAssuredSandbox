package practice1;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PUT {

	@Test
	public void sendPutRequest() {
		RestAssured.baseURI = "https://instance.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("username", "password");
		Map<String,String> q = new HashMap<String, String>();
		q.put("jsonkey", "value");
		q.put("swagger filter", "key1, key2, key3");
		File inputJson = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Payload.json");
		//for both POST and PUT Calls, we can have the Path parameter as per documentation, and we need to pass along with action
		Response put = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).queryParams(q).body(inputJson).when().put("jsonkey");
		System.out.println(put.prettyPrint());
		System.out.println(put.statusCode());
		//w.r.t service now, PUT and PATCH are same implementation except we need to replace PUT with PATCH	
	}
}
