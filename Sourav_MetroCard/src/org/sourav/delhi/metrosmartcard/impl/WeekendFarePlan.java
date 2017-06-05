package org.sourav.delhi.metrosmartcard.impl;

import org.sourav.delhi.metrosmartcard.IJourneyFarePlan;

public class WeekendFarePlan implements IJourneyFarePlan{

	@Override
    public String getName() {
        return WeekdayFarePlan.class.toString();
    }
    @Override
    public double getFareValueDetails() {
        return 5.5;
    }

}
