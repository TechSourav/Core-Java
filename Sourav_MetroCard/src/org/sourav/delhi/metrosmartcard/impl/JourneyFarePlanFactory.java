package org.sourav.delhi.metrosmartcard.impl;

import java.util.Calendar;
import java.util.TimeZone;

import org.sourav.delhi.metrosmartcard.IJourneyFarePlan;

public class JourneyFarePlanFactory {
	
	//public static String[] namesOfDays =  {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESSDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
	
    static final IJourneyFarePlan weekendPlan = new WeekendFarePlan();
    static final IJourneyFarePlan weekdayPlan = new WeekdayFarePlan();
    //Calendar cal = Calendar.getInstance(TimeZone.getDefault());
    
    public static IJourneyFarePlan getFareStrategy(Calendar localDateTime) {
    	//int day =localDateTime.get(localDateTime.DAY_OF_WEEK);
    	
        if (localDateTime.get(localDateTime.DAY_OF_WEEK) == 7 || localDateTime.get(localDateTime.DAY_OF_WEEK) == 1) {
            return weekendPlan;
        } else {
            return weekdayPlan;
        }
    }
}


