package TexasHoldEm;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Deck {
	private int size = 52;
	private Set<Card> deck = new HashSet<>();
	public Deck(){
		//int j = 0;
		for(int i = 2; i< 15; i++){
			Card card = new Card(i, "Diamonds");
			Card card1 = new Card(i, "Spades");
			Card card2 = new Card(i, "Clubs");
			Card card3 = new Card(i, "Hearts");
			
			deck.add(card);
			deck.add(card1);
			deck.add(card2);
			deck.add(card3);
			}
		}
	
	protected void printDeck(){
		for(Card card:deck){
			System.out.println(card);
		}
	}
	public Card shuffle() {
		int item = new Random().nextInt(size);
		int j = 0;
		//System.out.println(item);
		for(Card card:deck){
			if(j == item){
				deck.remove(card);
				size--;
				return card;
			}
			j++;
		}
		return null;
	}

	public int getSize() {
		return deck.size();
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Set<Card> getDeck() {
		return deck;
	}

	public void setDeck(Set<Card> deck) {
		this.deck = deck;
	}
	
}
