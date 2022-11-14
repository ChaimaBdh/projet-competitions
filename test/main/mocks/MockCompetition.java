package main.mocks;

import java.util.*;
import main.*;

/** A mock class that extends Competition class */
public class MockCompetition extends Competition {
	
	/** an attribute that will test a method's call */
	public int test;
	
	/** Defines the MockCompetition that extends Competition
	 * @param comp the competitor's list
	 */
	public MockCompetition(List<Competitor> comp) {
		super(comp);
		this.test=0;
	}
	
	
	/** Tests the method's call
	 * @param comp competitor's list
	 */
	@Override
	public void play(List<Competitor> comp) {
		this.test++;
	}
			  
}
