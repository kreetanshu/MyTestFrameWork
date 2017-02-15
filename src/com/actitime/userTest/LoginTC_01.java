package com.actitime.userTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.actitime.pagelib.AddNewUserPage;
import com.actitime.pagelib.BasePage;
import com.actitime.pagelib.LoginPage;
import com.actitime.pagelib.UserPage;
import com.actitime.universallib.Constant;
import com.actitime.universallib.Driver;
import com.actitime.universallib.ExcelLib;
import com.actitime.universallib.WebDriverCommonLib;


public class LoginTC_01{
static WebDriver d1;
@BeforeTest
public void operBrowser(){
	//Step2: Launching url and loging in	
	d1=Driver.getBrowser();
	WebDriverCommonLib wlib=new WebDriverCommonLib();
	d1.get(Constant.url);
	wlib.maximizeBrowse();
	wlib.WaitPageToLoad();
}

@Test
public void TC_01() throws EncryptedDocumentException, InvalidFormatException, IOException{
	ExcelLib elib = new ExcelLib();
//reading excel data
	String un = elib.getExcelData("Sheet1", 1, 0);
	String pwd = elib.getExcelData("Sheet1", 1, 1);
	String repwd = elib.getExcelData("Sheet1", 1, 2);
	String fn=elib.getExcelData("Sheet1", 1, 3);
	String ln=elib.getExcelData("Sheet1", 1, 4);
	String emailid = elib.getExcelData("Sheet1", 1, 5);
	String exp_res = elib.getExcelData("Sheet1", 1, 6);
	System.out.println("Username is "+un);
	System.out.println("Password is "+pwd);
	
// Creating ref variables for POM
    LoginPage lb = new LoginPage(d1);
    UserPage up = new UserPage(d1);
    BasePage bp = new BasePage(d1);
    AddNewUserPage anup = new AddNewUserPage(d1);

//Performing actions
    lb.clickOnLogin(Constant.un, Constant.pwd);
    bp.clickOnUser();
    up.addNewUser();
    anup.addUser(un, pwd, repwd,fn,ln,emailid);

    String act_res= anup.succmsg();

//Step3: Validation
try {
	Assert.assertEquals(act_res	, exp_res);
	System.out.println(exp_res+" is matching with "+act_res);
	elib.setExcelData("Sheet1", 1, 8, act_res);
	elib.setExcelData("Sheet1",1,9,"pass");
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	elib.setExcelData("Sheet1",1,9,"Fail");
}
}
@AfterTest
public void afterAddnewUser(){
	BasePage bp = new BasePage(d1);
	bp.logout();
	d1.close();
}
}
