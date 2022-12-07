package core.pratice.payment;

import core.pratice.benefit.BenefitPolicy;
import core.pratice.benefit.PaybackBenefitPolicy;
import core.pratice.card.Card;
import core.pratice.card.Series;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaybackBenefitPolicyTest {

    PaybackBenefitPolicy paybackBenefitPolicy = new PaybackBenefitPolicy();

    @Test
    @DisplayName("New_Generation 카드로 결제할 경우 0.01% 페이벡이 적용되어야 한다.")
    void NewGeneration_o(){
        //given
        Card card = new Card(1L, "NewGeneration", Series.NEW_GENERATION);
        //when
        int payback = paybackBenefitPolicy.benefit(card, 10000);
        //then
        Assertions.assertThat(payback).isEqualTo(100);
    }

    @Test
    @DisplayName("일반 카드일 경우 페이벡은 적용되어서는 안 된다.")
    void NewGeneration_x(){
        Card card = new Card(1L, "NewGeneration", Series.BASIC);
        //when
        int payback = paybackBenefitPolicy.benefit(card, 10000);
        //then
        Assertions.assertThat(payback).isEqualTo(0);
    }
}
