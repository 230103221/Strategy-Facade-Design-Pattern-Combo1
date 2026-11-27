import java.util.Map;

public class NotificationFacade {
    private final UserPreferenceStore preferenceStore;
    private final TemplateFormatter templateFormatter;
    private final DeliveryLogger deliveryLogger;
    private DeliveryChannelStrategy activeStrategy;

    public NotificationFacade(DeliveryChannelStrategy initialStrategy) {
        this.preferenceStore = new UserPreferenceStore();
        this.templateFormatter = new TemplateFormatter();
        this.deliveryLogger = new DeliveryLogger();
        this.activeStrategy = initialStrategy;
    }

    public void setDeliveryChannelStrategy(DeliveryChannelStrategy strategy) {
        this.activeStrategy = strategy;
        System.out.println("\n[Facade] Switched delivery channel to: " + strategy.getChannelName());
    }

    public void sendAlert(String userId, String messageKey, Map<String, String> payload) {
        System.out.println("[Facade] Dispatching '" + messageKey + "' alert to '" + userId + "' via " + activeStrategy.getChannelName());

        UserContact contact = preferenceStore.resolveContact(userId);
        String formattedMessage = templateFormatter.render(messageKey, payload);
        boolean isSent = activeStrategy.dispatch(contact, formattedMessage);
        deliveryLogger.logStatus(userId, activeStrategy.getChannelName(), messageKey, isSent);

        System.out.println("[Facade] Notification workflow finished.");
    }
}