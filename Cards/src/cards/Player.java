package cards;

import java.util.ArrayList;

public class Player {
	
	ArrayList<Card> myCards = new ArrayList<Card>();

	String playerName ;

	public Player (String name) {
		playerName = name; 
	}

	
	public String getPlayerName() {
		return playerName;
	}

	public void addCard(Card c) {
		myCards.add(c);
	}
	
	public String toString () {
		String s = "Player " + playerName + ": \t" ;
		for (int i=0; i<myCards.size(); i++) {
			s += myCards.get(i).toString() + " ";
		}
		return s;
	}
}
