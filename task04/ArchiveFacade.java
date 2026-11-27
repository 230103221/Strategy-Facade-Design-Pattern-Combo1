import java.util.ArrayList;
import java.util.List;

public class ArchiveFacade {
    private final FileReader fileReader;
    private final ChecksumGenerator checksumGenerator;
    private final ArchivePackager archivePackager;
    private CompressionStrategy activeStrategy;

    public ArchiveFacade(CompressionStrategy initialStrategy) {
        this.fileReader = new FileReader();
        this.checksumGenerator = new ChecksumGenerator();
        this.archivePackager = new ArchivePackager();
        this.activeStrategy = initialStrategy;
    }

    public void setCompressionStrategy(CompressionStrategy strategy) {
        this.activeStrategy = strategy;
        System.out.println("\n[Facade] Switched compression strategy to: " + strategy.getAlgorithmName());
    }

    public void createArchive(List<String> sourceFiles, String destination) {
        System.out.println("[Facade] Starting archival job -> '" + destination + "' using " + activeStrategy.getAlgorithmName());

        List<FilePayload> payloads = fileReader.readFiles(sourceFiles);
        String checksum = checksumGenerator.computeIntegrityHash(payloads);

        List<String> compressedDataList = new ArrayList<>();
        for (FilePayload payload : payloads) {
            String compressed = activeStrategy.compress(payload.getRawData());
            compressedDataList.add(compressed);
        }

        archivePackager.packageArchive(destination, activeStrategy.getAlgorithmName(), checksum, compressedDataList);
        System.out.println("[Facade] Archive '" + destination + "' created successfully.");
    }
}