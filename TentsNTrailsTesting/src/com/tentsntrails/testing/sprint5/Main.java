package com.tentsntrails.testing.sprint5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * The main class for our Tents n Trails testing suite.
 * 
 * To create a test for the suite:
 * Visit this site:http: //www.guru99.com/selenium-tutorial.html
 * Here you will find many in depth tutorials for the Selenium IDE
 * and WebDriver. Tutorials #2-4, and #7 -9, were used to create
 * this testing suite.
 * 
 * To add a test to the suite:
 * Create the test using the Selenium IDE. Then,
 * File >> Export Test Case As.. >> Java / JUNIT 4 / WebDriver
 * Save this java file. Then copy and paste the file (minus package name)
 * in to a new Java class in this project. Now, add a new testing block,
 * as shown below.
 * @author Cookie Computing
 *
 */
public class Main {
	public static void main(String[] args) {
		
		SeleniumTutorialGuru stg = new SeleniumTutorialGuru();
		
		/**
		 *TESTING BLOCK:
		 *In order to establish some consistency, please copy and
		 *paste a whole try/catch block and then replace the variable's
		 *class and print statement to match the new test's name.
		 */
        try {
        	MergeLocations test = new MergeLocations();
        	test.setUp();
        	test.testMergeLocations();
        	test.tearDown();
        	System.out.println("[PASSED] MergeLocations"); //will only reach here if no Exception is thrown
		} catch (Exception e) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");//just to catch our eyes
			System.out.println("[FAILED] MergeLocations");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			e.printStackTrace();
		}
        
        
        // exit the program explicitly
        System.exit(0);
    }
}