public class SameDayCourierStrategy implements ShippingRateStrategy {
    @Override
    public double calculateRate(double weightKg, double distanceKm) {
        return 25.0 + (weightKg * 3.0) + (distanceKm * 0.35);
    }

    @Override
    public String getServiceName() {
        return "Same-Day Courier Delivery";
    }
}