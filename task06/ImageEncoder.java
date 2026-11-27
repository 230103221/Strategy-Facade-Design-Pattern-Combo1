public class ImageEncoder {
    public void saveOutput(PixelMatrix matrix, String outputPath) {
        System.out.printf("  [ImageEncoder] Saved %dx%d [%s] thumbnail to '%s'%n",
                matrix.getWidth(), matrix.getHeight(), matrix.getColorProfile(), outputPath);
    }
}