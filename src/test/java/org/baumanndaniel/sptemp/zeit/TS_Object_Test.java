package org.baumanndaniel.sptemp.zeit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import java.time.OffsetDateTime;

public class TS_Object_Test {

	private TS_Object<Integer, OffsetDateTime> tso1;
	private TS_Object<Double, Time_Period> tso2;
	private TS_Object<Double, Integer> tso3;
	
	@Before
	public void create_ts_objects() {
		this.tso1 = new TS_Object<>(120, OffsetDateTime.parse("2019-06-25T10:07:25+02:00"));
		this.tso2 = new TS_Object<>(120.5, Time_Period.from_iso("2019-06-25T10:07:30+02:00", "2019-06-25T10:10:05+02:00"));
	}
	
	@Test
	public void test_constructor() {
		try {
			this.tso3 = new TS_Object<>(120.5, 90);
			fail("IllegalArgumentException not thrown!");
		} catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void test_equals() {
		TS_Object<Integer, OffsetDateTime> tso4 = new TS_Object<>(120, OffsetDateTime.parse("2019-06-25T10:07:25+02:00"));
		assertFalse(this.tso1.equals(this.tso2));
		assertTrue(this.tso1.equals(tso4));
	}
	
	@Test
	public void test_hashcode() {
		assertEquals(this.tso1.hashCode(), -2089264923);
		assertEquals(this.tso2.hashCode(), -1870917194);
	}
	
	@Test
	public void test_get_value() {
		assertEquals(this.tso1.get_value(), (Integer)120);
	}
	
	@Test
	public void test_get_ts() {
		assertEquals(this.tso1.get_ts(), (OffsetDateTime)OffsetDateTime.parse("2019-06-25T10:07:25+02:00"));
	}
	
	@Test
	public void test_get_type() {
		assertEquals(this.tso1.get_type(), Integer.class);
	}
	
	@Test
	public void test_start_time() {
		assertEquals(this.tso1.start_time(), OffsetDateTime.parse("2019-06-25T10:07:25+02:00"));
		assertEquals(this.tso2.start_time(), OffsetDateTime.parse("2019-06-25T10:07:30+02:00"));
	}
	
	@Test
	public void test_end_time() {
		assertEquals(this.tso1.end_time(), OffsetDateTime.parse("2019-06-25T10:07:25+02:00"));
		assertEquals(this.tso2.end_time(), OffsetDateTime.parse("2019-06-25T10:10:05+02:00"));
	}

}
