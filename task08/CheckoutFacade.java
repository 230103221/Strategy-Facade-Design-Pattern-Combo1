public class CheckoutFacade {
    private final InventoryLockService inventoryService;
    private final TaxEngine taxEngine;
    private final PaymentProcessor paymentProcessor;
    private final ReceiptGenerator receiptGenerator;
    private PaymentStrategy activeStrategy;

    public CheckoutFacade(PaymentStrategy initialStrategy) {
        this.inventoryService = new InventoryLockService();
        this.taxEngine = new TaxEngine();
        this.paymentProcessor = new PaymentProcessor();
        this.receiptGenerator = new ReceiptGenerator();
        this.activeStrategy = initialStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.activeStrategy = strategy;
        System.out.println("\n[Facade] Switched payment strategy to: " + strategy.getMethodName());
    }

    public boolean checkout(CheckoutOrder order) {
        System.out.println("[Facade] Starting checkout for order '" + order.getOrderId() + "'...");

        if (!inventoryService.lockStock(order.getOrderId(), order.getItemSku(), order.getQuantity())) {
            System.out.println("[Facade] Checkout failed: Out of stock.");
            return false;
        }

        double tax = taxEngine.calculateTax(order.getSubtotal(), order.getRegionCode());
        double totalAmount = Math.round((order.getSubtotal() + tax) * 100.0) / 100.0;

        boolean paymentSuccess = paymentProcessor.executeTransaction(order.getOrderId(), totalAmount, activeStrategy);

        if (!paymentSuccess) {
            inventoryService.releaseStock(order.getOrderId(), order.getItemSku(), order.getQuantity());
            System.out.println("[Facade] Checkout aborted due to payment failure. Inventory safely unlocked.");
            return false;
        }

        receiptGenerator.generateReceipt(order, tax, totalAmount, activeStrategy.getMethodName());
        System.out.println("[Facade] Checkout completed successfully for order '" + order.getOrderId() + "'.");
        return true;
    }
}