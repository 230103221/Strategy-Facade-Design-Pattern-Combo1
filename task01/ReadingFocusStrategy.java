public class ReadingFocusStrategy implements LightingStrategy {
    @Override
    public LightingSettings calculateSettings(int ambientLux, boolean isOccupied, double gridLoadPercent) {
        int brightness = ambientLux < 200 ? 95 : 75;
        return new LightingSettings(brightness, 5000);
    }

    @Override
    public String getSceneName() { return "Reading Focus Mode"; }
}