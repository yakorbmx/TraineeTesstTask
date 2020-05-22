package by.onliner;

import by.onliner.testThroughCatalog.TestThroughCatalog;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner {
  public ChromeDriver chromeDriver;

  @Before
  public void startDriver() {
    //    System.setProperty(
    //        "webdriver.chrome.driver",
    //        "src\\resources\\chromedriver.exe"); // в случае если не прописаны переменные среды
    // разкомментить, также можно "прикрутить" библиотеку WebdriverManager
    chromeDriver = new ChromeDriver();
  }

  @Test
  public void appleIphonePriceCheckThroughTheCatalog() {
    TestThroughCatalog testThroughCatalog = new TestThroughCatalog(chromeDriver);
    testThroughCatalog.goToOnliner();
    testThroughCatalog.clickOnMenu();
    testThroughCatalog.openCatalog();
    testThroughCatalog.categoryPick();
    testThroughCatalog.pickMobilePhonesCategory();
    testThroughCatalog.openFilters();
    testThroughCatalog.pickAppleManufacturer();
    testThroughCatalog.closeFilters();
    testThroughCatalog.getPriceOfFirstItem();
    testThroughCatalog.comparePrice();
  }

  @After
  public void closeDriver() {
    chromeDriver.close();
  }
}
