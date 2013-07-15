package cards;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;


public class Deck {
	private List<Card> cards = new ArrayList<Card>();

	public Deck(){
		Init();		
	}
	
	public Deck(boolean Shuffled){
		Init();		
		if(Shuffled){
			Shuffle();
		}
	}
	
	private void Init(){
		for (Suit suit : Suit.values()) {
			for(Rank rank : Rank.values()) {
				this.cards.add(new Card(rank, suit));
			}
		}
	}
	
	public void Shuffle(){
		List<Card> shuffledDeck = new ArrayList<Card>();
		Random generator = new Random();
		int randomCard;
		
		while(!cards.isEmpty()){
			randomCard = generator.nextInt(cards.size());
			shuffledDeck.add(cards.get(randomCard));
			cards.remove(randomCard);
		}

		cards = shuffledDeck;
	}
	
	public void Cut(){
		List<Card> cutDeck = new ArrayList<Card>();
		int randomCard;
		
		randomCard = cards.size()/2;
		
		for(int i = randomCard; i < cards.size(); i++){
			cutDeck.add(cards.get(i));
		}
		
		for(int i = 0; i < randomCard; i++){
			cutDeck.add(cards.get(i));
		}
		
		cards = cutDeck;
		
	}
	
	public String toString(){
		return cards.toString();
	}
	
}
