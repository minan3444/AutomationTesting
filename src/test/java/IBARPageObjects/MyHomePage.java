package IBARPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;
import java.util.List;

public class MyHomePage {
	final static Logger log = Logger.getLogger(MyHomePage.class);

    public  WebDriver WebDriver = null;

   public MyHomePage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this); 
    	this.WebDriver = driver;
    }

    
    @FindBy(css=".l_close")
    public static WebElement popUp;
    
    @FindBy(xpath="//a[@class='logo' and@href='/']")
    public WebElement azLanguagelogo;
    
    
    @FindBy(xpath="//a[@class='logo' and@href='/en/']")
    public static WebElement enLanguagelogo;
    
    @FindBy(xpath="//a[@class='logo'  and@href='/ru/']")
    public static WebElement ruLanguagelogo;
    
    @FindBy(xpath="//a[text()='AZ']")
    public WebElement azLanguage;
    
    @FindBy(xpath="//a[text()='RU']")
    public static WebElement ruLanguage;
  
    @FindBy(xpath="//a[text()='EN']")
    public static WebElement enLanguage;
    
    @FindBy(css="input.search_query")
    public static WebElement searchArea;
    
    
    @FindBy(css="div.col.card_block.pull")
    public static List<WebElement> americanExpressCardNumber;
    
    @FindBy(xpath="//b[text()='Order credit online!']")
    public static WebElement orderCreditOnline;	
    
    @FindBy(xpath="//h1[text()='Urgent loan order']")
    public static WebElement urgentLoanOrderWebPage;	
    
    @FindBy(css="input#submitButton")
    public static WebElement submitButton;
    
    @FindBy(xpath="//span[@data-for='name' and text()='*Məlumat düzgün deyil.']")
    public static WebElement validationErroMessageForNameField;
    
    
    @FindBy(xpath="//span[@data-for='surname' and text()='*Məlumat düzgün deyil.']")
    public static WebElement validationErroMessageForSurnameField;
    
    @FindBy(xpath="//span[@data-for='phone' and text()='*Məlumat düzgün deyil.']")
    public static WebElement validationErroMessageForPhoneField;
    
    
    public void waitUntil(WebElement element) {
    	WebDriverWait wait = new WebDriverWait(WebDriver,20);
    	try {
    		wait.until(ExpectedConditions.visibilityOf(element));
    	} catch (WebDriverException e) {
    		log.error("page is not loaded ");
		}	
    }
   
}

    

  
    
   
   
    
   

  
