package main.strategy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Competitor;
import main.match.RandomWinner;
import main.mocks.MockMatch;

class RandomWinnerTest {
	
	public MockMatch ma;
	public RandomWinner r;
	public Competitor c1,c2;
	
	@BeforeEach
	void init() {
		c1 = new Competitor("Blastoff");
		c2 = new Competitor("Drift");
		ma=new MockMatch(c1,c2);
		r=new RandomWinner();
	}
	@Test
	void testGetWinner() {
		assertEquals(0,ma.test);
		ma.getWinner(c1, c2);
		assertEquals(1,ma.test);
	}

	@Test
	void testToString() {
		assertEquals("Random winner : a random winner will be returned",r.toString());
	}

}
