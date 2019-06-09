package com.dev.bowling;

public class BowlingGame {
	private int rolls[]= new int[21];
	private int currentRoll=0;
	private static int ZERO_SCORE =0;
	private static int MAX_FRAMES=10;
	private static int MAX_PINS_IN_FRAME=10;
	
	public void roll(int pins) {
		rolls[currentRoll++]=pins;
	}
	
	public int calculateScore() {
		int score = ZERO_SCORE;
	    int frameIndex = 0;
	    for (int frame = 0; frame < MAX_FRAMES ; frame++) {
	    	if (isStrike(frameIndex))
	        {
	          score += MAX_PINS_IN_FRAME +rolls[frameIndex+1] +rolls[frameIndex+2];
	          frameIndex++;
	        }else if (isSpare(frameIndex))
	        {
		        score += MAX_PINS_IN_FRAME + rolls[frameIndex + 2];
		        frameIndex += 2;
	        } else {
	        score += rolls[frameIndex] + rolls[frameIndex + 1];
	        frameIndex += 2;
	      }
	    }
	    return score;
	  }
	
	  private boolean isSpare(int frameIndex) {
		    return rolls[frameIndex] +rolls[frameIndex + 1] == MAX_PINS_IN_FRAME;
	  }
	  private boolean isStrike(int frameIndex) {
		    return rolls[frameIndex] == MAX_PINS_IN_FRAME;
	  }
}
