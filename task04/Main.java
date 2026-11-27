import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> files = List.of("assets/banner.bmp", "logs/system.log");

        ArchiveFacade archiver = new ArchiveFacade(new RunLengthCompression());
        archiver.createArchive(files, "backups/release_rle.arc");

        archiver.setCompressionStrategy(new DictionaryCompression());
        archiver.createArchive(files, "backups/release_dict.arc");

        archiver.setCompressionStrategy(new NoCompression());
        archiver.createArchive(files, "backups/release_raw.tar");
    }
}