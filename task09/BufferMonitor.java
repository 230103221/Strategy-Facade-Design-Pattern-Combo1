public class BufferMonitor {
    public double measureBandwidthMbps() {
        return 18.5;
    }

    public void allocateJitterBuffer(String resolution) {
        System.out.println("  [BufferMonitor] Adjusted ring buffer capacity for " + resolution + " (12s ahead).");
    }
}