package steps;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateRequestSteps {
	
	static RequestSpecification requestSpecification= null;
	static Response response = null;
	private Map<String, String> queryParams = new HashMap<String, String>();

	
	@Given("Set the endpoint for the Sandbox Environment")
	public void setEndPoint() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
		
	}
	
	@Given("Set the authentication for application")
	public void setAuth() {
		RestAssured.authentication = RestAssured.basic("username", "password");
	}
	
	@Given("Set the Queryparam for create request")
	public void setQueryParam(DataTable dataTable) {
		Map<String, String> asMap = dataTable.asMap();
      requestSpecification.queryParams(asMap);
	}
	
	@Given("Set the Content Type in the Create Request")
	public void setContentTyp() {
		requestSpecification.contentType(ContentType.JSON);
	}
	
	@Given("Set the Accept in the Create Request")
	public void setAccept() {
		requestSpecification.accept(ContentType.JSON);
	}
	
	@Given("Set the Request Body as {String} in the Create Request")
	public void setRequestBody(String FileName) {
		requestSpecification.body(new File(System.getProperty("user.dir")+ "\\src\\test\\resources\\"+FileName));
	}  
	
	@When("Send the POST Request to the Sandbox Environment")
	public void sendPostRequest() {
		requestSpecification.when().post();
	}	
	
	@When("Send the GET Request to the Sandbox Environment")
	public void sendGetRequest() {
		requestSpecification.when().get();
	}	
	
	@When("Send the PUT Request to the Sandbox Environment")
	public void sendPutRequest() {
		requestSpecification.when().put();
	}
	
	@When("Send the PATCH Request to the Sandbox Environment")
	public void sendPatchRequest() {
		requestSpecification.when().patch();
	}
	
	@Then("Validate the Status Code as {int}")
	public void validateStatusCode(int code) {
		response.then().assertThat().statusCode(code);
	}
	
	@Then("Validate the value for the response {String}")
	public void validateResponseKeyValue(String KeyName) {
		response.then().assertThat().body("responseobject"+"."+KeyName, Matchers.containsString("ExpectedValue"));
	}

}
