package PomClasses;

import BasicReusableClass.ReusableClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_fasionPage extends ReusableClass
{
    WebDriver driver;
    public HomePage_fasionPage(WebDriver driver)
    {
       super(driver);
       this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//a[ .//*[normalize-space()='Fashion']  or  normalize-space()='Fashion' ]")
    WebElement fashionTab;
    @FindBy(xpath="//h1[text()='Fashion']")
    WebElement fashionIcon;
    @FindBy(xpath="//div[text()='Korean Store ']")
    WebElement koreanStore;
    @FindBy(css="span[role='button']")
    WebElement loginPopUp;
    public void verifyFasionPageOnHomePage()
    {
        loginPopUp.click();
        fashionTab.click();
        waitForElementToBeVisible(By.xpath("//h1[text()='Fashion']"));
        System.out.println(fashionIcon.getText());
        fashionIcon.click();
        koreanStore.click();

    }
}
