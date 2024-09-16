package RestAssuredWadiaaAPI_BDD_Approch;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class general_information {
	
	
	public static HashMap<String, String> map = new HashMap<String, String>();
	
	@BeforeClass
	public void general_informationPostData() {
		RestAssured.baseURI = "http://localhost:3001/v1";
		RestAssured.basePath = "general-info/investor";
	}
	
	
	@Test(priority = 1)
	public void firstName() {
		map.put("firstName", "Sam123");
				Response response = given()
						.contentType("application/json")
						.body(map)
					.when()
						.post();
				response.prettyPrint();
					response.then()
					.statusCode(400);

	}
	
	@Test(priority = 2)
	public void lastNameValidation() {
		map.put("firstName", "Sam");
		map.put("lastName", "Bahadur123");
				Response response = given()
						.contentType("application/json")
						.body(map)
					.when()
						.post();
				response.prettyPrint();
					response.then()
					.statusCode(400);

	}
	
	@Test(priority = 3)
	public void emailValidation() {
		map.put("firstName", "Sam");
		map.put("lastName", "Bahadur");
		map.put("email", "check");
				Response response = given()
						.contentType("application/json")
						.body(map)
					.when()
						.post();
				response.prettyPrint();
					response.then()
					.statusCode(400);

	}
	
	@Test(priority = 4)
	public void contactNumberValidation() {
		map.put("firstName", "Sam");
		map.put("lastName", "Bahadur");
		map.put("email", "sam.bahadur@gmail.com");
		map.put("contactNumber", "012342342345");
				Response response = given()
						.contentType("application/json")
						.body(map)
					.when()
						.post();
				response.prettyPrint();
					response.then()
					.statusCode(400);

	}
	
	@Test(priority = 5)
	public void residenceCountryValidation() {
		map.put("firstName", "Sam");
		map.put("lastName", "Bahadur");
		map.put("email", "sam.bahadur@gmail.com");
		map.put("contactNumber", "919673505528");
		map.put("residenceCountry", "check");
				Response response = given()
						.contentType("application/json")
						.body(map)
					.when()
						.post();
				response.prettyPrint();
					response.then()
					.statusCode(400);
	}
	
	@Test(priority = 6)
	public void birthDate() {
		map.put("firstName", "Sam");
		map.put("lastName", "Bahadur");
		map.put("email", "sam.bahadur@gmail.com");
		map.put("contactNumber", "919673505528");
		map.put("residenceCountry", "India");
		map.put("birthDate", "check");
				Response response = given()
						.contentType("application/json")
						.body(map)
					.when()
						.post();
				response.prettyPrint();
					response.then()
					.statusCode(400);
	}
	

}
