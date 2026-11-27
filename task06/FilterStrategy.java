public interface FilterStrategy {
    void applyFilter(PixelMatrix matrix);
    String getFilterName();
}