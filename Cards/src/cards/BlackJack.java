package cards;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BlackJack {
	
	ArrayList<Player> players = new ArrayList<Player>();
	CardDeck deck ;

	public BlackJack () {
	}

	// TODO make a state status that gives the next operation: bet, deal, shows, handels, finish...
	public void play() throws Exception {
		
		while (true) {	
			
			for (int i=0; i< (players.size()-1); i++) {
				bet (i);
			}
	
			dealCards(2); //  cards per player

			showDealer (); 
			
			for (int i=0; i< (players.size()-1); i++) {
				handlePlayer (i);
			}
			
			handleDealer ();  // last player
			
			finishHand ();
		}
	}
		
	private void showDealer () {
		Player dealer = getDealer(); 
	    System.out.println(dealer.getDealerCards() );		
	}
	
	private Player getDealer () {
		Player dealer = players.get(players.size()-1); 
	    return dealer;		
	}
	
	private void bet (int playerNum) {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String cmd = "";
		Player p = players.get(playerNum);

		do {  // do while until valid bet
		    System.out.print(p.getChips() + " Place bet (0 = Quit): ");
		    if (p.getWager() > 0) 
		    	System.out.print (" (Enter=keep " + p.getWager() + "): " );
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
		
		Player p = players.get(player);
		if (cmd.equals("") && p.getWager() > 0 ) {
			p.setWager(p.getWager());
			return true;
		}
			
		try {
			bet = Integer.parseInt(cmd);
		}
		catch (Exception e) {
			bet = -1 ;
			System.out.println("Invalid bet, try again");
			return false ;
		}
		
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
		Player p = players.get(playerNum); 
		do {
		    System.out.print(p.getPlayerName() + ": " + p.getCards() );
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
		Player p = players.get(player);
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
		int dealer = players.size()-1 ; // dealer is the last player
		Player p = players.get(dealer); 
	    System.out.print(p.getPlayerName() + ": ");
		do {
		    System.out.print(p.getCards() );
		    
			if (p.getDealerScore() > 21  ) {
				System.out.println();
				return;
			}
			if (p.getDealerScore() > 16 && p.getDealerScore() < 22  ) {
				System.out.println();
				return;
			}
			else {
				Card c = deck.dealCard();
				p.addCard(c);
			}
		}
	    while ( true );
	}

	private void finishHand () {
	    //System.out.println("Finish Hand");
		int dealerIndex = players.size()-1 ; // dealer is the last player
		Player dealer = players.get(dealerIndex); 
		for (int i=0; i< (players.size()-1); i++) {
			Player player = players.get(i); 
			if (player.getScore() > 22) 
				player.lost();
			else if (dealer.getDealerScore() > 21) 
				player.won();
			else if (player.getScore() > dealer.getDealerScore())
				player.won();
			else if (player.getScore() == dealer.getDealerScore())
				player.pushed();
			else
				player.lost();
			player.newHand();
			dealer.newHand();
		}
	}


	public void addPlayer (String name, int chips) {
		Player p = new Player(name, chips) ;
		players.add(p);
		//return p;
	}
	
	public String toString () {
		String s = "";
		for (int i=0; i< players.size(); i++)
			s += players.get(i).toString() + "\n" ;
		return s;
	}
	
	public void dealCards (int numPerPlayer) throws Exception {
		if (players.size() < 1) {
			throw new Exception ("ERROR: cannot deal cards, num players = " + players.size()) ;
		}
		//*TODO don't shuffle at the beginning of each deal
		deck = new CardDeck();
		//System.out.println("shuffle the deck");
		deck.shuffle();
		
		for(int i=0; i < numPerPlayer; i++)  // deal cards
			for(int p=0; p < players.size(); p++) { // for each player
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
