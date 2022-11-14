package main.mocks;

import main.Competitor;
import main.match.Match;

public class MockMatch implements Match {
	
	public int test;
	
	
	public MockMatch(Competitor c1, Competitor c2) {
		super();
		this.test=0;
	}
	
	

	/** 
	 * Tests the method's call
	 */
	@Override
	public void getWinner(Competitor c1, Competitor c2) {
		this.test++;	
	}
	

}
