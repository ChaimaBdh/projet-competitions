package main.competitions;

import main.Competition;
import main.CompetitionTest;

class LeagueTest extends CompetitionTest{
	protected League l ;
	
	@Override
	public Competition createOneCompetition() {
		return this.l = new League(this.comps);
	}

	
}
