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
    // P.S. проверить версию браузера и chromedriver'a лежащего в папке в том случае, если на тестовом
    // стенде не предустановлен chromedriver в переменных среды.
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
