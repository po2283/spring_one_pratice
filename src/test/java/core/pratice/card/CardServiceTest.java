package core.pratice.card;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class CardServiceTest {
    CardService cardService = new CardServiceImpl();

    @Test
    void join(){
        Card card = new Card(1L, "cardA", Series.NEW_GENERATION);
        cardService.join(card);

        Card findcard = cardService.findCard(1L);

        assertThat(card).isEqualTo(findcard);
    }

}
