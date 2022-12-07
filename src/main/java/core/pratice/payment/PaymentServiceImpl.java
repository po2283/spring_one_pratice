package core.pratice.payment;

import core.pratice.benefit.BenefitPolicy;
import core.pratice.benefit.MembershipBenefitPolicy;
import core.pratice.card.Card;
import core.pratice.card.CardRepository;
import core.pratice.card.MemoryCardRepository;

public class PaymentServiceImpl implements PaymentService{
    private final CardRepository cardRepository;
    private BenefitPolicy benefitPolicy;


    //문제점, Membership에서 Payback으로 바꾸려면 직접 구체화에 가서 바꿔줘야 함
    //구체화가 구체화에 의존한다는 문제점이 생김(DIP 위반)
    //기능을 바구려면 PaymentServiceImpl에서 Policy를 바꿔줘야 함(OCP 위반)
   //private final BenefitPolicy benefitPolicy = new MembershipBenefitPolicy();
   /*
   private BenefitPolicy benefitPolicy;
   이렇게 하면 추상화에만 의존하게 되지만 구현체가 없어서 코드를 실행할 수 없다.
   -> 해결! PaymentServiceImpl에 BenefitPolicy의 구현체를 대신 생성하고 주입해야...
    */

    /**
     *
     * @param cardRepository
     * @param benefitPolicy
     * 해결, PaymentServiceImpl은 더이상 구체화를 의존하고 있지 않다.
     * PaymentServiceImpl 입장에서는 BenefitPolicy에 어떤 종류가 들어갈지는 알 수 없다. -> 외부(AppConfig)에서 받은 걸 그냥 실행하기만 하면 된다.
     */
    public PaymentServiceImpl(CardRepository cardRepository, BenefitPolicy benefitPolicy) {
        this.cardRepository = cardRepository;
        this.benefitPolicy = benefitPolicy;
    }



    @Override
    public Payment createpayment(Long cardId, Long paymentId, int paymentPrice) {
        Card card = cardRepository.findById(cardId);
        int benefitPrice = benefitPolicy.benefit(card, paymentPrice);

        return new Payment(cardId, paymentId, paymentPrice, benefitPrice, "membership");
    }
}
