public interface RoutingStrategy {
    RoutePlan calculateRoute(String startPoint, String destination, String trafficCondition);
    String getCriteriaName();
}