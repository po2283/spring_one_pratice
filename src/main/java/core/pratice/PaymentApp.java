package core.pratice;

import core.pratice.card.Card;
import core.pratice.card.CardService;
import core.pratice.card.CardServiceImpl;
import core.pratice.card.Series;
import core.pratice.payment.Payment;
import core.pratice.payment.PaymentService;
import core.pratice.payment.PaymentServiceImpl;

public class PaymentApp {

    public static void main(String[] args) {
        CardService cardService = new CardServiceImpl();
        PaymentService paymentService = new PaymentServiceImpl();

        long cardId = 1L;

        Card card = new Card(cardId, "cardA", Series.NEW_GENERATION);
        cardService.join(card);
        
        Payment payment = paymentService.createpayment(cardId, 2L, 10000);

        System.out.println("payment = " + payment);
    }
}
