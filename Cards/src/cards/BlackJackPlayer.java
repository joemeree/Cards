package cards;

public class BlackJackPlayer extends Player {

	int chips = 0; 
	int Wager = 0;
	
	public BlackJackPlayer (String name) {
		super(name);
	}
	
	public BlackJackPlayer (String name, int chips) {
		super(name);
		this.chips = chips;
	}
	
	public static void main(String[] args) { 
		// TODO Auto-generated method stub

	}
	
	public void addCard(Card c) {
		myCards.add(c);
	}
	
	public String toString () {
		String s = "Player " + playerName + ": \t" ;
		for (int i=0; i<myCards.size(); i++) {
			s += myCards.get(i).toString() + " ";
		}
		s += " Chips: " + chips;
		return s;
	}
	
}
