package com.shoestore.tests.pages;

import com.shoestore.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonthPage extends BaseTest {

    @FindBy(xpath="//*[@id=\"charlotte_olympia_charlotte_olympia_cherie_sandal\"]/div/table/tbody/tr[1]/td[2]/a")
    WebElement brandItem;

    @FindBy(xpath="//*[@id=\"charlotte_olympia_charlotte_olympia_cherie_sandal\"]/div/table/tbody/tr[7]/td/form/input[1]")
    WebElement userEmail;

    @FindBy(xpath="//*[@id=\"charlotte_olympia_charlotte_olympia_cherie_sandal\"]/div/table/tbody/tr[7]/td/form/input[2]")
    WebElement emailSubmit;

    @FindBy(xpath="//*[@id=\"charlotte_olympia_charlotte_olympia_cherie_sandal\"]/div/table/tbody/tr[5]/td[2]/a")
    WebElement brandMonth;

    @FindBy(xpath = "//*[@id=\"flash\"]/div")
    WebElement flashNotice;

    public MonthPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean isBrandItemDisplayed(){
      return   brandItem.isDisplayed();
    }
    public void setUserEmail(String e){
        userEmail.sendKeys(e);
    }
    public void clickEmailSubmit(){
        emailSubmit.click();
    }

    public String getBrandMonth(){
        return brandMonth.getText();
    }

    public String getFlashNotice(){
        return flashNotice.getText();
    }
}
