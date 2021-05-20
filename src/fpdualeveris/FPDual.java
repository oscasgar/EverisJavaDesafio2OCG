package fpdualeveris;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import operators.Ball;
import operators.Pinball;
import operators.Player;
import operators.Pts;

public class FPDual {

	/**
	 * main method of FPDual
	 * 
	 * @author ocastrog
	 *
	 */
	public static void main(String[] args) {

		operatorsChallenge();

	}

	/**
	 * method where the application is executed
	 */
	private static void operatorsChallenge() {
		Ball[] ballList = createBalls(1000);
		Player actPlayer = Player.createPlayer("default", Pts.MEDIUM, Pts.MEDIUM);
		Pinball pinball = new Pinball(ballList);
		selectionMenu();
		Scanner sc = new Scanner(System.in);
		// Metemos scanner, no hay miedo!!
		menuSelector(pinball, sc, actPlayer);
		sc.close();
	}

	/**
	 * Method to make the selection in the menu
	 * 
	 * @param pinball
	 * @param sc
	 */
	private static void menuSelector(Pinball pinball, Scanner sc, Player actPlayer) {
		char optionChar = sc.nextLine().charAt(0);
		byte option = (byte) Character.getNumericValue(optionChar);
		switch (option) {
		case 1:
			actPlayer = createPlayer(sc);
			System.out.println("");
			selectionMenu();
			menuSelector(pinball, sc, actPlayer);
			break;
		case 2:
			System.out.println("Elige un jugador (Si no tienes uno elige default)");
			String playerNameC2 = sc.nextLine();
			actPlayer = playerFinder(sc, playerNameC2);
			System.out.println("");
			selectionMenu();
			menuSelector(pinball, sc, actPlayer);
			break;
		case 3:
			if (actPlayer == null) {
				System.out.println("Elige un jugador (Si no tienes uno elige default)");
				String playerNameC3 = sc.nextLine();
				actPlayer = playerFinder(sc, playerNameC3);
			}
			System.out.println("Estas jugando como:");
			System.out.println(actPlayer.toString());
			pinball.launchBall(actPlayer);
			System.out.println("");
			selectionMenu();
			menuSelector(pinball, sc, actPlayer);
			break;
		case 4:
			System.out.println("Record global:");
			System.out.println(Player.getGlobalHighscoreName());
			System.out.println(Player.getGlobalHighscore());
			System.out.println("");
			selectionMenu();
			menuSelector(pinball, sc, actPlayer);
			break;
		case 5:
			if (actPlayer == null) {
				System.out.println("Elige un jugador (Si no tienes uno elige default)");
				String playerName = sc.nextLine();
				actPlayer = playerFinder(sc, playerName);
			}
			System.out.println("Resord personal:");
			System.out.println(actPlayer.getHihgscore());
			System.out.println("");
			selectionMenu();
			menuSelector(pinball, sc, actPlayer);
			break;
		case 6:
			break;
		default:
			System.out.println("Error vuelve a probar");
			// Por aqui no me pillas tellez
			System.out.println("");
			selectionMenu();
			menuSelector(pinball, sc, actPlayer);
			break;
		}
	}

	/**
	 * method to find a player by name
	 * 
	 * @param sc
	 */
	private static Player playerFinder(Scanner sc, String playerName) {
		ArrayList<Player> playerList = Player.getPlayerList();
		Iterator<Player> itPlayerList = playerList.iterator();
		Player player = null;
		while (itPlayerList.hasNext() && player == null) {
			Player iPlayer = itPlayerList.next();
			if (iPlayer.getNAME().equals(playerName)) {
				player = iPlayer;
			}
		}
		if (player == null) {
			player = playerFinder(sc, "default");
		}
		return player;
	}

	/**
	 * Method to create a player
	 * 
	 * @param sc
	 */
	private static Player createPlayer(Scanner sc) {
		System.out.println("Dame el nombre del jugador");
		String name = sc.nextLine();
		System.out.println("Dame su nivel de suerte (1-5)");
		char luckOptionChar = sc.nextLine().charAt(0);
		byte luckOption = (byte) Character.getNumericValue(luckOptionChar);
		Pts luck = levelTraductor(luckOption);
		System.out.println("Dame su nivel de habilidad (1-5)");
		char skillOptionChar = sc.nextLine().charAt(0);
		byte skillOption = (byte) Character.getNumericValue(skillOptionChar);
		Pts skill = levelTraductor(skillOption);
		return (Player.createPlayer(name, luck, skill));
	}

	/**
	 * method to transform the enum into a byte
	 * 
	 * @param option
	 */
	private static Pts levelTraductor(byte option) {
		Pts level;
		switch (option) {
		case 1:
			level = Pts.VERY_LOW;
			break;
		case 2:
			level = Pts.LOW;
			break;
		case 3:
			level = Pts.MEDIUM;
			break;
		case 4:
			level = Pts.HIGH;
			break;
		case 5:
			level = Pts.VERY_HIGH;
			break;
		default:
			System.out.println("Error, prueba otra vez");
			level = levelTraductor(option);
			break;
		}
		return level;
	}

	/**
	 * method to print selection menu on screen
	 */
	private static void selectionMenu() {
		System.out.println("Menu de seleccion (introduce un numero): ");
		System.out.println("1.- Crear jugador");
		System.out.println("2.- Elegir jugador");
		System.out.println("3.- Jugar");
		System.out.println("4.- Ver HighScore Global");
		System.out.println("5.- Ver HighScore Personal");
		System.out.println("6.- Salir");
	}

	/**
	 * loop to create balls
	 * 
	 * @param numb
	 * @return
	 */
	private static Ball[] createBalls(int numb) {
		Ball ballList[] = new Ball[numb];
		for (int i = 0; i < numb; i++) {
			ballList[i] = new Ball(i);
		}
		return ballList;
	}
}
