package core.pratice.payment;

import core.pratice.benefit.BenefitPolicy;
import core.pratice.benefit.MembershipBenefitPolicy;
import core.pratice.card.Card;
import core.pratice.card.CardRepository;
import core.pratice.card.MemoryCardRepository;

public class PaymentServiceImpl implements PaymentService{
    private final CardRepository cardRepository = new MemoryCardRepository();
    private final BenefitPolicy benefitPolicy = new MembershipBenefitPolicy();


    @Override
    public Payment createpayment(Long cardId, Long paymentId, int paymentPrice) {
        Card card = cardRepository.findById(cardId);
        int benefitPrice = benefitPolicy.benefit(card, paymentPrice);

        return new Payment(cardId, paymentId, paymentPrice, benefitPrice, "membership");
    }
}
