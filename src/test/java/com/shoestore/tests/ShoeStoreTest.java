package com.shoestore.tests;

import com.shoestore.base.BaseTest;
import com.shoestore.tests.pages.BrandPage;
import com.shoestore.tests.pages.HomePage;
import com.shoestore.tests.pages.MonthPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoeStoreTest extends BaseTest {

    HomePage homePage;
    BrandPage brandPage;
    MonthPage monthPage;

    public ShoeStoreTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        init();
        homePage = new HomePage();
        brandPage = new BrandPage();
        monthPage = new MonthPage();
    }

    @Test(priority = 1)
    public void verifyHome(){
        boolean flag = homePage.isHomeOpen();
        Assert.assertTrue(flag);
    }

    @Test(priority = 2)
    public void remindUserEmail(){
        homePage.setEmail("test@mail.com");
        homePage.clickSubmitBtn();
        String str = homePage.getConfirmation();
        Assert.assertEquals(str,"Thanks! We will notify you of our new shoes at this email: test@mail.com");
    }

    @Test(priority = 3)
    public void enterPromoCode(){
        homePage.setPromoCode("SAVE50");
        homePage.clickPromoButton();
        String msg = homePage.getPromoCodeMsg();
        Assert.assertEquals(msg,"Invalid code format");
    }

    @Test(priority = 4)
    public void selectBrandSearch() throws InterruptedException {
        homePage.setSelectBrandList("Gucci");
        homePage.clickSearchBtn();
        Thread.sleep(6000);
        Boolean brand = brandPage.isSearchResultExists();
        Assert.assertTrue(brand);
        String shoeBrand = brandPage.getShoeName();
        Assert.assertEquals(shoeBrand,"Gucci Noah Crystal dOrsay Pump");
    }

    @Test(priority = 5)
    public void notifyWhenShoeAvailableForFutureMonths() throws InterruptedException {
        homePage.clickFutureMonth();
        Thread.sleep(6000);
        Boolean shoeName = monthPage.isBrandItemDisplayed();
        Assert.assertTrue(shoeName);
        String month = monthPage.getBrandMonth();
        Assert.assertEquals(month,"October");
        monthPage.setUserEmail("test@mail.com");
        monthPage.clickEmailSubmit();
        String notice = monthPage.getFlashNotice();
        Assert.assertEquals(notice,"Thanks! We will notify you when this shoe is available at this email: test@mail.com");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}

