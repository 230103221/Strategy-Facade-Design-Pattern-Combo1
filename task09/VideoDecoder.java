public class VideoDecoder {
    public void initializeStream(String streamUrl, String resolution) {
        System.out.println("  [VideoDecoder] Hardware decoding started for '" + streamUrl + "' at " + resolution);
    }

    public void switchTrackSeamless(String newResolution, long currentTimestampMs) {
        System.out.printf("  [VideoDecoder] Seamless IDR-frame switch to %s at timestamp %dms%n",
                newResolution, currentTimestampMs);
    }
}