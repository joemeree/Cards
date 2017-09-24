/**
 * 
 */
package cards;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author fusion
 *
 */
public class CardDeck {

	public CardDeck () throws Exception {
        for(int i=1; i<=52; i++){
            deck.add(new Card(i));
       }		
	}

	public void shuffle () {
		Collections.shuffle(deck);
	}
	
	ArrayList<Card> deck = new ArrayList<Card>() ;
	
	public String toString() {
        String s = "";
		for(int i=0; i<52; i++)
            s += deck.get(i).getRank() + deck.get(i).getSuit() + " ";
		return s;
	}
	
	public Card dealCard () {
		if (deck.size() > 0)
			return deck.remove(0);
		else
			return null;
		
	}

}
