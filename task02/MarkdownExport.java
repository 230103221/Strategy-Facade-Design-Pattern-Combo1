import java.util.ArrayList;
import java.util.List;

public class MarkdownExport implements ExportStrategy {
    @Override
    public String serialize(ReportDocument document) {
        StringBuilder sb = new StringBuilder();
        sb.append("> ").append(document.getMetadataHeader()).append("\n\n");
        sb.append("# ").append(document.getTitle()).append("\n\n");

        List<DataRecord> records = document.getRecords();
        if (records.isEmpty()) return sb.toString();

        List<String> headers = new ArrayList<>(records.get(0).getFields().keySet());
        sb.append("| ").append(String.join(" | ", headers)).append(" |\n");
        sb.append("|").append(" --- |".repeat(headers.size())).append("\n");

        for (DataRecord record : records) {
            List<String> row = new ArrayList<>();
            for (String h : headers) {
                row.add(record.getFields().getOrDefault(h, ""));
            }
            sb.append("| ").append(String.join(" | ", row)).append(" |\n");
        }
        return sb.toString();
    }

    @Override
    public String getFormatName() { return "Markdown (.md)"; }
}