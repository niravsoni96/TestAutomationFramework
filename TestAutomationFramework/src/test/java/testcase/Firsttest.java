package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.baseTest;
import utilites.ReadExcel;

public class Firsttest extends baseTest {

	@Test(dataProviderClass = ReadExcel.class, dataProvider = "testdata")
	public static void login(String username, String password) throws InterruptedException {

		System.out.println("Tear down");
		Thread.sleep(2000);
		driver.findElement(By.linkText(loc.getProperty("signin_link"))).click();
		Thread.sleep(2000);
		driver.findElement(By.id(loc.getProperty("login_id"))).sendKeys(username);
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("next_btn"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(loc.getProperty("password"))).sendKeys(password);
		Thread.sleep(5000);
		driver.findElement(By.xpath(loc.getProperty("signin"))).click();
		Thread.sleep(5000);

	}

	

}
