package steps;

import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import pages.DysonPage;

public class DysonSteps {
    private DysonPage dyPage = new DysonPage();

    @Тогда("^в новом окне открывается страница «(.*?)»$")
    public void checkNewTabOpenedSteps(String pageContent) {
        dyPage.checkNewTabOpened(pageContent);
    }

    @И("^пользователь проверяет, что на странице присутствует .*?: «(.*?)»$")
    public void checkItemPresentSteps(String itemName) {
        dyPage.checkItemPresent(itemName);
    }

    @Когда("^пользователь выбирает из вернего меню вкладку «(.*?)»$")
    public void chooseMenuItemSteps(String menuItem) {
        dyPage.chooseMenuItem(menuItem);
    }

    @И("^в выпадающем меню пользователь выбирает пункт «(.*?)»$")
    public void chooseSubMenuItemSteps(String subMenuItem) {
        dyPage.chooseSubMenuItem(subMenuItem);
    }

    @Тогда("^открывается страница «(.*?)»$")
    public void checkPageOpenedSteps(String pageTitle) {
        dyPage.checkPageOpened(pageTitle);
    }
}
