public class CardsDeck {
    private Card[][] cards;

    public CardsDeck() {
        cards = new Card[4][10];
        prepareCards();
    }

    public void prepareCards() {
        Seed[] seeds = Seed.values();
        Number[] numbers = Number.values();
        int seedsLength = seeds.length;
        int numbersLength = numbers.length;
        for (int i = 0; i < seedsLength; i++) {
            for (int j = 0; j < numbersLength; j++) {
                cards[i][j] = new Card(numbers[j], seeds[i]);
            }
        }
    }

    public String toString() {
        int cardsLength = cards.length;
        String string ="";
        for (int i = 0; i < cardsLength; i++) {
            int cardsRowLength = cards[i].length;
            for (int j = 0; j < cardsRowLength; j++) {
                string += cards[i][j] + (j != (cardsRowLength-1) ? ", " : "");
            }
            if (i != (cardsLength-1)) {
                string+="\n";
            }
        }
        return string;
    }

    public void setCards(Card[][] cards) {
        this.cards = cards;
    }

    public Card[][] getCards() {
        return cards;
    }
}