package main.competitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.Competition;
import main.CompetitionTest;
import main.Competitor;

class LeagueTest extends CompetitionTest{
	protected League l ;
	
	@Override
	public Competition createOneCompetition() {
		return this.l = new League(this.comps);
	}

	@Test
    public void leagueTest(){
        int size= comps.size();
		l.play(comps);
		int allpts=0;
		for (Competitor c : comps){
			allpts += c.getPoints();
		}
		size = size * (size-1);
		assertEquals(size,allpts);         
    }
}
