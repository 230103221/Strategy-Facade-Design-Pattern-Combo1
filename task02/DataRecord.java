import java.util.LinkedHashMap;
import java.util.Map;

public class DataRecord {
    private final Map<String, String> fields = new LinkedHashMap<>();

    public void addField(String key, String value) {
        fields.put(key, value);
    }

    public Map<String, String> getFields() {
        return fields;
    }
}