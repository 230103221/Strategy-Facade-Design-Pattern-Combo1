public class StandardGroundStrategy implements ShippingRateStrategy {
    @Override
    public double calculateRate(double weightKg, double distanceKm) {
        return 5.0 + (weightKg * 1.2) + (distanceKm * 0.05);
    }

    @Override
    public String getServiceName() {
        return "Standard Ground Shipping";
    }
}