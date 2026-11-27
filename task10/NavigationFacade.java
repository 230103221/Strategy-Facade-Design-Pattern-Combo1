public class NavigationFacade {
    private final GpsTracker gpsTracker;
    private final MapTileLoader mapTileLoader;
    private final TrafficFeedClient trafficFeedClient;
    private final VoiceGuidanceUnit voiceGuidance;
    private RoutingStrategy activeStrategy;
    private String activeDestination;
    private boolean tripInProgress;

    public NavigationFacade(RoutingStrategy initialStrategy) {
        this.gpsTracker = new GpsTracker();
        this.mapTileLoader = new MapTileLoader();
        this.trafficFeedClient = new TrafficFeedClient();
        this.voiceGuidance = new VoiceGuidanceUnit();
        this.activeStrategy = initialStrategy;
        this.tripInProgress = false;
    }

    public void startNavigation(String origin, String destination) {
        this.activeDestination = destination;
        System.out.println("[Facade] Initializing trip using " + activeStrategy.getCriteriaName());

        gpsTracker.lockInitialCoordinates(origin);
        mapTileLoader.loadVectorTiles(origin, destination);
        String traffic = trafficFeedClient.fetchLiveTrafficStatus(origin + " - " + destination);

        RoutePlan plan = activeStrategy.calculateRoute(origin, destination, traffic);
        voiceGuidance.announceRoute(plan, false);
        this.tripInProgress = true;
    }

    public void updateWaypoint(String newLocation) {
        gpsTracker.simulateMovementTo(newLocation);
        System.out.println("\n[Facade] Vehicle progress updated -> Current GPS position: '" + newLocation + "'");
    }

    public void switchRoutingStrategy(RoutingStrategy newStrategy) {
        this.activeStrategy = newStrategy;
        System.out.println("[Facade] Switched routing strategy to: " + newStrategy.getCriteriaName());

        if (!tripInProgress || activeDestination == null) {
            System.out.println("[Facade] Strategy saved for upcoming navigation.");
            return;
        }

        String currentPos = gpsTracker.getCurrentPosition();
        mapTileLoader.loadVectorTiles(currentPos, activeDestination);
        String traffic = trafficFeedClient.fetchLiveTrafficStatus(currentPos + " - " + activeDestination);

        RoutePlan updatedPlan = activeStrategy.calculateRoute(currentPos, activeDestination, traffic);
        voiceGuidance.announceRoute(updatedPlan, true);
    }
}