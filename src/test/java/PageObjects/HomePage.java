package PageObjects;

import org.openqa.selenium.Alert;
import PageObjects.LoggerHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.junit.Assert;

import MySteps.StepDefinitions;

import com.cucumber.listener.Reporter;

import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.util.List;

public class HomePage {
	final static Logger log = Logger.getLogger(HomePage.class);

    public  WebDriver WebDriver = null;

    public HomePage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this); 
    	this.WebDriver = driver;
    }

    @FindBy(id = "not-logged-in-container")
    public static  WebElement girisYap;

    @FindBy(id = "email")
    public static   WebElement email;
    
    @FindBy(id = "password")
    public static  WebElement password;
    
    @FindBy(id = "loginSubmit")
    public WebElement loginSubmit;
    
    @FindBy(css = "#accountBtn")
    public static WebElement hesabım;
    
    @FindBy(css=".fancybox-item.fancybox-close")
    public static WebElement popUp;
    
    @FindBy(xpath="//div[@title='Kapat']")
    public static WebElement notificationPopUpClose;
    
    @FindBy(xpath="//div[@class='notification-popup-container']/div/div")
    public static List<WebElement> notificationPopUp;
    
    @FindBy(css="div.p-card-wrppr")
    public static List<WebElement> specificProductList;
    
    @FindBy(xpath="//div[text()='Sepete Ekle']")
    public  WebElement addToBasket;
    
    @FindAll({
            @FindBy(css = ".tab-link.active"),
            @FindBy(css = ".tab-link")
    })
    public List<WebElement> tabLinks;
    
    @FindBy(id = "logo")
    public static WebElement trendyolLogo;

    @FindAll({
            @FindBy(css = "li.tab-link"),
    })
    public static List<WebElement> butiktabLink;

    @FindBy(xpath="//article[@class='component-item']/a/span/img[@src]")
    public static List<WebElement> productImages;
    
    public void tabLoaded(int i) throws InterruptedException {
    	List<WebElement> elements =tabLinks;
    	WebElement tab = elements.get(i);
    	waitUntil(tab);
    	tab.click();
    }
    
    public void refresh() {

    	WebDriver.navigate().refresh();
    }
    
    public void sendKeysEnter(WebElement element) {
    	waitUntil(element);
    	element.sendKeys(Keys.ENTER);
    }
    
    public void anaSayfaYenile() {
    	trendyolLogo.click();
    }
      
    public boolean login() throws InterruptedException {
    	waitUntil(email);
    	email.sendKeys("minann38@gmail.com");
    	password.sendKeys("15505018");
    	waitUntil(loginSubmit); 
    	loginSubmit.click();
    	if(!hesabım.isDisplayed()){
    		loginSubmit.click();
  		}
    	Thread.sleep(5000);
    	return true;
    }

    public void waitUntil(WebElement element) {
    	WebDriverWait wait = new WebDriverWait(WebDriver,5);
    	try {
    		wait.until(ExpectedConditions.visibilityOf(element));
    	} catch (WebDriverException e) {
    		log.error("page is not loaded ");
		}	
    }

    public static void Hover(WebDriver driver, WebElement element) {
    	Actions action = new Actions(driver);
    	action.moveToElement(element).perform();
    }
    
    public static void doubleClick (WebDriver driver,WebElement element) {
    	Actions action=new Actions(driver);
    	action.doubleClick(element).perform();
    }
  
    public  void scrollDownSeeElement(WebDriver driver,WebElement element){
    	JavascriptExecutor js = (JavascriptExecutor) driver;		
    	js.executeScript("arguments[0].scrollIntoView();", element);
    }   
   
}

    

  
    
   
   
    
   

  
