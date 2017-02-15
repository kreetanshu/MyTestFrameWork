package com.actitime.pagelib;

import org.apache.poi.ss.usermodel.DateUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditUserPage {
	WebDriver dr;
	
	public EditUserPage(WebDriver dr){
		this.dr=dr;
		PageFactory.initElements(dr, this);
	}
	
@FindBy(name="phone")
WebElement phonenum;

@FindBy(xpath=".//*[@id='ButtonPane']/input[1]")
WebElement savebtn;

public void enterPhone(){
	int count=1;
	phonenum.sendKeys(String.valueOf(count));
	count++;
}
public void saveUpdate(){
	savebtn.click();
}
}
