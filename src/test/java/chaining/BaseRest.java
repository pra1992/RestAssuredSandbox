package chaining;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseRest {
    
	static RequestSpecification requestSpecification = null;
	static Response response = null;
	static String PathParameter = null;
	
	@BeforeSuite
	public void beforeRun() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
		RestAssured.authentication = RestAssured.basic("admin", "Welcome@123");
		RequestSpecification all = RestAssured.given().log().all();		
	}
	
	@AfterMethod
	public void afterRun() {
		  System.out.println(response.prettyPrint());
	         System.out.println(response.statusCode());
	         response.then().assertThat().statusCode(Matchers.greaterThan(199));
		
	}
}
