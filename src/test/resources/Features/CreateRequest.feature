Feature: Sandbox Environment- Request Management and Validations

@RunTest
Scenario: TC001_Create Request with request body as File
Given Set the endpoint for the Sandbox Environment
And Set the authentication for application
And Set the Queryparam for create request
And Set the Content Type in the Create Request
And Set the Accept in the Create Request
And Set the Request Body in the Create Request
When Send the POST Request to the Sandbox Environment
Then Validate the Status Code 201
And Validate the value for the response "Key"

@RunTest
Scenario Outline: TC002 Create Request with multiple request body as files
Given Set the endpoint for the Sandbox Environment
And Set the authentication for application
And Set the Queryparam for create request
|JsonKeyNames|JsonKeyValue|
|SwaggerFilterCriteria|Key1, Key2, key3|
And Set the Content Type in the Create Request
And Set the Accept in the Create Request
And Set the Request Body as <File_Name> in the Create Request
When Send the POST Request to the Sandbox Environment
Then Validate the Status Code as 201
And Validate the value for the response "Key"

Examples:
|File_Name|
|Payload1.json|
|Payload2.json|

@RunTest
Scenario Outline: TC003 Get all Incidents with JsonKey as Filter
Given Set the endpoint for the Sandbox Environment
And Set the authentication for application
And Set the Queryparam for create request
|JsonKeyNames|JsonKeyValue|
|SwaggerFilterCriteria|Key1, Key2, key3|
And Set the Content Type in the Create Request
And Set the Accept in the Create Request
When Send the POST Request to the Sandbox Environment
Then Validate the Status Code as 200
And Validate the GET Response contains the fields with values
|Field1|Value1|
|Field2|Value2|

Examples:
|File_Name|
|Payload1.json|
|Payload2.json|

@RunTest
Scenario Outline: TC004 Update Request with multiple request body as files
Given Set the endpoint for the Sandbox Environment
And Set the authentication for application
And Set the Queryparam for create request
|JsonKeyNames|JsonKeyValue|
|SwaggerFilterCriteria|Key1, Key2, key3|
And Set the Content Type in the Create Request
And Set the Accept in the Create Request
And Set the Request Body as <File_Name> in the Create Request
When Send the PUT Request to the Sandbox Environment
Then Validate the Status Code as 201
And Validate the value for the response "Key"

Examples:
|File_Name|
|Payload1.json|
|Payload2.json|

@RunTest
Scenario Outline: TC004 partially update Request with multiple request body as files
Given Set the endpoint for the Sandbox Environment
And Set the authentication for application
And Set the Queryparam for create request
|JsonKeyNames|JsonKeyValue|
|SwaggerFilterCriteria|Key1, Key2, key3|
And Set the Content Type in the Create Request
And Set the Accept in the Create Request
And Set the Request Body as <File_Name> in the Create Request
When Send the PATCH Request to the Sandbox Environment
Then Validate the Status Code as 201
And Validate the value for the response "Key"

Examples:
|File_Name|
|Payload1.json|
|Payload2.json|


Scenario Outline: Create a POST Request with headers as parameters
Given Set the endpoint for the Sandbox Environment
And Set the authentication for application
And Set the Queryparam for create request
|JsonKeyNames|JsonKeyValue|
|SwaggerFilterCriteria|Key1, Key2, key3|
And Set the Content Type in the Create Request
And Set the Accept in the Create Request
And Set the following Headers in the Input Request
|Content-Type|application/json|
|Accept|application/json|
And Set the Request Body as <File_Name> in the Create Request
When Send the POST Request to the Sandbox Environment
Then Validate the Status Code as 201
And Validate the value for the response "Key"

Examples:
|File_Name|
|Payload1.json|
|Payload2.json|








