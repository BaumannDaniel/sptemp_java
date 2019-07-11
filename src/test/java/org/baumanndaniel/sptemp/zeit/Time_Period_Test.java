package org.baumanndaniel.sptemp.zeit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import java.time.OffsetDateTime;

public class Time_Period_Test {
	
	private Time_Period tp;

	@Before
	public void create_time_period() {
		OffsetDateTime s = OffsetDateTime.parse("2019-06-25T10:07:25+02:00");
		OffsetDateTime e = OffsetDateTime.parse("2019-06-25T10:12:34+02:00");
		this.tp = new Time_Period(s,e);
	}
	
	@Test
	public void test_constructor() {
		try {
			OffsetDateTime s = OffsetDateTime.parse("2019-06-25T10:12:34+02:00");
			OffsetDateTime e = OffsetDateTime.parse("2019-06-25T10:07:25+02:00");
			Time_Period test_tp = new Time_Period(s,e);
			fail("IllegalArgumentException not thrown!");
		} catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void test_from_iso() {
		assertEquals(tp, Time_Period.from_iso("2019-06-25T10:07:25+02:00", "2019-06-25T10:12:34+02:00"));
	}
	
	@Test
	public void test_equals() {
		OffsetDateTime s = OffsetDateTime.parse("2019-06-25T10:07:25+02:00");
		OffsetDateTime e = OffsetDateTime.parse("2019-06-25T10:12:34+02:00");
		Time_Period tp2 = new Time_Period(s,e);
		assertTrue(tp2.equals(tp));
	}
	
	@Test
	public void test_hash_code() {
		assertEquals(tp.hashCode(), 1622319481);
	}
	
	@Test
	public void get_start_test() {
		assertEquals(tp.get_start(), OffsetDateTime.parse("2019-06-25T10:07:25+02:00"));
	}
	
	@Test
	public void set_start_test() {
		try {
			tp.set_start(OffsetDateTime.parse("2019-06-25T10:12:34+02:00"));
			fail("IllegalArgumentException not thrown!");
		} catch(IllegalArgumentException e) {}
		
		tp.set_start(OffsetDateTime.parse("2019-06-25T10:07:18+02:00"));
		assertEquals(tp.get_start(), OffsetDateTime.parse("2019-06-25T10:07:18+02:00"));
	}
	
	@Test
	public void get_end_test() {
		assertEquals(tp.get_end(), OffsetDateTime.parse("2019-06-25T10:12:34+02:00"));
	}
	
	@Test
	public void set_end_test() {
		try {
			tp.set_end(OffsetDateTime.parse("2019-06-25T10:07:24+02:00"));
			fail("IllegalArgumentException not thrown!");
		} catch(IllegalArgumentException e) {}
		
		tp.set_end(OffsetDateTime.parse("2019-06-25T10:14:18+02:00"));
		assertEquals(tp.get_end(), OffsetDateTime.parse("2019-06-25T10:14:18+02:00"));
	}

}
