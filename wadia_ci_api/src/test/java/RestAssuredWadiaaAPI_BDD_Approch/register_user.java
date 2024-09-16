package RestAssuredWadiaaAPI_BDD_Approch;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class register_user {

    public static HashMap<String, String> map = new HashMap<String, String>();

    @BeforeClass
    public void registerPostData() {
    
     

        RestAssured.baseURI = "http://localhost:3001/v1";
        RestAssured.basePath = "/user/register-user";
    }

   
    @Test(priority = 1)
    public void checkFirstNameWithNumbers() {
        // Modify the firstName to include numbers
        map.put("firstName", "Vedant123");
        
        // Send the request with modified data
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
    public void checkLastnameWithNumber() {
        
    	   map.put("firstName", "Vedant");
    	   map.put("lastName", "Kulkarni@123");

           // Send the request with modified data
           Response response = given()
        		   .contentType("application/json")
        		   .body(map)
        	   .when()
        			.post();
           response.prettyPrint();

           // Validate response
        response.then()
        			.statusCode(400); // Assuming 400 is returned for validation errors
                            
       }
       
    @Test(priority = 3)
    public void checkPhoneValidation() {
        
 	   map.put("firstName", "Vedant");
 	   map.put("lastName", "Kulkarni");
 	   map.put("phone", "123123123123123");
        // Send the request with modified data
        Response response = given()
        		.contentType("application/json")
        		.body(map)
        	.when()
        		.post();
        response.prettyPrint();

        // Validate response
    response.then()
    			.statusCode(400); // Assuming 400 is returned for validation errors
                         
    }
    
    @Test(priority = 4)
    public void checkEmailValidation() {
        
  	   map.put("firstName", "Vedant");
  	   map.put("lastName", "Kulkarni");
  	   map.put("phone", "912342342345");
  	   map.put("email", "vedant");
         // Send the request with modified data
         Response response = given()
        		 .contentType("application/json")
        		 .body(map)
        	.when()
        		.post();
         response.prettyPrint();

         // Validate response
    response.then()
    			.statusCode(400); // Assuming 400 is returned for validation errors
                          
     }
    
    @Test(priority = 5)
    public void checkAccountTypeValidation() {
        
   	   map.put("firstName", "Vedant");
   	   map.put("lastName", "Kulkarni");
   	   map.put("phone", "912342342345");
   	   map.put("email", "vedantbk@gmail.com");
   	   map.put("password", "Pass@123");
   	   map.put("accountType", "check");
          // Send the request with modified data
          Response response = given()
        		  .contentType("application/json")
        		  .body(map)
        	 .when()
        	 	 .post();
          response.prettyPrint();

          // Validate response
     response.then()
          		  .statusCode(400); // Assuming 400 is returned for validation errors
                           
      }
    
    @Test(priority = 6)
    public void PostData() {
    	 map.put("firstName", "Vedant");
     	 map.put("lastName", "Kulkarni");
     	 map.put("phone", "912342342345");
     	 map.put("email", "vedantbk@gmail.com");
     	 map.put("password", "Pass@123");
     	 map.put("accountType", "investor");
        Response response = given()
        		.contentType("application/json")
        		.body(map)
        	.when()
        		.post();
        response.prettyPrint();
        response.then()
        		.statusCode(201)
        		.and()
        		.assertThat().body("data.user.firstName", equalTo("Vedant"));
    }

    }

