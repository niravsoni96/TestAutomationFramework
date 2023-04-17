package testcase;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.google.gson.JsonObject;

import endpoints.UserEndpoints;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payload.Userpayload;


public class Apitest {
	
	Faker fake;
	Userpayload userpayload;
	
	@BeforeClass
	public void Setupdata() {
		fake = new Faker();
		userpayload = new Userpayload();
		userpayload.setUsername(fake.name().username());
		userpayload.setId(fake.idNumber().hashCode());
		userpayload.setFirstName(fake.name().firstName());
		userpayload.setLastName(fake.name().lastName());
		userpayload.setEmail(fake.internet().safeEmailAddress());
		userpayload.setPassword(fake.internet().password(5,10));
		userpayload.setPhone(fake.phoneNumber().cellPhone());
		
		
		
	}
	
	@Test(priority = 1)
	public void createemp() {
		
		Response response=UserEndpoints.createEmp(userpayload);
		response.then().log().all();
		
		 
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	@Test(priority = 2)
	public void getUserbyid() {
		Response response=UserEndpoints.getemp(this.userpayload.getUsername());
		
		
		response.then().log().all();
		
		 
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
}
