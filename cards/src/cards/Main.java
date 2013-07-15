package cards;

public class Main {

	public static void main(String[] args) {
		Deck playDeck;
		
		System.out.println("Hello World!");
		
		System.out.println("Generating new unshuffled deck...");
		playDeck = new Deck(false);
		System.out.println(playDeck);
				
		System.out.println("Shuffling deck...");
		playDeck.Shuffle();
		System.out.println(playDeck);
		
		System.out.println("Cutting deck...");
		playDeck.Cut(-1);
		System.out.println(playDeck);
		
		System.out.println("Done!");

	}

}
