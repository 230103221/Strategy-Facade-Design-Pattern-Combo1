import java.util.List;

public class ReportDocument {
    private final String title;
    private final String author;
    private final List<DataRecord> records;
    private String metadataHeader;

    public ReportDocument(String title, String author, List<DataRecord> records) {
        this.title = title;
        this.author = author;
        this.records = records;
        this.metadataHeader = "";
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public List<DataRecord> getRecords() { return records; }
    public String getMetadataHeader() { return metadataHeader; }
    public void setMetadataHeader(String metadataHeader) { this.metadataHeader = metadataHeader; }
}