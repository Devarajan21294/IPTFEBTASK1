package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Base.Base_Class;

public class TestClass extends Base_Class {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		launchBrowser("chrome");
		launchUrl("https://letcode.in/dropdowns");
		
		WebElement element = driver.findElement(By.id("fruits"));
		selectOptions(element, "index", "1");
		navigateTo("https://letcode.in/edit");
		WebElement textField = driver.findElement(By.id("fullName"));
		passInput(textField, "Rose");
		navigateMethod("back");
		navigateMethod("forward");
		navigateMethod("refresh");
		getUrl();
		getTitle();
		System.out.println("Current URL: " + getUrl());
		System.out.println("Page Title: " + getTitle());
		navigateTo("https://letcode.in/alert");
		WebElement buttonClick= driver.findElement(By.id("confirm"));
		buttonClick.click();
		alertHandling("accept");
		buttonClick =  driver.findElement(By.id("confirm"));
		buttonClick.click();
		Thread.sleep(3000);
		alertHandling("dismiss");
	    Thread.sleep(3000);
		
		takeScreenShot("after alert");
		browserTerminate();

	}


}
