package cards;

import java.util.ArrayList;

public class CardGame {

	int numPlayers = 0;
	ArrayList<Player> players = new ArrayList<Player>();
	CardDeck deck ;

	public CardGame () {
	}
	
	public void addPlayer (String name) {
		//players.add(new Player (name));
		numPlayers ++;
	}
	
	public void dealCards (int numPerPlayer) throws Exception {
		if (numPlayers < 1) {
			throw new Exception ("ERROR: cannot deal cards, num players = " + numPlayers) ;
		}
		deck = new CardDeck();
		//System.out.println("shuffle the deck");
		deck.shuffle();
		
		for(int i=0; i < numPerPlayer; i++)  // deal cards
			for(int p=0; p < numPlayers; p++) { // for each player
				Card c = deck.dealCard();
				if (c == null) 
					outOfCards (players.get(p), i);
				else 
					players.get(p).addCard(c);
			}
	}
	
	private void outOfCards (Player p, int numCard) {
		System.out.println("ERROR: handle out of cards dealing card " + numCard + 
				" to " + p.getPlayerName());
		System.exit(0);
	}
	
	public String toString () {
		String s = "";
		for (int i=0; i< numPlayers; i++)
			s += players.get(i) + "\n" ;
		return s;
	}
	
}
