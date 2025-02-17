package practice1;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Post {
	
	@Test
	public void sendPostRequest() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
		RestAssured.authentication = RestAssured.basic("username", "password");
		Map<String, String> query = new HashMap<String,String>();
		query.put("Key", "Value");
		query.put("Swagger Filter criteria", "Key1, Key2, Key3");
		File inputJson = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Payload.json");
		Response post = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).queryParams(query).body(inputJson).when().post();
		 Object object = post.jsonPath().get("responseobject.keyname");//means "response object.keyname, sends the path of the json key to be called"
		
	}

}
