public class TaxEngine {
    public double calculateTax(double subtotal, String regionCode) {
        double rate = regionCode.equalsIgnoreCase("EU") ? 0.20 : 0.08;
        double tax = Math.round(subtotal * rate * 100.0) / 100.0;
        System.out.printf("  [TaxEngine] Region '%s' (%.0f%% VAT/Tax) -> Tax: $%.2f%n",
                regionCode, rate * 100, tax);
        return tax;
    }
}