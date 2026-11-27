public class FilePayload {
    private final String fileName;
    private final String rawData;

    public FilePayload(String fileName, String rawData) {
        this.fileName = fileName;
        this.rawData = rawData;
    }

    public String getFileName() { return fileName; }
    public String getRawData() { return rawData; }
}