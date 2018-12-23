public class Player {
    //VARIABLE TYPE CLASS CARDS
    Cards cards;
    //DEVELOPER CONSTRUCTOR
    Player() {}
    //NORMAL CONSTRUCTOR
    Player(Cards cards) {
        this.cards = cards;
    }

    Player(String[] cards) {
        Cards newCards = new Cards(cards);
        this.cards = newCards;
    }
    //Method getCards to give cards for players
    public Cards getCards() {
        return this.cards;
    }

    public void printCards(){
        this.cards.printCards();
    }

    public int whoWin(Player player_two){
        System.out.print("PLAYER 1: ");
        this.cards.printCards();
        System.out.print("\nPLAYER 2: ");
        player_two.printCards();
        System.out.println();
        return this.cards.whoWin(this,player_two);
    }
    public void changeCards(String[] cards) {
        this.cards.changeCards(cards);
    }

    //Method performs from String card to int value of card by char
    public int translateFromStringToCardValue(String card) {
        return this.cards.translateCardValueToWeight(card.charAt(0));
    }
    //HIGH_CARD
    public int getValueOfCard(int i) {
        return this.cards.getValueOfCard(i);
    }
    //ONE PAIR
    public int getOnePairValue() {
        return this.cards.getOnePairValue();
    }
    //THREE CARDS WITHOUT ONE PAIR
    public String[] getCardsWithoutOnePair() {
        return this.cards.getCardsWithoutOnePair();
    }
    //TWO PAIR
    public int getHeighestTwoPairValue() {
        return this.cards.getHeighestTwoPairValue();
    }
    //FIFTH CARD WITHOUT TWO PAIR
    public String getCardWithoutTwoPair() {
        return this.cards.getCardWithoutTwoPair();
    }
    //THREE OF A KIND
    public int getThreeOfAKindValue() {
        return this.cards.getThreeOfAKindValue();
    }
    //FOUR OF A KIND
    public int getFourOfAKind(){
        return this.cards.getFourOfAKind();
    }
    public int getFullHouse(){
        return this.cards.getFullHouse();
    }
}