package core.pratice.payment;

public class Payment {
    private Long cardId;
    private Long paymentId;
    private int paymentPrice;
    private int benefitPrice;

    private String benefitKind;

    public Payment(Long cardId, Long paymentId, int paymentPrice, int benefitPrice, String benefitKind) {
        this.cardId = cardId;
        this.paymentId = paymentId;
        this.paymentPrice = paymentPrice;
        this.benefitPrice = benefitPrice;
        this.benefitKind = benefitKind;
    }

    public double calculateBenefit(){
        return benefitPrice;
    }

    public Long getCardId() {
        return cardId;
    }


    public Long getPaymentId() {
        return paymentId;
    }

    public int getPaymentPrice() {
        return paymentPrice;
    }


    public int getBenefitPrice() {
        return benefitPrice;
    }

    public String getBenefitKind(){
        return benefitKind;
    }

    @Override
    public String toString(){
        return "Payment{" + "cardId=" + cardId +
                ", paymentId= " + paymentId +
                ", paymentPrice=" + paymentPrice +
                ", benefitPrice=" + benefitPrice +
                ",  benefitKind=" + benefitKind +
                '}';
    }

}
