package linuxorg;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.SearchPage;
import pages.StartPage;
import pages.VotingPage;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestClass implements WebDriver{
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
//        System.setProperty("webdriver.http.factory", "jdk-http-client");
//        System.setProperty("webdriver.chrome.driver", "/tmp/src/test/java/resources/linux/110/chromedriver");  // linux
//        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/windows/chromedriver.exe");  // windows
        ChromeOptions chrome_options = new ChromeOptions();
        chrome_options.addArguments("--no-sandbox");
        chrome_options.addArguments("--headless");
        chrome_options.addArguments("--disable-gpu");
        chrome_options.addArguments("--disable-dev-shm-usage");
        try {
//        driver = new RemoteWebDriver(new URL("http://bla:4444"), options);
//            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chrome_options);
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chrome_options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
//        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
    public void checkeSearchOperation() {
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

    @Override
    public void get(String url) {

    }

    @Override
    public String getCurrentUrl() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public String getPageSource() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public void quit() {

    }

    @Override
    public Set<String> getWindowHandles() {
        return null;
    }

    @Override
    public String getWindowHandle() {
        return null;
    }

    @Override
    public TargetLocator switchTo() {
        return null;
    }

    @Override
    public Navigation navigate() {
        return null;
    }

    @Override
    public Options manage() {
        return null;
    }
}
