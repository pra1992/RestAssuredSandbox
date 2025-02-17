package practice1;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class SchemaComparisons {

	
	@Test
	public void comparePayload() {
		RestAssured.baseURI = "https://instance.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("username", "password");
		Map<String,String> q = new HashMap<String, String>();
		q.put("jsonkey", "value");
		q.put("swagger filter", "key1, key2, key3");
                File inputJson = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Payload.json");
                Response put = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).queryParams(q).body(inputJson).when().put("jsonkey");
                //Now after converting the sample payload of response from documentation , to schema, validating all the fields using JSON Schema Validator
               put.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\ResponseSchema.json")));
}
}
