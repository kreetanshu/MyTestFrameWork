package com.actitime.universallib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class WebDriverCommonLib {
	public void WaitPageToLoad(){
		Driver.d1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	}
	public void maximizeBrowse(){
		Driver.d1.manage().window().maximize();
	}
   public void acceptAlert(){
	Alert a1=Driver.d1.switchTo().alert();
	a1.accept();
    }
   public void cancelAlert(){
	Driver.d1.switchTo().alert().dismiss();
    }
   public void selectDropDown(WebElement dd,String vbtext){
	Select s1=new Select(dd);
	s1.selectByVisibleText(vbtext);
    }
   public void verifyTitle(String expTitle){
	String actTitle=Driver.d1.getTitle();
	Assert.assertEquals(expTitle, actTitle);
	System.out.println("expected title "+expTitle+"is matching actualtitle "+actTitle);
   }
}
