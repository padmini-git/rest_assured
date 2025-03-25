package com.example.restassured.ReportGeneration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTitle {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		System.out.println("title:"+ driver.getTitle());

	}

}
