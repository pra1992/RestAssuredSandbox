package chaining;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SimpleGetRequestWithQueryParam extends BaseRest{
	
	@Test(dependsOnMethods = "chaining.Post.sendPostRequest")
	public void sendGetRequest() {
		Map<String, String> query = new HashMap<String,String>();
		query.put("Key", "Value");
		query.put("Swagger Filter criteria", "Key1, Key2, Key3");
	     response = requestSpecification.accept(ContentType.JSON).when().get();
         List<Object> list = response.jsonPath().getList("results." + PathParameter);
         System.out.println(list);
    
		
	}

}
