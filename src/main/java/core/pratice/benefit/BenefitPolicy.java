package core.pratice.benefit;

import core.pratice.card.Card;

public interface BenefitPolicy {
    /**
     * @retrun 혜택 할인
     */

    int benefit(Card card, int price);

}
