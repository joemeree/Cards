// Author: Joe Meree

package cards;

import java.util.ArrayList;
import java.util.List;

public class Player {

	int chips = 0; 
	int wager = 0;
	int score = 0;
	boolean ace = false ;
	
	List <Card> myCards = new ArrayList <Card> ();
	String playerName = "not initialized";
	
	public Player (String name) {
		playerName = name;
	}

	public void newHand () {
		myCards.clear();
		score = 0;
		ace = false ;
	}
	
	public Player (String name, int chips) {
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
			else if (tmp == 1)
				ace = true;
			score += tmp;
		}
	}
	
	public boolean hasAce () {
		return ace;
	}
	
	public String toString () {
		String s = playerName + ": \t" ;
		for (int i=0; i<myCards.size(); i++) {
			s += myCards.get(i).toString() + " ";
		}
		s += "(" + score + ")\t";
		s += "Chips: " + chips;
		return s;
	}
	
	public String getPlayerName() {
		return playerName;
	}

	public String getCards () {
		// String s = playerName + ": " ;
		String s = "";
		for (int i=0; i<myCards.size(); i++) {
			s += myCards.get(i).toString().substring(0,1) + " ";
		}
		s += showScore();
		return s;
	}
	
	public String getDealerCards () {
		String s = playerName + ": " ;
		for (int i=0; i<myCards.size(); i++) {
			if (i == 1 )
				s += "X " ;
			else
				s += myCards.get(i).toString().substring(0,1) + " ";
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

	public int getDealerScore () {
		if (hasAce() && (score + 10) > 16 && (score + 10) < 22  ) {
			return score + 10;
		}
		else {
			return score;
		}
	}


	public String showScore () {
		String s = "";
		if (ace) {
			s = String.valueOf(score) + "/" + String.valueOf(score+10);  
		}
		else
			s = String.valueOf(score);
		return " (" + s + ") ";  
	}
	
	public int getChipsInt () {
		return chips;
	}
	
	public int getWager () {
		return wager ;
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

	public void lost() {
	}

	public void won() {
		chips += (wager * 2);
	}

	public void pushed() {
		chips += wager ;
	}
}
