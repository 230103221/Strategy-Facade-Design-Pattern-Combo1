public class ImagePipelineFacade {
    private final ImageDecoder decoder;
    private final ThumbnailResizer resizer;
    private final ImageEncoder encoder;
    private FilterStrategy activeStrategy;

    public ImagePipelineFacade(FilterStrategy initialStrategy) {
        this.decoder = new ImageDecoder();
        this.resizer = new ThumbnailResizer();
        this.encoder = new ImageEncoder();
        this.activeStrategy = initialStrategy;
    }

    public void setFilterStrategy(FilterStrategy strategy) {
        this.activeStrategy = strategy;
        System.out.println("\n[Facade] Switched filter strategy to: " + strategy.getFilterName());
    }

    public void processImage(String inputPath, int width, int height) {
        System.out.println("[Facade] Processing '" + inputPath + "' with " + activeStrategy.getFilterName());

        PixelMatrix matrix = decoder.decode(inputPath);
        resizer.resize(matrix, width, height);
        activeStrategy.applyFilter(matrix);

        String outputPath = inputPath.replace(".", "_thumb.");
        encoder.saveOutput(matrix, outputPath);
        System.out.println("[Facade] Pipeline finished successfully.");
    }
}