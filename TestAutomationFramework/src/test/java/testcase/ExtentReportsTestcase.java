package testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import base.baseTest2;
import utilites.ReadExcel;

public class ExtentReportsTestcase extends baseTest2 {

	@Test(dataProviderClass = ReadExcel.class, dataProvider = "testdata")
	public static void login(String username, String password) throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.linkText(loc.getProperty("signin_link"))).click();
		test.info("click on sign link");
		Thread.sleep(2000);
		driver.findElement(By.id(loc.getProperty("login_id"))).sendKeys(username);

		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("next_btn"))).click();
		test.info("click on next button");
		Thread.sleep(5000);
		boolean eleSelected = driver.findElement(By.xpath(loc.getProperty("password"))).isDisplayed();

		if (eleSelected == true) {
			driver.findElement(By.xpath(loc.getProperty("password"))).sendKeys(password);
			Thread.sleep(5000);

			driver.findElement(By.xpath(loc.getProperty("signin"))).click();
			Thread.sleep(5000);

		} else if (driver.findElement(By.xpath(loc.getProperty("limit_text"))).isDisplayed() == true
				&& driver.findElement(By.xpath(loc.getProperty("limit_text"))).getText()
						.equals("You've reached your daily sign-in limit. Learn why?")) {

			test.pass(username + " " + "Username is successfully log into the system");
		}

		else {
			test.fail(username + " " + "Username is wrong or Password field is not visible");
			Assert.fail(username + " " + "Username is wrong or Password field is not visible");

		}

	}

}
