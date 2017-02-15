package com.actitime.pagelib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewUserPage {
	WebDriver d1;
public AddNewUserPage(WebDriver d1){
	this.d1=d1;
	PageFactory.initElements(d1, this);
     }	
@FindBy(name="username")
WebElement uname;

@FindBy(name="passwordText")
WebElement password;

@FindBy(name="passwordTextRetype")
WebElement passRetype;

@FindBy(name="firstName")
WebElement fname1;

@FindBy(name="lastName")
WebElement lname1;

@FindBy(name="email")
WebElement email1;

@FindBy(xpath="//input[@type='submit']")
WebElement submitBtn;

@FindBy(xpath=".//table[@id='ErrorsTable']/tbody/tr/td[2]/table/tbody/tr/td/span")
WebElement errormsg;

@FindBy(xpath="//span[@class='successmsg']")
WebElement successmsg;

public void addUser(String un,String pwd, String rpwd,String fname,String lname,String email){
	uname.sendKeys(un);
	password.sendKeys(pwd);
	passRetype.sendKeys(rpwd);
	fname1.sendKeys(fname);
	lname1.sendKeys(lname);
	email1.sendKeys(email);
	submitBtn.click();
}



public String errormsg(){
 return	errormsg.getText();
}

public String succmsg(){
	return successmsg.getText();
}

}
