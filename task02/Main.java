import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataRecord row1 = new DataRecord();
        row1.addField("ID", "101");
        row1.addField("Product", "Laptop");
        row1.addField("Revenue", "$1200");

        DataRecord row2 = new DataRecord();
        row2.addField("ID", "102");
        row2.addField("Product", "Monitor");
        row2.addField("Revenue", "$350");

        ReportDocument report = new ReportDocument("Q4 Sales Summary", "Analytics Team", List.of(row1, row2));

        DocumentExportFacade exporter = new DocumentExportFacade(new PlainTextExport());
        exporter.exportReport(report, "exports/sales_q4.txt");

        exporter.setExportStrategy(new CsvExport());
        exporter.exportReport(report, "exports/sales_q4.csv");

        exporter.setExportStrategy(new MarkdownExport());
        exporter.exportReport(report, "exports/sales_q4.md");
    }
}