package cards;

public class SingleDeckTest {

	public static void main(String[] args) throws Exception {
		System.out.println("create the deck");
		CardDeck d = new CardDeck();
		System.out.println(d.toString());
		System.out.println("shuffle the deck");
		d.shuffle();
		System.out.println(d.toString());	
	}
}
