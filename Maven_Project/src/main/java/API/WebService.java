package API;
import org.testng.annotations.*;

import java.io.PrintStream;

import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WebService {
	@Test
	public void GetWeatherDetails()
	{
		//Set the REST API Endpoint or specify the base URL to RESTfull web service
		   RestAssured.baseURI = "http://demoqa.com/utilities/weather/city";
		   
		 //Get the specification at the request that you want to sent to the server.
		  // the server is specified by the BaseURL that we have specified
		  RequestSpecification httpRequest = RestAssured.given();
		  Response response = httpRequest.request(Method.GET,"London");
		  int statusCode = response.getStatusCode();
		  Assert.assertEquals(statusCode/*Actual Value*/ ,200 /*Executes Value*/, "Correct status code returned");
		  
		  //now let us print the body of the message to see the response from the server
		  String responseBody = response.getBody().asString();
		  System.out.println("Response Body is => " + responseBody);
		 
			}
	
	
}
