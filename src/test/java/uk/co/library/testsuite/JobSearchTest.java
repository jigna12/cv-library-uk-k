package uk.co.library.testsuite;
/*
1.JobSearchTest
Inside JobSearchTest class create following testmethods
1.verifyJobSearchResultUsingDifferentDataSet(String jobTitle, String location, String
distance, String salaryMin, String salaryMax, String salaryType, String jobType,
String result).
enter job title 'jobTitle'
enter Location 'location'
select distance 'distance'
click on moreSearchOptionsLink
enter salaryMin 'salaryMin'
enter salaryMax 'salaryMax'
select salaryType 'salaryType'
select jobType 'jobType'
click on 'Find Jobs' button
 */
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import resources.testdata.TestData;
import uk.co.library.pages.HomePage;
import uk.co.library.pages.ResultPage;
import uk.co.library.testbase.TestBase;

public class JobSearchTest extends TestBase {

    HomePage homePage;
    ResultPage resultPage;

    @BeforeMethod
    public void inIt() {
        homePage = new HomePage();
        resultPage = new ResultPage();
    }
    @Test (dataProvider = "jobData", dataProviderClass = TestData.class, groups = {"sanity", "smoke", "regression"})
    public void verifyJobSearchResultUsingDifferentDataSet1(String jobTitle, String location, String
            distance, String salaryMin, String salaryMax, String salaryType, String jobType,
                                               String result) throws InterruptedException{
        SoftAssert softAssert = new SoftAssert();
        homePage.acceptIFrameAlert();
        homePage.enterJobTitle(jobTitle);
        homePage.enterLocation(location);
        homePage.selectDistanceDropDown(distance);
        homePage.clickMoreSearchOptionsLink();
        homePage.enterSalaryMin(salaryMin);
        homePage.enterSalaryMax(salaryMax);
        homePage.selectSalaryTypeFieldDropDown(salaryType);
        homePage.selectJobTypeFieldDropDown(jobType);
        homePage.clickOnFindJobsBtn();
        resultPage.verifyTheResults(result);
//        String actualMessage = resultPage.verifyResultText();
//        Assert.assertEquals(result, actualMessage, "Results not found");
        softAssert.assertAll();
    }
}
