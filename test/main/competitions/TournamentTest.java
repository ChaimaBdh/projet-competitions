package main.competitions;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.*;
import main.CompetitionTest;
import main.Competitor;
import main.exceptions.*;


class TournamentTest extends CompetitionTest{
	
	private Tournament t;

	@Override
	public Competition createOneCompetition() {
		return this.t = new Tournament(this.comps);
	}
	

	@Test
	void NotApowerOfTwoException() throws NotAPowerOfTwoException {
		c5=new Competitor("Bayern Munich");
		t.addCompetitor(c5);
		assertTrue(t.getAllCompetitors().contains(c5));
		assertThrows(NotAPowerOfTwoException.class,() ->{
			new Tournament(comps);
		});
	}
	
	@Test
	public void tournamentTest() {
		t.play(this.comps);
		int allpts=0;
		for (Competitor c : comps){
			allpts += c.getPoints();
		}
		assertEquals(comps.size()-1,allpts);
	}
}
