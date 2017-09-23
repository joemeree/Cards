package cards;

public class CardGameTest {
	public static void main(String[] args) throws Exception {
		CardGame c = new CardGame();
		c.addPlayer("Joe");
		c.addPlayer("Judi");
		c.addPlayer("Thomas");
		c.addPlayer("Steven");
		c.dealCards(5); //  cards per player
		System.out.println(c.toString() ) ;

		c = new CardGame();
		//c.addPlayer("Joe");  no players
		try {			
			c.dealCards(5); //  cards per player
			System.out.println(c.toString()) ;
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println();

		c = new CardGame();
		c.addPlayer("Joe");
		c.addPlayer("Thomas");
		c.dealCards(30); //  cards per player
		System.out.println(c.toString()) ;
	}
}
