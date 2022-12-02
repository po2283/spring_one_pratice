package core.pratice.benefit;

import core.pratice.card.Card;
import core.pratice.card.Series;

public class MembershipBenefitPolicy implements BenefitPolicy {

    private int membershipBenefitAmount = 8;


    @Override
    public int benefit(Card card, int price) {
        if(card.getSeries() == Series.NEW_GENERATION){
            return price * membershipBenefitAmount/100;
        }else{
            return 0;
        }
    }
}
