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
	
	public int getScore(){
		return this.score;
	}
	
	public String toString(){
		return name + " holds " + hand.toString();
	}
	
}
