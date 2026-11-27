public class BalancedAutoStrategy implements BitrateStrategy {
    @Override
    public String determineResolution(double bandwidthMbps) {
        if (bandwidthMbps >= 10.0) return "1080p FullHD (5.0 Mbps)";
        if (bandwidthMbps >= 4.0) return "720p HD (2.8 Mbps)";
        return "480p SD (1.2 Mbps)";
    }

    @Override
    public String getModeName() {
        return "Balanced Auto Mode";
    }
}