public class PixelMatrix {
    private int width;
    private int height;
    private String colorProfile;

    public PixelMatrix(int width, int height, String colorProfile) {
        this.width = width;
        this.height = height;
        this.colorProfile = colorProfile;
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public String getColorProfile() { return colorProfile; }

    public void resize(int newWidth, int newHeight) {
        this.width = newWidth;
        this.height = newHeight;
    }

    public void setColorProfile(String colorProfile) {
        this.colorProfile = colorProfile;
    }
}