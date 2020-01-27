
package MySteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Parameters;


public class CrossBrowser {
	
	@Parameters("browser")
	public WebDriver setup(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\TOSHIBA\\Desktop\\resources\\chromedriver.exe");
			WebDriver driver =  new ChromeDriver(options);
			driver.manage().window().maximize();	
			return driver;
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--disable-notifications");
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\TOSHIBA\\Desktop\\resources\\geckodriver.exe");
			FirefoxDriver firefoxirever = new FirefoxDriver(firefoxOptions);
			firefoxirever .manage().window().maximize();
			return firefoxirever;
			
		}
		throw new IllegalArgumentException("not supported driverd");
	}
	 
}

