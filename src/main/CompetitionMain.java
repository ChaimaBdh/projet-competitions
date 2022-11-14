package main;

import java.util.*;
import main.strategy.*;
import main.competitions.*;
import main.exceptions.NotAPowerOfTwoException;

/** Main class that will play the competition depending on what kind of competition the user will choose */
public class CompetitionMain {
	
	/** the scanner */
	private static Scanner s;
	
	/** The main method 
	 * @param args the argument
	 */
	public static void main(String[] args) {
		List<Competitor> competitors = new ArrayList<Competitor>();
		Selection s1=new SelectFirst();
		Selection s2=new SelectTwoFirst();
		Selection s3=new SelectTwoFirstThenTwoBestThird();
		
		s = new Scanner(System.in);
		boolean done = false;
		System.out.print("========== Sports Competition ========== \n");			
		System.out.print("Please choose a competition \n" );
		System.out.print("1) Tournament, 2) League, 3) Master \n");
		do {
			
		int choice = s.nextInt();
		
		if(choice == 1) {
			System.out.print("========== Tournament Competition ========== \n");
			System.out.print("Choose a number of competitors \n");
			
			int number=s.nextInt();
			for(int i = 0; i < number; i++) {
				competitors.add(new Competitor("Competitor "+Integer.toString(i+1)));
			}
			
			try {
				Tournament t = new Tournament(competitors);
				t.play();
				t.displayRanking();
			    } catch (NotAPowerOfTwoException e) {
			      System.out.println("Cannot play a tournament : number of competitors is not a power of two !\n");
			    }
			done=true;
			}
		else if(choice == 2) {
			System.out.print("========== League Competition  ========== \n");
			System.out.print("choose a number of competitors \n");
			
			int number=s.nextInt();
			for(int i = 0; i < number; i++) {
				competitors.add(new Competitor("Competitor "+Integer.toString(i+1)));
			}
			League l = new League(competitors);	
			l.play();
			l.displayRanking();
			done=true;
		}
		
		else if(choice == 3){
			String[] worldCup = {"Qatar", "Ecuador", "Senegal", "Netherlands", "England", "Iran", "USA", "Wales", "Argentina",
					"Saudi Arabia", "Mexico", "Poland", "France", "Australia", "Denmark", "Tunisia",
					"Spain", "Costa Rica", "Germany", "Japan", "Belgium", "Canada", "Morocco",
					"Croatia", "Brazil", "Serbia", "Switzerland", "Cameroon", "Portugal", "Ghana", "Uruguay", "South Korea"				
					};
			for( int i =0;i < worldCup.length; i++) {
				competitors.add(new Competitor(worldCup[i]));
			}
			 boolean ok = false;
			 System.out.print("========== Master Competition  ========== \n");
			 System.out.println("Select the type of Master you want");
			 System.out.print("1) Master(16) : 16 competitors will be choose \n");
			 System.out.print("2) Master(24) : 24 competitors will be choose\n");
			 System.out.print("3) Master(32) : 32 competitors will be choose\n");
			 do {
			 int choice2 = s.nextInt();
			 if(choice2 == 1) {
				System.out.print("========== The World Cup 2022 ========== \n");
				System.out.print(" \n");
				Master m1=new Master(competitors,s1,4);
				m1.play();
				ok=true;
			 }
			 else if(choice2 == 3) {
				System.out.print("========== The World Cup 2022 ========== \n");
				System.out.print(" \n");
				Master m2=new Master(competitors,s2,8);
				m2.play();
				ok=true;
			 }
			 else if(choice2 ==2) {
				System.out.print("========== The World Cup 2022 ========== \n");
				System.out.print(" \n");
				Master m3=new Master(competitors,s3,3);
				m3.play();
				ok=true;
			 }
			 else {
				System.out.print("Master doesn't exist \n");
				System.out.println("Please choose an existing Master 4");
			 }
			 }while(!ok);
			 
			 done=true;
		 	}
		else {
			System.out.print("Competition doesn't exist \n");
			System.out.println("Please choose an existing competition ");
		}
		}while(!done);
	}
	
}

