package testcase;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import com.google.gson.JsonObject;

import base.Extentreport_base;
import base.baseTest2;
import endpoints.UserEndpoints;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payload.Userpayload;


public class ApitestExtentReport extends Extentreport_base{
	
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
		
		test2.log(Status.INFO, "Create employee Api calling");
		Response response=UserEndpoints.createEmp(userpayload);
		
		response.then().log().all();
		
		if(response.getStatusCode()==200) {
		Assert.assertEquals(response.getStatusCode(), 200);
		test2.pass("Create employee Api is call succeeded ");
		}else {
			test2.fail("Create employee Api is call not succeeded ");
		}
		
	}
	@Test(priority = 2)
	public void getUserbyid() {
		test2.log(Status.INFO, "Get employee details Api calling");
		Response response=UserEndpoints.getemp(this.userpayload.getUsername());
		
		
		response.then().log().all();
		
		if(response.getStatusCode()==200) {
		Assert.assertEquals(response.getStatusCode(), 200);
		test2.pass("Get employee details Api is call succeeded ");
		}else {
			test2.fail("Get employee Api is call not succeeded ");
		}
		
	}
}
