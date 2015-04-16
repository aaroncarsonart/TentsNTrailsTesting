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
 * 
 * @author Cookie Computing
 *
 */
public class Main {
	
	public static void main(String[] args) {
		
		SeleniumTutorialGuru stg = new SeleniumTutorialGuru();
		
		/**
		 *TESTING BLOCK:
		 *
		 *In order to establish some consistency, please copy and
		 *paste a whole try/catch block and then replace the variable's
		 *class and print statement to match the new test's name.
		 *
		 *Please use the below example test case as your template.
		 **/
		
		/** Example Test Case **/
		// User Story #0 - Login and Logout as an Admin
        try 
        {
        	LoginAsAdmin test = new LoginAsAdmin();
        	test.setUp();
        	test.testLoginAsAdmin();
        	test.tearDown();
        	System.out.println("[PASSED] #---: Login as Admin");
		} 
        catch (Exception e) 
        {
			// Test failed, print out error message
			// "======" are there to make the failures more visible
			System.out.println("=====================================================================");
			System.out.println("[FAILED] #---: Login as Admin");
			System.out.println("=====================================================================");
			e.printStackTrace();
		}
		
		/** Sprint 5 Test Cases **/
		// User Story #168 -- Merge Locations
        try 
        {
        	MergeLocations test = new MergeLocations();
        	test.setUp();
        	test.testMergeLocations();
        	test.tearDown();
        	System.out.println("[PASSED] #168: Merge Locations");
		}
        catch (Exception e) 
        {
			// Test failed, print out error message
			// "======" are there to make the failures more visible
			System.out.println("=====================================================================");
			System.out.println("[FAILED] #168: Merge Locations");
			System.out.println("=====================================================================");
			e.printStackTrace();
		}
        
        /** Sprint 7 Test Cases **/
        // TO DO: Implement Sprint 7 Test Cases
        
        
        // exit the program explicitly
        System.exit(0);
    }
}