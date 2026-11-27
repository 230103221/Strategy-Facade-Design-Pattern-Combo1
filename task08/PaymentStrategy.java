public interface PaymentStrategy {
    boolean authorizeAndCharge(String orderId, double totalAmount);
    String getMethodName();
}