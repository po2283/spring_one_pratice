package core.pratice;

import core.pratice.Card.Card;
import core.pratice.Card.CardService;
import core.pratice.Card.CardServiceImpl;
import core.pratice.Card.Series;

import java.util.Arrays;

public class CardApp {
    public static void main(String[] args) {
        CardService cardService = new CardServiceImpl();
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
