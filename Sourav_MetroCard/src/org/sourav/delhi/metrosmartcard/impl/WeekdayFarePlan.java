package org.sourav.delhi.metrosmartcard.impl;

import org.sourav.delhi.metrosmartcard.IJourneyFarePlan;

public class WeekdayFarePlan implements IJourneyFarePlan{

	@Override
    public String getName() {
        return WeekdayFarePlan.class.toString();
    }
    @Override
    public double getFareValueDetails() {
        return 7;
    }

}
