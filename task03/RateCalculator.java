public class RateCalculator {
    public double computeTotalCost(ShippingOrder order, String boxType, ShippingRateStrategy strategy) {
        double baseRate = strategy.calculateRate(order.getWeightKg(), order.getDistanceKm());
        double packagingFee = boxType.contains("(L)") ? 4.50 : (boxType.contains("(M)") ? 2.00 : 0.75);
        double total = Math.round((baseRate + packagingFee) * 100.0) / 100.0;
        System.out.printf("  [RateCalculator] Service: %s | Base: $%.2f + Packaging: $%.2f = Total: $%.2f%n",
                strategy.getServiceName(), baseRate, packagingFee, total);
        return total;
    }
}