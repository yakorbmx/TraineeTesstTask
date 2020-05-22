package by.onliner.testThroughCatalog;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestThroughCatalog {
  private WebDriver chromeDriver;
  private WebDriverWait wait;

  public String stringToGetThePriceFromElement;
  public int priceOfItemParsedToInt;
  public int priceToCompare = 100;

  public TestThroughCatalog(WebDriver chromeDriver) {
    this.chromeDriver = chromeDriver;
    wait = new WebDriverWait(chromeDriver, 60);
  }

  public void goToOnliner() {
    chromeDriver.get("https://www.onliner.by/");
  }

  public void clickOnMenu() {
    chromeDriver.findElement(By.xpath("//*[@id=\"navigation-sidebar\"]/div[2]/a")).click();
  }

  public void openCatalog() {
    chromeDriver
        .findElement(
            By.xpath("//*[@id=\"navigation-sidebar\"]/div[2]/div[2]/div[2]/ul[1]/li[2]/a[1]"))
        .click();
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[@id=\"container\"]/div/div/div/div/div[1]/ul/li[2]")));
  }

  public void categoryPick() {
    chromeDriver
        .findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div/div[1]/ul/li[2]"))
        .click();
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath(
                "//*[@id=\"container\"]/div/div/div/div/div[1]/div[3]/div/div[1]/div[1]/div/div[1]/div[1]")));
  }

  public void pickMobilePhonesCategory() {
    chromeDriver
        .findElement(
            By.xpath(
                "//*[@id=\"container\"]/div/div/div/div/div[1]/div[3]/div/div[1]/div[1]/div/div[1]"))
        .click();
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath(
                "//*[@id=\"container\"]/div/div/div/div/div[1]/div[3]/div/div[1]/div[1]/div/div[1]/div[2]/div/a[1]/span/span[2]")));
    chromeDriver
        .findElement(
            By.xpath(
                "//*[@id=\"container\"]/div/div/div/div/div[1]/div[3]/div/div[1]/div[1]/div/div[1]/div[2]/div/a[1]/span/span[2]"))
        .click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("schema-filter")));
  }

  public void openFilters() {
    chromeDriver
        .findElement(
            By.xpath(
                "/html/body/div[1]/div/div/div[2]/div/div/div[2]/div[2]/div[4]/div[3]/div[1]/div[1]"))
        .click();
  }

  public void pickAppleManufacturer() {
    chromeDriver
        .findElement(By.xpath("//*[@id=\"schema-filter\"]/div[3]/div[6]/div[2]/ul/li[3]/label"))
        .click();
  }

  public void closeFilters() {
    chromeDriver
        .findElement(
            By.xpath(
                "//*[@id=\"container\"]/div/div[2]/div/div/div[2]/div[2]/div[4]/div[2]/div[1]"))
        .click();
  }

  public void getPriceOfFirstItem() {
    WebElement result =
        chromeDriver.findElement(
            By.xpath("//*[@id=\"schema-filter-button\"]/div/div/div[1]/span[2]"));
    wait.until(
        ExpectedConditions.textToBePresentInElement(
            result, "Найдено")); // костыль для того чтобы успел обновиться каталог
    stringToGetThePriceFromElement =
        chromeDriver
            .findElement(
                By.xpath(

                    "//*[@id=\"schema-products\"]/div[1]/div/div[3]/div[1]/div/div[1]/div[1]/a"))
            .getText();
  }

  public void comparePrice() {
    stringToGetThePriceFromElement = stringToGetThePriceFromElement.replaceAll("[^0-9]", "");
    priceOfItemParsedToInt = Integer.parseInt(stringToGetThePriceFromElement) / 100;
    Assert.assertTrue(priceOfItemParsedToInt > priceToCompare);
  }
}
