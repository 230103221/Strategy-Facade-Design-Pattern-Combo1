public class EcoDimStrategy implements LightingStrategy {
    @Override
    public LightingSettings calculateSettings(int ambientLux, boolean isOccupied, double gridLoadPercent) {
        if (!isOccupied) {
            return new LightingSettings(0, 2700);
        }
        int baseBrightness = gridLoadPercent > 80.0 ? 25 : 40;
        int adjusted = Math.max(10, baseBrightness - (ambientLux / 20));
        return new LightingSettings(adjusted, 3000);
    }

    @Override
    public String getSceneName() { return "Eco Dim Mode"; }
}