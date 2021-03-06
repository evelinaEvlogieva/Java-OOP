package cardsWithPower;

public class Card {
    private CardRank rank;
    private CardSuit suit;

    public Card(CardRank rank, CardSuit suit){
        this.rank = rank;
        this.suit = suit;
    }

    private int getPower(){
        return this.rank.getValue() + this.suit.getValue();
    }

    @Override
    public String toString(){
        return String.format("Card name: %s of %s; Card power: %d",
                this.rank.name(),
                this.suit.name(),
                this.getPower()
                );
    }
}
