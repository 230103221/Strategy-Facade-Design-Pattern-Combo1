public class GrayscaleFilter implements FilterStrategy {
    @Override
    public void applyFilter(PixelMatrix matrix) {
        matrix.setColorProfile("8-bit Luminance Grayscale");
        System.out.println("  [GrayscaleFilter] Converted " + matrix.getWidth() + "x" + matrix.getHeight() + " pixels to grayscale.");
    }

    @Override
    public String getFilterName() {
        return "Grayscale Filter";
    }
}