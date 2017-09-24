package cards;

import java.util.ArrayList;
import java.util.List;

public class BlackJackPlayer implements Player {

	int chips = 0; 
	int wager = 0;
	int score = 0;
	
	List <Card> myCards = new ArrayList <Card> ();
	String playerName = "not initialized";
	
	public BlackJackPlayer (String name) {
		playerName = name;
	}
	
	public BlackJackPlayer (String name, int chips) {
		playerName = name;
		this.chips = chips;
	}
	
	public void addCard(Card c) {
		myCards.add(c); 
		setScore ();	
	}
	
	private void setScore () {
		score = 0 ;
		for (int i=0; i<myCards.size(); i++) {
			int tmp = myCards.get(i).getRankInt();
			if (tmp > 10) 
				tmp = 10 ;
			score += tmp;
		}
	}
	
	public String toString () {
		String s = playerName + ": \t" ;
		for (int i=0; i<myCards.size(); i++) {
			s += myCards.get(i).toString() + " ";
		}
		s += "(" + score + ") ";
		s += " Chips: " + chips;
		return s;
	}
	
	public String getPlayerName() {
		return playerName;
	}

	public String getCards () {
		String s = playerName + ": " ;
		for (int i=0; i<myCards.size(); i++) {
			s += myCards.get(i).toString() + " ";
		}
		s += "(" + score + ") ";
		return s;
	}
	
	public String getDealerCards () {
		String s = playerName + ": " ;
		for (int i=0; i<myCards.size(); i++) {
			if (i == 0 )
				s += "XX " ;
			else
				s += myCards.get(i).toString() + " ";
		}
		return s;
	}
	
	public String getChips () {
		String s = playerName + ": " ;
		s += " Chips: " + chips;
		return s;
	}
	
	public int getScore () {
		return score;
	}
	
	public int getChipsInt () {
		return chips;
	}
	
	public boolean setWager (int bet) {
		if (bet > 0 && bet <= chips) {
			wager = bet;
			chips = chips - bet;
			return true;
		}
		else
			return false;
	}
	
}
