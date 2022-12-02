package core.pratice.card;

public interface CardRepository {

    //card 정보를 받아서 save한다.
    void save(Card card);

    //cardId를 가지고 와서 id를 통해서 찾아 card를 반환한다.
    Card findById(Long cardId);
}
