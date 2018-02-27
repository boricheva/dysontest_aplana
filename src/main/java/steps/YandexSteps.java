package steps;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import org.openqa.selenium.By;
import pages.YandexPage;

public class YandexSteps {
    private YandexPage yaPage = new YandexPage();
    private By link;

    @Дано("^пользователь переходит на главную страницу Яндекса: (.*?)$")
    public void openPageSteps(String url) {
        yaPage.openPage("http://www." + url + "/");
    }

    @Когда("^Пользователь вводит в строку поиска текст: «(.*?)»$")
    public void fillTextAreaSteps(String text) {
        yaPage.fillTextArea(text);
    }

    @И("^переходит к результатам поиска$")
    public void goToSearchResultsSteps() {
        yaPage.goToSearchResults();
    }

    @И("^на первых (.*?) страницах с результатами находит ссылку магазина: (.*?)$")
    public void findLinkSteps(int numPages, String shopUrl) {
        link = yaPage.findLink(numPages, shopUrl);
    }

    @И("^переходит по ссылке$")
    public void clickLinkSteps() {
        yaPage.clickLink(link);
    }
}