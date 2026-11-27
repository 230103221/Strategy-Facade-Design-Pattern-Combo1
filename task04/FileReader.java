import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public List<FilePayload> readFiles(List<String> filePaths) {
        List<FilePayload> payloads = new ArrayList<>();
        for (String path : filePaths) {
            String mockContent = path.endsWith(".bmp")
                    ? "AAAAABBBBBCCCCCDDDDD"
                    : "System Archive Data Log - System Data Verified";
            payloads.add(new FilePayload(path, mockContent));
            System.out.println("  [FileReader] Read '" + path + "' (" + mockContent.length() + " bytes)");
        }
        return payloads;
    }
}