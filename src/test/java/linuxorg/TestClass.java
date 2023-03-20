package linuxorg;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.SearchPage;
import pages.StartPage;
import pages.VotingPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestClass {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() throws MalformedURLException {
//        System.setProperty("webdriver.http.factory", "jdk-http-client");
//        System.setProperty("webdriver.chrome.driver", ConfigSetup.getProperty("chromedriver"));
//        System.setProperty("webdriver.chrome.driver", "/home/chromedriver");
//        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("useAutomationExtension", false);
//        driver = new ChromeDriver(options);
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Проверка заголовка")
    public void checkTest() {
        StartPage startPage = new StartPage(driver);
        String actualTitle = driver.getTitle();
        String expectedTitle1 = "LINUX.ORG.RU — Русская информация об ОС Linux";
        Assert.assertEquals(actualTitle, expectedTitle1);
    }

    @Test
    @DisplayName("Переход на Новости")
    public void checkNews() {
        StartPage startPage = new StartPage(driver);
        startPage.clickNewsButton();
        String actualTitle = driver.getTitle();
        String expectedTitle2 = "Новости";
        Assert.assertEquals(actualTitle, expectedTitle2);
    }

    @Test
    @DisplayName("Переход в Галерею")
    public void checkGallery() {
        StartPage startPage = new StartPage(driver);
        startPage.clickGallery();
        String actualTitle = driver.getTitle();
        String expectedTitle3 = "Галерея";
        Assert.assertEquals(actualTitle, expectedTitle3);
    }

    @Test
    @DisplayName("Переход в Статьи")
    public void checkArticles() {
        StartPage startPage = new StartPage(driver);
        startPage.clickArticles();
        String actualTitle = driver.getTitle();
        String expectedTitle4 = "Статьи";
        Assert.assertEquals(actualTitle, expectedTitle4);
    }

    @Test
    @DisplayName("Переход в Форум")
    public void checkForum() {
        StartPage startPage = new StartPage(driver);
        startPage.clickForum();
        String actualTitle = driver.getTitle();
        String expectedTitle5 = "Форум";
        Assert.assertEquals(actualTitle, expectedTitle5);
    }

    @Test
    @DisplayName("Переход в Трекер")
    public void checkTracker() {
        StartPage startPage = new StartPage(driver);
        startPage.clickTracker();
        String actualTitle = driver.getTitle();
        String expectedTitle6 = "Последние сообщения";
        Assert.assertEquals(actualTitle, expectedTitle6);
    }

    @Test
    @DisplayName("Переход в Поиск")
    public void checkeSearch() {
        StartPage startPage = new StartPage(driver);
        startPage.clickSearch();
        String actualTitle = driver.getTitle();
        String expectedTitle7 = "Поиск по сайту";
        Assert.assertEquals(actualTitle, expectedTitle7);
    }

    @Test
    @DisplayName("Проверка опроса")
    public void checkVoting() {
        StartPage startPage = new StartPage(driver);
        String actual = startPage.getVotingTitle();
        startPage.choseCheckBox();
        startPage.clickToVote();
        VotingPage votingPage = new VotingPage(driver);
        String inVotePageTitle = votingPage.getVotingTitle();
        Assert.assertEquals(actual, inVotePageTitle);
    }

    @Test
    @DisplayName("Проверка работы поиска")
    public void checkeSearchJob() {
        StartPage startPage = new StartPage(driver);
        String searchRequest = startPage.getFirstNewsTitle();
        startPage.clickSearch();
        SearchPage searchPage = new SearchPage(driver);
        searchPage.setRequest(searchRequest);
        searchPage.clickSearch();
        String searchAnswer = searchPage.getFirstAnswerTitle();
        Assert.assertEquals(searchRequest, searchAnswer);
    }

    @AfterClass
    public static void finish() {
        driver.quit();
    }
}
