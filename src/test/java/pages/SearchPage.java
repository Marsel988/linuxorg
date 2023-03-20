package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    private static WebDriver webDriver;

    public SearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void setRequest(String request) {
        searchRequestBox.clear();
        searchRequestBox.sendKeys(request);
    }

    public void clickSearch() {
        searchButton.click();
    }

    public String getFirstAnswerTitle() {
        return firstAnswer.getText();
    }

    @FindBy(xpath = "//*[@id=\"q\"]")
    private WebElement searchRequestBox;              // Поле ввода запроса поиска

    @FindBy(xpath = "//*[@id=\"query\"]/div[1]/button")
    private WebElement searchButton;              // Кнопка поиска


    @FindBy(xpath = "//*[@id=\"query\"]/div[7]/article[1]/h1/a")
    private WebElement firstAnswer;              // Первый поисковый ответ
}
