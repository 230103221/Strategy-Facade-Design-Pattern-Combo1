public class ContentValidator {
    public boolean validate(ReportDocument document) {
        if (document == null || document.getTitle() == null || document.getTitle().isBlank()) {
            System.out.println("  [ContentValidator] Validation failed: Missing document title.");
            return false;
        }
        if (document.getRecords() == null || document.getRecords().isEmpty()) {
            System.out.println("  [ContentValidator] Validation failed: Document contains no records.");
            return false;
        }
        System.out.println("  [ContentValidator] Document '" + document.getTitle() + "' passed validation.");
        return true;
    }
}