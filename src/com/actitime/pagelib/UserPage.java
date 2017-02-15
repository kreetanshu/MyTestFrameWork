package com.actitime.pagelib;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.universallib.ExcelLib;

public class UserPage extends BasePage {
	WebDriver d1;
public UserPage(WebDriver d1){
	super(d1);
	this.d1=d1;
	PageFactory.initElements(d1, this);
}

@FindBy(xpath=".//input[@value='Add New User']")
WebElement addNewUser;

@FindBy(xpath=".//a[contains(text(),'kiran')]")
WebElement userlink;

public void addNewUser(){
	addNewUser.click();
}

public void editUser(){
	
	EditUserPage ep= new EditUserPage(d1);
	
		System.out.println(userlink.getText());
		userlink.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ep.enterPhone();
		ep.saveUpdate();
		ExcelLib xl = new ExcelLib();
		Object[][] arr= new Object[2][1];
		try {
			System.out.println(xl.getExcelData("Sheet1", 1, 1));
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(arr);
}


}
