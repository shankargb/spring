package com.junit;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class AddTest {

	private static Sub sub = null;
	
	@BeforeClass
	public static void beforeAll() {
		sub = new Sub();
	}
	
	@AfterClass
	public static void afterAll() {
		sub = null;
	}
	
	@Test
	public void testSub() {
		Integer subValue = sub.subtract(60, 40);
		Integer expectedValue = 20;
		assertEquals(expectedValue, subValue);
	}
}
