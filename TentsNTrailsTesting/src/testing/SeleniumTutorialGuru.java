package testing;

//always import these two:
//contains the WebDriver class needed to instantiate a new browser loaded with a specific driver
import org.openqa.selenium.WebDriver;
//contains the FirefoxDriver class needed to instantiate a Firefox-specific driver onto the
//browser instantiated by the WebDriver class
import org.openqa.selenium.firefox.FirefoxDriver;
//If your test needs more complicated actions such as accessing another class, taking browser
//screenshots, or manipulating external files, definitely you will need to import more packages.

public class SeleniumTutorialGuru {
	
	public SeleniumTutorialGuru() { //this is the main method if you only have one test in your project.
        // declaration and instantiation of objects/variables
        WebDriver driver = new FirefoxDriver(); //default Firefox profile will be launched
        String baseUrl = "http://tentsntrailsdebug.azurewebsites.net/";
        String expectedTitle = "Home - tents n trails";
        String actualTitle = "";
 
        // launch Firefox and direct it to the Base URL
        driver.get(baseUrl);
 
        // get the actual value of the title
        actualTitle = driver.getTitle();
 
        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("SeleniumTutorialGuru Test Passed!");
        } else {
            System.out.println("SeleniumTutorialGuru Test Failed");
        }
        
        //close Firefox
        driver.close();
    }

}
