package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class YandexPage extends BasePage {

    public void openPage(String url) {
        driver.get(url);
    }

    public void fillsearchBar(String text) {
        By searchBarLocator = By.xpath("//input[@aria-label='Запрос']");
        fillTextArea(searchBarLocator, text);
    }

    public void goToSearchResults() {
        WebElement seeResultsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Найти')]/parent::button")));
        seeResultsButton.click();
    }

    public By findLink(int numPagesToCheck, String link) {
        By linkSectionLocator = By.xpath("//a/b[contains(text(), '" + link + "')]//ancestor::li[contains(@class, 'serp-item')]//a//div[contains(@class, 'organic__url-text')]");
        By nextButtonLocator = By.xpath("//a[contains(text(), 'дальше')]");
        for (int i = 0; i < numPagesToCheck; i += 1) {
            wait.until(ExpectedConditions.elementToBeClickable(nextButtonLocator));
            try {
                driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
                driver.findElement(linkSectionLocator);
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                return linkSectionLocator;
            } catch (NoSuchElementException e) {
                click(nextButtonLocator);
            }
        }
        String errorMessage = "На первых " + numPagesToCheck + " страницах не обнаружена ссылка магазина: " + link;
        throw new NoSuchElementException(errorMessage);
    }

    public void clickLink(By link) {
        rememberWindowHandle();
        click(link);
    }
}
