package cards;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;


public class Deck {
	private List<Card> cards = new ArrayList<Card>();

	public Deck(){
		this(false);		
	}
	
	public Deck(boolean Shuffled){
		Init();		
		if(Shuffled){
			Shuffle();
		}
	}
	
	private void Init(){
		cards.clear();
		for (Suit suit : Suit.values()) {
			for(Rank rank : Rank.values()) {
				cards.add(new Card(rank, suit));
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
	
	public void Cut(int cutIndex){
		List<Card> cutDeck = new ArrayList<Card>();
		
		if(cutIndex < 0 || cutIndex > 52) {
			cutIndex = cards.size()/2;
		} 		
		
		for(int i = cutIndex; i < cards.size(); i++){
			cutDeck.add(cards.get(i));
		}
		
		for(int i = 0; i < cutIndex; i++){
			cutDeck.add(cards.get(i));
		}		
		
		cards = cutDeck;		
	}
	
	public void DealCards(ArrayList<Player> players, int amount){
		for(int i = 0; i < amount; i++){
			for (Player player : players){
				if(cards.size() > 0){
					player.addCardToHand(this.drawTopCard());
				}
			}
		}
	}
	
	public void addCards(Card aCard){
		cards.add(aCard);
	}
	
	public void addCards(List<Card> cardList){
		for(Card aCard : cardList){
			cards.add(aCard);
		}		
	}
	
	public Card drawTopCard(){
		Card topCard = cards.get(cards.size()-1);
		cards.remove(cards.size()-1);
		return topCard;
	}
	
	public Card peekTopCard(){
		return cards.get(cards.size()-1);
	}
	
	public ArrayList<Card> emptyDeck(){
		List<Card> result = this.cards;
		this.cards.clear();
		return (ArrayList<Card>)result;
		
	}
	
	public String toString(){
		return cards.toString();
	}
	
}
