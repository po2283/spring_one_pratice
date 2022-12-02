package core.pratice.payment;

import core.pratice.card.Card;

public interface PaymentService {
    Payment createpayment(Long cardid, Long paymentId, int paymentPrice);
}
