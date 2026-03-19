package audio;

import javax.sound.sampled.*;

public class TonePlayer {

    // Параметры по умолчанию
    private static final int SAMPLE_RATE = 44100; // Гц
    private static final int SAMPLE_SIZE_BITS = 16;
    private static final int CHANNELS = 1; // Моно
    private static final boolean SIGNED = true;
    private static final boolean BIG_ENDIAN = false;

    /**
     * Воспроизводит тон заданной частоты в течение указанного времени.
     *
     * @param frequency Гц — частота тона
     * @param duration  мс — продолжительность воспроизведения
     */
    public static void playTone(double frequency, int duration) {
        try {
            AudioFormat format = new AudioFormat(SAMPLE_RATE, SAMPLE_SIZE_BITS, CHANNELS, SIGNED, BIG_ENDIAN);
            SourceDataLine line = AudioSystem.getSourceDataLine(format);
            line.open(format);
            line.start();

            int bufferSize = (int) ((SAMPLE_RATE * duration) / 1000);
            byte[] buffer = new byte[bufferSize * 2]; // 16 бит = 2 байта на сэмпл

            double amplitude = 32767; // Максимальная амплитуда для 16-битного звука
            double dt = 1.0 / SAMPLE_RATE;

            for (int i = 0; i < bufferSize; i++) {
                double t = i * dt;
                double sampleValue = amplitude * Math.sin(2 * Math.PI * frequency * t);
                short sample = (short) sampleValue;

                // Записываем в буфер в little-endian формате (BIG_ENDIAN = false)
                buffer[2 * i] = (byte) (sample & 0xFF);
                buffer[2 * i + 1] = (byte) ((sample >> 8) & 0xFF);
            }

            line.write(buffer, 0, buffer.length);
            line.drain();
            line.close();
        } catch (LineUnavailableException e) {
            System.err.println("Аудиолиния недоступна: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Пример: воспроизвести тон 440 Гц (ля первой октавы) в течение 2 секунд

        int tone = (255 - 1) * 2;

        playTone(tone, 2000);
    }
}