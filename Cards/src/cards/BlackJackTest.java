package cards;

public class BlackJackTest {
		public static void main(String[] args) throws Exception {
			CardGame c = new BlackJack();
			c.addPlayer("Joe");
			c.addPlayer("Judi");
			c.addPlayer("Thomas");
			c.dealCards(2); //  cards per player
			System.out.println(c.toString() ) ;

			c = new BlackJack();
			//c.addPlayer("Joe");  no players
			try {			
				c.dealCards(2); //  cards per player
				System.out.println(c.toString()) ;
			}
			catch (Exception e) {
				System.out.println(e.toString());
			}
			System.out.println();

			c = new BlackJack();
			c.addPlayer("Joe");
			c.addPlayer("Thomas");
			c.dealCards(30); //  cards per player
			System.out.println(c.toString()) ;
		}
	}

