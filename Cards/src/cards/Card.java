/**
 * 
 */
package cards;

/**
 * @author fusion
 *
 */
public class Card {

	public Card (String suit, int rank) throws Exception {
		setNumValue (suit, rank) ;
	}

	public Card (int val) throws Exception {
		setNumValue (val);
	}

	public String toString() {
		//return "Card [suit=" + getSuit() + ", rank=" + getRank() + ", numValue=" + numValue + "]";
        return getRank() + getSuit() ;
	}

	double numValue ;
	
	public static String SPADE = "S";
	public static String HEART = "H";
	public static String CLUB = "C";
	public static String DIAMOND = "D";
	
	private void setNumValue(String s, int rankval) throws Exception {
		int suitval = -1;
		if (s.equals(SPADE) || s.equals(HEART) || s.equals(CLUB) || s.equals(DIAMOND) )  
				suitval = suitStringToInt (s) ;
		else throw new Exception ("Invalid suit (must be S H C D): " + s);
		
		if (rankval < 1  || rankval > 13) 
			throw new Exception ("Invalid rank (must be 1-13): " + rankval);
		
		numValue = suitval*13 + (rankval - 1);
	}

	private void setNumValue(int num) throws Exception {
		if (num > 52 || num < 1) 
			throw new Exception ("Invalid numValue for card (must be 1-52): " + num);
		numValue = num-1;
	}


	private String suitIntToString (int i) {
		if (i == 0) return Card.SPADE;
		else if (i == 1) return Card.HEART;
		else if (i == 2) return Card.CLUB;
		else return Card.DIAMOND; // i == 3  
	} 

	private int suitStringToInt (String s) throws Exception {
		if (s.equals(Card.SPADE)) return 0 ;
		else if (s.equals(Card.HEART)) return 1 ;
		else if (s.equals(Card.CLUB)) return 2 ;
		else if (s.equals(Card.DIAMOND)) return 3 ;
		else throw new Exception ("Invalid suit character: " + s);
	} 

	public String getSuit() {
		int i = (int) (numValue / 13.0  ) ;
		return suitIntToString ( i );
	}

	public int getRankInt() {
		int i = (int) (numValue % 13) + 1  ;
		return i ;
	}

	public String getRank() {
		int i = (int) (numValue % 13) + 1  ;
		if (i == 10) return "T";
		else if (i == 1) return "A";
		else if (i == 11) return "J";
		else if (i == 12) return "Q";
		else if (i == 13) return "K";
		return String.valueOf(i) ;
	}

	public int getNumValue() {
		return (int) numValue;
	}

}
