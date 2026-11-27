public class DiskWriter {
    public void writeToFile(String outputPath, String formattedContent) {
        System.out.println("  [DiskWriter] Writing " + formattedContent.length() + " bytes to '" + outputPath + "'");
        System.out.println("--- File Output Preview ---\n" + formattedContent.trim() + "\n---------------------------");
    }
}