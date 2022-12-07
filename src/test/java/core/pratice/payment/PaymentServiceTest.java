package core.pratice.payment;

import core.pratice.AppConfig;
import core.pratice.card.*;
import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PaymentServiceTest {
    CardService cardService;
    PaymentService paymentService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        cardService = appConfig.cardService();
        paymentService = appConfig.paymentService();
    }

    @Test
    void createPayment(){
        long cardId = 1L;
        Card card = new Card(cardId, "cardA", Series.NEW_GENERATION);
        cardService.join(card);

        Card findcard = cardService.findCard(1L);

        Payment payment = paymentService.createpayment(cardId, 2L, 10000);
        assertThat(payment.getBenefitPrice()).isEqualTo(800);
    }
}
