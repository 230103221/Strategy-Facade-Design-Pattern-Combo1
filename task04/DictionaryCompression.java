public class DictionaryCompression implements CompressionStrategy {
    @Override
    public String compress(String rawData) {
        String tokenized = rawData
                .replace("System", "$1")
                .replace("Archive", "$2")
                .replace("Data", "$3");
        return "[DICT:$1=System,$2=Archive,$3=Data]|" + tokenized;
    }

    @Override
    public String getAlgorithmName() {
        return "Dictionary Compression (LZ-Token)";
    }
}