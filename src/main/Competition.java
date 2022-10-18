package main;

import java.util.*;
import main.util.*;
import main.exceptions.*;


/** A class that represents a competition */
public abstract class Competition {

  /** A list of competitors */
  public final List<Competitor> competitors;
  
  /** A kind of match */
  public Match match;
  
  /** A list of all kind of match that can be played */
  public List<Match> matchs;
  
  /** The scanner */
  Scanner scan;
  
  /** A competition is defined by a given list of competitors
   * @param comp the list
   */
  public Competition(List<Competitor> comp) {
    this.competitors = comp;
    this.matchs = new ArrayList<>();
  }
  
  /** Adds a match to the list of match 
   * @param m the kind of match to add
   */
  public void addMatch(Match m) {
	  this.matchs.add(m);
  }

  
  /**
   * Displays all kind of match possible for the competition 
   */
  public void displayMatchPossible() {
	 System.out.println("Select the type of match you want \n");
	 int i = 0;
	 // displays all match available to play
	 for(Match m : this.matchs) {
		 System.out.println(i + " - " + m + "\n");
		 i++;
	 }
  }

  
  /** 
   * Selects a kind of match (how we will get the winner)
   */
  public void selectMatch() {
	  this.displayMatchPossible();
	  scan = new Scanner(System.in);
	  int i = scan.nextInt();
		  
	  Match matchChosen = this.matchs.get(i);
	  this.match = matchChosen;
  }
  
  /**
   * @return the list of all competitors
   */
  public List<Match> getAllMatch() {
	  return this.matchs;
  }

  /** Adds a competitor of the list
   *  @param c the competitor
   */
  public void addCompetitor(Competitor c) {
	  this.competitors.add(c);
  }


  /** Removes a competitor of the list
   *  @param c the competitor
   *  @throws UnknownPlayerException when the competitor does not exist in the list
   */
  public void removeCompetitor(Competitor c) throws UnknownPlayerException {
	  if(!this.competitors.contains(c)) {
		  throw new UnknownPlayerException();
	  }
	  else {
		  this.competitors.remove(c);
	  }
  }


  /**
   * @return the list of all competitors
   */
  public List<Competitor> getAllCompetitors() {
	  return this.competitors;
  }


  /**
   * Plays the competition
   */
  public void play() {
	 this.play(this.competitors);
  }


  /**
   * plays all match according to the list of competitors
   * @param comp the list of competitors
   */
  protected abstract void play(List<Competitor> comp);


  /** Plays a match between two competitors
   * @param c1 the first competitor
   * @param c2 the second competitor
   */
  protected void playMatch(Competitor c1, Competitor c2) {
	  this.match.getWinner(c1, c2);
  }


  /**
   * @return the ranking, a competitor (key) associated to a value (the rank)
   */
  public Map<Competitor, Integer> ranking() {
		Map<Competitor, Integer> competitorsRanking = new HashMap<>();
		Iterator<Competitor> it = this.competitors.iterator();

		while(it.hasNext()) {
			Competitor c1 = it.next();
			competitorsRanking.put(c1, c1.getPoints());
		}
		competitorsRanking = MapUtil.sortByDescendingValue(competitorsRanking);
		return competitorsRanking;
	}


  /**
   * Displays the rank of all competitors
   */
  public void displayRanking() {
		Map<Competitor, Integer> rank = this.ranking();
		System.out.println("*** RANKING ***");
		for(Map.Entry<Competitor, Integer> entry : rank.entrySet()) {
			System.out.println(entry.getKey().getName() + " - "+ entry.getValue());
		}
	}


}
