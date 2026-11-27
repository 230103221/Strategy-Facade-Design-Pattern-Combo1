public interface CompressionStrategy {
    String compress(String rawData);
    String getAlgorithmName();
}