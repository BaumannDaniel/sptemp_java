package org.baumanndaniel.sptemp.zeit;

import static org.junit.Assert.*;

import java.time.OffsetDateTime;
import java.util.HashMap;

import org.junit.Test;
import org.junit.Before;

import org.baumanndaniel.sptemp.interpolation.ICollection;

public class TS_Unit_Test {
	
	private TS_Unit tsu1;
	
	@Before
	public void create_ts_units() {
		Time_Period tp1 = Time_Period.from_iso("2019-06-25T10:07:30+02:00", "2019-06-25T10:10:05+02:00");
		this.tsu1 = new TS_Unit(ICollection::constant, tp1);
	}
	
	@Test
	public void test_interpolate() {
		TS_Object<Integer, OffsetDateTime> tso1 = new TS_Object<>(120, OffsetDateTime.parse("2019-06-25T10:07:25+02:00"));
		TS_Object<Integer, OffsetDateTime> tso2 = new TS_Object<>(140, OffsetDateTime.parse("2019-06-25T10:07:45+02:00"));
		OffsetDateTime t = OffsetDateTime.parse("2019-06-25T10:07:30+02:00");
		assertEquals(tsu1.interpolate(tso1, tso2, t, new HashMap()).get_value(), 120);
	}

}
