public class LightingSettings {
    private final int brightness;
    private final int colorTempKelvin;

    public LightingSettings(int brightness, int colorTempKelvin) {
        this.brightness = brightness;
        this.colorTempKelvin = colorTempKelvin;
    }

    public int getBrightness() { return brightness; }
    public int getColorTempKelvin() { return colorTempKelvin; }
}