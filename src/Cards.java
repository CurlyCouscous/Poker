public class Cards {

    //ASSIGNMENT CHAR TO CARD:
    static final private char TWO = '2';
    static final private char THREE = '3';
    static final private char FOUR = '4';
    static final private char FIVE = '5';
    static final private char SIX = '6';
    static final private char SEVEN = '7';
    static final private char EIGHT = '8';
    static final private char NINE = '9';
    static final private char TEN = 'T';
    static final private char JACK = 'J';
    static final private char QUEEN = 'Q';
    static final private char KING = 'K';
    static final private char ACE = 'A';

    //ASSIGNMENT WEIGHT TO CARDS:
    static final private int TWO_WEIGHT = 2;
    static final private int THREE_WEIGHT = 3;
    static final private int FOUR_WEIGHT = 4;
    static final private int FIVE_WEIGHT = 5;
    static final private int SIX_WEIGHT = 6;
    static final private int SEVEN_WEIGHT = 7;
    static final private int EIGHT_WEIGHT = 8;
    static final private int NINE_WEIGHT = 9;
    static final private int TEN_WEIGHT = 10;
    static final private int JACK_WEIGHT = 11;
    static final private int QUEEN_WEIGHT = 12;
    static final private int KING_WEIGHT = 13;
    static final private int ACE_WEIGHT = 14;

    //ASSIGNMENT WEIGHT TO SERIES OF CARDS:
    private final static int HIGH_CARD = 1;
    private final static int ONE_PAIR = 2;
    private final static int TWO_PAIRS = 3;
    private final static int THREE_OF_A_KIND = 4;
    private final static int STRAIGHT = 5;
    private final static int FLUSH = 6;
    private final static int FULL_HOUSE = 7;
    private final static int FOUR_OF_A_KIND = 8;
    private final static int STRAIGHT_FLUSH = 9;
    private final static int ROYAL_FLUSH = 10;

    //CARD CARDS FOR GUIDANCE:
    String[] cards;
    int[] cardsValues;
    char[] cardsColors;

    //DEVELOPER CONSTRUCTOR:
    public Cards() {
    }

    //NORMAL CONSTRUCTOR AND SORTING CARDS:
    public Cards(String... cards) {

        this.cards = cards;
        this.cardsValues = this.getCardsValues();
        this.sortFiveCards();
        this.cardsColors = this.getCardsColors();

    }

    public void changeCards(String[] cards) {

        this.cards = cards;
        this.cardsValues = this.getCardsValues();
        this.sortFiveCards();
        this.cardsColors = this.getCardsColors();

    }

    public String[] getCards() {
        return this.cards;
    }

    //ASSIGNMENT SERIES FROM CARDS IN HAND:
    public int getScore(Cards cards) {

        if (cards.returnRoyalFlush() != null) return ROYAL_FLUSH;
        if (cards.returnStraightFlush() != null) return STRAIGHT_FLUSH;
        if (cards.returnFourOfAKind() != null) return FOUR_OF_A_KIND;
        if (cards.returnFullHouse() != null) return FULL_HOUSE;
        if (cards.returnFlush() != null) return FLUSH;
        if (cards.returnStraight() != null) return STRAIGHT;
        if (cards.returnThreeOfAKind() != null) return THREE_OF_A_KIND;
        if (cards.returnTwoPairs() != null) return TWO_PAIRS;
        if (cards.returnOnePair() != null) return ONE_PAIR;
        return HIGH_CARD;

    }

    public int[] getCardsValues() {
        int[] newCardsValues = new int[5];
        for (int i = 0; i < 5; i++) {
            newCardsValues[i] = translateCardValueToWeight(this.cards[i].charAt(0));
        }
        return newCardsValues;
    }

    public char[] getCardsColors() {
        char[] newCardsColors = new char[5];
        for (int i = 0; i < 5; i++) {
            newCardsColors[i] = this.cards[i].charAt(1);
        }
        return newCardsColors;
    }

    //TRANSLATE CARD VALUES(FROM CHAR) TO WEIGHT(INT):
    public int translateCardValueToWeight(char card) {

        if (TWO == card) return TWO_WEIGHT;
        if (THREE == card) return THREE_WEIGHT;
        if (FOUR == card) return FOUR_WEIGHT;
        if (FIVE == card) return FIVE_WEIGHT;
        if (SIX == card) return SIX_WEIGHT;
        if (SEVEN == card) return SEVEN_WEIGHT;
        if (EIGHT == card) return EIGHT_WEIGHT;
        if (NINE == card) return NINE_WEIGHT;
        if (TEN == card) return TEN_WEIGHT;
        if (JACK == card) return JACK_WEIGHT;
        if (QUEEN == card) return QUEEN_WEIGHT;
        if (KING == card) return KING_WEIGHT;
        if (ACE == card) return ACE_WEIGHT;

        return 0;

    }

    public void printCards() {
        for (String card : this.cards) {
            System.out.print(card + " ");
        }
    }

    //SORTING CARDS FROM THE LOWEST TO A HIGHEST:
    public String[] sortFiveCards() {
        String[] sortedCards = new String[5];
        int temp;                                                                   //bubble sorting cards start
        int change = 1;
        while (change > 0) {
            change = 0;
            for (int i = 0; i < cardsValues.length - 1; i++) {
                if (cardsValues[i] > cardsValues[i + 1]) {
                    temp = cardsValues[i + 1];
                    cardsValues[i + 1] = cardsValues[i];
                    cardsValues[i] = temp;
                    change++;
                }
            }
        }
        for (int c = 0; c < 5; c++) {
            int value = translateCardValueToWeight(this.cards[c].charAt(0));
            for (int i = 0; i < 5; i++) {
                if (cardsValues[i] == value && sortedCards[i] == null) {
                    sortedCards[i] = this.cards[c];                                 //attribution from cards to table with sorted cards
                }
            }
        }
        this.cardsValues = this.getCardsValues();
        return sortedCards;                                                         //bubble sorting cards the end
    }

    public int getValueOfCard(int i) {

        return this.cardsValues[i];

    }

    public int getOnePairValue() {
        String[] onePair = this.returnOnePair();
        return this.translateCardValueToWeight(onePair[0].charAt(0));

    }

    public String[] getCardsWithoutOnePair() {
        String[] threeCards = new String[3];
        int valueOfPair = this.getOnePairValue();
        int n = 0;
        for (String card : this.cards) {
            if (this.translateCardValueToWeight(card.charAt(0)) != valueOfPair) {
                threeCards[n] = card;
                n++;
            }
        }
        return threeCards;
    }

    public int getHeighestTwoPairValue() {
        String[][] twoPairs = this.returnTwoPairs();
        int value1 = this.translateCardValueToWeight(twoPairs[0][0].charAt(0));
        int value2 = this.translateCardValueToWeight(twoPairs[1][0].charAt(0));
        if (value1 > value2) return value1;
        return value2;
    }
//        public int getHeighestTw1oPairValue(){
//        String[][] twoPairs = this.returnTwoPairs();
//        char value1 = twoPairs[0][0].charAt(0);
//        char value2 = twoPairs[1][0].charAt(0);
//        if(translateCardValueToWeight(value1) > translateCardValueToWeight(value2)) return translateCardValueToWeight(value1);
//        if(translateCardValueToWeight(value2) > translateCardValueToWeight(value1)) return translateCardValueToWeight(value2);
//        return 0;
//    }

    public String getCardWithoutTwoPair() {
        String[][] twoPairs = this.returnTwoPairs();
        int value1 = this.translateCardValueToWeight(twoPairs[0][0].charAt(0));
        int value2 = this.translateCardValueToWeight(twoPairs[1][0].charAt(0));
        for (String card : this.cards) {
            if (this.translateCardValueToWeight(card.charAt(0)) != value1 &&
                    this.translateCardValueToWeight(card.charAt(0)) != value2) {
                return card;
            }
        }
        return "";
    }

    public int getThreeOfAKindValue() {
        String[] threeOfAKind = this.returnThreeOfAKind();
        return this.translateCardValueToWeight(threeOfAKind[0].charAt(0));

    }

    public int getFullHouse() {
        String[] fullHouse = this.returnFullHouse();
        if (cardsValues[0] == cardsValues[1] && cardsValues[2] == cardsValues[1]) {
            return this.translateCardValueToWeight(fullHouse[0].charAt(0));
        } else {
            return this.translateCardValueToWeight(fullHouse[3].charAt(0));
        }
    }

    public int getFourOfAKind() {
        String[] fourOfAKind = this.returnFourOfAKind();
        return this.translateCardValueToWeight(fourOfAKind[2].charAt(0));

    }

    public String returnHighCard() {
        int heighestCardWeight = 0;
        String valueOfHighestCard = "";                                     //returned value of highest card
        for (int i = 0; i < 5; i++) {                                    //for each (card from cards table initializon at the beginning of this class)
            if (cardsValues[i] > heighestCardWeight) {                           //overwrite card if cardvalue > heighestCardWeight
                heighestCardWeight = cardsValues[i];
                valueOfHighestCard = cards[i];
            }
        }
        return valueOfHighestCard;
    }

    public String[] returnOnePair() {
        String[] onePair = new String[2];                   //table with 2 cells (1 cell for first card from pair ; next cell for second card from pair)
        int onePairWeight = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (cardsValues[i] == cardsValues[j] && cardsValues[i] > onePairWeight) {                               //if cardFirst == cardSecond we have one pair
                    onePair[0] = this.cards[i];                                                           //first card from pair to onePair table
                    onePair[1] = this.cards[j];                                                           //second card from pair to onePair table
                    onePairWeight = cardsValues[i];                                                         //onePairWeight take value of card from pair
                }
            }
        }
        if (onePairWeight == 0)
            return null;                                                                      //if table is empty we don't have pair
        return onePair;                                                                                   //return table with my best one pair
    }

    public String[][] returnTwoPairs() {
        String[][] twoPairs = new String[2][2];             //table with two columns(first column = first card from "x" pair ; second column = second card from "x" pair) and two rows(first row for first pair and second row for second pair)
        String[] onePair1 = new String[2];                  //first pair
        String[] onePair2 = new String[2];                  //second pair
        int onePairWeight1 = 0;                             //weight of first pair
        int onePairWeight2 = 0;                             //weight of second pair
        for (int i = 0; i < 4; i++) {                                                           //compare first card with rest to search pair
            for (int j = i + 1; j < 5; j++) {
                if (cardsValues[i] == cardsValues[j]) {                                                  //then we have first pair
                    if (onePairWeight1 != cardsValues[i] && onePairWeight2 != cardsValues[j]) {
                        if (onePairWeight1 == 0) {                                              //if we have first pair , we must create second pair
                            onePair1[0] = this.cards[i];
                            onePair1[1] = this.cards[j];
                            onePairWeight1 = cardsValues[i];                                         //create weight of first pair
                        } else {
                            onePair2[0] = this.cards[i];
                            onePair2[1] = this.cards[j];
                            onePairWeight2 = cardsValues[i];                                         //create weight of second pair
                        }
                    }
                }
            }
        }
        twoPairs[0] = onePair1;                                                             //attribution first pair to table with two pairs
        twoPairs[1] = onePair2;                                                             //attribution second pair to table with two pairs
        if (onePairWeight1 == 0 || onePairWeight2 == 0)
            return null;                        //if we don't find two pairs we return null
        return twoPairs;
    }

    public String[] returnThreeOfAKind() {
        String[] threeOfAKind = new String[3];                                              //create table with 3 cells for this same card
        for (int i = 0; i < 3; i++) {                                                       //compare first card with rest to search Three Of A Kind
            for (int j = i + 1; j < 4; j++) {
                for (int k = j + 1; k < 5; k++) {
                    if (cardsValues[i] == cardsValues[j] && cardsValues[j] == cardsValues[k]) {               //if we find three of this same cards we attribution table with threeofakind
                        threeOfAKind[0] = this.cards[i];
                        threeOfAKind[1] = this.cards[j];
                        threeOfAKind[2] = this.cards[k];
                    }
                }
            }
        }
        if (threeOfAKind[0] == null)
            return null;                                           //if we don't have card at first cell we returned null
        return threeOfAKind;
    }

    public String[] returnStraight() {
        String[] straight = new String[5];                                                  //create table with 5 cells for increasing name of cards
        if (cardsValues[1] == cardsValues[0] + 1) {                                         //compare cards with this sequence for fulfill condition
            if (cardsValues[2] == cardsValues[1] + 1) {
                if (cardsValues[3] == cardsValues[2] + 1) {
                    if (cardsValues[4] == cardsValues[3] + 1) {
                        for (int i = 0; i < 5; i++) {
                            straight[i] = this.cards[i];                                    //attribution cards to table
                        }
                    }
                }
            }
        }
        if(cardsValues[4] == 14) {
            if(cardsValues[0] == 2){
                if(cardsValues[1] == 3){
                    if(cardsValues[2] == 4){
                        if(cardsValues[3] == 5){
                            straight[0] = cards[4];
                            straight[1] = cards[0];
                            straight[2] = cards[1];
                            straight[3] = cards[2];
                            straight[4] = cards[3];
                        }
                    }
                }
            }
        }
        if (straight[0] == null)
            return null;                                               //if we don't have value of first cell we return null
        return straight;
    }


    public String[] returnFlush() {
        boolean allCardsinThisSameColor = true;
        for (int i = 0; i < 4; i++) {
            if (cardsColors[i] != cardsColors[i + 1]) {
                allCardsinThisSameColor = false;
            }
        }
        if (allCardsinThisSameColor) return cards;
        return null;
    }


    public String[] returnFullHouse() {
//        String[] fullHouse = new String[5];
        if ((cardsValues[1] == cardsValues[0] &&                                            //conditions to return fullhouse
                cardsValues[3] == cardsValues[2] &&
                cardsValues[4] == cardsValues[3]) ||
                (cardsValues[1] == cardsValues[0] &&
                        cardsValues[2] == cardsValues[1] &&
                        cardsValues[4] == cardsValues[3])) {
            return this.cards;
        }
        return null;                                                                        //otherwise return null
    }

    public String[] returnFourOfAKind() {
        String[] fourOfAKind = new String[4];                                               //create table with 4 cells for this same kind of cards
        for (int i = 0; i < 2; i++) {                                                       //compare cards between each other to search four cards of this same kind
            for (int j = i + 1; j < 3; j++) {
                for (int k = j + 1; k < 4; k++) {
                    for (int l = k + 1; l < 5; l++) {
                        if (cardsValues[i] == cardsValues[j] && cardsValues[j] == cardsValues[k] && cardsValues[k] == cardsValues[l]) {            //conditions to return FourOfAKind
                            fourOfAKind[0] = this.cards[i];
                            fourOfAKind[1] = this.cards[j];
                            fourOfAKind[2] = this.cards[k];
                            fourOfAKind[3] = this.cards[l];
                        }
                    }
                }
            }
        }
        if (fourOfAKind[0] == null)
            return null;                                             //if first cell is empty return null
        return fourOfAKind;
    }

    public String[] returnStraightFlush() {
        boolean isThisSameValues = true;
        for (int i = 0; i < 4; i++) {                                                        //if cards have got this same values return true
            if (cardsValues[i + 1] != cardsValues[i] + 1) {
                isThisSameValues = false;
            }
        }
        boolean isThisSameColors = true;
        if (isThisSameValues) {                                                              //if cards have got this same colors return true
            for (int i = 0; i < 4; i++) {
                if (cardsColors[i + 1] != cardsColors[i]) {
                    isThisSameColors = false;
                }
            }
        }
        if(cardsValues[4] == 14) {
            if(cardsValues[0] == 2){
                if(cardsValues[1] == 3){
                    if(cardsValues[2] == 4){
                        if(cardsValues[3] == 5){
                            isThisSameValues = true;
                        }
                    }
                }
            }
        }
        if (isThisSameColors && isThisSameValues)
            return this.cards;                         //if two conditions are trues return cards

        return null;
    }

    public String[] returnRoyalFlush() {
        if (cardsValues[0] != 10)
            return null;                                               //if first card != 10 return null
        boolean isThisSameValues = true;
        for (int i = 0; i < 4; i++) {                                                        //if cards have got this same values return true
            if (cardsValues[i + 1] != cardsValues[i] + 1) {
                isThisSameValues = false;
            }
        }
        boolean isThisSameColors = true;
        if (isThisSameValues) {
            for (int i = 0; i < 4; i++) {                                                    //if cards have got this same colors return true
                if (cardsColors[i + 1] != cardsColors[i]) {
                    isThisSameColors = false;
                }
            }
        }
        if (isThisSameColors && isThisSameValues)
            return cards;                              //if two conditions are trues return cards
        return null;
    }


    // Method to compare series between player_one(score1) and player_two(score2)
    public int whoWin(Player player_one, Player player_two) {

        int score1 = getScore(player_one.getCards());                               //Player One get cards
        int score2 = getScore(player_two.getCards());                               //Player Two get cards
        if (score1 > score2) {
            System.out.println("Winner 1 WIN");
            return 1;
        }           //if first player have better score than second player return that Winner 1 WIN
        if (score2 > score1) {
            System.out.println("Winner 2 WIN");
            return 2;
        }           //if second player have better score than first player return that Winner 2 WIN
        int j = 0;
        switch (score1) {
            case HIGH_CARD:
                for (int i = 4; i >= 0; i--) {
                    if (player_one.getValueOfCard(i) > player_two.getValueOfCard(i)) {
                        System.out.println("Winner 1 WIN");
                        return 1;
                    } else if (player_two.getValueOfCard(i) > player_one.getValueOfCard(i)) {
                        System.out.println("Winner 2 WIN");
                        return 2;
                    }
                }
                System.out.println("THIS IS A FUCKIN DRAW");
                return 0;

            case ONE_PAIR:
                if (player_one.getOnePairValue() > player_two.getOnePairValue()) {
                    System.out.println("Winner 1 WIN");
                    return 1;
                } else if (player_two.getOnePairValue() > player_one.getOnePairValue()) {
                    System.out.println("Winner 2 WIN");
                    return 2;
                } else {
                    String[] threeCardsWithoutPair_1 = player_one.getCardsWithoutOnePair();
                    String[] threeCardsWithoutPair_2 = player_two.getCardsWithoutOnePair();
                    for (int i = 2; i >= 0; i--) {
                        if (player_one.translateFromStringToCardValue(threeCardsWithoutPair_1[i]) > player_two.translateFromStringToCardValue(threeCardsWithoutPair_2[i])) {
                            System.out.println("WINNER 1 WIN");
                            return 1;
                        } else if (player_two.translateFromStringToCardValue(threeCardsWithoutPair_2[i]) > player_one.translateFromStringToCardValue(threeCardsWithoutPair_1[i])) {
                            System.out.println("WINNER 2 WIN");
                            return 2;
                        }
                    }
                    System.out.println("THIS IS A FUCKIN DRAW");
                    return 0;
                }

            case TWO_PAIRS:
                if (player_one.getHeighestTwoPairValue() > player_two.getHeighestTwoPairValue()) {
                    System.out.println("WINNER 1 WIN");
                    return 1;
                } else if (player_two.getHeighestTwoPairValue() > player_one.getHeighestTwoPairValue()) {
                    System.out.println("WINNER 2 WIN");
                    return 2;
                } else {
                    String fifthCard1 = player_one.getCardWithoutTwoPair();
                    String fifthCard2 = player_two.getCardWithoutTwoPair();
                    if (player_one.translateFromStringToCardValue(fifthCard1) > player_two.translateFromStringToCardValue(fifthCard2)) {
                        System.out.println("WINNER 1 WIN");
                        return 1;
                    } else if (player_two.translateFromStringToCardValue(fifthCard2) > player_one.translateFromStringToCardValue(fifthCard1)) {
                        System.out.println("WINNER 2 WIN");
                        return 2;
                    }

                }
                System.out.println("THIS IS A FUCKIN DRAW");
                return 0;

            case THREE_OF_A_KIND:
                if (player_one.getThreeOfAKindValue() > player_two.getThreeOfAKindValue()) {
                    System.out.println("Winner 1 WIN");
                    return 1;
                } else if (player_two.getThreeOfAKindValue() > player_one.getThreeOfAKindValue()) {
                    System.out.println("Winner 2 WIN");
                    return 2;
                }

            case STRAIGHT:
                j = 0;
                if (player_one.getValueOfCard(j) > player_two.getValueOfCard(j)) {
                    System.out.println("Winner 1 WIN");
                    return 1;
                } else if (player_two.getValueOfCard(j) > player_one.getValueOfCard(j)) {
                    System.out.println("Winner 2 WIN");
                    return 2;
                }
                System.out.println("THIS IS A FUCKIN DRAW");
                return 0;

            case FLUSH:
                if (player_one.getValueOfCard(j) > player_two.getValueOfCard(j)) {
                    System.out.println("Winner 1 WIN");
                    return 1;
                } else if (player_two.getValueOfCard(j) > player_one.getValueOfCard(j)) {
                    System.out.println("Winner 2 WIN");
                    return 2;
                }
                System.out.println("THIS IS A FUCKIN DRAW");
                return 0;

            case FULL_HOUSE:
                if (player_one.getFullHouse() > player_two.getFullHouse()) {
                    System.out.println("Winner 1 WIN");
                    return 1;
                } else {
                    System.out.println("Winner 2 WIN");
                    return 2;
                }

            case FOUR_OF_A_KIND:
                j = 2;
                if (player_one.getValueOfCard(j) > player_two.getValueOfCard(j)) {
                    System.out.println("Winner 1 WIN");
                    return 1;
                } else {
                    System.out.println("Winner 2 WIN");
                    return 2;
                }

            case STRAIGHT_FLUSH:
                j = 0;
                if (player_one.getValueOfCard(j) == player_two.getValueOfCard(j)) {
                    System.out.println("THIS IS A FUCKIN DRAW");
                    return 0;
                } else if (player_one.getValueOfCard(j) > player_two.getValueOfCard(j)) {
                    System.out.println("Winner 1 WIN");
                    return 1;
                } else if (player_two.getValueOfCard(j) > player_one.getValueOfCard(j)) {
                    System.out.println("Winner 2 WIN");
                    return 2;
                }

            case ROYAL_FLUSH:
                System.out.println("THIS IS A FUCKIN DRAW");
                return 0;

        }
        return 0;
    }
}