public class UltraHdStrategy implements BitrateStrategy {
    @Override
    public String determineResolution(double bandwidthMbps) {
        return bandwidthMbps >= 25.0 ? "4K UHD HDR (24.0 Mbps)" : "1440p QHD (12.0 Mbps)";
    }

    @Override
    public String getModeName() {
        return "Ultra HD 4K Mode";
    }
}