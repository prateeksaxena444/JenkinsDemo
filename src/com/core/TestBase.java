package com.core;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.utility.ReadExcel;

public class TestBase {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//open browser and launched website
		System.setProperty("webdriver.chrome.driver","G:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        String baseUrl = "https://phptravels.org/clientarea.php";
        driver.get(baseUrl);
        String actualTitle = driver.getTitle();
        String expectedTitle="Client Area - PHPTRAVELS";
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("website launched");
        } else {
            System.out.println("error in launching website");
            System.exit(0);
        }
        
        ReadExcel re=new ReadExcel();
        re.readExcel("G:\\Workspace\\SeleniumFramework\\src\\com\\data","Data.xlsx","operation",driver);
        
       
        //close browser
        driver.close();
		
		
		
	}

}
