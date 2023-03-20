package pages;

import linuxorg.ConfigSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage {

    private static WebDriver webDriver;

    public StartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(ConfigSetup.getProperty("startPage"));
        PageFactory.initElements(webDriver, this);
    }

    public void clickNewsButton() {
        newsButton.click();
    }

    public void clickSiteTitle() {
        siteTitle.click();
    }

    public void clickGallery() {
        gallery.click();
    }

    public void clickArticles() {
        articles.click();
    }

    public void clickForum() {
        forum.click();
    }

    public void clickTracker() {
        tracker.click();
    }

    public void clickSearch() {
        search.click();
    }

    public void clickRegMenu() {
        regMenu.click();
    }

    public void clickLogin() {
        loginbutton.click();
    }

    public void choseCheckBox() {
        checkBox.click();
    }

    public void clickToVote() {
        voteButton.click();
    }

    public void clickToFirstArticle() {
        firstArticle.click();
    }

    public String getVotingTitle(){
        return votingTitle.getText();
    }

    public String getFirstNewsTitle(){
        return firstNews.getText();
    }

    @FindBy(xpath = "//*[@id=\"sitetitle\"]/a")
    private WebElement siteTitle;                   // Заголовок

    @FindBy(xpath = "//*[@id=\"hd\"]//a[@href = '/news/']")
    private WebElement newsButton;                  // Новости

    @FindBy(xpath = "//*[@id=\"hd\"]//a[@href = '/gallery/']")
    private WebElement gallery;                     // Галерея

    @FindBy(xpath = "//*[@id=\"hd\"]//a[@href = '/articles/']")
    private WebElement articles;                    // Статьи

    @FindBy(xpath = "//*[@id=\"hd\"]//a[@href = '/forum/']")
    private WebElement forum;                       // Форум

    @FindBy(xpath = "//*[@id=\"hd\"]//a[@href = '/tracker/']")
    private WebElement tracker;                     // Трекер

    @FindBy(xpath = "//*[@id=\"hd\"]//a[@href = '/search.jsp']")
    private WebElement search;                      // Поиск

    @FindBy(xpath = "//*[@id=\"regmenu\"]/a[1]")
    private WebElement regMenu;                     // Регистрация

    @FindBy(xpath = "//*[@id=\"loginbutton\"]")
    private WebElement loginbutton;                 // Вход

    @FindBy(xpath = "//*[@id=\"boxlets\"]/div[3]/div/p")
    private WebElement votingTitle;                     // Заголовок голосования

    @FindBy(xpath = "//*[@id=\"boxlets\"]/div[2]/div/form/div[4]/label/input")
    private WebElement checkBox;                     // Выбор из опроса

    @FindBy(xpath = "//*[@id=\"boxlets\"]/div[2]/div/form/button")
    private WebElement voteButton;                   // Голосовать

    @FindBy(xpath = "//*[@id=\"boxlets\"]/div[3]/div/ul/li[1]/a")
    private WebElement firstArticle;                   // Первая статься в колонке справа

    @FindBy(xpath = "//div[3]/div/div/article[1]/h1/a")
    private WebElement firstNews;                   // Первая статься в колонке по центру
}