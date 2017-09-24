package cards;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BlackJack {
	
	public static void main (String[] args) throws Exception {
		BlackJack bj = new BlackJack();
		bj.addPlayer("Joe", 1000);
		bj.addPlayer("Dealer", 1000000);
		//System.out.println( bj.toString() );
		bj.play();
	}
	
	ArrayList<BlackJackPlayer> players = new ArrayList<BlackJackPlayer>();
	CardDeck deck ;
	int numPlayers = 0;

	public BlackJack () {
	}

	public void play() throws Exception {
		
		//while (true) {			
			for (int i=0; i< (numPlayers-1); i++) {
				bet (i);
			}
	
			dealCards(2); //  cards per player

			showDealer (); 
			
			for (int i=0; i< (numPlayers-1); i++) {
				handlePlayer (i);
			}
			
			handleDealer ();  // last player
			
			finishHand ();
		//}
	}
		
	private void showDealer () {
		BlackJackPlayer dealer = players.get(players.size()-1); 
	    System.out.println(dealer.getDealerCards() );		
	}
	
	private void bet (int playerNum) {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String cmd = "";
		do {  // do while until valid bet
		    System.out.print(players.get(playerNum).getChips() + " Enter your bet (0 = Quit): ");
		    try {
		    	cmd = reader.readLine();
		    }
		    catch (Exception e) {
		    	System.out.println(e.toString());
		    }
		}
    	while ( ! placeBet (playerNum, cmd) );  
	}

	private boolean placeBet (int player, String cmd) {
		int bet = 0;
		try {
			bet = Integer.parseInt(cmd);
		}
		catch (Exception e) {
			bet = -1 ;
			System.out.println("Invalid bet, try again");
			return false ;
		}
		
		BlackJackPlayer p = players.get(player);
		if (bet == 0 ) {
			System.out.println("bye");
			System.exit(0); 
		}
		else if (p.setWager (bet) ) {
			return true;  //valid bet	
		}
		else 
		{
			System.out.println("Invalid bet");
			return false; // bet is not valid, prompt again
		}
		return false ;
	}
	
	private void handlePlayer (int playerNum) {
		String cmd = "";
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		do {
			BlackJackPlayer p = players.get(playerNum); 
		    System.out.print(p.getCards() );
			if (p.getScore() >= 21) {
				System.out.println();
				return;
			}
			
		    System.out.print( " Enter (H)it, (S)tick: ");
		    try {
		    	cmd = reader.readLine();
		    }
		    catch (Exception e) {
		    	System.out.println(e.toString());
		    }
		}
	    while ( playerNotDone (playerNum, cmd) );
	}

	private boolean playerNotDone (int player, String cmd) {
		BlackJackPlayer p = players.get(player);
		if (cmd.toUpperCase().equals("H")) {
			Card c = deck.dealCard();
			p.addCard(c);
			return true ; // player not done
		}
		else if (cmd.toUpperCase().equals("S")) 
			return false; // player done 
		else 
			return true;
	}
	
	private void handleDealer () {
	    System.out.println("Handle Dealer");
	}

	private void finishHand () {
	    System.out.println("Finish Hand");
	}


	public Player addPlayer (String name, int chips) {
		BlackJackPlayer p = new BlackJackPlayer(name, chips) ;
		players.add(p);
		numPlayers ++;
		return p;
	}
	
	public String toString () {
		String s = "";
		for (int i=0; i< numPlayers; i++)
			s += players.get(i).toString() + "\n" ;
		return s;
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
	
}
