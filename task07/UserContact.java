public class UserContact {
    private final String userId;
    private final String email;
    private final String phoneNumber;
    private final String deviceToken;

    public UserContact(String userId, String email, String phoneNumber, String deviceToken) {
        this.userId = userId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.deviceToken = deviceToken;
    }

    public String getUserId() { return userId; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getDeviceToken() { return deviceToken; }
}