package com.shoestore.tests.pages;

import com.shoestore.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.event.HyperlinkListener;

public class BrandPage extends BaseTest {

    @FindBy(id = "shoe_list")
    WebElement searchResult;

    @FindBy(xpath = "//*[@id=\"gucci_gucci_noah_crystald_orsay_pump\"]/div/table/tbody/tr[2]/td[2]")
    WebElement shoeName;

    public BrandPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean isSearchResultExists(){
        return searchResult.isDisplayed();
    }

    public String getShoeName(){
        return shoeName.getText();
    }

}
