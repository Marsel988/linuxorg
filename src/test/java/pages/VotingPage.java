package pages;

import linuxorg.ConfigSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VotingPage {
    private static WebDriver webDriver;

    public VotingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public String getVotingTitle() {
        return siteTitle.getText();
    }

    @FindBy(xpath = "//h1[contains(@itemprop,\"headline\")]")
    private WebElement siteTitle;                   // Название голосования


}

