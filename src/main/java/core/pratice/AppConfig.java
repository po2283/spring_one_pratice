package core.pratice;

import core.pratice.benefit.BenefitPolicy;
import core.pratice.benefit.MembershipBenefitPolicy;
import core.pratice.card.CardRepository;
import core.pratice.card.CardService;
import core.pratice.card.CardServiceImpl;
import core.pratice.card.MemoryCardRepository;
import core.pratice.payment.PaymentService;
import core.pratice.payment.PaymentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//에플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
@Configuration
public class AppConfig {

    //카드 레파지토리에 카드를 저장하게 도와주는 서비스
    @Bean
    public CardService cardService(){
        return new CardServiceImpl(cardRepository());
    }

    //결제할 경우 혜택을 만들어주는 서비스
    @Bean
    public PaymentService paymentService(){
        return new PaymentServiceImpl(cardRepository(), benefitPolicy());
    }

    //예쁘게 리펙토링 -> 중복 및 역할에 따른 구현이 잘 보이게
    @Bean
    public CardRepository cardRepository(){
        return new MemoryCardRepository();
    }

    @Bean
    public BenefitPolicy benefitPolicy(){
        return new MembershipBenefitPolicy();
    }


}
