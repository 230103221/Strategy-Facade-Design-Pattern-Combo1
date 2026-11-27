public class NoCompression implements CompressionStrategy {
    @Override
    public String compress(String rawData) {
        return rawData;
    }

    @Override
    public String getAlgorithmName() {
        return "Store Only (No Compression)";
    }
}