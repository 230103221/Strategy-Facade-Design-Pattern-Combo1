public class DimmerHardware {
    public void setFixtureOutput(String roomId, int brightness, int colorTempKelvin) {
        System.out.printf("  [DimmerHardware] Room '%s' -> Brightness: %d%%, Color Temp: %dK%n",
                roomId, brightness, colorTempKelvin);
    }
}