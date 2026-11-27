public class BankTransferPayment implements PaymentStrategy {
    private final String iban;

    public BankTransferPayment(String iban) {
        this.iban = iban;
    }

    @Override
    public boolean authorizeAndCharge(String orderId, double totalAmount) {
        System.out.printf("  [BankTransferPayment] Initiating SEPA/ACH debit from IBAN %s for $%.2f...%n",
                iban, totalAmount);
        System.out.println("  [BankTransferPayment] Clearing house mandate verified.");
        return true;
    }

    @Override
    public String getMethodName() {
        return "Direct Bank Transfer (" + iban + ")";
    }
}