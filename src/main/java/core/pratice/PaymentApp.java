package core.pratice;

import core.pratice.card.Card;
import core.pratice.card.CardService;
import core.pratice.card.CardServiceImpl;
import core.pratice.card.Series;
import core.pratice.payment.Payment;
import core.pratice.payment.PaymentService;
import core.pratice.payment.PaymentServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PaymentApp {

    public static void main(String[] args) {
        /*
        스프링 사용 전
        -> Appconfig(DI 컨테이너)를 사용해 직접 객체 생성
        AppConfig appConfig = new AppConfig();
        CardService cardService = appConfig.cardService();
        PaymentService paymentService = appConfig.paymentService();
         */

        //스프링 사용 -> 스프링이 컨테이너에서 Bean을 찾아서 객체 생성
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CardService cardService = applicationContext.getBean("cardService", CardService.class);
        PaymentService paymentService = applicationContext.getBean("paymentService", PaymentService.class);

        long cardId = 1L;
        Card card = new Card(cardId, "cardA", Series.NEW_GENERATION);
        cardService.join(card);
        
        Payment payment = paymentService.createpayment(cardId, 2L, 10000);

        System.out.println("payment = " + payment);
    }
}
