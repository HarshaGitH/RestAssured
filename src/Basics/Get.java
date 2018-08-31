package Basics;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get {

	public static void main(String[] args) {
		
		//Using restassured to automate the guest request for service in Postman
		
		//Below 2 steps are basically what I give in the URL
		//When is the resource 
		//1.Base URL 
		RestAssured.baseURI = "https://maps.googleapis.com";
		//2.These are the parameters given
		//param("key","value")
		given().
		param("location","-33.8670522,151.1957362").
		param("radius","500").
		param("key","AIzaSyA6HpTY5S70fhsSFTf4b3s_67NIsMb8Suo").
		when().
		get("/maps/api/place/nearbysearch/json").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("results[0].name",equalTo("Sydney"));
		//content type is from header validation
			
		
		

	}

}
