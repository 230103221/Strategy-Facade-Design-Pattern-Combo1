public class PowerGridMonitor {
    public double getCurrentLoadPercentage() {
        return 45.5;
    }

    public boolean isPowerStable() {
        return getCurrentLoadPercentage() < 95.0;
    }
}