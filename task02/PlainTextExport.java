public class PlainTextExport implements ExportStrategy {
    @Override
    public String serialize(ReportDocument document) {
        StringBuilder sb = new StringBuilder();
        sb.append(document.getMetadataHeader()).append("\n");
        sb.append("REPORT: ").append(document.getTitle().toUpperCase()).append("\n");
        sb.append("========================================\n");
        for (DataRecord record : document.getRecords()) {
            record.getFields().forEach((k, v) -> sb.append(k).append(": ").append(v).append(" | "));
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String getFormatName() { return "Plain Text (.txt)"; }
}