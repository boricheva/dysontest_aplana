package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;


public class DysonPage extends BasePage {
    private String dysonPageTitle;
    private By dysonPageTitleLocator = By.xpath("//div[contains(@class, 'content-header')]/div[contains(@class, 'title')]/h1");

    private void rememberTitle() {
        dysonPageTitle = driver.findElement(dysonPageTitleLocator).getText();
    }

    private void waitTitleChange() {
        waitAction.until(driver  -> {
            String currPageTitle = driver.findElement(dysonPageTitleLocator).getText();
            return !currPageTitle.equals(dysonPageTitle);
        });
    }

    public void checkPageOpened(String pageTitle) {
        waitTitleChange();
        String currPageTitle = driver.findElement(dysonPageTitleLocator).getText();
        assertTrue(currPageTitle.contains(pageTitle));
    }

    public void checkNewTabOpened(String pageContent) {
        switchWindowHandle();
        WebElement logo = driver.findElement(By.xpath("//a[@id='main-logo']/img"));
        String logoTitle = logo.getAttribute("title");
        assertTrue(logoTitle.contains(pageContent));
    }

    public void checkItemPresent(String itemName) {
        By productNameLocator = By.xpath("//div[@id='products-grid']//h5[@class='product-name']/a[contains(text(), '" + itemName + "')]");
        driver.findElement(productNameLocator);
    }

    public void chooseMenuItem(String menuItem) {
        By menuItemLocator = By.xpath("//nav/ul/li//span[contains(text(), '" + menuItem + "')]");
        click(menuItemLocator);
    }

    public void chooseSubMenuItem(String subMenuItem) {
        By subMenuItemLocator = By.xpath("//nav/ul/li//span[contains(text(), '" + subMenuItem + "')]");
        rememberTitle();
        click(subMenuItemLocator);
    }
}
