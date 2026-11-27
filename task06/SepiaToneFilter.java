public class SepiaToneFilter implements FilterStrategy {
    @Override
    public void applyFilter(PixelMatrix matrix) {
        matrix.setColorProfile("Warm Vintage Sepia RGB");
        System.out.println("  [SepiaToneFilter] Applied warm sepia matrix transform to " + matrix.getWidth() + "x" + matrix.getHeight() + " frame.");
    }

    @Override
    public String getFilterName() {
        return "Sepia Tone Filter";
    }
}