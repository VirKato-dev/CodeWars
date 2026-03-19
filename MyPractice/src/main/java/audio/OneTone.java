package audio;

import javax.sound.sampled.*;

public class OneTone {

    private static final float SAMPLE_RATE = 8000;
    private static final int SAMPLE_SIZE = 8;
    private static final int CHANNELS = 1;

    private static final AudioFormat FORMAT = new AudioFormat(
            SAMPLE_RATE, SAMPLE_SIZE, CHANNELS, false, false);

    private final SourceDataLine line;

    private boolean phase = true;

    public OneTone() throws LineUnavailableException {
        line = AudioSystem.getSourceDataLine(FORMAT);
        line.open(FORMAT);
        line.start();
    }

    public void play(int frequency) {
        byte[] buffer = new byte[(int)SAMPLE_RATE / (frequency * 2)];

        int i = 0;
        while (i < buffer.length) {
            int halfTone = frequency;
            for (; i < buffer.length && halfTone >= 0; i++, halfTone--) {
                buffer[i] = phase ? (byte) 127 : (byte) 0;
            }
            phase = !phase;
        }

        line.write(buffer, 0, buffer.length);
    }

    public void stop() {
        line.drain();
        line.close();
    }

    public static void main(String[] args) throws LineUnavailableException, InterruptedException {
        OneTone player = new OneTone();
        int duration = 1;
        int frequency = 3999;

        for (int i = 0; i < duration; i++) {
            player.play((int) SAMPLE_RATE / 2 - (frequency - i));
        }

        player.stop();
    }

}
