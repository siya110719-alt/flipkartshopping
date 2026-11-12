package PomClasses;

import BasicReusableClass.ReusableClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage_GenralizePage extends ReusableClass
{
    WebDriver driver;
    public HomePage_GenralizePage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
@FindBy(xpath= "//img[contains(@src,'31f7e3af490c225f')]")
WebElement cartIconOnHomePage;
@FindBy(xpath="//img[contains(@src,'5a9ff48eef96b876')]")
WebElement flighticonOnHomePage;
@FindBy(xpath="//span[@class='b3wTlE']")
WebElement closeButtonOnLoginPopUp;
@FindBy(xpath="//img[contains(@src,'89994458b1ea8f83')]")
WebElement cartIconOnTravelPage;
@FindBy(xpath="//input[@class='nw1UBF v1zwn26']")
WebElement searchBar;
@FindBy(css=".VDtK0l")
List<WebElement>listOfwatches;
@FindBy(xpath="//div[text()='Select delivery location']")
WebElement deliveryLocation;
@FindBy(css=".css-11aywtz")
WebElement searchLocation;
@FindBy(xpath="//div[@class='css-146c3p1 r-dnmrzs r-1udh08x r-1udbk01 r-3s2u2q r-1iln25a' and text()=' Hanuman Ward']")
WebElement cityaddress;
public boolean verfifyCarticonDisplay()
{
    return cartIconOnHomePage.isDisplayed();
}
public boolean verfifyTraveliconDisplay()
{
    return flighticonOnHomePage.isDisplayed();
}
public void functionalityCheck(String item,String itemOfChoice)
{
    closeButtonOnLoginPopUp.click();
    flighticonOnHomePage.click();
    cartIconOnTravelPage.click();
    searchBar.sendKeys(item);
    waitForElementToBeVisible(By.xpath("//a[contains(@href,'watches+for+men')]"));
    for(WebElement suggestionsOfWatches:listOfwatches)
    {
        String text=suggestionsOfWatches.getText();
        System.out.println(text);
    }
}
public void verifyScrollingDownandUpOfHomePage()
{
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");   // bottom of page
    js.executeScript("window.scrollTo(0, 0);");                            // top of page
}
public HomePage_fasionPage verifySelectdeliveryLocationClickableOrNot(String cityName)
{
    deliveryLocation.click();
    searchLocation.sendKeys(cityName);
    cityaddress.click();
    HomePage_fasionPage homePage_fasionPage=new HomePage_fasionPage(driver);
 return homePage_fasionPage;
}
}
