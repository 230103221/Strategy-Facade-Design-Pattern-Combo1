public class AmbientPartyStrategy implements LightingStrategy {
    @Override
    public LightingSettings calculateSettings(int ambientLux, boolean isOccupied, double gridLoadPercent) {
        return new LightingSettings(65, 2200);
    }

    @Override
    public String getSceneName() { return "Ambient Party Mode"; }
}