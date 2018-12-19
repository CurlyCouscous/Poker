public class Cards {
    //CARD CARDS FOR GUIDANCE:
    String[] cards;
    //DEVELOPER CONSTRUCTOR:
    public Cards() {}
    //NORMAL CONSTRUCTOR AND SORTING CARDS:
    public Cards(String... cards) {

        this.cards = cards;
        this.sortFiveCards();
    }

    //ASSIGNMENT CHAR TO CARD:
//    static final private char TWO = '2';
//    static final private char THREE = '3';
//    static final private char FOUR = '4';
//    static final private char FIVE = '5';
//    static final private char SIX = '6';
//    static final private char SEVEN = '7';
//    static final private char EIGHT = '8';
//    static final private char NINE = '9';
//    static final private char TEN = 'T';
//    static final private char JACK = 'J';
//    static final private char QUEEN = 'Q';
//    static final private char KING = 'K';
//    static final private char ACE = 'A';

    //ASSIGNMENT WEIGHT TO CARDS:
//    static final private int TWO_WEIGHT = 2;
//    static final private int THREE_WEIGHT = 3;
//    static final private int FOUR_WEIGHT = 4;
//    static final private int FIVE_WEIGHT = 5;
//    static final private int SIX_WEIGHT = 6;
//    static final private int SEVEN_WEIGHT = 7;
//    static final private int EIGHT_WEIGHT = 8;
//    static final private int NINE_WEIGHT = 9;
//    static final private int TEN_WEIGHT = 10;
//    static final private int JACK_WEIGHT = 11;
//    static final private int QUEEN_WEIGHT = 12;
//    static final private int KING_WEIGHT = 13;
//    static final private int ACE_WEIGHT = 14;

    //ASSIGNMENT WEIGHT TO SERIES OF CARDS:
//    private final static int HIGH_CARD = 1;
//    private final static int ONE_PAIR = 2;
//    private final static int TWO_PAIRS = 3;
//    private final static int THREE_OF_A_KIND = 4;
//    private final static int STRAIGHT = 5;
//    private final static int FLUSH = 6;
//    private final static int FULL_HOUSE = 7;
//    private final static int FOUR_OF_A_KIND = 8;
//    private final static int STRAIGHT_FLUSH = 9;
//    private final static int ROYAL_FLUSH = 10;

    //ASSIGNMENT SERIES FROM CARDS IN HAND:
    public int getScore(Cards cards) {

        if (cards.returnRoyalFlush() != null) return 10;
        if (cards.returnStraightFlush() != null) return 9;
        if (cards.returnFourOfAKind() != null) return 8;
        if (cards.returnFullHouse() != null) return 7;
        if (cards.returnFlush() != null) return 6;
        if (cards.returnStraight() != null) return 5;
        if (cards.returnThreeOfAKind() != null) return 4;
        if (cards.returnTwoPairs() != null) return 3;
        if (cards.returnOnePair() != null) return 2;
        return 1;

    }
    //TRANSLATE CARD VALUES(FROM CHAR) TO WEIGHT(INT):
    public int translateCardValueToWeight(char card) {

        if ('2' == card) return 2;
        if ('3' == card) return 3;
        if ('4' == card) return 4;
        if ('5' == card) return 5;
        if ('6' == card) return 6;
        if ('7' == card) return 7;
        if ('8' == card) return 8;
        if ('9' == card) return 9;
        if ('T' == card) return 10;
        if ('J' == card) return 11;
        if ('Q' == card) return 12;
        if ('K' == card) return 13;
        if ('A' == card) return 14;

        return 0;

    }

    public void printCards(){
        for (String card: this.cards){
            System.out.print(card + " ");
        }
    }

    //SORTING CARDS FROM THE LOWEST TO A HIGHEST:
    public String[] sortFiveCards() {
        String[] sortedCards = new String[5];
        int[] cardsValue = new int[5];
        for (int i = 0; i < 5; i++) {
            cardsValue[i] = translateCardValueToWeight(this.cards[i].charAt(0));
        }
        int temp;                                                                   //bubble sorting cards start
        int change = 1;
        while (change > 0) {
            change = 0;
            for (int i = 0; i < cardsValue.length - 1; i++) {
                if (cardsValue[i] > cardsValue[i + 1]) {
                    temp = cardsValue[i + 1];
                    cardsValue[i + 1] = cardsValue[i];
                    cardsValue[i] = temp;
                    change++;
                }
            }
        }
        for (int c = 0; c < 5; c++) {
            int value = translateCardValueToWeight(this.cards[c].charAt(0));
            for (int i = 0; i < 5; i++) {
                if (cardsValue[i] == value && sortedCards[i] == null) {
                    sortedCards[i] = this.cards[c];                                 //attribution from cards to table with sorted cards
                }
            }
        }
        return sortedCards;                                                         //bubble sorting cards the end
    }

    public void changeCards(String[] cards) {

        this.cards = cards;
        this.sortFiveCards();

    }

    public int getValueOfCard(int i) {

        return this.translateCardValueToWeight(this.cards[i].charAt(0));

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

    public int getThreeOfAKindValue(){
        String[] threeOfAKind = this.returnThreeOfAKind();
        return this.translateCardValueToWeight(threeOfAKind[0].charAt(0));

    }

    public int getFullHouse(){
        String[] fullHouse = this.returnFullHouse();
        int[] valueOfCardsFromFullHouse = new int[5];
        for(int i = 0 ; i < 5 ; i++) {
            int cardValues = translateCardValueToWeight(this.cards[i].charAt(0));
            valueOfCardsFromFullHouse[i] = cardValues;
        }
        if(valueOfCardsFromFullHouse[0] == valueOfCardsFromFullHouse[1] && valueOfCardsFromFullHouse[2] == valueOfCardsFromFullHouse[1]){
            return this.translateCardValueToWeight(fullHouse[0].charAt(0));
        }else{
            return this.translateCardValueToWeight(fullHouse[3].charAt(0));
        }
    }

    public int getFourOfAKind(){
        String[] fourOfAKind = this.returnFourOfAKind();
        return this.translateCardValueToWeight(fourOfAKind[2].charAt(0));

    }

    public String returnHighCard() {
        int heighestCardWeight = 0;
        String valueOfHighestCard = "";                                     //returned value of highest card
        for (String card : this.cards) {                                    //for each (card from cards table initializon at the beginning of this class)
            int cardValue = translateCardValueToWeight(card.charAt(0));     //Take card weight
            if (cardValue > heighestCardWeight) {                           //overwrite card if cardvalue > heighestCardWeight
                heighestCardWeight = cardValue;
                valueOfHighestCard = card;
            }
        }
        return valueOfHighestCard;
    }

    public String[] returnOnePair() {
        String[] onePair = new String[2];                   //table with 2 cells (1 cell for first card from pair ; next cell for second card from pair)
        int onePairWeight = 0;
        for (int i = 0; i < 4; i++) {
            int cardFirst = translateCardValueToWeight(this.cards[i].charAt(0));                //Create card which is compare with rest of cards
            for (int j = i + 1; j < 5; j++) {
                int cardSecond = translateCardValueToWeight(this.cards[j].charAt(0));
                if (cardFirst == cardSecond && cardFirst > onePairWeight) {                               //if cardFirst == cardSecond we have one pair
                    onePair[0] = this.cards[i];                                                           //first card from pair to onePair table
                    onePair[1] = this.cards[j];                                                           //second card from pair to onePair table
                    onePairWeight = cardFirst;                                                         //onePairWeight take value of card from pair
                }
            }
        }
        if (onePairWeight == 0)   return null;                                                                      //if table is empty we don't have pair
        return onePair;                                                                                   //return table with my best one pair
    }

    public String[][] returnTwoPairs() {
        String[][] twoPairs = new String[2][2];             //table with two columns(first column = first card from "x" pair ; second column = second card from "x" pair) and two rows(first row for first pair and second row for second pair)
        String[] onePair1 = new String[2];                  //first pair
        String[] onePair2 = new String[2];                  //second pair
        int onePairWeight1 = 0;                             //weight of first pair
        int onePairWeight2 = 0;                             //weight of second pair
        for (int i = 0; i < 4; i++) {                                                           //compare first card with rest to search pair
            int cardFirst = translateCardValueToWeight(this.cards[i].charAt(0));
            for (int j = i + 1; j < 5; j++) {
                int cardSecond = translateCardValueToWeight(this.cards[j].charAt(0));
                if (cardFirst == cardSecond) {                                                  //then we have first pair
                    if (onePairWeight1 != cardFirst && onePairWeight2 != cardSecond) {
                        if (onePairWeight1 == 0) {                                              //if we have first pair , we must create second pair
                            onePair1[0] = this.cards[i];
                            onePair1[1] = this.cards[j];
                            onePairWeight1 = cardFirst;                                         //create weight of first pair
                        } else {
                            onePair2[0] = this.cards[i];
                            onePair2[1] = this.cards[j];
                            onePairWeight2 = cardFirst;                                         //create weight of second pair
                        }
                    }
                }
            }
        }
        twoPairs[0] = onePair1;                                                             //attribution first pair to table with two pairs
        twoPairs[1] = onePair2;                                                             //attribution second pair to table with two pairs
        if (onePairWeight1 == 0 || onePairWeight2 == 0) return null;                        //if we don't find two pairs we return null
        return twoPairs;
    }

    public String[] returnThreeOfAKind() {
        String[] threeOfAKind = new String[3];                                              //create table with 3 cells for this same card
        for (int i = 0; i < 3; i++) {                                                       //compare first card with rest to search Three Of A Kind
            int cardFirst = translateCardValueToWeight(this.cards[i].charAt(0));
            for (int j = i + 1; j < 4; j++) {
                int cardSecond = translateCardValueToWeight(this.cards[j].charAt(0));
                for (int k = j + 1; k < 5; k++) {
                    int cardThird = translateCardValueToWeight(this.cards[k].charAt(0));
                    if (cardFirst == cardSecond && cardSecond == cardThird) {               //if we find three of this same cards we attribution table with threeofakind
                        threeOfAKind[0] = this.cards[i];
                        threeOfAKind[1] = this.cards[j];
                        threeOfAKind[2] = this.cards[k];
                    }
                }
            }
        }
        if (threeOfAKind[0] == null) return null;                                           //if we don't have card at first cell we returned null
        return threeOfAKind;
    }

    public String[] returnStraight() {
        String[] straight = new String[5];                                                  //create table with 5 cells for increasing name of cards
        int[] cardsValues = new int[5];                                                     //create table with 5 cells for increasing values of cards
        for (int i = 0; i < 5; i++) {
            cardsValues[i] = translateCardValueToWeight(this.cards[i].charAt(0));           //attribution value further cards
        }
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
        if (straight[0] == null) return null;                                               //if we don't have value of first cell we return null
        return straight;
    }

    public String[] returnFlush() {
        if (this.cards[0].charAt(1) == this.cards[1].charAt(1) &&                           //compare cards colors(charAt(1)) between each other
                this.cards[1].charAt(1) == this.cards[2].charAt(1) &&
                this.cards[2].charAt(1) == this.cards[3].charAt(1) &&
                this.cards[3].charAt(1) == this.cards[4].charAt(1)) {
            return this.cards;                                                              //if this is a true returned cards
        }
        return null;                                                                        //otherwise return null
    }

    public String[] returnFullHouse() {
//        String[] fullHouse = new String[5];
        int[] cardsValues = new int[5];                                                     //create table with value of cards
        for (int i = 0; i < 5; i++) {                                                       //take further cards values
            cardsValues[i] = translateCardValueToWeight(this.cards[i].charAt(0));
        }
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
            int cardFirst = translateCardValueToWeight(this.cards[i].charAt(0));
            for (int j = i + 1; j < 3; j++) {
                int cardSecond = translateCardValueToWeight(this.cards[j].charAt(0));
                for (int k = j + 1; k < 4; k++) {
                    int cardThird = translateCardValueToWeight(this.cards[k].charAt(0));
                    for (int l = k + 1; l < 5; l++) {
                        int cardFourth = translateCardValueToWeight(this.cards[l].charAt(0));
                        if (cardFirst == cardSecond && cardSecond == cardThird && cardThird == cardFourth) {            //conditions to return FourOfAKind
                            fourOfAKind[0] = this.cards[i];
                            fourOfAKind[1] = this.cards[j];
                            fourOfAKind[2] = this.cards[k];
                            fourOfAKind[3] = this.cards[l];
                        }
                    }
                }
            }
        }
        if (fourOfAKind[0] == null) return null;                                             //if first cell is empty return null
        return fourOfAKind;
    }

    public String[] returnStraightFlush() {
        int[] cardsValues = new int[5];                                                      //create table with values of cards
        char[] cardsColors = new char[5];                                                    //create table with colors of cards
        for (int i = 0; i < 5; i++) {                                                        //attribution colors and values for further cards
            cardsValues[i] = translateCardValueToWeight(this.cards[i].charAt(0));
            cardsColors[i] = this.cards[i].charAt(1);
        }
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
        if (isThisSameColors && isThisSameValues) return this.cards;                         //if two conditions are trues return cards

        return null;
    }

    public String[] returnRoyalFlush() {
        int[] cardsValues = new int[5];                                                      //create table with values of cards
        char[] cardsColors = new char[5];                                                    //create table with colors of cards
        for (int i = 0; i < 5; i++) {                                                        ///attribution colors and values for further cards
            cardsValues[i] = translateCardValueToWeight(this.cards[i].charAt(0));
            cardsColors[i] = this.cards[i].charAt(1);
        }
        if (cardsValues[0] != 10) return null;                                               //if first card != 10 return null
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
        if (isThisSameColors && isThisSameValues) return cards;                              //if two conditions are trues return cards
        return null;
    }


    // Method to compare series between player_one(score1) and player_two(score2)
    public int whoWin(Player player_one , Player player_two) {

        int score1 = getScore(player_one.getCards());                               //Player One get cards
        int score2 = getScore(player_two.getCards());                               //Player Two get cards
        if(score1 > score2){ System.out.println("Winner 1 WIN"); return 1;}           //if first player have better score than second player return that Winner 1 WIN
        if(score2 > score1){ System.out.println("Winner 2 WIN"); return 2;}           //if second player have better score than first player return that Winner 2 WIN
        int j = 0;
        switch (score1){
            case 1:
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

            case 2:
                if(player_one.getOnePairValue() > player_two.getOnePairValue()) {
                    System.out.println("Winner 1 WIN");
                    return 1;
                }else if(player_two.getOnePairValue() > player_one.getOnePairValue()) {
                    System.out.println("Winner 2 WIN");
                    return 2;
                }else{
                    String[] threeCardsWithoutPair_1 = player_one.getCardsWithoutOnePair();
                    String[] threeCardsWithoutPair_2 = player_two.getCardsWithoutOnePair();
                    for(int i = 2 ; i >= 0 ; i--){
                        if(player_one.translateFromStringToCardValue(threeCardsWithoutPair_1[i]) > player_two.translateFromStringToCardValue(threeCardsWithoutPair_2[i])){
                            System.out.println("WINNER 1 WIN");
                            return 1;
                        }else if(player_two.translateFromStringToCardValue(threeCardsWithoutPair_2[i]) > player_one.translateFromStringToCardValue(threeCardsWithoutPair_1[i])) {
                            System.out.println("WINNER 2 WIN");
                            return 2;
                        }
                    }
                    System.out.println("THIS IS A FUCKIN DRAW");
                    return 0;
                }

            case 3:
                if(player_one.getHeighestTwoPairValue() > player_two.getHeighestTwoPairValue()){
                    System.out.println("WINNER 1 WIN");
                    return 1;
                }else if(player_two.getHeighestTwoPairValue() > player_one.getHeighestTwoPairValue()){
                    System.out.println("WINNER 2 WIN");
                    return 2;
                } else {
                    String fifthCard1 = player_one.getCardWithoutTwoPair();
                    String fifthCard2 = player_two.getCardWithoutTwoPair();
                    if (player_one.translateFromStringToCardValue(fifthCard1) > player_two.translateFromStringToCardValue(fifthCard2)){
                        System.out.println("WINNER 1 WIN");
                        return 1;
                    } else if (player_two.translateFromStringToCardValue(fifthCard2) > player_one.translateFromStringToCardValue(fifthCard1)){
                        System.out.println("WINNER 2 WIN");
                        return 2;
                    }

                }
                System.out.println("THIS IS A FUCKIN DRAW");
                return 0;

            case 4:
                if(player_one.getThreeOfAKindValue() > player_two.getThreeOfAKindValue()){
                    System.out.println("Winner 1 WIN");
                    return 1;
                }else if(player_two.getThreeOfAKindValue() > player_one.getThreeOfAKindValue()){
                    System.out.println("Winner 2 WIN");
                    return 2;
                }

            case 5:
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

            case 6:

                if (player_one.getValueOfCard(j) > player_two.getValueOfCard(j)) {
                    System.out.println("Winner 1 WIN");
                    return 1;
                } else if (player_two.getValueOfCard(j) > player_one.getValueOfCard(j)) {
                    System.out.println("Winner 2 WIN");
                    return 2;
                }
                System.out.println("THIS IS A FUCKIN DRAW");
                return 0;

            case 7:
                if(player_one.getFullHouse() > player_two.getFullHouse()){
                    System.out.println("Winner 1 WIN");
                    return 1;
                }else {
                    System.out.println("Winner 2 WIN");
                    return 2;
                }

            case 8:
                j = 2;
                if(player_one.getValueOfCard(j) > player_two.getValueOfCard(j)){
                    System.out.println("Winner 1 WIN");
                    return 1;
                }else {
                    System.out.println("Winner 2 WIN");
                    return 2;
                }

            case 9:
                j = 0;
                if (player_one.getValueOfCard(j) == player_two.getValueOfCard(j)){
                    System.out.println("THIS IS A FUCKIN DRAW");
                    return 0;
                } else if (player_one.getValueOfCard(j) > player_two.getValueOfCard(j)){
                    System.out.println("Winner 1 WIN");
                    return 1;
                } else if (player_two.getValueOfCard(j) > player_one.getValueOfCard(j)){
                    System.out.println("Winner 2 WIN");
                    return 2;
                }

            case 10:
                System.out.println("THIS IS A FUCKIN DRAW");
                return 0;

        }
    return 0;
    }
}