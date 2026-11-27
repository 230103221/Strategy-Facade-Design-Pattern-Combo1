import java.util.Map;

public class Main {
    public static void main(String[] args) {
        NotificationFacade notifier = new NotificationFacade(new EmailDelivery());
        notifier.sendAlert("user_42", "SECURITY_LOGIN", Map.of("ip", "192.168.1.45", "device", "Windows PC"));

        notifier.setDeliveryChannelStrategy(new SmsDelivery());
        notifier.sendAlert("user_42", "SECURITY_LOGIN", Map.of("ip", "192.168.1.45", "device", "Windows PC"));

        notifier.setDeliveryChannelStrategy(new PushNotificationDelivery());
        notifier.sendAlert("user_88", "ORDER_SHIPPED", Map.of("orderId", "9941", "carrier", "DHL Express"));
    }
}