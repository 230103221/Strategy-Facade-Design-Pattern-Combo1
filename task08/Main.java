public class Main {
    public static void main(String[] args) {
        CheckoutOrder order = new CheckoutOrder("CHK-801", "GPU-RTX-4080", 1, 1000.00, "US");

        CheckoutFacade checkout = new CheckoutFacade(new CreditCardPayment("****-4242", true));
        checkout.checkout(order);

        checkout.setPaymentStrategy(new DigitalWalletPayment("ApplePay", "BIO-9981-OK"));
        checkout.checkout(order);

        CheckoutOrder corporateOrder = new CheckoutOrder("CHK-802", "SRV-RACK-12", 2, 2500.00, "EU");
        checkout.setPaymentStrategy(new BankTransferPayment("DE89370400440532013000"));
        checkout.checkout(corporateOrder);
    }
}