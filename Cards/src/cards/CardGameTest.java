package cards;

public class CardGameTest {
	public static void main(String[] args) throws Exception {
		CardGame c = new CardGame();
		c.addPlayer("Joe");
		c.addPlayer("Judi");
		c.addPlayer("TJ");
		c.addPlayer("Steve");
		c.dealCards(3); //  cards per player
		System.out.println(c.toString() ) ;

		System.out.println("Deal to 0 players") ;
		c = new CardGame();
		//c.addPlayer("Joe");  no players
		try {			
			c.dealCards(3); //  cards per player
			System.out.println(c.toString()) ;
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println();

		System.out.println("Deal too many cards") ;
		c = new CardGame();
		c.addPlayer("Joe");
		c.addPlayer("TJ");
		c.dealCards(30); //  cards per player
		System.out.println(c.toString()) ;
	}
}
