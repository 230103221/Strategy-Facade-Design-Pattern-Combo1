public class ThumbnailResizer {
    public void resize(PixelMatrix matrix, int targetWidth, int targetHeight) {
        System.out.printf("  [ThumbnailResizer] Downsampling %dx%d -> %dx%d (Bicubic)%n",
                matrix.getWidth(), matrix.getHeight(), targetWidth, targetHeight);
        matrix.resize(targetWidth, targetHeight);
    }
}