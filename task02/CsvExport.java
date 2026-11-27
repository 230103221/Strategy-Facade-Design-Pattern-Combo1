import java.util.ArrayList;
import java.util.List;

public class CsvExport implements ExportStrategy {
    @Override
    public String serialize(ReportDocument document) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ").append(document.getMetadataHeader()).append("\n");
        List<DataRecord> records = document.getRecords();
        if (records.isEmpty()) return sb.toString();

        List<String> headers = new ArrayList<>(records.get(0).getFields().keySet());
        sb.append(String.join(",", headers)).append("\n");

        for (DataRecord record : records) {
            List<String> row = new ArrayList<>();
            for (String h : headers) {
                row.add(record.getFields().getOrDefault(h, ""));
            }
            sb.append(String.join(",", row)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String getFormatName() { return "CSV (.csv)"; }
}