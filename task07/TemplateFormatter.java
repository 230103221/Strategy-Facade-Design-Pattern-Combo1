import java.util.Map;

public class TemplateFormatter {
    public String render(String messageKey, Map<String, String> payload) {
        String template;
        switch (messageKey) {
            case "SECURITY_LOGIN":
                template = "Security Alert: New login detected from IP {ip} on {device}.";
                break;
            case "ORDER_SHIPPED":
                template = "Order #{orderId} has been dispatched via {carrier}.";
                break;
            default:
                template = "Notification [{key}]: {info}";
                break;
        }

        String rendered = template.replace("{key}", messageKey);
        for (Map.Entry<String, String> entry : payload.entrySet()) {
            rendered = rendered.replace("{" + entry.getKey() + "}", entry.getValue());
        }
        System.out.println("  [TemplateFormatter] Rendered message: \"" + rendered + "\"");
        return rendered;
    }
}