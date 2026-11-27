public interface LightingStrategy {
    LightingSettings calculateSettings(int ambientLux, boolean isOccupied, double gridLoadPercent);
    String getSceneName();
}