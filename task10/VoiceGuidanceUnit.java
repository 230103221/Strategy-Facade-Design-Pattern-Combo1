public class VoiceGuidanceUnit {
    public void announceRoute(RoutePlan plan, boolean isRecalculation) {
        String prefix = isRecalculation ? "Route recalculated. " : "Starting navigation. ";
        System.out.printf("  [VoiceGuidanceUnit] TTS: \"%sTake %s (%.1f km, ~%d min, Tolls: $%.2f).\"%n",
                prefix, plan.getSummary(), plan.getDistanceKm(), plan.getEstimatedMinutes(), plan.getTollCost());
    }
}