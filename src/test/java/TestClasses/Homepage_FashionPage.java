package TestClasses;

import BasicTestsClasses.BaseTest;
import PomClasses.HomePage_fasionPage;
import org.testng.annotations.Test;
public class Homepage_FashionPage extends BaseTest
{
    @Test
    public void fashionpageVerifiation()
    {
        HomePage_fasionPage homePage_fasionPage=new HomePage_fasionPage(driver);
        homePage_fasionPage.verifyFasionPageOnHomePage();
    }

}
