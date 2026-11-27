public class ShippingOrder {
    private final String orderId;
    private final String destinationAddress;
    private final double weightKg;
    private final double distanceKm;

    public ShippingOrder(String orderId, String destinationAddress, double weightKg, double distanceKm) {
        this.orderId = orderId;
        this.destinationAddress = destinationAddress;
        this.weightKg = weightKg;
        this.distanceKm = distanceKm;
    }

    public String getOrderId() { return orderId; }
    public String getDestinationAddress() { return destinationAddress; }
    public double getWeightKg() { return weightKg; }
    public double getDistanceKm() { return distanceKm; }
}