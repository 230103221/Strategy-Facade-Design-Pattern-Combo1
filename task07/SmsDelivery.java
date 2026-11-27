public class SmsDelivery implements DeliveryChannelStrategy {
    @Override
    public boolean dispatch(UserContact contact, String formattedMessage) {
        System.out.println("  [SmsDelivery] Sending SMS via SMPP gateway to [" + contact.getPhoneNumber() + "]: \"" + formattedMessage + "\"");
        return true;
    }

    @Override
    public String getChannelName() {
        return "SMS Channel";
    }
}