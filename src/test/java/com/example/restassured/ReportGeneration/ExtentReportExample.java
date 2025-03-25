package com.example.restassured.ReportGeneration;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportExample {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;

	public static void main(String[] args) {

		// ExtentHtmlReporter htmlReporter = new
		// ExtentHtmlReporter("extentReport.html"); deprecated after version 4.0.0
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("Spark.html");
		extent = new ExtentReports();
		extent.attachReporter(extentSparkReporter);

		driver = new ChromeDriver();

		test = extent.createTest("Google Search Test", "This is a test to search on Google and validate results");

		try {

			driver.get("https://www.google.com");
			test.pass("Navigated to Google homepage");

			WebElement searchBox = driver.findElement(By.name("q"));
			searchBox.sendKeys("Selenium WebDriver");
			test.pass("Entered text into search box");

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));

			// WebElement searchButton = driver.findElement(By.name("btnK"));
			searchButton.click();
			test.pass("Clicked on the search button");
			System.out.println("Title:" + driver.getTitle());

			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

			WebElement secondResultLink = wait1.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id='rso']//h3)[2]/parent::a")));
			secondResultLink.click();
			test.pass("Clicked on the second search result");

			String newPageTitle = driver.getTitle();
			System.out.println("Title of the new page: " + newPageTitle);

			if (newPageTitle.contains("Selenium")) {
				test.pass("Successfully opened the Selenium page with the correct title: " + newPageTitle);
			} else {
				test.fail("The title of the new page is incorrect: " + newPageTitle);
			}

		} catch (Exception e) {
			test.fail("Test failed with exception: " + e.getMessage());
		} finally {

			driver.quit();
			extent.flush();
		}
	}
}
