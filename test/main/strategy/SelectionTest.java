package main.strategy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.Competitor;
import main.competitions.Master;

class SelectionTest {
	
	public Master m1,m2,m3;
	Selection s1;
	Selection s2;
	Selection s3;
	List<Competitor> comps;
	
	@Test
	void testSelectFinalists1() {
		s1=new SelectFirst();
		this.comps = new ArrayList<Competitor>();
		for(int i = 0; i < 4; i++) {
			comps.add(new Competitor("CompetitorS1 "+Integer.toString(i+1)));
		}
		m1=new Master(comps,s1,2);
		m1.buildGroupStage();
		m1.playGroupStage();
		assertEquals(s1,m1.getSelection());
		s1.selectFinalists(m1.playGroupStage());
		assertEquals(m1.getNbOfGroupStage(),s1.selectFinalists(m1.playGroupStage()).size());
	}
	@Test
	void testSelectFinalists2() {
		s2=new SelectTwoFirst();
		this.comps = new ArrayList<Competitor>();
		for(int i = 0; i < 8; i++) {
			comps.add(new Competitor("CompetitorS2 "+Integer.toString(i+1)));
		}
		m2=new Master(comps,s2,2);
		m2.buildGroupStage();
		m2.playGroupStage();
		assertEquals(s2,m2.getSelection());
		s2.selectFinalists(m2.playGroupStage());
		assertEquals(m2.getNbOfGroupStage()*2,s2.selectFinalists(m2.playGroupStage()).size());
	}
	
	@Test
	void testSelectFinalists3() {
		s3=new SelectTwoFirstThenTwoBestThird();
		this.comps = new ArrayList<Competitor>();
		for(int i = 0; i < 8; i++) {
			comps.add(new Competitor("CompetitorS3 "+Integer.toString(i+1)));
		}
		m3=new Master(comps,s3,3);
		m3.buildGroupStage();
		m3.playGroupStage();
		assertEquals(s3,m3.getSelection());
		s3.selectFinalists(m3.playGroupStage());
		assertEquals(m3.getNbOfGroupStage()*2,s3.selectFinalists(m3.playGroupStage()).size());
	}
}
