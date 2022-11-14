package main.match;

import main.Competitor;

/** An interface to define a Match */
public interface Match {
	
	
	/** Returns the winner of the match
	 * @param c1 the first competitor
	 * @param c2 the second competitor
	 */
	public void getWinner(Competitor c1, Competitor c2);
	
	/** 
	 * @return a string representation for a match
	 */
	public String toString();

}
