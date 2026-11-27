public class ExpressAirStrategy implements ShippingRateStrategy {
    @Override
    public double calculateRate(double weightKg, double distanceKm) {
        return 15.0 + (weightKg * 2.5) + (distanceKm * 0.12);
    }

    @Override
    public String getServiceName() {
        return "Express Air Freight";
    }
}