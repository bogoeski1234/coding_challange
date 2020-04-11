package tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.utilities.Driver;

import javax.xml.xpath.XPath;
import java.util.List;

public class GitHubPage {
    public GitHubPage() {
        PageFactory.initElements(Driver.get(), this);



    }
    @FindBy(xpath = "//*[@aria-label='Search GitHub']")
    public WebElement searchBox;


    @FindBy(xpath = "//*[@class='d-flex flex-column flex-md-row flex-justify-between border-bottom pb-3 position-relative']")
    public WebElement searchResult;

    @FindBy(xpath = "(//*[@data-search-type='Repositories'])[1]")
    public WebElement numOfRepos;

    @FindBy(xpath = "(//ul)[13]//li/div/div/a")
    public List<WebElement> listOfRepoURL;

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement signInLink;         ;

    @FindBy(id = "login_field")
    public WebElement userNameBox;

    @FindBy (id  = "password")
    public WebElement passwordBox;

    @FindBy(xpath  = "//*[@type='submit']")
    public WebElement signInButton;

    public void logIn(String username, String password){
        WebDriverWait wait = new WebDriverWait(Driver.get(),5);
        signInLink.click();
        wait.until(ExpectedConditions.urlContains("https://github.com/login"));
        userNameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        signInButton.click();
        wait.until(ExpectedConditions.urlContains("https://github.com"));

    }



}
