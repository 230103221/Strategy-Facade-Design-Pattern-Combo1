public class PaymentProcessor {
    public boolean executeTransaction(String orderId, double amount, PaymentStrategy strategy) {
        System.out.println("  [PaymentProcessor] Routing transaction via " + strategy.getMethodName());
        return strategy.authorizeAndCharge(orderId, amount);
    }
}