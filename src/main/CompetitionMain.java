package main;

import java.util.*;
import main.competitions.*;
import main.strategy.*;
import main.exceptions.NotAPowerOfTwoException;

/** A main class that will play the competition depending on what kind of competition the user will choose */
public class CompetitionMain {
	
	/** the scanner */
	private static Scanner s;

	/**
	 * @return the list of competitors initialized 
	 */
	public static List<Competitor> initCompetitors() {
		Competitor c1 = new Competitor("Blastoff");
		Competitor c2 = new Competitor("Drift");
		Competitor c3 = new Competitor("Lynx");
		Competitor c4 = new Competitor("Catalyst");
		Competitor c5 = new Competitor("Raven");
		Competitor c6 = new Competitor("Midas");
		
		List<Competitor> competitors = new ArrayList<Competitor>();
		competitors.add(c1);
		competitors.add(c2);
		competitors.add(c3);
		competitors.add(c4);
		competitors.add(c5);
		competitors.add(c6);
		return competitors;
	}
	
	
	
	/** The main method 
	 * @param args the argument
	 */
	public static void main(String[] args) {
		List<Competitor> competitors = initCompetitors();
		Competitor c7 = new Competitor("Chaima");
		Competitor c8 = new Competitor("Yannick");
		Match rand = new RandomWinner();
		
		s = new Scanner(System.in);

		System.out.print("========== Sports Competition ========== \n");
		System.out.print("Please choose a competition \n" );
		System.out.print("1) Tournament, 2) League \n");
				
		int choice = s.nextInt();
		
		if(choice == 1) {
			System.out.print("========== Tournament Competition ========== \n");
			
			try {
				Tournament t = new Tournament(competitors);
				
				t.play();
				t.displayRanking();
			    } catch (NotAPowerOfTwoException e) {
			      System.out.println("Cannot play a tournament : number of competitors is not a power of two !\n");
			      System.out.print("2 new players will be added : \n" + c7 + " and " + c8 + "\n");
			      
					competitors.add(c7);
					competitors.add(c8);
					Tournament t = new Tournament(competitors);

					t.addMatch(rand);
					t.selectMatch();
					t.play();
					t.displayRanking();
			    } 
			}
		else if(choice == 2) {
			System.out.print("========== League Competition  ========== \n");
			League l = new League(competitors);
			
			l.addMatch(rand);
			l.selectMatch();
			
			l.play();
			l.displayRanking();
		}
		else {
			System.out.print("Please choose an existing competition \n");
		}		
	}
	
}
