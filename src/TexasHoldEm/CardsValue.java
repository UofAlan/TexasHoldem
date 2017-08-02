package TexasHoldEm;


import java.util.Arrays;


public class CardsValue {
	private int priority = 0;
	private Card[] cardChain = new Card[7];
	
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public Card[] getCardChain() {
		return cardChain;
	}
	public void add2CardChain(Board board, Player player){
		int i = 0;
		for(Card card:board.getBoardCards()){
			cardChain[i] = card;
			i ++;
		}
		for(Card card:player.getCardsInHand()){
			cardChain[i] = card;
			i++;
		}
	}
	public void setCardChain(Card[] cardChain) {
		this.cardChain = cardChain;
	}

	public void sortByNum(){
		Arrays.sort(cardChain, new numComparator());
		/*for(Card card:cardChain){
			System.out.println(" " + card);
		}*/
	}
	public void sortBySuit(){
		Arrays.sort(cardChain, new suitComparator());
//		for(Card card:cardChain){
//			System.out.println(" " + card);//Clubs-->Diamonds-->Hearts-->Spades
//		}
//		System.out.println();
	}
	public void sortBySuitthenNum(){
		Arrays.sort(cardChain,new suitComparator());
		Arrays.sort(cardChain, new numComparator());
//		for(Card card:cardChain){
//			System.out.println(" " + card);//Clubs-->Diamonds-->Hearts-->Spades
//		}
	}
	public void sortByNumthenSuit(){
		Arrays.sort(cardChain, new numComparator());
		Arrays.sort(cardChain,new suitComparator());
	}
	public String RoyalSearch(){
		String result = "";
		sortByNumthenSuit();
		for (int i = 0; i < cardChain.length; i++) {
			if ((i+4<cardChain.length)&& (cardChain[i].getNumber() ==10 && 
				cardChain[i+1].getNumber() ==11 &&
				cardChain[i+2].getNumber() ==12 && 
				cardChain[i+3].getNumber() ==13 && 
				cardChain[i+4].getNumber() ==14 )
				&&
				(cardChain[i].getSuit() == cardChain[i+1].getSuit() &&
				cardChain[i].getSuit() == cardChain[i+2].getSuit() &&
				cardChain[i].getSuit() == cardChain[i+3].getSuit() &&
				cardChain[i].getSuit() == cardChain[i+4].getSuit())) {
				//find Royal
				result = "Royal Flush Suit:" + cardChain[i].getSuit();
				break;
			}
		}
		if (result!="") {
			setPriority(10);
		}
		return result;
	}
	public String StraFlushSearch(){
		String result = "";
		sortByNumthenSuit();
		for (int i = 0; i < cardChain.length; i++) {
			if ((i+4<cardChain.length)&&(cardChain[i].getSuit() == cardChain[i+1].getSuit() &&
				cardChain[i].getSuit() == cardChain[i+2].getSuit() &&
				cardChain[i].getSuit() == cardChain[i+3].getSuit() &&
				cardChain[i].getSuit() == cardChain[i+4].getSuit()) 
					&&
				(cardChain[i].getNumber() +1 == cardChain[i+1].getNumber()&& 
				cardChain[i].getNumber() +2 == cardChain[i+2].getNumber() &&
				cardChain[i].getNumber() +3 == cardChain[i+3].getNumber() && 
				cardChain[i].getNumber() +4 == cardChain[i+4].getNumber()
				)) {
				//Straight Flush
				result = "Straight Flush!" + "Flush starts with " + cardChain[i];
				
			}
		}
		if (result!="") {
			setPriority(9);
		}
		return result;
	}
	public String FourofAKindSearch(){
		String result = "";
		sortByNum();
		for (int i = 0; i < cardChain.length; i++) {
			if((i+3<cardChain.length)&& cardChain[i].getNumber() == cardChain[i+1].getNumber() &&
			cardChain[i].getNumber() == cardChain[i+2].getNumber() &&
			cardChain[i].getNumber() == cardChain[i+3].getNumber()
			){
				result = "FOUR of A KIND! Four:" + cardChain[i]; 
			}
		}
		if (result!="") {
			setPriority(8);
		}
		return result;
	}
	public String FullHouseSearch() {
		String result = "";
		sortByNum();
		for (int i = 0; i < cardChain.length; i++) {
			if ((i+2<cardChain.length) &&cardChain[i].getNumber() == cardChain[i+1].getNumber() &&
			cardChain[i].getNumber() == cardChain[i+2].getNumber()) {
				for (int j = i+3; j < cardChain.length; j++) {
					if ((j+1<cardChain.length)&& cardChain[j].getNumber() == cardChain[j+1].getNumber()) {
						result = "FULL HOUSE! 3:" + cardChain[i] + "  2:" + cardChain[j];
					}
				}
			}
		}
		if (result!="") {
			setPriority(7);
		}
		return result;
	}
	public String FlushSearch() {
		String result = "";
		sortBySuit();
		for (int i = 0; i < cardChain.length; i++) {
			if((i+4<cardChain.length) && cardChain[i].getSuit() == cardChain[i+1].getSuit() &&
				cardChain[i].getSuit() == cardChain[i+2].getSuit() &&
				cardChain[i].getSuit() == cardChain[i+3].getSuit() &&
				cardChain[i].getSuit() == cardChain[i+4].getSuit() 
				){
				result = "FLUSH! " +cardChain[i].getSuit();
			}
		}
		if (result!="") {
			setPriority(6);
		}
		return result;
	}
	public String StraightSearch() {
		String result = "";
		sortByNum();
		for (int i = 0; i < cardChain.length; i++) {
			if ((i+4<cardChain.length)&& cardChain[i].getNumber() +1 == cardChain[i+1].getNumber()&& 
				cardChain[i].getNumber() +2 == cardChain[i+2].getNumber() &&
				cardChain[i].getNumber() +3 == cardChain[i+3].getNumber() && 
				cardChain[i].getNumber() +4 == cardChain[i+4].getNumber()
					) {
				result = "Straight Found! Starts with:"+cardChain[i];
			}
		}
		if (result!="") {
			setPriority(5);
		}
		return result;
	}
	public String ThreeofAKindSearch() {
		String result = "";
		sortByNum();
		for (int i = 0; i < cardChain.length; i++) {
			if ((i+2<cardChain.length) && cardChain[i].getNumber() == cardChain[i+1].getNumber() &&
					cardChain[i].getNumber() == cardChain[i+2].getNumber()) {
				result = "Three of A Kind Found! 3:" + cardChain[i].toString();
			}
		}
		if (result!="") {
			setPriority(4);
		}
		return result;
	}
	public String TwoPairsSearch() {
		String result = "";
		sortByNum();
		for (int i = 0; i < cardChain.length; i++) {
			if ((i+1<cardChain.length)&&cardChain[i].getNumber() == cardChain[i+1].getNumber()) {
				for (int j = i+2; j < cardChain.length; j++) {
					if ((j+1<cardChain.length)&&cardChain[j].getNumber() == cardChain[j+1].getNumber()) {
						result = "Two Pairs found! Larger pair:" + cardChain[j].toString() + " Small pair:" + cardChain[i].toString();
					}
				}
			}
		}
		if (result!="") {
			setPriority(3);
		}
		return result;
	}
	public String OnePairSearch(){
		String result = "";
		sortBySuitthenNum();
		for (int i = 0; i < cardChain.length; i++) {
			if ((i+1<cardChain.length)&&cardChain[i].getNumber() == cardChain[i+1].getNumber()) {
				result = "Pair found! pair:" + cardChain[i].toString();
			}
		}
		if (result!="") {
			setPriority(2);
		}
		return result;
	}
	public String HighCardSearch() {
		String result = "";
		sortByNum();
		result = "Highest card is: " + cardChain[cardChain.length-1].toString();
		if (result!="") {
			setPriority(1);
		}
		return result;
	}
	public String ResultSearch(){
		String result = "";
		if (result == "") {
			result = RoyalSearch();
			if (result == "") {
				result = StraFlushSearch();
				if (result == "") {
					result = FourofAKindSearch();
					if (result == "") {
						result  = FullHouseSearch();
						if (result == "") {
							result = FlushSearch();
							if (result == "") {
								result = StraightSearch();
								if (result == "") {
									result = ThreeofAKindSearch();
									if (result == "") {
										result = TwoPairsSearch();
										if (result == "") {
											result = OnePairSearch();
											if (result == "") {
												result = HighCardSearch();
											}
										}
									}
								}
							}
						}
					}
				}
			}
		} {
			
		}
		return result;
	}
}
