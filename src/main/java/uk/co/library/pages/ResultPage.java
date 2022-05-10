package uk.co.library.pages;
/*
2.ResultPage
Locators - resultText
Method - verifyTheResults(String expected)
test package.
create all packages and class that you created for page object model
 */

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import uk.co.library.utility.Utility;

public class ResultPage extends Utility {

    public ResultPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//h1[@class='search-header__title']")
    WebElement resultText;

    public void verifyTheResults(String expected) {
        Reporter.log("Verifying Test Results "+resultText.toString());
        verifyThatTextIsDisplayed(resultText, expected);
    }
}
