package tests.step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.pages.GitHubPage;
import tests.pages.RepostoryPage;
import tests.utilities.ConfigurationReader;
import tests.utilities.Driver;
import tests.utilities.Utilities;

import java.util.List;

public class StepDef {
    GitHubPage gitHubPage = new GitHubPage();
    Utilities utilities = new Utilities();
    RepostoryPage repostoryPage = new RepostoryPage();
    WebDriverWait wait = new WebDriverWait(Driver.get(),5);

    @Given("I login with username and password")
    public void i_login_with_username_and_password() {
        gitHubPage.logIn(ConfigurationReader.get("username"),ConfigurationReader.get("password"));

    }

    @When("I enter {string} in the search Box field and hit Enter")
    public void i_enter_in_the_search_Box_field(String text) {
        gitHubPage.searchBox.sendKeys(text);
        gitHubPage.searchBox.sendKeys(Keys.ENTER);

    }




    @Then("we should see {int} or more in the {string}")
    public void we_should_see_in_the_search_Results(Integer expected,String element) {
        String actualText = "";
        if (element.equals("search Results")) {
            actualText=gitHubPage.searchResult.getText();
        }else if(element.equals("commits")){
            actualText =repostoryPage.commits.getText();
        }else if(element.equals("branches")){
            actualText = repostoryPage.branches.getText();
        }else if(element.equals("releases")){
            actualText = repostoryPage.releases.getText();
        }else if(element.equals("contributors")){
            actualText= repostoryPage.contributors.getText();
        }
        Integer actual = utilities.getIntFromString(actualText);
        Assert.assertTrue(actual >= expected);
    }

    @Then("we match num Of Repo and num of search Results")
    public void we_match_num_Of_Repo_and_num_of_search_Results() {

        int numOfRepo = utilities.getIntFromString(gitHubPage.numOfRepos.getText());
        int numOfSearchResult = utilities.getIntFromString(gitHubPage.searchResult.getText());
        Assert.assertEquals(numOfRepo,numOfSearchResult);


    }
    @When("we select {string} Repository from list Repositories")
    public void we_select_Repository_from_list_Repositories(String repo) {

        for(WebElement element: gitHubPage.listOfRepoURL){
            System.out.println(element.getAttribute("href" ));
            if(element.getAttribute("href" ).equals("https://github.com/"+repo)){
                element.click();
                wait.until(ExpectedConditions.urlContains("https://github.com/"+repo));
            }
            break;
        }
    }
    @Then("we should see following value")
    public void we_should_see_following_value(io.cucumber.datatable.DataTable dataTable) {
        WebElement element = null;
        List<String> elementList = dataTable.asList();

        for(String str:elementList){
            if(str.equals("commits")){
                element = repostoryPage.commits;
            }else if(str.equals("branches")){
                element = repostoryPage.branches;
            }else if(str.equals("releases")){
                element = repostoryPage.releases;
            }else if(str.equals("contributors")){
                element= repostoryPage.contributors;
            }
        }
        Assert.assertTrue(element.isDisplayed());
    }


}
