public class ReceiptGenerator {
    public void generateReceipt(CheckoutOrder order, double tax, double total, String methodName) {
        System.out.println("  [ReceiptGenerator] === OFFICIAL RECEIPT ===");
        System.out.println("    Order ID : " + order.getOrderId());
        System.out.println("    Item     : " + order.getItemSku() + " x" + order.getQuantity());
        System.out.printf("    Subtotal : $%.2f | Tax: $%.2f | Paid: $%.2f%n",
                order.getSubtotal(), tax, total);
        System.out.println("    Method   : " + methodName);
        System.out.println("  [ReceiptGenerator] ========================");
    }
}