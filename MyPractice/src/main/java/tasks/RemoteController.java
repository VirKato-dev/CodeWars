package tasks;

/**
 * Пульт дистанционного управления
 */
public class RemoteController {
    private BaseStrategy[] modes = {
            new VolumeStrategy(),
            new ChannelStrategy()
    };
    private int currentMode = 0;

    public int firstButton() {
        currentMode = ++currentMode % modes.length;
        System.out.println("Выбран режим: " + modes[currentMode].getModeName());
        return currentMode;
    }

    public int secondButton() {
        modes[currentMode].increment();
        System.out.println(modes[currentMode].getValueName() + ": " + modes[currentMode].getValue());
        return modes[currentMode].getValue();
    }

    public int thirdButton() {
        modes[currentMode].decrement();
        System.out.println(modes[currentMode].getValueName() + ": " + modes[currentMode].getValue());
        return modes[currentMode].getValue();
    }
}


abstract class BaseStrategy {
    private int value = 0;
    protected int limit = 10;

    public final void increment() {
        value = (limit + ++value) % limit;
    }

    public final void decrement() {
        value = (limit + --value) % limit;
    }

    public final int getValue() {
        return value;
    }

    abstract String getModeName();

    abstract String getValueName();
}

/**
 * Изменение громкости
 */
class VolumeStrategy extends BaseStrategy {
    public VolumeStrategy() {
        this.limit = 5;
    }

    @Override
    public String getModeName() {
        return "Изменение громкости";
    }

    @Override
    public String getValueName() {
        return "Громкость";
    }
}

/**
 * Переключение каналов
 */
class ChannelStrategy extends BaseStrategy {
    public ChannelStrategy() {
        this.limit = 3;
    }

    @Override
    public String getModeName() {
        return "Изменение канала";
    }

    @Override
    public String getValueName() {
        return "Канал";
    }
}
