package operators;

import java.util.Random;

public class Pinball {

	Ball[] ballList;
	Random rd = new Random();

	/**
	 * Pinball constructor
	 * 
	 * @param ballList
	 */
	public Pinball(Ball[] ballList) {
		this.ballList = ballList;
	}

	/**
	 * Method that "throws the ball" and starts the pinball
	 * 
	 * @param player
	 */
	public void launchBall(Player player) {
		Ball ball = ballList[rd.nextInt(ballList.length)];
		System.out.println(ball.getBALLID());
		System.out.println(ball.getLevelOfImperfection());
		hitBall(ball, player);
		String mensaje = (ball.getPoints() > Player.getGlobalHighscore()) ? "¡Nuevo record global!" : "¡Nuevo record personal!";
		if (ball.getPoints() > Player.getGlobalHighscore()) {
			System.out.println(mensaje);
			Player.setGlobalHighscore(ball.getPoints());
			Player.setGlobalHighscoreName(player.getNAME());
			player.setHihgscore(ball.getPoints());
		} else if (ball.getPoints() > player.getHihgscore()) {
			System.out.println(mensaje);
			player.setHihgscore(ball.getPoints());
		}
		ball.setPoints(0);
	}

	/**
	 * Method to calculate points randomly by simulating that the ball hits the targets
	 * 
	 * @param ball
	 * @param player
	 */
	private void hitBall(Ball ball, Player player) {
		boolean fall = false;
		while (!fall) {
			hitTarget(ball, player);
			fall = (player.getLUCK() == Pts.VERY_LOW && player.getSKILL() == Pts.VERY_LOW) ? true : false;
			int chanceToHit = rd.nextInt(10) + 1;
			if (player.getLUCK() == Pts.VERY_HIGH) {
				chanceToHit = chanceToHit + 1;
			}

			if (player.getSKILL() == Pts.VERY_HIGH && chanceToHit <= 2) {
				fall = true;
			} else if (player.getSKILL() == Pts.HIGH && chanceToHit <= 4) {
				fall = true;
			} else if (player.getSKILL() == Pts.MEDIUM && chanceToHit <= 6) {
				fall = true;
			} else if (player.getSKILL() == Pts.LOW && chanceToHit <= 7) {
				fall = true;
			} else if (player.getSKILL() == Pts.VERY_LOW && chanceToHit <= 9) {
				fall = true;
			}

			if (!fall) {
				System.out.println("¡Has golpeado la bola y ha subido hasta arriba para volver a caer!");
				hitTarget(ball, player);
			}
		}

	}

	/**
	 * Method to calculate points randomly by simulating that the ball hits the targets
	 * 
	 * @param ball
	 * @param player
	 */
	private void hitTarget(Ball ball, Player player) {
		if (ball.getLevelOfImperfection() == Pts.VERY_HIGH || player.getLUCK() == Pts.VERY_LOW) {
			if (rd.nextInt(2) == 1) {
				System.out.println("¡Oh no tu bola ha saltado y ha bajado sin darle a ningun objetivo");
			}
		} else if (player.getLUCK() == Pts.LOW || ball.getLevelOfImperfection() == Pts.HIGH) {
			if (rd.nextInt(4) == 1) {
				System.out.println("¡Oh no tu bola ha saltado y ha bajado sin darle a ningun objetivo");
			}
		} else {
			int targetHitted = rd.nextInt(36);

			if (player.getLUCK() == Pts.HIGH || ball.getLevelOfImperfection() == Pts.VERY_LOW) {
				targetHitted += 1;
			} else if (player.getLUCK() == Pts.VERY_HIGH) {
				targetHitted += 5;
			}

			if (targetHitted >= 0 && targetHitted <= 19) {
				ball.setPoints(ball.getPoints() + 10);
				System.out.println("¡+ 10 puntos!");
			} else if (targetHitted >= 20 && targetHitted <= 29) {
				ball.setPoints(ball.getPoints() + 20);
				System.out.println("¡+ 20 puntos!");
			} else if (targetHitted >= 30 && targetHitted <= 34) {
				ball.setPoints(ball.getPoints() + 50);
				System.out.println("¡+ 50 puntos!");
			} else if (targetHitted >= 35 && targetHitted <= 40) {
				ball.setPoints(ball.getPoints() + 100);
				System.out.println("¡+ 100 puntos!");
			} else {
				System.out.println("Error puntos");
			}
		}

		if (rd.nextInt(10) < 9) {
			System.out.println("¡Tu bola ha rebotado y se dirige a otro objetivo!");
			hitTarget(ball, player);
		}

	}
}
