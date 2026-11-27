public interface BitrateStrategy {
    String determineResolution(double bandwidthMbps);
    String getModeName();
}