public class ImageDecoder {
    public PixelMatrix decode(String inputPath) {
        System.out.println("  [ImageDecoder] Decoding raw bitmap from '" + inputPath + "' (1920x1080 RGB)...");
        return new PixelMatrix(1920, 1080, "Standard sRGB");
    }
}