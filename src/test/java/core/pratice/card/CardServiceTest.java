package core.pratice.card;

import static org.assertj.core.api.Assertions.*;

import core.pratice.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CardServiceTest {
    CardService cardService;

    //테스트 실행 전에 무조건 실행
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        cardService = appConfig.cardService();
    }

    @Test
    void join(){
        Card card = new Card(1L, "cardA", Series.NEW_GENERATION);
        cardService.join(card);

        Card findcard = cardService.findCard(1L);

        assertThat(card).isEqualTo(findcard);
    }

}
