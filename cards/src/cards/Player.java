package cards;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private List<Card> hand = new ArrayList<Card>();
	private String name = null;
	private int score = 0;

	public Player(String name){
		this.name = name;
	}
	
	public void addCardToHand(Card aCard){
		hand.add(aCard);
	}
	
	public void drawFromDeck(Deck aDeck){
		this.drawFromDeck(aDeck, 1);
	}
	
	public void drawFromDeck(Deck aDeck, int amountToDraw){
		for(int i=0; i < amountToDraw; i++){
			this.addCardToHand((aDeck.drawTopCard()));
		}		
	}
	
	public void discardAllCards(Deck graveyard){
		graveyard.addCards(hand);
		hand.clear();
	}
	
	public int getScore(){
		return this.score;
	}
	
	public String toString(){
		return name + " holds " + hand.toString();
	}
	
}
