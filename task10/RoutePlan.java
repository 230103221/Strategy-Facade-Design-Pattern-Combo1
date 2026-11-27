public class RoutePlan {
    private final String summary;
    private final double distanceKm;
    private final int estimatedMinutes;
    private final double tollCost;

    public RoutePlan(String summary, double distanceKm, int estimatedMinutes, double tollCost) {
        this.summary = summary;
        this.distanceKm = distanceKm;
        this.estimatedMinutes = estimatedMinutes;
        this.tollCost = tollCost;
    }

    public String getSummary() { return summary; }
    public double getDistanceKm() { return distanceKm; }
    public int getEstimatedMinutes() { return estimatedMinutes; }
    public double getTollCost() { return tollCost; }
}