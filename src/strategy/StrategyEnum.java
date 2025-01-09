package strategy;

public enum StrategyEnum {
    ORIGINAL(0),
    HIGH_LIFE(1),
    DAY_AND_NIGHT(2);

    final int value;

    StrategyEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static StrategyEnum fromValue(int value) {
        for (StrategyEnum strategyEnum: StrategyEnum.values()) {
            if (strategyEnum.getValue() == value) {
                return strategyEnum;
            }
        }
        return null;
    }
}
