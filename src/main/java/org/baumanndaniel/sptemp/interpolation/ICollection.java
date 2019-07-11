package org.baumanndaniel.sptemp.interpolation;

import java.time.OffsetDateTime;
import java.util.HashMap;

import org.baumanndaniel.sptemp.zeit.TS_Object;

public class ICollection {

	/**
	 * 
	 * @param start_ts TS_Object laying before end_ts on the time axis
	 * @param end_ts TS_Object laying after start_ts on the time axis
	 * @param time OffsetDateTime defining the point in time for which the value will be interpolated
	 * @param kwargs HashMap with additional arguments for the interpolation function.
	 * @return A null value.
	 */
	public static TS_Object<?,?> undefined(TS_Object<?,?> start_ts, TS_Object<?,?> end_ts, OffsetDateTime time, HashMap<?, ?> kwargs) {
		return null;
	}
	
	/**
	 * 
	 * @param start_ts TS_Object laying before end_ts on the time axis
	 * @param end_ts TS_Object laying after start_ts on the time axis
	 * @param time OffsetDateTime defining the point in time for which the value will be interpolated
	 * @param kwargs HashMap with additional arguments for the interpolation function.
	 * @return TS_Object with start_ts.get _value() as value, if time lays before end_ts.start_time() on the time axis,
	 *         else the value of the returned TS_Object is end_ts.get_value().
	 */
	public static TS_Object<?,?> constant(TS_Object<?,?> start_ts, TS_Object<?,?> end_ts, OffsetDateTime time, HashMap<?, ?> kwargs) {
		if (time.isBefore(end_ts.start_time())) {
			return new TS_Object<>(start_ts.get_value(), time);
		}
		else {
			return new TS_Object<>(end_ts.get_value(), time);
		}
	}
}
