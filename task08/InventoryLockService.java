public class InventoryLockService {
    public boolean lockStock(String orderId, String sku, int quantity) {
        System.out.printf("  [InventoryLockService] Reserved %d unit(s) of SKU '%s' for order %s.%n",
                quantity, sku, orderId);
        return true;
    }

    public void releaseStock(String orderId, String sku, int quantity) {
        System.out.printf("  [InventoryLockService] ROLLBACK: Released %d locked unit(s) of SKU '%s' for order %s.%n",
                quantity, sku, orderId);
    }
}