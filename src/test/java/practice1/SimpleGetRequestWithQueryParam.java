package practice1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SimpleGetRequestWithQueryParam {
	
	@Test
	public void sendGetRequest() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
		RestAssured.authentication = RestAssured.basic("prasanthsnkr@gmail.com", "Appukuttu@0112");
		Map<String, String> query = new HashMap<String,String>();
		query.put("Key", "Value");
		query.put("Swagger Filter criteria", "Key1, Key2, Key3");
		Response response = RestAssured.given().accept(ContentType.JSON).when().get();
         List<Object> list = response.jsonPath().getList("results.sys_id");
         System.out.println(list);
		
	}

}
