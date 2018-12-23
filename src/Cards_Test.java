import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Cards_Test {
    static Cards cards;

    @BeforeClass
    public static void cardsTestSetup(){
        cards = new Cards();
        System.out.println("CARDS TEST START");
    }

    @AfterClass
    public static void cardsTestEnd(){
        System.out.println("CARDS TEST END");
    }

    @Test
    public void testChangeCards(){
        String[] newCards = new String[5];
        this.cards.changeCards(newCards);
//        assertEquals(newCards, this.cards.getCards());
    }
}
