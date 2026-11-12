package BasicTestsClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BaseTest
{
    public WebDriver driver;
    @BeforeMethod
    public void initializBrowser() throws IOException {
        Properties prop=new Properties();
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//Global.properties");
        prop.load(fis);
        String browserName=System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome"))
        {
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.default_content_setting_values.geolocation", 2);
            options.setExperimentalOption("prefs", prefs);
            driver = new ChromeDriver(options);
        }
        else if(browserName.equalsIgnoreCase("firefox"))
        {
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("permissions.default.geo", 2);   // 2 = block
            driver = new FirefoxDriver(options);
        }
        else
        {
            EdgeOptions options = new EdgeOptions();
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.default_content_setting_values.geolocation", 2);
            options.setExperimentalOption("prefs", prefs);
            driver = new EdgeDriver(options);
        }
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
}
