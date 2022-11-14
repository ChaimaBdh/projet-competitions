package main.competitions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Competition;
import main.CompetitionTest;
import main.strategy.SelectFirst;


class MasterTest extends CompetitionTest {
	
	protected Master m;
	protected SelectFirst s1;
	
	@Override
	public Competition createOneCompetition() {
		s1=new SelectFirst();
		return m=new Master(comps,s1,2);
	}
	
	@Test
	void mastertest() {
		assertEquals(2,m.getNbOfGroupStage());
		assertEquals(s1,m.getSelection());
		m.play();
		for(League l : m.buildGroupStage()) {
			assertEquals(2,l.getAllCompetitors().size());
		}
	}
	
}
