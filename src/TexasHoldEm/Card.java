package TexasHoldEm;

import java.util.Comparator;

public class Card {
	
	private int number;//2-->11,12,13,14forAce
	private String suit;//Diamonds Hearts Clubs and Spades
	
	public Card(int number, String suit){
		this.number = number;
		this.suit = suit;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	@Override
	public String toString() {
		String temp = "";
		if(this.number>10){
			if(this.number == 11){
				temp += "Jack";
			}
			if(this.number == 12){
				temp += "Queen";
			}
			if(this.number == 13){
				temp += "King";
			}
			if(this.number == 14){
				temp += "Ace";
			}
		}
		else{
			temp += this.number ;
		}
		temp += " of " + this.suit;
		return temp;
	}
	
}
class numComparator implements Comparator<Card>{

	@Override
	public int compare(Card card1, Card card2) {
		
		return card1.getNumber()-card2.getNumber();//ascending order
	}
	
}
class suitComparator implements Comparator<Card>{
	@Override
	public int compare(Card o1, Card o2) {
		if(o1 == null){
			return -1;
		}
		if (o2 == null) {
			return 1;
		}
		if(o1.equals(o2)){
			return 0;
		}
		return o1.getSuit().compareTo(o2.getSuit());
	}
    
}
