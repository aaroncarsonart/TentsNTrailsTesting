package com.tentsntrails.testing.sprint6;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * A test suite class contains no actual needed code, but the annotated code
 * section above which specify which tests to run. List the test classes above
 * in the order they must be executed, and it will be run automatically by
 * Eclipse.
 * 
 * @author Aaron Carson
 * @version Apr 13, 2015
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	CreateLocations.class, 
	CreateReviews.class,
	UserStory085.class, 
	UserStory130.class, 
	UserStory157.class,
	DeleteReviews.class, 
	DeleteLocations.class, 
})

// leave this empty
public class TestSuite {}
