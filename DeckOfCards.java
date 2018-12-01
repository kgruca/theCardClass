
public class DeckOfCards {
	public static void main(String[] args) {
		
		Card card1, card2, card3, card4, card5;
		
		card1 = new Card();
		card2 = new Card('5');
		card3 = new Card('9', Suit.hearts);
		card4 = new Card('j', Suit.clubs);
		card5 = new Card('3', Suit.diamonds);
		
		Card newCard = new Card(card4);
		
		
		String report = card1.toString() + ", " + card2.toString() + ", " + card3.toString() + ", " + 
						card4.toString() + ", " + card5.toString() + ", " + newCard.toString() + ". ";
		
		System.out.println(report);
		
		if(!card1.set('1', Suit.clubs))
			System.out.println("Set failed: card1.set('1', Suit.clubs)");
		if(!card1.set('T', Suit.clubs))
			System.out.println("Set failed: card1.set('T', Suit.clubs)");
		
		card1 = card3;
		
		System.out.println("card1: " + card1.toString() + "\tcard3: " + card3.toString());
		
		card1.set('q', Suit.spades);
		
		report = card1.toString() + ", " + card2.toString() + ", " + card3.toString() + ", " + 
				card4.toString() + ", " + card5.toString() + ", " + newCard.toString() + ". ";
		
		System.out.println(report);
	}
	

}

enum Suit {
	clubs, diamonds, hearts, spades
}

class Card {
	private char value;
	private Suit suit;
	
	public Card(char value, Suit suit) {
		set(value, suit);
	}
	
	public Card(char value) {
		this(value, Suit.spades);
	}
	
	public Card() {
		this('A', Suit.spades);
	}
	
	public Card(Card card) {
		this.suit = card.suit;
		this.value = card.value;
	}
	
	public boolean set(char value, Suit suit) {
		char upVal;
		boolean valid = true;
		
		this.suit = suit;
		
		upVal = Character.toUpperCase(value);
		
		if (upVal == 'A' || upVal == 'K' || upVal == 'Q' || upVal == 'J'
	        || upVal == 'T' || (upVal >= '2' && upVal <= '9'))
		{
			this.value = upVal;
		}
		else {
			valid = false;
			this.value = 'A';
		}
		
		return valid;
	}
	
	public char getVal() {
		return value;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public String toString() {
		String retVal;
		
		retVal = String.valueOf(value) + " of " + suit;
		return retVal;
	}
}