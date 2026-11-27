public class ShippingFacade {
    private final BoxSelector boxSelector;
    private final RateCalculator rateCalculator;
    private final LabelPrinter labelPrinter;
    private ShippingRateStrategy activeStrategy;

    public ShippingFacade(ShippingRateStrategy initialStrategy) {
        this.boxSelector = new BoxSelector();
        this.rateCalculator = new RateCalculator();
        this.labelPrinter = new LabelPrinter();
        this.activeStrategy = initialStrategy;
    }

    public void setShippingStrategy(ShippingRateStrategy strategy) {
        this.activeStrategy = strategy;
        System.out.println("\n[Facade] Switched shipping strategy to: " + strategy.getServiceName());
    }

    public void dispatchOrder(ShippingOrder order) {
        System.out.println("[Facade] Dispatching order '" + order.getOrderId() + "' via " + activeStrategy.getServiceName());

        String boxType = boxSelector.selectBoxSize(order.getWeightKg());
        double totalCost = rateCalculator.computeTotalCost(order, boxType, activeStrategy);
        labelPrinter.printDispatchLabel(order, boxType, activeStrategy.getServiceName(), totalCost);

        System.out.println("[Facade] Order '" + order.getOrderId() + "' ready for carrier pickup.");
    }
}