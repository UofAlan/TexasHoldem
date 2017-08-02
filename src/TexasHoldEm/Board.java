package TexasHoldEm;

public class Board {
	private Card[] burnCards = new Card[3];
	private Card[] boardCards = new Card[5];
	public Board() {
	}
	public Card[] preFlop(Deck deck) {
		Card[] boardCards = new Card[5];
		//preFlop
		boardCards[0]= deck.shuffle();
		boardCards[1]= deck.shuffle();
		boardCards[2]= deck.shuffle();
		return boardCards;
	}
	

	public Card[] getBurnCards() {
		return burnCards;
	}


	public void setBurnCards(Card[] burnCards) {
		this.burnCards = burnCards;
	}


	public Card[] getBoardCards() {
		return boardCards;
	}
	public void setBoardCards(Card[] boardCards) {
		this.boardCards = boardCards;
	}
	
	public void printBoard() {
		System.out.println("Community Cards on Board:");
		for(Card card:boardCards){
			if(card == null){
				System.out.println("--------");
			}else{
				System.out.println(card);
			}
		}
	}
	public void printBurnCards() {
		System.out.println("BurnCards are:");
		for(Card card:burnCards){
			if(card == null){
				System.out.println("--------");
			}else{
				System.out.println(card);
			}
		}
	}
	
}
