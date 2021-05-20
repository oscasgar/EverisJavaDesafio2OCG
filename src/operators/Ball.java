package operators;

import java.util.Random;

public class Ball {

	private final int BALLID;
	private Pts levelOfImperfection;
	private int points = 0;

	/**
	 * @return the BALLID
	 */
	public int getBALLID() {
		return BALLID;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points
	 *            the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * @return the levelOfImperfection
	 */
	public Pts getLevelOfImperfection() {
		return levelOfImperfection;
	}

	/**
	 * @param levelOfImperfection
	 *            the levelOfImperfection to set
	 */
	public void setLevelOfImperfection(Pts levelOfImperfection) {
		this.levelOfImperfection = levelOfImperfection;
	}

	/**
	 * Creation of a ball
	 * 
	 * @param id
	 */
	public Ball(int id) {
		BALLID = id;
		Random rd = new Random();
		this.levelOfImperfection = levelOfImperfectionAssignment((byte) (rd.nextInt(35) + 1));
	}

	/**
	 * An imperfection level is assigned to the ball randomly
	 * 
	 * @param x
	 */
	private Pts levelOfImperfectionAssignment(byte x) {
		Pts levelOfImperfection;
		if (x <= 8 || (x >= 21 && x <= 28)) {
			if (x <= 8) {
				levelOfImperfection = Pts.VERY_LOW;
			} else {
				levelOfImperfection = Pts.MEDIUM;
			}
		} else if (x >= 9 && x <= 20) {
			levelOfImperfection = Pts.LOW;
		} else if (x >= 29 && x <= 33) {
			levelOfImperfection = Pts.HIGH;
		} else {
			levelOfImperfection = Pts.VERY_HIGH;
		}
		return levelOfImperfection;
	}

}
