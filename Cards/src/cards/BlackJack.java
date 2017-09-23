package cards;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BlackJack extends CardGame {
	
	public BlackJack () {
	}

	public static void main (String[] args) throws Exception {
		BlackJack bj = new BlackJack();
		bj.addPlayer("Joe", 1000);
		bj.addPlayer("Dealer", 1000000);
		//System.out.println( bj.toString() );
		bj.play();
	}
	
	public void play() throws Exception {
		
		//while (true) {			
			for (int i=0; i< (numPlayers-1); i++) {
				bet (i);
			}
	
			dealCards(2); //  cards per player

			System.out.println(toString() ) ;
			
			for (int i=0; i< (numPlayers-1); i++) {
				handlePlayer (i);
			}
			
			handleDealer ();  // last player
			
			finishHand ();
		//}
	}
		
	private void bet (int playerNum) {
		String cmd = "";
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    System.out.print("Enter your bet (0 = Quit): ");
	    try {
	    cmd = reader.readLine();
	    }
	    catch (Exception e) {
	    	System.out.println(e.toString());
	    }
	    System.out.println("You entered: " + cmd);
	}

	private void handlePlayer (int playerNum) {
		String cmd = "";
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    System.out.print("Enter (H)it, (S)tick: ");
	    try {
	    cmd = reader.readLine();
	    }
	    catch (Exception e) {
	    	System.out.println(e.toString());
	    }
	    System.out.println("You entered: " + cmd);
	}

	private void handleDealer () {
	    System.out.println("Handle Dealer");
	}

	private void finishHand () {
	    System.out.println("Finish Hand");
	}


	public Player addPlayer (String name, int chips) {
		Player p = new BlackJackPlayer(name, chips) ;
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
	
}
