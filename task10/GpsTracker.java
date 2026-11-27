public class GpsTracker {
    private String currentPosition;

    public void lockInitialCoordinates(String origin) {
        this.currentPosition = origin;
        System.out.println("  [GpsTracker] Satellite lock acquired at origin: '" + currentPosition + "'");
    }

    public void simulateMovementTo(String waypoint) {
        this.currentPosition = waypoint;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }
}