package main.match;

import java.util.*;
import main.*;

/** A class that describes how to get a random winner */
public class RandomWinner implements Match {
	
	/** */
	public RandomWinner() {
	}
	
	
	/**
	 * @see main.match.Match#getWinner(Competitor, Competitor)
	 */
	public void getWinner(Competitor c1, Competitor c2) {
		  Random rand = new Random();
		  List<Competitor> match = new ArrayList<>();
		  match.add(c1);
		  match.add(c2);
		  Competitor winner = match.get(rand.nextInt(match.size()));
		  winner.addPoints();
		  System.out.println(c1 + " vs " + c2 + " --> " + winner + " wins !\n");
	}
	
	
	/**
	 * @see main.match.Match#toString()
	 */
	public String toString() {
		return "Random winner : a random winner will be returned";
	}

	
	
}
