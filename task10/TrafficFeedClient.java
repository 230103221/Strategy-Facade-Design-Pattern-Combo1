public class TrafficFeedClient {
    public String fetchLiveTrafficStatus(String corridor) {
        String status = "HEAVY";
        System.out.println("  [TrafficFeedClient] Live traffic telemetry for '" + corridor + "': " + status);
        return status;
    }
}