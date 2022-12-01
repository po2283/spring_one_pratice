package core.pratice.Card;

//카드 서비스 인터페이스
//CardRepository와 다른 점 -> CardRepository는 card를 받아서 저장소에 넣고 가지고 오는 인터페이스
//CardService는 클라이언트가 카드를 등록하고 자신의 정보를 조회하는 것
//CardService -> CardRepository로
public interface CardService {

    //카드 등록과 카드 조회
    void join(Card card);

    Card findCard(Long cardId);
}
