package uk.co.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import uk.co.library.utility.Utility;

/*
1.HomePage -
Locators - jobTitle, location, distanceDropDown, moreSearchOptionsLink, salaryMin,
salaryMax, salaryTypeDropDown, jobTypeDropDown, findJobsBtn
Methods - enterJobTitle(String jobTitle), enterLocation(String location),
selectDistance(String distance), clickOnMoreSearchOptionLink(),
enterMinSalary(String minSalary), enterMaxSalary(String maxSalary), selectSalaryType(String
sType), selectJobType(String jobType),
clickOnFindJobsButton().
 */
public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[@id='save']")
    WebElement acceptAllButton;
    @FindBy(xpath = "(//input[@id='keywords'])[1]")
    WebElement jobTitleField;
    @FindBy(xpath = "//input[@id='location']")
    WebElement locationField;
    @FindBy(xpath = "//select[@id='distance']")
    WebElement distanceDropDownField;
    @FindBy(xpath = "//button[@id='toggle-hp-search']")
    WebElement moreSearchOptionsLink;
    @FindBy(xpath = "//input[@id='salarymin']")
    WebElement salaryMinField;
    @FindBy(xpath = "//input[@id='salarymax']")
    WebElement salaryMaxField;
    @FindBy(xpath = "//select[@id='salarytype']")
    WebElement salaryTypeFieldDropDown;
    @FindBy(xpath = "//select[@id='tempperm']")
    WebElement jobTypeFieldDropDown;
    @FindBy(xpath = "//input[@id='hp-search-btn']")
    WebElement findJobsBtn;

    public void acceptIFrameAlert() throws InterruptedException {
        Thread.sleep(500);
        driver.switchTo().frame("gdpr-consent-notice");
        clickOnElement(acceptAllButton);
        Reporter.log("Accepting all cookies : " + acceptAllButton.toString());

    }
    public void enterJobTitle(String jobTitle){
        Reporter.log("Entering Job Title : " + jobTitleField.toString());
        sendTextToElement(jobTitleField,jobTitle);
    }
    public void enterLocation(String location){
        Reporter.log("Entering Location : " + locationField.toString());
        sendTextToElement(locationField,location);
    }

    public void selectDistanceDropDown(String distance){
        Reporter.log("Selecting Distance : " + distanceDropDownField.toString());
        selectByVisibleTextFromDropDown(distanceDropDownField,distance);
    }
    public void clickMoreSearchOptionsLink(){
        Reporter.log("Clicking on More Search Options : " + moreSearchOptionsLink.toString());
        clickOnElement(moreSearchOptionsLink);
    }
    public void enterSalaryMin(String minSalary){
        Reporter.log("Entering Min Salary : " + salaryMinField.toString());
        sendTextToElement(salaryMinField,minSalary);
    }
    public void enterSalaryMax(String maxSalary){
        Reporter.log("Entering Max Salary : " + salaryMaxField.toString());
        sendTextToElement(salaryMaxField,maxSalary);
    }
    public void selectSalaryTypeFieldDropDown(String sType){
        Reporter.log("Selecting Salary Type : " + sType);
        selectByVisibleTextFromDropDown(salaryTypeFieldDropDown,sType);
    }
    public void selectJobTypeFieldDropDown(String jType){
        Reporter.log("Selecting Job Type : " + jType);
        selectByVisibleTextFromDropDown(jobTypeFieldDropDown,jType);
    }
    public void clickOnFindJobsBtn(){
        Reporter.log("Clicking on Find Job Button : " + findJobsBtn.toString());
        clickOnElement(findJobsBtn);
    }

}
