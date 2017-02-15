package com.actitime.pagelib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver d1;
public LoginPage(WebDriver d1){
	this.d1=d1;
	PageFactory.initElements(d1, this);
}

@FindBy(name="username")
WebElement userNameTextBox;

@FindBy(name="pwd")
WebElement pwdTextBox;

@FindBy(xpath=".//input[@type='submit']")
WebElement loginButton;

public void clickOnLogin(String un, String pwd){
	userNameTextBox.sendKeys(un);
	pwdTextBox.sendKeys(pwd);
	loginButton.click();
}

}
