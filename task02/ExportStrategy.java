public interface ExportStrategy {
    String serialize(ReportDocument document);
    String getFormatName();
}