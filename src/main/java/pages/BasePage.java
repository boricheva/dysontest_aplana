package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.Set;

public abstract class BasePage {
    WebDriver driver = BaseSteps.getDriver();
    Wait<WebDriver> wait = new WebDriverWait(driver, 60);
    private static String baseHandle;
    FluentWait<WebDriver> waitAction = new WebDriverWait(driver, 60)
                .ignoring(StaleElementReferenceException.class);

    void click(By locator) {
        waitAction.until(driver  -> {
            WebElement elToClick = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", elToClick);
            elToClick.click();
            return true;
        });
    }

    void rememberWindowHandle() {
        baseHandle = driver.getWindowHandle();
    }

    void switchWindowHandle() {
        Set<String> allHandles = driver.getWindowHandles();
        for (String handle : allHandles) {
            if (!handle.equals(baseHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }
}
