public class LabelPrinter {
    public void printDispatchLabel(ShippingOrder order, String boxType, String serviceName, double totalCost) {
        System.out.println("  [LabelPrinter] === DISPATCH LABEL ===");
        System.out.println("    Order ID   : " + order.getOrderId());
        System.out.println("    Destination: " + order.getDestinationAddress());
        System.out.println("    Service    : " + serviceName);
        System.out.println("    Package    : " + boxType + " (" + order.getWeightKg() + " kg)");
        System.out.printf("    Postage    : $%.2f%n", totalCost);
        System.out.println("  [LabelPrinter] ======================");
    }
}