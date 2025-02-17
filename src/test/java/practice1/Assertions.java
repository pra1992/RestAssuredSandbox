package practice1;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Assertions {
	
	@Test(priority = 1)
	public void sendGetRequest() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
		RestAssured.authentication = RestAssured.basic("username", "password");
		Map<String, String> q = new HashMap<String, String>();
		
		q.put("jsonkey", "jsonvalue");
		q.put("swagger filter criteria", "key1, key2, key3");
		
		Response response = RestAssured.given().log().all().contentType(ContentType.JSON).queryParams(q).when().get();
	     System.out.print(response.prettyPrint());
		response.then().assertThat().statusCode(200);}
		
	//********************To kick start with hamcrest assertions
		@Test
		public void validateGetRequest() {
			RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
			RestAssured.authentication = RestAssured.basic("prasanthsnkr@gmail.com", "Appukuttu@0112");
			
			Map<String, String> q = new HashMap<String, String>();
			q.put("jsonkey", "value");
			q.put("swagger filter criteria", "key1, key2, key3");
			 Response response = RestAssured.given().log().all().accept(ContentType.JSON).queryParams(q).when().get();
			 
			 // Validating the response object, when Index is known and value is partially known
			 
			 response.then().assertThat().body("jsonArrayObject.key[index]", Matchers.containsString("INC"));
			 
			 //Index is not known but value is known
             response.then().assertThat().body("jsonArrayObject.jsonKey", Matchers.hasItem("INC00007"));
             
            //Direct comparison
             
             response.then().assertThat().body("jsonarrayobject. key[index]", Matchers.equalTo("KeyValue"));
             
		}
		
		
		
	

}
