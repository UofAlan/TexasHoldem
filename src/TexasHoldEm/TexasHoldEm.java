package TexasHoldEm;

public class TexasHoldEm {

	public static void main(String[] args) {
		int numPlayers = 4;
		int money = 10;
		Player player0 = new Player(); player0.setRole("Dealer");
		Player player1 = new Player(); player1.setRole("SmallBlind");
		Player player2 = new Player(); player2.setRole("BigBlind");
		Player player3 = new Player(); player3.setRole("NorlPlayer");
		System.out.println("Number of the players: " + numPlayers);
		System.out.println("---------------------------------------------");
		System.out.println("The role of the Players:");
		System.out.println("Player0: " + player0.getRole() + "   Player1: " + player1.getRole() + "   Player2: " + player2.getRole() +"   Player3: " + player3.getRole());
		System.out.println("---------------------------------------------");
		
		Deck deck = new Deck();
		//deck.printDeck();
		//System.out.println(deck.shuffle());
		//System.out.println(deck.getSize());
		//System.out.println("deck size is :" + deck.getSize());
		System.out.println("----Delt 2 hole cards to each player!!----");
		player0.setCardsInHand(deck); //System.out.println("deck size is :" + deck.getSize());
		player1.setCardsInHand(deck); //System.out.println("deck size is :" + deck.getSize());
		player2.setCardsInHand(deck); //System.out.println("deck size is :" + deck.getSize());
		player3.setCardsInHand(deck); //System.out.println("deck size is :" + deck.getSize());
		if (deck.getSize()==44) {
			System.out.println("    All players got their cards in hand!");
			System.out.println();
		}else{
			System.out.println("delt error!");
		}
		//System.out.println("deck size is :" + deck.getSize());
		//System.out.println("---------------------------------------------");
		//assume all players called to the flop!
		Board board = new Board();
		//burn
		System.out.println("---------Burn one before Pre-Flop-------------");
		deck.getDeck().remove(deck.shuffle());
		if(deck.getSize() == 43){
			System.out.println("             Burned!");
			System.out.println();
		}else{
			System.out.println("error!");
		}
		//System.out.println("deck size is :" + deck.getSize());
		System.out.println("----------------Pre-Flop---------------------");
		
		

		//Pre-Flop!
		board.setBoardCards(board.preFlop(deck));
		//System.out.println("deck size is :" + deck.getSize());
		//System.out.println("---------------------------------------------");
		//player0.printCardsInHand();	System.out.println("---------------------------------------------");
		//player1.printCardsInHand();	System.out.println("---------------------------------------------");
		//player2.printCardsInHand(); System.out.println("---------------------------------------------");
		//player3.printCardsInHand(); System.out.println("---------------------------------------------");*/
		board.printBoard();
		//System.out.println(deck.getSize());
		System.out.println("----------------the Turn--------------------");
		Card[] Turn = new Card[5];
		for(int i = 0; i<3; i++){
			Turn[i] = board.getBoardCards()[i];
		}
		Turn[3] = deck.shuffle();
		board.setBoardCards(Turn);
		
		board.printBoard();
		System.out.println("----------------the River---------------------");
		Turn[4] = deck.shuffle();
		board.setBoardCards(Turn);
		board.printBoard();
		System.out.println();
		int winNum0,winNum1,winNum2,winNum3;
		
		winNum0 = player0.result(board, player0);System.out.println();
		winNum1 = player1.result(board, player1);System.out.println();
		winNum2 = player2.result(board, player2);System.out.println();
		winNum3 = player3.result(board, player3);System.out.println();
		//System.out.println(winNum0 + winNum1);
		
		System.out.println("----------------the Winner---------------------");
		int max = Math.max(winNum0, winNum1);
		max = Math.max(max, winNum2);
		max = Math.max(max, winNum3);
		if(max == winNum0){
			System.out.println(player0);
		}
		if(max == winNum1){
			System.out.println(player1);
		}
		if(max == winNum2){
			System.out.println(player2);
		}
		if(max == winNum3){
			System.out.println(player3);
			
		}
		
	}
	

}
