package practice1;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ChangeRequestModifications {
	
	@Test(priority = 1)
	public void changeRequest() {
		RestAssured.baseURI = "";
		RestAssured.authentication =RestAssured.basic("username", "password");
		File inputJson = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Payload.json");
		Response put = RestAssured.given().log().all().contentType(ContentType.XML).accept(ContentType.XML).body(inputJson).when().put("pathparameter");
		System.out.println(put.statusCode());		
	}
	
	@Test(priority = 2)
	public void deleteRequest() {
		RestAssured.baseURI="";
		RestAssured.authentication="";
		Response delete = RestAssured.when().delete("pathparameter");
		System.out.println(delete.statusCode());
		
	}

}
