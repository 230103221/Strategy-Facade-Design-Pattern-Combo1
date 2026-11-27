public class UserPreferenceStore {
    public UserContact resolveContact(String userId) {
        System.out.println("  [UserPreferenceStore] Resolving contact endpoints for user '" + userId + "'...");
        return new UserContact(
                userId,
                userId.toLowerCase() + "@example.com",
                "+1-555-019-2834",
                "fcm_tok_" + userId.hashCode()
        );
    }
}