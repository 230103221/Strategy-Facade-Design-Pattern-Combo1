public class AvoidTollsRouting implements RoutingStrategy {
    @Override
    public RoutePlan calculateRoute(String startPoint, String destination, String trafficCondition) {
        int eta = trafficCondition.equalsIgnoreCase("HEAVY") ? 42 : 29;
        return new RoutePlan(
                "Free Service Highway -> Riverfront Rd (" + startPoint + " to " + destination + ")",
                27.4,
                eta,
                0.00
        );
    }

    @Override
    public String getCriteriaName() {
        return "Avoid Tolls Routing";
    }
}