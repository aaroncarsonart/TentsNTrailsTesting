package com.tentsntrails.testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.tentsntrails.testing.sprint5.MergeLocations;
import com.tentsntrails.testing.sprint6.CreateLocations;
import com.tentsntrails.testing.sprint6.CreateReviews;
import com.tentsntrails.testing.sprint6.DeleteLocations;
import com.tentsntrails.testing.sprint6.DeleteReviews;
import com.tentsntrails.testing.sprint6.UserStory085;
import com.tentsntrails.testing.sprint6.UserStory130;
import com.tentsntrails.testing.sprint6.UserStory157;

/**
 * This Test is designed to run all previous tests from Sprint5 and Sprint6.
 * Every test class needs to be added in the order they need to be run.  You
 * can add classes multiple times if necessary.
 * <p>
 * Run this test suite with Eclipse's "Run" button and selecting JUnit, or pass a
 * reference to this class from the this to the CommandLineExample code I have
 * or
 * 
 * @author Aaron Carson
 * @version Apr 13, 2015
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	// Sprint 5 
	MergeLocations.class,
	
	// Sprint 6
	CreateLocations.class,
	CreateReviews.class,
	
	UserStory085.class,
	UserStory130.class,
	UserStory157.class,
	
	DeleteReviews.class,
	DeleteLocations.class,
	
	// Sprint 7 TO DO
})

// class itself has no definition
public class RegressionTestSuite {}
