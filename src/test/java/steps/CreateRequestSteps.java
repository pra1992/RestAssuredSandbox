package steps;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateRequestSteps {
	
	static RequestSpecification requestSpecification= null;
	static Response response = null;
	static String FilterValue = null;
	
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
	
//	@Given("Set the Content Type in the Create Request")
//	public void setContentTyp() {
//		requestSpecification.contentType(ContentType.JSON);
//	}
//	
//	@Given("Set the Accept in the Create Request")
//	public void setAccept() {
//		requestSpecification.accept(ContentType.JSON);
//	}
	
	public void setHeaders(DataTable dataTable) {
     List<Header> allHeaders = new ArrayList<Header>();
     Map<String, String> asMap = dataTable.asMap();
     Set<Entry<String, String>> entrySet = asMap.entrySet();
     for (Entry<String, String> entry : entrySet) {
		allHeaders.add(new Header(entry.getKey(), entry.getValue()));
	}
     requestSpecification.headers(new Headers(allHeaders));
     // the other way  for reference is
     Map<String, String> asMap2 = dataTable.asMap();
     Map<String,String> headers = new HashMap<String, String>();
     for (Entry<String, String> entry : asMap2.entrySet()) {
    	 headers.put(entry.getKey(), entry.getValue());
	}
     requestSpecification.headers(headers);
	}
	
	@Given("Set the Request Body as {String} in the Create Request")
	public void setRequestBody(String FileName) {
		requestSpecification.body(new File(System.getProperty("user.dir")+ "\\src\\test\\resources\\"+FileName));
	}  
	
	@When("Send the POST Request to the Sandbox Environment")
	public void sendPostRequest() {
		response=requestSpecification.when().post();
		
	}	
	
	@When("Send the GET Request to the Sandbox Environment")
	public void sendGetRequest() {
		requestSpecification.when().get(FilterValue);
		response.then().log().all();
		
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
		FilterValue= response.jsonPath().get(KeyName);
	}
	
	@Then("Validate the GET Response contains the fields with values")
	public void validateGetResponseKey(DataTable dataTable) {
		Map<String, String> asMap1 = dataTable.asMap();
		Set<Entry<String, String>> entrySet = asMap1.entrySet();
		for (Entry<String, String> entry : entrySet) {
			response.then().assertThat().body(entry.getKey(), Matchers.equalTo(entry.getValue()));		
		}
	}
	

}
