package com.module;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.ReadExcel;

public class CommonUtility {
	
	ReadExcel re=new ReadExcel();

	public void register(WebDriver driver) throws IOException
	{
		
	System.out.println("Registration started");
	driver.findElement(By.linkText("Register")).click();
	driver.switchTo().window(driver.getWindowHandle());
	String title = driver.getTitle();
	System.out.println(title);
	
	
	System.out.println(re.readRegistrationDetails("G:\\Workspace\\SeleniumFramework\\src\\com\\data","Data.xlsx","registration_details",driver,"Company"));
	
	}
	
	public void login()
	{
		System.out.println("login in progress");
	}
}
