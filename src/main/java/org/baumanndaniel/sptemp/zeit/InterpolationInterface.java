package org.baumanndaniel.sptemp.zeit;

import java.time.OffsetDateTime;
import java.util.HashMap;

@FunctionalInterface
public interface InterpolationInterface {
	TS_Object<?,?> interpolate(TS_Object<?,?> start_ts, TS_Object<?,?> end_ts, OffsetDateTime time, HashMap<?, ?> kwargs);
}