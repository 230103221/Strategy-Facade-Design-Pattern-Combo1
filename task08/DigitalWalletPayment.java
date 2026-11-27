public class DigitalWalletPayment implements PaymentStrategy {
    private final String walletProvider;
    private final String biometricToken;

    public DigitalWalletPayment(String walletProvider, String biometricToken) {
        this.walletProvider = walletProvider;
        this.biometricToken = biometricToken;
    }

    @Override
    public boolean authorizeAndCharge(String orderId, double totalAmount) {
        System.out.printf("  [DigitalWalletPayment] Verifying %s token [%s] for $%.2f...%n",
                walletProvider, biometricToken, totalAmount);
        System.out.println("  [DigitalWalletPayment] Instant wallet settlement completed.");
        return true;
    }

    @Override
    public String getMethodName() {
        return "Digital Wallet (" + walletProvider + ")";
    }
}