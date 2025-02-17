package practice1;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DELETE {
	
	public void deleteRequest() {
		RestAssured.baseURI = "https://instance.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("username", "password");
		Response delete = RestAssured.when().delete("pathparameter");
		System.out.println(delete.prettyPrint());
		System.out.println(delete.statusCode());
	}

}
