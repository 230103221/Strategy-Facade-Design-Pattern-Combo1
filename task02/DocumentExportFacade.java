public class DocumentExportFacade {
    private final ContentValidator validator;
    private final MetadataStamp metadataStamp;
    private final DiskWriter diskWriter;
    private ExportStrategy activeStrategy;

    public DocumentExportFacade(ExportStrategy initialStrategy) {
        this.validator = new ContentValidator();
        this.metadataStamp = new MetadataStamp();
        this.diskWriter = new DiskWriter();
        this.activeStrategy = initialStrategy;
    }

    public void setExportStrategy(ExportStrategy strategy) {
        this.activeStrategy = strategy;
        System.out.println("\n[Facade] Switched export strategy to: " + strategy.getFormatName());
    }

    public void exportReport(ReportDocument document, String outputPath) {
        System.out.println("[Facade] Starting export to '" + outputPath + "' using " + activeStrategy.getFormatName());

        if (!validator.validate(document)) {
            System.out.println("[Facade] Export aborted due to validation errors.");
            return;
        }

        metadataStamp.applyStamp(document);
        String serializedContent = activeStrategy.serialize(document);
        diskWriter.writeToFile(outputPath, serializedContent);
        System.out.println("[Facade] Export completed successfully.");
    }
}