package core.pratice;

import core.pratice.card.Card;
import core.pratice.card.CardService;
import core.pratice.card.CardServiceImpl;
import core.pratice.card.Series;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CardApp {
    public static void main(String[] args) {

        /*외부에서 주입해주는 AppConfig
        AppConfig appConfig = new AppConfig();
        appConfig에 있는 cardService를 사용하면 된다.*/

        //스프링 사용
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CardService cardService = applicationContext.getBean("cardService", CardService.class);

        Card card = new Card(1L, "cardA", Series.NEW_GENERATION);
        cardService.join(card);

        //findCard가 Card를 반환하고 있음
        Card findcard = cardService.findCard(1L);

        //저장한 카드를 가지고 와서 이름을 출력
        System.out.println("new card = " + card.getName());
        //저장한 카드의 id로 찾은 값을 가지고 와서 이름을 출력
        System.out.println("find card = " + findcard.getName());
        // -> 둘 다 같은 것을 알 수 있음

    }
}
