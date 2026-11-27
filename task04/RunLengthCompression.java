public class RunLengthCompression implements CompressionStrategy {
    @Override
    public String compress(String rawData) {
        if (rawData == null || rawData.isEmpty()) return "";
        StringBuilder encoded = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= rawData.length(); i++) {
            if (i < rawData.length() && rawData.charAt(i) == rawData.charAt(i - 1)) {
                count++;
            } else {
                encoded.append(rawData.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        return encoded.toString();
    }

    @Override
    public String getAlgorithmName() {
        return "Run-Length Encoding (RLE)";
    }
}