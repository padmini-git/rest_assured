package com.example.restassured.API;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import java.time.Duration;

public class FileUploadTest {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {		
		driver = new ChromeDriver();
	}

	@Test
	public void testFileUpload() {

		driver.get("https://www.flipkart.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement fileUploadButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fileUpload")));

		fileUploadButton.sendKeys("C:\\Users\\Teja\\Downloads\\file.txt");

	}

	@AfterMethod
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}
	}
}
