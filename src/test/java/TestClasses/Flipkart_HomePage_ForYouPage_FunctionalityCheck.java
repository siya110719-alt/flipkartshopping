package TestClasses;

import BasicTestsClasses.BaseTest;
import PomClasses.HomePage_GenralizePage;
import PomClasses.HomePage_fasionPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Flipkart_HomePage_ForYouPage_FunctionalityCheck extends BaseTest
{
    @Test
    public void homePageFunctionalityCheck()
    {
        HomePage_GenralizePage homePage=new HomePage_GenralizePage(driver);
        Assert.assertTrue(homePage.verfifyCarticonDisplay(),"Flipkart icon is not displayed");
        Assert.assertTrue(homePage.verfifyTraveliconDisplay(),"Travel icon not displayed");
        homePage.functionalityCheck("watches","watches for men");
        homePage.verifyScrollingDownandUpOfHomePage();
        homePage.verifySelectdeliveryLocationClickableOrNot("pusad");




    }
}
