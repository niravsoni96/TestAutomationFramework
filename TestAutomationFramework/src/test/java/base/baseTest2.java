package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import endpoints.Routes;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest2 extends Extentreport_base{

	public static WebDriver driver;
	public static Properties p = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr;
	public static FileReader l;
	

	@BeforeMethod
	public void setup() throws IOException {

		if (driver == null) {

			fr = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
			l = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\loactors.properties");
			p.load(fr);
			loc.load(l);
		}
		if (p.getProperty("browser").equalsIgnoreCase("chrome")) {
			
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(p.getProperty("testurl"));
			test.log(Status.INFO, "URL successfully launch");
			

		} else if (p.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(p.getProperty("testurl"));

		}

	}
	@BeforeTest
	public void beforeTest(){
		
		
		extent.attachReporter(spark);

		
		
	}
	@AfterMethod
	public void tearDown() {
//		extent.flush();

		driver.close();
		//System.out.println("Tear down");

	}
}
