package strategy;

import strategy.rules.CombinedRule;
import strategy.rules.creation.B36;
import strategy.rules.survival.S23;

public class HighLifeStrategy extends Strategy {
    public HighLifeStrategy() {
        combinedRule = new CombinedRule(new S23(), new B36());
    }
}
