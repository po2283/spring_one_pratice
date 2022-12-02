package core.pratice.card;

import java.util.HashMap;
import java.util.Map;

//카드 저장소
public class MemoryCardRepository implements CardRepository {

    //카드 아이디와 카드 내용을 map에 저장
    //참고, HashMap은 동시성 이슈가 발생하므로 ConcurrentHashMap을 사용해야 한다.
    private static Map<Long, Card> store = new HashMap<>();

    //store에 id와 카드의 내용을 넣는다.
    @Override
    public void save(Card card) {
        store.put(card.getId(), card);
    }

    //cardId로 해당 card를 찾는 방식
    @Override
    public Card findById(Long cardId) {
        return store.get(cardId);
    }
}
