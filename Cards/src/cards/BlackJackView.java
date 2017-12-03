package cards;

public class BlackJackView {

	BlackJack bj ;

	public BlackJackView () {
		bj = new BlackJack();
	}

	public void addPlayer (String name, int chips) {
		bj.addPlayer (name, chips) ;
	}
	
	public void play () throws Exception {
		bj.play();
	}
	

	public static void main (String[] args) throws Exception {
		BlackJackView bjv = new BlackJackView();
		bjv.addPlayer("Joe", 1000);
		bjv.addPlayer("Dealer", 1000000);
		//System.out.println( bj.toString() );
		bjv.play();
	}
	
}
