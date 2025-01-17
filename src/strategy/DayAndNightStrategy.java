package strategy;

import strategy.rules.CombinedRule;
import strategy.rules.creation.B3678;
import strategy.rules.survival.S34678;

public class DayAndNightStrategy extends Strategy {
    public DayAndNightStrategy() {
        combinedRule = new CombinedRule(new B3678(), new S34678());
    }
}
