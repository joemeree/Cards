package cards;

public class BlackJackTest {
		public static void main(String[] args) throws Exception {
			BlackJack c = new BlackJack();
			c.addPlayer("Joe", 1000);
			c.addPlayer("Judi", 1000);
			c.addPlayer("Thomas", 1000);
			c.dealCards(2); //  cards per player
			System.out.println(c.toString() ) ;

			c = new BlackJack();
			//c.addPlayer("Joe", 1000);  no players
			try {			
				c.dealCards(2); //  cards per player
				System.out.println(c.toString()) ;
			}
			catch (Exception e) {
				System.out.println(e.toString());
			}
			System.out.println();

			c = new BlackJack();
			c.addPlayer("Joe", 1000);
			c.addPlayer("Thomas", 1000);
			c.dealCards(30); //  cards per player
			System.out.println(c.toString()) ;
		}
	}

