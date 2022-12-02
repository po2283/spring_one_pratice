package core.pratice.card;

public class CardServiceImpl implements CardService{

    //구체화가 구체화에 의존하고 있음 나중에 고쳐야 함
    private final CardRepository cardRepository = new MemoryCardRepository();

    @Override
    public void join(Card card) {
        cardRepository.save(card);
    }

    @Override
    public Card findCard(Long cardId) {
        return cardRepository.findById(cardId);
    }
}
