package com.csd.calculator;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NumberProgramTest {
	
	NumberProgram objNumber;
	
	@Before
	public void setup(){
		objNumber = new NumberProgram();
	}
	
	@After
	public void cleanUp(){
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testFindGreaterNumber(){
		int expectedValue = 6;
		int actualValue = (int) objNumber.findGreaterNumber(5,6);
		assertEquals(expectedValue,actualValue,0);
		
		double expectedDoubleValue = 5.6;
		double actualDoubleValue = objNumber.findGreaterNumber(5.6,4.3);
		assertEquals(expectedDoubleValue,actualDoubleValue,0);
		
		double expectedEqualValue = 5.6;
		double actualEqualValue = objNumber.findGreaterNumber(5.6,5.6);
		assertEquals(expectedEqualValue,actualEqualValue,0);
		
		double expectedNegativeValue = -1;
		double actualNegativeValue = objNumber.findGreaterNumber(-1,-4);
		assertEquals(expectedNegativeValue,actualNegativeValue,0);
		
		long expectedLargeValue = 999999999;
		long actualLargeValue = (long) objNumber.findGreaterNumber(999999999,999999998);
		assertEquals(expectedLargeValue,actualLargeValue,0);
		
		double expectedDecimalValue = 0.111111111111111111111111111111111111111111;
		double actualDecimalValue = objNumber.findGreaterNumber(0.111111111111111111111111111111111111111111,0.11111111111111111111111111111111111111111);
		assertEquals(expectedDecimalValue,actualDecimalValue,0);
	}

}
