public class BoxSelector {
    public String selectBoxSize(double weightKg) {
        String boxType;
        if (weightKg <= 2.0) {
            boxType = "Small Padded Mailer (S)";
        } else if (weightKg <= 10.0) {
            boxType = "Medium Corrugated Box (M)";
        } else {
            boxType = "Large Heavy-Duty Crate (L)";
        }
        System.out.println("  [BoxSelector] Selected packaging for " + weightKg + " kg: " + boxType);
        return boxType;
    }
}