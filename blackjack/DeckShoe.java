public class DeckShoe {

    //An array of decks of cards that comprise this multi-deck.
    private Deck[] decks;
    private int cardsLeft;


    public DeckShoe(int numDecks) {
        decks = new Deck[numDecks];
        for (int i = 0; i < numDecks; i++) {
            decks[i] = new Deck();
            decks[i].shuffle();
        }
        cardsLeft = numDecks * 52;

    }


    //Deals the top card from the stack of decks and returns that Card.
    public Card dealTopCard() {
        for (Deck deck : decks) {
            if(deck.cardsLeft() > 0){
                cardsLeft--;
                return deck.dealTopCard();
            }
        }
        restoreDecks();
        cardsLeft = decks.length * 52;
        return decks[0].dealTopCard();
    }


    //Reshuffles all of the decks.
    protected void restoreDecks() {
        for ( Deck deck : decks) {
            deck.restockDeck();
            deck.shuffle();
        }
    }


    //returns the number of cards left to be dealt in the entire stack of cards.
    public int cardsLeft() {
        return cardsLeft;
    }


}
