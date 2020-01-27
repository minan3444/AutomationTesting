package MySteps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import manager.RandomItemDetailManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import PageObjects.HomePage;
import PageObjects.LoggerHelper;

public class StepDefinitions {

	public static  WebDriver driver;
	Logger log = LoggerHelper.getLogger(StepDefinitions.class);

	@Before 
	public void StartUp() {
		log.info("before method is started");
		CrossBrowser choosBrowser = new CrossBrowser(); 
		driver = choosBrowser.setup("chrome");
		log.info("before method is finish");
	}   
	
	@After
	public void tearDown() {
		
		
		//driver.close();
		 //driver.quit();
	}

	@Given("^Trendyol sayfasını tarayıcıda açarım$")
	public void trendyol_sayfasını_tarayıcıda_açarım() throws InterruptedException {
		log.info("given schenaryo start");
		HomePage homePage = new HomePage(driver);
		driver.navigate().to("https://www.trendyol.com/");
		if(homePage.popUp.isDisplayed()){
		  homePage.waitUntil(homePage.popUp);	
		  homePage.popUp.click();
		}
     }
	
	@And("^Giriş yap butonuna tıklarsam$")
	public void giriş_yap_butonuna_tıklarsam() throws Throwable {
		HomePage homePage = new HomePage(driver);
		homePage.waitUntil(homePage.girisYap);
		homePage.girisYap.click();
	}

	@And("^Sisteme kayıtlı birkullanıcı ile giriş yapılırsa$")
	public void sisteme_kayıtlı_birkullanıcı_ile_giriş_yapılırsa() throws Throwable {
		HomePage homePage = new HomePage(driver);
		homePage.login();
		homePage.refresh();
		homePage.waitUntil(homePage.hesabım);
		Assert.assertEquals(true, homePage.hesabım.isDisplayed());
		}
	
	@Then("^Ana sayfada tabların yüklenip yüklenmediğinin kontrolü yapılır$")
	public void ana_sayfada_tabların_yüklenip_yüklenmediğinin_kontrolü_yapılır() throws Throwable {
		HomePage homePage = new HomePage(driver);
		int butiksayisi=homePage.tabLinks.size();
        for (int i = 1; i < butiksayisi; i++) {
        	homePage.refresh(); 
			homePage.tabLoaded(i);	
		}
        log.info("Butik tablari yuklendi");
	}	

	@And("^rastgele bir butiğe gidilerek ürün görsellerinin yüklendiği görülür$")
	public void rastgele_bir_butiğe_gidilerek_ürün_görsellerinin_yüklendiği_görülür() throws Throwable {
		int rastgeleButik = (int)(Math.random()*(10))+1;
		HomePage homePage = new HomePage(driver);
		Thread.sleep(5000);
		homePage.tabLoaded(rastgeleButik);
	}

	@And("^rastgele bir ürün detayına gidilir$")
	public void rastgele_bir_ürün_detayına_gidilir() throws Throwable {		
		HomePage homePage = new HomePage(driver);		
		homePage.anaSayfaYenile();
		RandomItemDetailManager manager = new RandomItemDetailManager();
		int randomItem = manager.processStem1(homePage);
		manager.processStep2(homePage, randomItem);
		manager.processStep3(homePage);
	}

	@And("^ürün sepete eklenir$")
	public void ürün_sepete_eklenir() throws Throwable {
		HomePage homePage = new HomePage(driver);
		homePage.scrollDownSeeElement(homePage.WebDriver,homePage.addToBasket);
		homePage.addToBasket.click();
	}
}

