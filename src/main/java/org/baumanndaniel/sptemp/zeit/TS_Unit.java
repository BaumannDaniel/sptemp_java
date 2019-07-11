package org.baumanndaniel.sptemp.zeit;

import java.time.OffsetDateTime;
import java.util.HashMap;

/**
 * This class can be used to represent static methods, timestamped with a Time_Period.
 * 
 * @author  Daniel Baumann
 * @version 0.0.1
 * @since   0.0.1
 */
public class TS_Unit extends TS_Object<InterpolationInterface, Time_Period> {

	/**
	 * 
	 * @param value A interpolation method.
	 * @param ts A Time_Period object.
	 */
	public TS_Unit(InterpolationInterface value, Time_Period ts) {
		super(value, ts);
	}
	
	/**
	 * Calls timestamped function of the TS_Unit, and returns interpolated value.
	 * 
	 * @param start_ts TS_Object laying before end_ts on the time axis
	 * @param end_ts TS_Object laying after start_ts on the time axis
	 * @param time OffsetDateTime defining the point in time for which the value will be interpolated
	 * @param kwargs HashMap with additional arguments for the interpolation function.
	 * @throws IllegalArgumentException if start_ts.get_type() does not equal end_ts.get_type()
	 * @return TS_Object holding interpolated value and 'time' as timestamp.
	 */
	public TS_Object<?,?> interpolate(TS_Object<?,?> start_ts, TS_Object<?,?> end_ts, OffsetDateTime time, HashMap<?, ?> kwargs) {
		if (start_ts.get_type().equals(end_ts.get_type())) {
			return this.ip(this.get_value(), start_ts, end_ts, time, kwargs);
		}
		else {
			throw new IllegalArgumentException("ts must be of type OffsetDateTime or of type Time_Period");
		}
	}
	
	private TS_Object<?,?> ip(InterpolationInterface ipf, TS_Object<?,?> start_ts, TS_Object<?,?> end_ts, OffsetDateTime time, HashMap<?, ?> kwargs) {
		return ipf.interpolate(start_ts, end_ts, time, kwargs);
	}
}