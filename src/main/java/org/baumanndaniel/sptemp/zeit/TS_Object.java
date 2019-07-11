package org.baumanndaniel.sptemp.zeit;

import java.util.Objects;
import java.time.OffsetDateTime;

/**
 * This class can be used to represent timestamped objects.
 * Any object can be timestamped with a Time_Period or OffsetDateTime object
 * 
 * @author  Daniel Baumann
 * @version 0.0.1
 * @since   0.0.1
 */
public class TS_Object<V, D> {
	
	private V value;
	private D ts;
	private Class type;
	
	/**
	 * 
	 * @param value object that is timestamped
	 * @param ts timestamp for the value
	 * @throws IllegalArgumentException if 'ts' not of type OffsetDateTime or Time_Period
	 */
	public TS_Object(V value, D ts) {
		if (ts instanceof OffsetDateTime || ts instanceof Time_Period) {
			this.value = value;
			this.ts = ts;
			this.type = value.getClass();
		}
		else {
			throw new IllegalArgumentException("ts must be of type OffsetDateTime or of type Time_Period");
		}
	}
	
	/**
	 * Indicates of some other object is equal to this TS_Object
	 * @param o object with which this TS_Object will be compared
	 * @return true if 'o' is an instance of the TS_Object class and
	 *         the value and timestamp of the two TS_Objects are equal
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof TS_Object<?,?>)) {
            return false;
        }
		
		TS_Object tso = (TS_Object)o;
		return this.get_value().equals(tso.get_value()) &&
				this.get_ts().equals(tso.get_ts());
	}
	
	/**
	 * @return returns hash code for the TS_Object
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.value, this.ts);
	}
	
	/**
	 * 
	 * @return the timestamped value
	 */
	public V get_value() {
		return this.value;
	}
	
	/**
	 * 
	 * @return the timestamp of the value
	 */
	public D get_ts() {
		return this.ts;
	}
	
	/**
	 * 
	 * @return the Class of the value
	 */
	public Class get_type() {
		return this.type;
	}
	
	/**
	 * 
	 * @return If the timestamp is of type OffsetDateTime, then the timestamp is returned.
	 *         If the timestamp is of type Time_Period, then timestamp.get_start() is returned
	 */
	public OffsetDateTime start_time() {
		if (this.ts instanceof OffsetDateTime) {
			OffsetDateTime s_time = (OffsetDateTime) this.ts;
			return s_time;
		}
		else {
			Time_Period s_time = (Time_Period) this.ts;
			return s_time.get_start();
		}
	}
	
	/**
	 * 
	 * @return If the timestamp is of type OffsetDateTime, then the timestamp is returned.
	 *         If the timestamp is of type Time_Period, then timestamp.get_end() is returned
	 */
	public OffsetDateTime end_time() {
		if (this.ts instanceof OffsetDateTime) {
			OffsetDateTime s_time = (OffsetDateTime) this.ts;
			return s_time;
		}
		else {
			Time_Period s_time = (Time_Period) this.ts;
			return s_time.get_end();
		}
	}
	
}
