package org.sourav.delhi.metrosmartcard.util;

public enum MetroStationDetails {

	A1,
	A2,
	A3,
	A4,
	A5,
	A6,
	A7,
	A8,
	A9,
	A10;
	
    public int distance(MetroStationDetails station) {
        return Math.abs(station.ordinal() - this.ordinal());
    }

}
