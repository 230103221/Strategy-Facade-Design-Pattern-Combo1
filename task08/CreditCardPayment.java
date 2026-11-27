public class CreditCardPayment implements PaymentStrategy {
    private final String maskedCard;
    private final boolean simulateDecline;

    public CreditCardPayment(String maskedCard, boolean simulateDecline) {
        this.maskedCard = maskedCard;
        this.simulateDecline = simulateDecline;
    }

    @Override
    public boolean authorizeAndCharge(String orderId, double totalAmount) {
        System.out.printf("  [CreditCardPayment] Running 3D-Secure & CVV check for card %s ($%.2f)...%n",
                maskedCard, totalAmount);
        if (simulateDecline) {
            System.out.println("  [CreditCardPayment] Authorization DECLINED by issuing bank.");
            return false;
        }
        System.out.println("  [CreditCardPayment] Authorization APPROVED.");
        return true;
    }

    @Override
    public String getMethodName() {
        return "Credit Card (" + maskedCard + ")";
    }
}