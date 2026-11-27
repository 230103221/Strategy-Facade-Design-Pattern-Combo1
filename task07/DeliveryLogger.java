public class DeliveryLogger {
    public void logStatus(String userId, String channelName, String messageKey, boolean success) {
        String status = success ? "DELIVERED" : "FAILED";
        System.out.printf("  [DeliveryLogger] Audit -> User: %s | Channel: %s | Template: %s | Status: %s%n",
                userId, channelName, messageKey, status);
    }
}