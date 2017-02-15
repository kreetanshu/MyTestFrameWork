package com.actitime.userTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.actitime.pagelib.AddNewUserPage;
import com.actitime.pagelib.BasePage;
import com.actitime.pagelib.EditUserPage;
import com.actitime.pagelib.LoginPage;
import com.actitime.pagelib.UserPage;
import com.actitime.universallib.Constant;
import com.actitime.universallib.Driver;
import com.actitime.universallib.WebDriverCommonLib;

public class EditUserTest_01 {

 WebDriver d1;
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
	public void EditAllUserTc_01(){
		LoginPage lb = new LoginPage(d1);
	    UserPage up = new UserPage(d1);
	    BasePage bp = new BasePage(d1);
	    AddNewUserPage anup = new AddNewUserPage(d1);
	    EditUserPage ep= new EditUserPage(d1);
	    lb.clickOnLogin(Constant.un, Constant.pwd);
	    bp.clickOnUser();
	    up.editUser();
	}
}
