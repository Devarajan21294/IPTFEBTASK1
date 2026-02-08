package com.Base;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_Class {
	public static WebDriver driver;

	protected static void launchBrowser(String browserName) {
		try {
			if(browserName.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
			
			}else if (browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}else if(browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
				}

		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR WHEN BROWSER LAUNCH");
		}
		driver.manage().window().maximize();

	}
	protected static void launchUrl(String url) {
		try {
		driver.get(url);
		} catch (Exception e) {
			
			Assert.fail("ERROR: OCCUR WHEN URL LAUNCH");
		}
	}
	protected static void passInput(WebElement element ,String value ) {
		try {
		element.sendKeys(value);
		} catch (Exception e) {
			
			Assert.fail("ERROR: OCCUR WHEN VAUE PASSED");
		}
	}
	protected static void browserTerminate() {
		try {
		driver.quit();
		} catch (Exception e) {
		
			Assert.fail("ERROR: OCCUR DURING BROWSER TERMINATED");
		}
}
	 protected static void selectOptions( WebElement element, String type,String value ) {
		try {
			Select select =new Select(element);
		if(type.equalsIgnoreCase("text")) {
			select.selectByVisibleText(value);}
			else if(type.equalsIgnoreCase("index")) {
				select.selectByIndex(Integer.parseInt(value));
			}else if(type.equalsIgnoreCase("value")) {
				select.selectByValue(value);
		}
				
		} catch (Exception e) {
			
			Assert.fail("ERROR: OCCUR DURING VALUE SELECTION");
		}	
	}
	
	 
	 protected static void navigateTo(String url) {
		 try {
			driver.navigate().to(url);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING NAVIGATION TO URL");
		}
	 }
	 protected static void navigateMethod(String type) {
		 try {
			 if (type.equalsIgnoreCase("back")) {
			driver.navigate().back();
		}else if(type.equalsIgnoreCase( "forward")) {
			driver.navigate().forward();
		} else if (type.equalsIgnoreCase("refresh")) {
            driver.navigate().refresh();
        }}

			 catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING NAVIGATION BACk");
		}
	 }
	 protected static String getUrl(){
		 try {  return  driver.getCurrentUrl();
					
			
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING GETURL");
		}
		 return null;
		 
	 }
	 protected static String getTitle(){ 
		 try {
return driver.getTitle();
			 
			
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING GET TITLE");
		 
	 }
		 return null;
}
	 protected static void alertHandling(String action) {
		    try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		        if (action.equalsIgnoreCase("accept")) {
		            alert.accept();
		            System.out.println("Alert accepted");
		        } else if (action.equalsIgnoreCase("dismiss")) {
		            alert.dismiss();
		            System.out.println("Alert dismissed");
		        }
		    } catch (Exception e) {
		        Assert.fail("ERROR: OCCURRED DURING ALERT HANDLE: " + e.getMessage());
		    }
		}

	
	 protected static void clickElement(WebElement element) {
		 try {
			element.click();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING CLICK ELEMENT");
		}
	 }
	 protected static String  getText(WebElement element ) {
		 try {
			String text= element.getText();
			System.out.println(text);
			return text;
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING TEXT GETTING");
			return null;
		}
	 }
		 protected static void takeScreenShot(String name) {
			 try {

				 TakesScreenshot ts = (TakesScreenshot)driver;
				
		            File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		            String destinationPath = "C:\\Users\\admin\\eclipse-workspace\\Maven_Project/selenium_screenshot.png";
		            File destinationFile = new File(destinationPath);

		            FileUtils.copyFile(sourceFile, destinationFile);
		            
		            System.out.println("Screenshot saved to: ");
			} catch (Exception e) {
				Assert.fail("ERROR: OCCUR DURING SCREENSHOT");
			}
		 
}
	

}
