package operators;

import java.util.ArrayList;
import java.util.Iterator;

public class Player {

	private final String NAME;
	private final Pts LUCK;
	private final Pts SKILL;
	private int hihgScore;
	private static int globalHighScore = 0;
	private static String globalHighscoreName = "Nadie ha jugado aun";
	private static ArrayList<Player> playerList = new ArrayList<Player>();

	/**
	 * @return the hihgscore
	 */
	public int getHihgscore() {
		return hihgScore;
	}

	/**
	 * @param hihgscore
	 *            the hihgscore to set
	 */
	public void setHihgscore(int hihgscore) {
		this.hihgScore = hihgscore;
	}

	/**
	 * @return the globalHighscore
	 */
	public static int getGlobalHighscore() {
		return globalHighScore;
	}

	/**
	 * @param globalHighscore
	 *            the globalHighscore to set
	 */
	public static void setGlobalHighscore(int globalHighscore) {
		Player.globalHighScore = globalHighscore;
	}

	/**
	 * @return the globalHighscoreName
	 */
	public static String getGlobalHighscoreName() {
		return globalHighscoreName;
	}

	/**
	 * @param globalHighscoreName
	 *            the globalHighscoreName to set
	 */
	public static void setGlobalHighscoreName(String globalHighscoreName) {
		Player.globalHighscoreName = globalHighscoreName;
	}

	/**
	 * @return the playerList
	 */
	public static ArrayList<Player> getPlayerList() {
		return playerList;
	}

	/**
	 * @param playerList
	 *            the playerList to set
	 */
	public static void setPlayerList(ArrayList<Player> playerList) {
		Player.playerList = playerList;
	}

	/**
	 * @return the nAME
	 */
	public String getNAME() {
		return NAME;
	}

	/**
	 * @return the lUCK
	 */
	public Pts getLUCK() {
		return LUCK;
	}

	/**
	 * @return the sKILL
	 */
	public Pts getSKILL() {
		return SKILL;
	}

	/**
	 * constructor method
	 * 
	 * @param NAME
	 * @param LUCK
	 * @param SKILL
	 */
	private Player(String NAME, Pts LUCK, Pts SKILL) {
		this.NAME = NAME;
		this.LUCK = LUCK;
		this.SKILL = SKILL;
		this.hihgScore = 0;

	}

	/**
	 * method that checks if the name is in the list of people
	 * 
	 * @param NAME
	 * @return
	 */
	private static boolean nameCheck(String NAME) {
		boolean exists = false;
		Iterator<Player> it = playerList.iterator();
		while (it.hasNext()) {
			if (it.next().getNAME().equals(NAME)) {
				exists = true;
			}
		}
		return exists;
	}

	/**
	 * Method to create a player
	 * 
	 * @param name
	 * @param luck
	 * @param skill
	 * @return
	 */
	public static Player createPlayer(String name, Pts luck, Pts skill) {
		Player player = new Player(name, luck, skill);
		if (!nameCheck(name)) {
			Player.playerList.add(player);
		} else {
			System.out.println("Ese jugador ya esta registrado");
		}
		return player;
	}

	/**
	 * to string method
	 */
	@Override
	public String toString() {
		return "Player [NAME=" + NAME + ", LUCK=" + LUCK + ", SKILL=" + SKILL + "]";
	}

	/**
	 * equals method
	 * 
	 * @param p
	 * @return
	 */
	public boolean equals(Player p) {
		boolean equals = false;
		if (this.NAME == p.getNAME()) {
			equals = true;
		}
		return equals;
	}

}
