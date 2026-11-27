public class BrewParameters {
    private final String grindSize;
    private final int waterTempCelsius;
    private final int extractionSeconds;

    public BrewParameters(String grindSize, int waterTempCelsius, int extractionSeconds) {
        this.grindSize = grindSize;
        this.waterTempCelsius = waterTempCelsius;
        this.extractionSeconds = extractionSeconds;
    }

    public String getGrindSize() { return grindSize; }
    public int getWaterTempCelsius() { return waterTempCelsius; }
    public int getExtractionSeconds() { return extractionSeconds; }
}