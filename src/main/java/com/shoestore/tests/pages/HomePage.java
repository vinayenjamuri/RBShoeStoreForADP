package com.shoestore.tests.pages;

import com.shoestore.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BaseTest {

    @FindBy(xpath="//*[@id=\"home_link_div\"]/a")
    WebElement home;

    @FindBy(name="email")
    WebElement email;

    @FindBy(id="remind_email_submit")
    WebElement submitBtn;

    @FindBy(xpath="//*[@id=\"flash\"]/div")
    WebElement sentConfirmation;

    @FindBy(name="promo_code")
    WebElement promoCode;

    @FindBy(id="promo_code_submit")
    WebElement promoSubBtn;

    @FindBy(xpath = "//*[@id=\"flash\"]/div")
    WebElement promoCodemsg;

    @FindBy(xpath = "//*[@id=\"brand\"]")
    WebElement selectBrandList;

    @FindBy(id = "search_button")
    WebElement searchBtn;

    @FindBy(xpath = "//*[@id=\"header_nav\"]/nav/ul/li[10]/a")
    WebElement futureMonth;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public boolean isHomeOpen(){
        return home.isDisplayed();
    }

    public void clickHome() {
        home.click();
    }

    public void setEmail(String e) {
        email.sendKeys(e);
    }

    public void clickSubmitBtn() {
        submitBtn.click();
    }

    public String getConfirmation(){
        return sentConfirmation.getText();
    }

    public void setPromoCode(String code){
        promoCode.sendKeys(code);
    }

    public void clickPromoButton(){
        promoSubBtn.click();
    }

    public String getPromoCodeMsg(){
        return promoCodemsg.getText();
    }
    public void setSelectBrandList(String brand){
        Select b = new Select(selectBrandList);
        b.selectByValue(brand);
    }
    public void clickSearchBtn(){
        searchBtn.click();
    }

    public void clickFutureMonth(){
        futureMonth.click();
    }

}
