public class HomeLightingFacade {
    private final PowerGridMonitor powerMonitor;
    private final DimmerHardware dimmer;
    private final RoomSensor sensor;
    private LightingStrategy activeStrategy;

    public HomeLightingFacade(LightingStrategy initialStrategy) {
        this.powerMonitor = new PowerGridMonitor();
        this.dimmer = new DimmerHardware();
        this.sensor = new RoomSensor();
        this.activeStrategy = initialStrategy;
    }

    public void setLightingStrategy(LightingStrategy strategy) {
        this.activeStrategy = strategy;
        System.out.println("\n[Facade] Switched lighting strategy to: " + strategy.getSceneName());
    }

    public void applyScene(String roomId) {
        System.out.println("[Facade] Applying '" + activeStrategy.getSceneName() + "' to room: " + roomId);

        if (!powerMonitor.isPowerStable()) {
            System.out.println("  [Alert] Power grid unstable! Aborting scene update.");
            return;
        }

        double gridLoad = powerMonitor.getCurrentLoadPercentage();
        int ambientLux = sensor.readAmbientLightLux(roomId);
        boolean occupied = sensor.isRoomOccupied(roomId);

        LightingSettings settings = activeStrategy.calculateSettings(ambientLux, occupied, gridLoad);
        dimmer.setFixtureOutput(roomId, settings.getBrightness(), settings.getColorTempKelvin());
    }
}