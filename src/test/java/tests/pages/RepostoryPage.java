package tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.utilities.Driver;

public class RepostoryPage {
    public RepostoryPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//*[@class='numbers-summary']//li[1]")
    public WebElement commits;

    @FindBy(xpath = "//*[@class='numbers-summary']//li[2]")
    public WebElement branches;

    @FindBy(xpath = "//*[@class='numbers-summary']//li[4]")
    public WebElement releases;

    @FindBy(xpath = "//*[@class='numbers-summary']//li[5]")
    public WebElement contributors;




}
