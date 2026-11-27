public class EmailDelivery implements DeliveryChannelStrategy {
    @Override
    public boolean dispatch(UserContact contact, String formattedMessage) {
        System.out.println("  [EmailDelivery] Sending SMTP email to <" + contact.getEmail() + ">: \"" + formattedMessage + "\"");
        return true;
    }

    @Override
    public String getChannelName() {
        return "Email Channel";
    }
}