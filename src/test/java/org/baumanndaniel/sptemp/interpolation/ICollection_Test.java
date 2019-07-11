package org.baumanndaniel.sptemp.interpolation;

import static org.junit.Assert.*;

import java.time.OffsetDateTime;
import java.util.HashMap;
import org.junit.Test;
import org.junit.Before;

import org.baumanndaniel.sptemp.zeit.TS_Object;

public class ICollection_Test {
	
	private TS_Object<Integer, OffsetDateTime> tso1, tso2;
	private OffsetDateTime t;

	@Before
	public void create_test_data() {
		this.tso1 = new TS_Object<>(120, OffsetDateTime.parse("2019-06-25T10:07:25+02:00"));
		this.tso2 = new TS_Object<>(140, OffsetDateTime.parse("2019-06-25T10:07:45+02:00"));
		this.t = OffsetDateTime.parse("2019-06-25T10:07:30+02:00");
	}
	
	@Test
	public void test_undefined() {
		assertEquals(ICollection.undefined(this.tso1, this.tso2, this.t, new HashMap()), null);
	}
	
	@Test
	public void test_constant() {
		assertEquals(ICollection.constant(this.tso1, this.tso2, this.t, new HashMap()).get_value(), 120);
	}

}
