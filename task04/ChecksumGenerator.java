import java.util.List;

public class ChecksumGenerator {
    public String computeIntegrityHash(List<FilePayload> files) {
        int hash = 7;
        for (FilePayload file : files) {
            hash = 31 * hash + file.getFileName().hashCode();
            hash = 31 * hash + file.getRawData().hashCode();
        }
        String hexHash = Integer.toHexString(Math.abs(hash)).toUpperCase();
        System.out.println("  [ChecksumGenerator] Computed SHA-Sim Checksum: #" + hexHash);
        return hexHash;
    }
}