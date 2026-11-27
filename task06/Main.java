public class Main {
    public static void main(String[] args) {
        ImagePipelineFacade pipeline = new ImagePipelineFacade(new GrayscaleFilter());
        pipeline.processImage("photos/portrait.jpg", 300, 300);

        pipeline.setFilterStrategy(new SepiaToneFilter());
        pipeline.processImage("photos/landscape.png", 400, 225);

        pipeline.setFilterStrategy(new HighContrastFilter());
        pipeline.processImage("photos/architecture.jpg", 500, 500);
    }
}