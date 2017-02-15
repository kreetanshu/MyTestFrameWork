package com.actitime.pagelib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
WebDriver d1;
	public BasePage(WebDriver d1){
		this.d1 =d1;
		PageFactory.initElements(d1, this);
	}

@FindBy(partialLinkText="Users")
WebElement userlink;

@FindBy(className="logoutImg")
WebElement logout;

public void clickOnUser(){
	userlink.click();
}

public void logout(){
	logout.click();
}

}
