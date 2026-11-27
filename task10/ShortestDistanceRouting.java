public class ShortestDistanceRouting implements RoutingStrategy {
    @Override
    public RoutePlan calculateRoute(String startPoint, String destination, String trafficCondition) {
        int eta = trafficCondition.equalsIgnoreCase("HEAVY") ? 46 : 31;
        return new RoutePlan(
                "Direct Urban Grid -> Central Ave (" + startPoint + " to " + destination + ")",
                21.8,
                eta,
                0.00
        );
    }

    @Override
    public String getCriteriaName() {
        return "Shortest Distance Routing";
    }
}