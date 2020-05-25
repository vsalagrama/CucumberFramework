package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.BlazeHome;
import pageObjects.HomePage;
import pageObjects.PurchasePage;
import pageObjects.Results;
import pageObjects.ThankyouPage;

public class PageObjectManager {
	private static WebDriver driver;
	private HomePage home;
	private Results res;
	private BlazeHome blazehome;
	private PurchasePage purchasepage;
	private static ThankyouPage thankyoupage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	public HomePage getHomePage() {
		return (home == null) ? home = new HomePage(driver) : home;
		
	}
	public Results getResults() {
		return (res == null) ? res = new Results(driver) : res;
		
	}
	public BlazeHome getBlazeHome() {
		return (blazehome == null) ? blazehome = new BlazeHome(driver) : blazehome;		
	}
	public PurchasePage getpurchasepage() {
		return (purchasepage == null) ? purchasepage = new PurchasePage(driver) : purchasepage;		
	}
	public static ThankyouPage getthankyoupage() {
		return (thankyoupage == null) ? thankyoupage = new ThankyouPage(driver) : thankyoupage;		
	}
}
