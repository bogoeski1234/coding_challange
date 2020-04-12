# coding_challange

From the following requierments to log in gitHub you need to put user name and password in configuration.properties file and to comment out log in stepp in feature file.
For the requierment 1.c.ii. the requerments was not clear. I didnt understand what is the requerment so I verified that I have more than 3 repositories. 
Requierment d. I couldnt find "capitalone/Hygieia" repo so I use one with capitalOne dashboard. 
Requerment d.ii.2 I used 4 or more step definition for test in order to pass since I have only 4 in repo.

Steps to Run project: 
1. Clone Git repo from https://github.com/bogoeski1234/coding_challange to your local machine 
2. Uncomment Given step from coding_challange.feature file 
3. Set up username and password for GitHub login in configuratio.properties. 
4. If username and password are not accessible skip steps 2 and 3. 
5. Tag @git is alredy set in feature file as well in CucumberRunner.
6. Navigate to CucumberRunner file and right click and select Run CucumberRunner option. 
7. Test will execute. 
8. Report from test is accesable in target -> default-cucumber-reports as html file.


REQUIREMENTS
1. Create an automated functional test that verifies the following flow:
a. Navigate to GitHub.com
b. Enter a search term.
i. This search term should be configurable via the Gherkin statement.
ii. For this test, use ‘hygieia’ for the search term
c. After the search action completes. Verify that the correct number of repos is returned.
i. The number of repos should be configurable via the Gherkin.
ii. For this test, set a value &gt;= 3
d. Next, select the &quot;capitalone/Hygieia” repository
i. Verify that the following 4 repo headers appear (“Commit”, “Branches”, “releases”, “contributors”) 
ii. Also verify that the 4 headers have at least the following numbers of counts: 
1. commits &gt; 2,000
2. branches &gt; 4
3. releases &gt;= 8
4. contributors &gt; 50

2. The tests should be created using the Cucumber framework
a. Include all gherkin, step definitions and page objects when you to push to your repo
