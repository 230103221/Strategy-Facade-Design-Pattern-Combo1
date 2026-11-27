public class PushNotificationDelivery implements DeliveryChannelStrategy {
    @Override
    public boolean dispatch(UserContact contact, String formattedMessage) {
        System.out.println("  [PushNotificationDelivery] Pushing APNs/FCM alert to device [" + contact.getDeviceToken() + "]: \"" + formattedMessage + "\"");
        return true;
    }

    @Override
    public String getChannelName() {
        return "Push Notification Channel";
    }
}