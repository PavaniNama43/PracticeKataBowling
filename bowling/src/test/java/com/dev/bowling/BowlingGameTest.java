package com.dev.bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {
	private BowlingGame game;
	
	@Before
	public void setUp() {
		 game = new BowlingGame();
	}
	
	private void rollPins(int roll,int pins) {
		for(int i=0;i<roll;i++) {
			game.roll(pins);
		}
	}
	
	@Test
	public void testGameScoreForGutterBalls() {
		
		rollPins(20,0);
		
		assertEquals(0, game.calculateScore());
	}
	
	@Test
	public void testGameScoreWhenTwoPinsDownPerRoll() {
		rollPins(20,2);
		
		assertEquals(40, game.calculateScore());
	}
	
	@Test
	public void testGameScoreWhenOneSpareInGame(){
		rollSpare();
		game.roll(5);
		rollPins(17,2);
		
		assertEquals(54, game.calculateScore());
	}
	
	private void rollSpare() {
		  game.roll(2);
		  game.roll(8);
	}
	
	@Test
	public void testGameScoreWhenOneStrikeInGame(){
		rollStrike();
		game.roll(5);
		game.roll(3);
		rollPins(16,2);
		
		assertEquals(58, game.calculateScore());
	}
	
	private void rollStrike() {
		  game.roll(10);
	}
	
	@Test
	public void testPerfectGame() {
		rollPins(12,10);
	    assertEquals(300, game.calculateScore());
	  }

}
