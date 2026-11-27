public interface ShippingRateStrategy {
    double calculateRate(double weightKg, double distanceKm);
    String getServiceName();
}