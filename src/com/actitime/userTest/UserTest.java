package com.actitime.userTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.actitime.universallib.Constant;
import com.actitime.universallib.Driver;
import com.actitime.universallib.ExcelLib;
import com.actitime.universallib.WebDriverCommonLib;


public class UserTest {

@Test	
public static void addUserTest(){

ExcelLib elib = new ExcelLib();

try {
	String un = elib.getExcelData("Sheet1", 1, 0);
	String pwd = elib.getExcelData("Sheet1", 1, 1);
	String repwd = elib.getExcelData("Sheet1", 1, 2);
	String fn=elib.getExcelData("Sheet1", 1, 3);
	String ln=elib.getExcelData("Sheet1", 1, 4);
	String emailid = elib.getExcelData("Sheet1", 1, 5);
	String exp_res = elib.getExcelData("Sheet1", 1, 6);
	System.out.println("Username is "+un);
	System.out.println("Password is "+pwd);
	//elib.setExcelData("Sheet1", 1, 6, "pass");
	WebDriver d1= Driver.getBrowser();
	//d1.get(Constant.url);
	//d1.quit();
	//step:2 login
	WebDriverCommonLib wlib=new WebDriverCommonLib();
	d1.get(Constant.url);
	wlib.WaitPageToLoad();
	wlib.maximizeBrowse();
	d1.findElement(By.name("username")).sendKeys(Constant.un);;
	d1.findElement(By.name("pwd")).sendKeys(Constant.pwd);;
	d1.findElement(By.xpath(".//input[@type='submit']")).click();
	d1.findElement(By.partialLinkText("Users")).click();
	d1.findElement(By.xpath(".//input[@value='Add New User']")).click();
	d1.findElement(By.name("username")).sendKeys(un);
	d1.findElement(By.name("passwordText")).sendKeys(pwd);
	d1.findElement(By.name("passwordTextRetype")).sendKeys(repwd);
	d1.findElement(By.name("firstName")).sendKeys(fn);
	d1.findElement(By.name("lastName")).sendKeys(ln);
	d1.findElement(By.name("email")).sendKeys(emailid);
	d1.findElement(By.xpath("//input[@type='submit']")).click();
	
	
	//step 4:validate
			String actText=d1.findElement(By.xpath("//span[@class='successmsg']")).getText();
			elib.setExcelData("Sheet1", 1, 8, actText);
			Assert.assertEquals(actText	, exp_res);
	        System.out.println(exp_res+" is matching with "+actText);
	        elib.setExcelData("Sheet1",1,9,"pass");
	
	
	
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

}
