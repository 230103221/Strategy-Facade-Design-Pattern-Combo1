public interface DeliveryChannelStrategy {
    boolean dispatch(UserContact contact, String formattedMessage);
    String getChannelName();
}