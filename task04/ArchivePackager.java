import java.util.List;

public class ArchivePackager {
    public void packageArchive(String destination, String algorithm, String checksum, List<String> compressedEntries) {
        int totalCompressedBytes = compressedEntries.stream().mapToInt(String::length).sum();
        System.out.println("  [ArchivePackager] Creating archive '" + destination + "'");
        System.out.println("    Algorithm : " + algorithm);
        System.out.println("    Checksum  : #" + checksum);
        System.out.println("    Entries   : " + compressedEntries.size() + " files (" + totalCompressedBytes + " bytes compressed)");
    }
}