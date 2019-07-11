package org.baumanndaniel.sptemp.zeit;

import java.util.Objects;
import java.time.OffsetDateTime;

/**
 * This class can be used to represent time periods with a closed lower and closed upper border.
 * 
 * @author  Daniel Baumann
 * @version 0.0.1
 * @since   0.0.1
 */
public class Time_Period {
	
	private OffsetDateTime start, end;
	
	/**
	 * Instantiates a Time_Perod from two OffsetDateTime objects.
	 * @param start starting time instant of the time period
	 * @param end ending time instant of the time period
	 * @throws IllegalArgumentException if start does not lay before end on the time axis
	 */
	public Time_Period(OffsetDateTime start, OffsetDateTime end) {
		if (start.isBefore(end)) {
			this.start = start;
			this.end = end;
		}
		else {
			throw new IllegalArgumentException("start must lay before end!");
		}
	}
	
	/**
	 * Creates Time_Period object from two Strings in the ISO8601 format
	 * @param start starting time instant of the time period
	 * @param end ending time instant of the time period
	 * @return returns Time_Period object
	 */
	public static Time_Period from_iso(String start, String end) {
		return new Time_Period(OffsetDateTime.parse(start), OffsetDateTime.parse(end));
	}
	
	/**
	 * Indicates of some other object is equal to this time period
	 * @param o object with which the time period will be compared
	 * @return true if 'o' is an instance of the Time_Period class and
	 *         start and end of the two time periods are equal
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Time_Period)) {
            return false;
        }
		
		Time_Period tp = (Time_Period) o;
		return start.equals(tp.get_start()) &&
				end.equals(tp.get_end());
	}
	
	/**
	 * @return returns hash code for the time period object
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.start, this.end);
	}
	
	/**
	 * 
	 * @return start time instant of the time period
	 */
	public OffsetDateTime get_start() {
		return this.start;
	}
	
	/**
	 * 
	 * @param time the time instant that replaces current starting time instant of the time period
	 * @throws IllegalArgumentException if 'time' does not lay before end of the time period on the time axis
	 */
	public void set_start(OffsetDateTime time) {
		if (time.isBefore(this.end)) {
			this.start = time;
		}
		else {
			throw new IllegalArgumentException("start must lay before end of the Time_Period!");
		}
	}
	
	/**
	 * 
	 * @return end time instant of the time period
	 */
	public OffsetDateTime get_end() {
		return this.end;
	}
	
	/**
	 * 
	 * @param time The time instant that will replace the ending time instant of the Time Period
	 * @throws IllegalArgumentException if 'time' does not lay after start of the time period on the time axis
	 */
	public void set_end(OffsetDateTime time) {
		if (time.isAfter(this.start)) {
			this.end = time;
		}
		else {
			throw new IllegalArgumentException("start must lay before end of the Time_Period!");
		}
	}
	
	/**
	 * 
	 * @param another The time period for which it will be checked if this time period lays before on the time axis
	 * @return true if this.end < another.start, else false
	 */
	public boolean before(Time_Period another) {
		if(this.end.isBefore(another.get_start())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param another The OffsetDateTime for which it will be checked if this time period lays before on the time axis
	 * @return true if this.end < another, else false
	 */
	public boolean before(OffsetDateTime another) {
		if(this.end.isBefore(another)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param another The time period for which it will be checked if this time period lays after on the time axis
	 * @return true if this.start > another.end, else false
	 */
	public boolean after(Time_Period another) {
		if(this.start.isAfter(another.get_end())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param another The OffsetDateTime for which it will be checked if this time period lays after on the time axis
	 * @return true if this.start > another, else false
	 */
	public boolean after(OffsetDateTime another) {
		if(this.start.isAfter(another)) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
