package cards;

public class CardTest {

	public static void main(String[] args) throws Exception {
		Card c = new Card (Card.SPADE, 1);
		System.out.println ("spade 1 " + c.toString());
		c = new Card (Card.HEART, 13);
		System.out.println ("heart 13 " + c.toString());
		c = new Card (Card.CLUB, 2);
		System.out.println ("club 2 " + c.toString());
		c = new Card (Card.DIAMOND, 13);
		System.out.println ("diamond 13 " + c.toString());
		c = new Card (1);
		System.out.println ("ace of spades = 1 " + c.toString());
		c = new Card (52);
		System.out.println ("king of diamonds = 52 " + c.toString());
		try {
			Card c1 = new Card (Card.DIAMOND, 0);
			System.out.println ("diamond 0 " + c1.toString()); 
			} 		
		catch (Exception e){ e.printStackTrace(); 	}
		try {
			Card c2 = new Card (Card.CLUB, 14);
			System.out.println ("club 14 " + c2.toString());
		}
		catch (Exception e){ e.printStackTrace(); 	}
		try {
			Card c3 = new Card ("X", 13);
			System.out.println (" X " + " 14 " + c3.toString());
		}
		catch (Exception e){ e.printStackTrace(); 	}

		/** System.out.println(1/13.0);
		System.out.println(2/13.0);
		System.out.println(14/13.0);
		System.out.println(52/13.0); **/
		
	}

}
