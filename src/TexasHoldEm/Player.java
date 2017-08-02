package TexasHoldEm;

import java.util.Arrays;

public class Player {
	private int Money;
	private String role;
	private Card[] cardsInHand = new Card[2];
	private boolean flag =true;//fold or not
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public Player() {
		// TODO Auto-generated constructor stub
	}
	public Player(Card card,Card card1) {
		cardsInHand[0] = card;
		cardsInHand[1] = card1;
	}
	public int getMoney() {
		return Money;
	}
	public void setMoney(int money) {
		Money = money;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Card[] getCardsInHand() {
		return cardsInHand;
	}
	public void setCardsInHand(Deck deck) {
		this.cardsInHand[0] = deck.shuffle();
		this.cardsInHand[1] = deck.shuffle();
	}
	public void raise(){
		
	}
	public void fold() {
		setFlag(false);
	}
	public void allIn(){
		
	}
	public void call(){
		
	}
	public void printCardsInHand() {
		System.out.println("The Cards in " + getRole() + "'s hand is : ");
		for(Card card:getCardsInHand()){
			System.out.println(card);
		}
	}
	@Override
	public String toString() {
		return "Player:" + role + ", cardsInHand=" + Arrays.toString(cardsInHand);
	}
	public int result(Board board, Player player){
		int winNum = 0;
		CardsValue cardsValue = new CardsValue();
		cardsValue.add2CardChain(board, player);
		
		System.out.println(player);
		
		String result = "";
		
		result = cardsValue.ResultSearch();
		winNum = cardsValue.getPriority();
		System.out.println("Result: "+ result);
		return winNum;
	}
}
