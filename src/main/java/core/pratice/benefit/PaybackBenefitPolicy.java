package core.pratice.benefit;

import core.pratice.card.Card;
import core.pratice.card.Series;

public class PaybackBenefitPolicy implements BenefitPolicy{

    private int paybackBenefitAmount = 1;

    @Override
    public int benefit(Card card, int price) {
        if(card.getSeries() == Series.NEW_GENERATION){
            return price * paybackBenefitAmount/100;
        }else{
            return 0;
        }
    }
}
