package com.dev.bowling;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BowlingGameTest {

	@Test
	public void testGameScoreForGutterBalls() {
		BowlingGame game= new BowlingGame();
		
		for(int i=0;i<20;i++) {
			game.roll(0);
		}
		
		assertEquals(0, game.getScore());
	}
	
	@Test
	public void testGameScoreWhenTwoPinsDownPerRoll() {
		BowlingGame game= new BowlingGame();
		
		for(int i=0;i<20;i++) {
			game.roll(2);
		}
		
		assertEquals(40, game.getScore());
	}
}
