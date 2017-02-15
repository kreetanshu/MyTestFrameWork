package com.actitime.universallib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class Driver {
 static WebDriver d1;
  public static WebDriver getBrowser(){
	  if(Constant.browser.equals("FF")){
		  d1= new FirefoxDriver();
	  }
	  else if(Constant.browser.equals("GC")){
		  System.setProperty("webdriver.chrome.driver", ".//exe_files/chromedriver.exe");
		  d1= new ChromeDriver();
	  }
	  else if(Constant.browser.equals("IE")){
		  System.setProperty("webdriver.ie.driver", ".//exe_files/IEDriverServer.exe");
		  d1=new InternetExplorerDriver();
	  }
	  return d1;
  }

}
