package TestCase;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class searchLaptop {
    public static WebDriver driver;
    WebDriverWait wait;

    @Given("Anasayfa yüklenir")
    public void homePage(){

        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.hepsiburada.com/");
        Assert.assertEquals("Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com", driver.getTitle());

    }

    @When("Laptop arması yapılır")
    public void searchLaptop(){

        WebElement searchData = driver.findElement(By.cssSelector("div[class='theme-PWhtyMC28ov8fuPKvrog']"));
        searchData.click();
        searchData.sendKeys("Laptop");
        searchData.sendKeys(Keys.ENTER);
    }

    @And("Ürüne tıklanır")
    public void clickProduct(){

        List<WebElement> elements = driver.findElements(By.className("moria-ProductCard-bOkJXM edIrcv seupogy7xui"));
        elements.get(2).click();
    }

    @Then("Anasayfaya dönülür")
    public void returnHomePage(){

        driver.findElement(By.className("sf-OldHeader-FpTYTu4Avgrxt5ZgRSEL"));
        Assert.assertEquals("Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com", driver.getTitle());
        driver.quit();
    }
}
