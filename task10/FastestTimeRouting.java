public class FastestTimeRouting implements RoutingStrategy {
    @Override
    public RoutePlan calculateRoute(String startPoint, String destination, String trafficCondition) {
        int eta = trafficCondition.equalsIgnoreCase("HEAVY") ? 38 : 24;
        return new RoutePlan(
                "Expressway M-11 -> Ring Bypass (" + startPoint + " to " + destination + ")",
                32.5,
                eta,
                8.50
        );
    }

    @Override
    public String getCriteriaName() {
        return "Fastest Time Routing";
    }
}