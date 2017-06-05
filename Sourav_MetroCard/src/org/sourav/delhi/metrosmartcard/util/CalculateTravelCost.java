package org.sourav.delhi.metrosmartcard.util;

import java.util.Calendar;
import java.util.TimeZone;

import org.sourav.delhi.metrosmartcard.IJourneyFarePlan;
import org.sourav.delhi.metrosmartcard.impl.JourneyFarePlanFactory;

public class CalculateTravelCost {
	
	//Calendar localDateTime = Calendar.getInstance(TimeZone.getDefault());
	
	public double getFare(MetroStationDetails source, MetroStationDetails destination,Calendar localDateTime) {
		IJourneyFarePlan farePlan = JourneyFarePlanFactory.getFareStrategy(localDateTime);
        int distance = source.distance(destination);
        double fare = distance * farePlan.getFareValueDetails();
        return fare;
    }

}
