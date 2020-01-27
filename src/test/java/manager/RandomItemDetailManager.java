package manager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import PageObjects.HomePage;

public class RandomItemDetailManager {
	public int getRandomItem() {
		return (int)(Math.random()*(9))+1;
	}
	public int processStem1(HomePage homePage) {
		int randımItem = getRandomItem();
		WebElement randTablink =homePage.butiktabLink.get(randımItem-1);
		homePage.Hover(homePage.WebDriver, randTablink);
		return randımItem;
	}
	
	public void processStep2(HomePage homePage, int randomItem) throws InterruptedException {
		
		List<WebElement> relatedBoutiqueAllProducts= homePage.WebDriver.findElements(By.xpath("//li[@class='tab-link']["+randomItem+"]/div/div/div/div/div/ul/li/a"));
		int ilgiliButiktekiTumUrunlerSayisi=relatedBoutiqueAllProducts.size();	
		int randomProductLink=(int)(Math.random()*(ilgiliButiktekiTumUrunlerSayisi))+1;
		WebElement choosedProduct=relatedBoutiqueAllProducts.get(randomProductLink-1);
		Thread.sleep(5000);		
		choosedProduct.click();
	}
	
	public void processStep3(HomePage homePage) throws InterruptedException {
		List<WebElement> specificProductList= homePage.specificProductList;
		int specificProductNumber=specificProductList.size();
		homePage.specificProductList.stream().forEach(homePage::waitUntil);
        int randspecificProductNumber=(int)(Math.random()*(specificProductNumber))+1;
		WebElement specificProduct=homePage.specificProductList.get(randspecificProductNumber-1);
		homePage.scrollDownSeeElement(homePage.WebDriver,specificProduct);
		specificProduct.click();
	}
}
