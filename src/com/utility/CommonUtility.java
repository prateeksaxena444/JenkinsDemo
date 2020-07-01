package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CommonUtility {
	 static WebDriver driver = null;
	
	public static WebDriver OpenApp(String BrowserName, String url){
		fn_LaunchBrowser(BrowserName);
		fn_OpenURL(url);
		return driver;
		}
		public static void fn_OpenURL(String url){
		driver.get(url);
		driver.manage().window().maximize();
		}
		 
		public static WebDriver fn_LaunchBrowser(String browsername){
		if(browsername=="CH"){
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		}else if(browsername=="FF"){
		driver= new FirefoxDriver();
		}else if(browsername=="IE"){
		System.setProperty("webdriver.ie.driver", "Drivers\\IEDriverServer.exe");
		driver= new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		return driver;
		}
		
		public static void MouseOver(WebElement we){
			Actions actObj=new Actions(driver);
			actObj.moveToElement(we).build().perform();
			}
		
		public static String fn_TakeSnapshot(WebDriver driver, String DestFilePath) throws IOException{
			String TS=fn_GetTimeStamp();
			TakesScreenshot tss=(TakesScreenshot) driver;
			File srcfileObj= tss.getScreenshotAs(OutputType.FILE);
			DestFilePath=DestFilePath+TS+".png";
			File DestFileObj=new File(DestFilePath);
			//FileUtils.copyFile(srcfileObj, DestFileObj);
			return DestFilePath;
			}
		
		public static String fn_GetTimeStamp(){
			DateFormat DF=DateFormat.getDateTimeInstance();
			Date dte=new Date();
			String DateValue=DF.format(dte);
			DateValue=DateValue.replaceAll(":", "_");
			DateValue=DateValue.replaceAll(",", "");
			return DateValue;
			}
		
		public static void fn_SelectVT(WebElement WE, String VisibleText){
			Select selObj=new Select(WE);
			selObj.selectByVisibleText(VisibleText);
			}
			 
			//select the dropdown using "select by index", so pass IndexValue as '2'
			public static void fn_Select(WebElement WE, int IndexValue){
			Select selObj=new Select(WE);
			selObj.selectByIndex(IndexValue);
			}
			 
			//select the dropdown using "select by value", so pass Value as 'thirdcolor'
			public static void fn_SelectV(WebElement WE, String Value){
			Select selObj=new Select(WE);
			selObj.selectByValue(Value);
			}
			
			
		
		
		

}
