public class CheckoutOrder {
    private final String orderId;
    private final String itemSku;
    private final int quantity;
    private final double subtotal;
    private final String regionCode;

    public CheckoutOrder(String orderId, String itemSku, int quantity, double subtotal, String regionCode) {
        this.orderId = orderId;
        this.itemSku = itemSku;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.regionCode = regionCode;
    }

    public String getOrderId() { return orderId; }
    public String getItemSku() { return itemSku; }
    public int getQuantity() { return quantity; }
    public double getSubtotal() { return subtotal; }
    public String getRegionCode() { return regionCode; }
}