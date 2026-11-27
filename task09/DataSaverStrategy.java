public class DataSaverStrategy implements BitrateStrategy {
    @Override
    public String determineResolution(double bandwidthMbps) {
        return bandwidthMbps < 1.5 ? "360p (800 kbps)" : "480p (1.2 Mbps)";
    }

    @Override
    public String getModeName() {
        return "Data Saver Mode";
    }
}