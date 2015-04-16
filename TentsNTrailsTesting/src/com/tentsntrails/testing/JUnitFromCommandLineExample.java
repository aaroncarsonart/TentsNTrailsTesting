package com.tentsntrails.testing;

import org.junit.internal.TextListener;
import org.junit.runner.Computer;
import org.junit.runner.JUnitCore;

/**
 * Optional method to place in a main to run junit code directly (this will 
 * run in terminal/console, NOT with Eclipse's built-in junit runner).
 * <p>
 * Idea from <a href="http://stackoverflow.com/questions/10127052/how-to-programmatically-execute-a-test-suite-using-junit4">Stack Overflow</a>
 */
public class JUnitFromCommandLineExample {	
	public static void main(String[] args){
		Computer computer = new Computer();
		JUnitCore jUnitCore = new JUnitCore();
		jUnitCore.addListener(new TextListener(System.out));
		jUnitCore.run(computer, SmokeTestSuite.class);
		jUnitCore.run(computer, RegressionTestSuite.class);		
	}
}
