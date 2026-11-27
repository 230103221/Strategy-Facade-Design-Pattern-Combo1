public class HighContrastFilter implements FilterStrategy {
    @Override
    public void applyFilter(PixelMatrix matrix) {
        matrix.setColorProfile("HDR High-Contrast RGB");
        System.out.println("  [HighContrastFilter] Boosted dynamic range contrast on " + matrix.getWidth() + "x" + matrix.getHeight() + " frame.");
    }

    @Override
    public String getFilterName() {
        return "High Contrast Filter";
    }
}