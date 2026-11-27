public class BrewChamber {
    public void brew(String methodName, int extractionSeconds) {
        System.out.println("  [BrewChamber] Brewing via " + methodName + " for " + extractionSeconds + " seconds.");
    }
}