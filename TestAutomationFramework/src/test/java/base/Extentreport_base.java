package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import endpoints.Routes;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Extentreport_base {

	public static ExtentReports extent  = new ExtentReports();
	public static ExtentSparkReporter spark  = new ExtentSparkReporter("Test Report.html");
	public static ExtentTest test = extent.createTest("Login Test case Report");
	public static ExtentTest test2 = extent.createTest("Api Test case Report");
	@AfterSuite
	public void tearDown() {
		extent.flush();

		
		//System.out.println("Tear down");

	}
	

	
}
