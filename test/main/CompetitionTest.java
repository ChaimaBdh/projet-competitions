package main;

import java.util.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.*;

import main.exceptions.UnknownPlayerException;
import main.mocks.MockCompetition;
import main.strategy.RandomWinner;

public abstract class CompetitionTest {
	
	public Competition c;
	public MockCompetition m;
	public List<Competitor> comps;
	public Match rand;
	public Competitor c1,c2,c3,c4,c5;
	public int test=0;
	
	@BeforeEach
	void init() {
		c1 = new Competitor("Blastoff");
		c2 = new Competitor("Drift");
		c3 = new Competitor("Catalyst", 1);
		c4 = new Competitor("Raven", 8);
		this.comps = new ArrayList<Competitor>();
		m=new MockCompetition(comps);
		comps.add(c1);
		comps.add(c2);
		comps.add(c3);
		comps.add(c4);
		rand=new RandomWinner();
		c=this.createOneCompetition();
	}
	
	@Test
	void testRemoveCompetitorNotInList() throws UnknownPlayerException {
		c5=new Competitor("AB");
		assertFalse(c.getAllCompetitors().contains(c5));
		assertThrows(UnknownPlayerException.class,() ->{
			c.removeCompetitor(c5);
		});
	}
	
	@Test
	void testRemoveCompetitor() throws UnknownPlayerException {
		assertEquals(4,c.getAllCompetitors().size());
		c.removeCompetitor(c1);
		assertEquals(3,c.getAllCompetitors().size());
	}

	@Test
	void testCompetitors() {
		assertEquals(4,c.getAllCompetitors().size());
		c5=new Competitor("Lynx");
		c.addCompetitor(c5);
		assertEquals(5,c.getAllCompetitors().size());
	}
	
		
	@Test
	void testPlay() {
		assertEquals(0,m.test);
		m.play();
		assertEquals(1,m.test);
		m.play(comps);
		m.playMatch(c1, c2);
		m.playMatch(c3, c4);
		assertEquals(4,m.test);
	}
	
	@Test
	void testRanking() {
		c5=new Competitor("Lynx");
		assertTrue(m.ranking().containsKey(c1));
		assertFalse(m.ranking().containsKey(c5));
		assertEquals(4,m.ranking().size());
		m.displayRanking();
	}
	
	
	@Test
	void testMatch(){
		assertEquals(0,m.getAllMatch().size());
		m.matchs.add(rand);
		assertEquals(1,m.getAllMatch().size());
		assertEquals(0,m.test);
		m.displayMatchPossible();
		m.selectMatch();
		assertEquals(2,m.test);
	}
		
	public abstract Competition createOneCompetition();

}
