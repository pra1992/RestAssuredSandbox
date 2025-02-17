package practice1;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Patch {

	public void sendPatch() {
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
		RestAssured.authentication = RestAssured.basic("username", "password");
		Map<String, String> q = new HashMap<String, String>();
		q.put("jsonkey", "value");
		q.put("swagger filter criteria", "key1, key2, key3");
		File inputJson = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Payload.json");
		Response response = RestAssured.given().log().all().contentType(ContentType.JSON).accept(ContentType.JSON).queryParams(q).body(inputJson).when().patch("pathparameter");
		
		System.out.println(response.prettyPrint());
		System.out.println(response.statusCode());
		
		
		
		
	}
	
}
