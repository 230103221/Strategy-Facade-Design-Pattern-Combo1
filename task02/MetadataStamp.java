import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MetadataStamp {
    public void applyStamp(ReportDocument document) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String stamp = "Author: " + document.getAuthor() + " | Generated: " + timestamp;
        document.setMetadataHeader(stamp);
        System.out.println("  [MetadataStamp] Applied stamp -> [" + stamp + "]");
    }
}