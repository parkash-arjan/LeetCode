package algo.leetcode.string;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AtoiTest {
	Atoi atoi = null;
	private static final int MIN_VALUE = Integer.MIN_VALUE;
	private static final int MAX_VALUE = Integer.MAX_VALUE;

	public AtoiTest() {
		atoi = new Atoi();
	}

	@Test
	void testEmptyOrNullString() {
		assertEquals(0, atoi.myAtoi(null), "Null string should have length zero.");
		assertEquals(0, atoi.myAtoi(""), "Empty string should have length zero.");
	}

	@Test
	void testConvertPositiveNumberInRange() {
		assertEquals(1, atoi.myAtoi("1"), "Should return 1 .");
		assertEquals(99, atoi.myAtoi("99"), "Should return 99 .");
		assertEquals(123, atoi.myAtoi("123"), "Should return 123 .");

		assertEquals(MAX_VALUE, atoi.myAtoi(String.valueOf(MAX_VALUE)), "Should return " + MAX_VALUE + ".");
	}

	@Test
	void testConvertPositiveNumberInRangeWithExplicitPlusSign() {
		assertEquals(1, atoi.myAtoi("+1"), "Should return 1 .");
		assertEquals(99, atoi.myAtoi("+99"), "Should return 99 .");
		assertEquals(123, atoi.myAtoi("+123"), "Should return 123 .");
		assertEquals(MAX_VALUE, atoi.myAtoi("+" + MAX_VALUE), "Should return " + MAX_VALUE + ".");
	}

	@Test
	void testConvertNegativeNumberInRange() {
		assertEquals(-1, atoi.myAtoi("-1"), "Should return -1 .");
		assertEquals(-99, atoi.myAtoi("-99"), "Should return -99 .");
		assertEquals(-123, atoi.myAtoi("-123"), "Should return -123 .");
		assertEquals(MIN_VALUE, atoi.myAtoi(String.valueOf(MIN_VALUE)), "Should return " + MIN_VALUE + ".");

	}

	@Test
	void testConvertNegativeNumberInRangeWithExplicitPlusSign() {
		assertEquals(-1, atoi.myAtoi("-1"), "Should return -1 .");
		assertEquals(-99, atoi.myAtoi("-99"), "Should return -99 .");
		assertEquals(-123, atoi.myAtoi("-123"), "Should return -123 .");
		assertEquals(MIN_VALUE, atoi.myAtoi("-2147483648"), "Should return " + MIN_VALUE + ".");
	}

//	@Test
//	void testConvertPositiveNumberOutOfRange() {
//
//		// 2147483647 MAX
//		// -2147483648 MIN
//
//		assertEquals(2147483647, atoi.myAtoi("2147483647"), "Should return 2147483647 .");
//		assertEquals(0, atoi.myAtoi("2147483648"), "Should return 99 .");
//		assertEquals(0, atoi.myAtoi("2147483649"), "Should return 99 .");
//		assertEquals(0, atoi.myAtoi("2147483650"), "Should return 99 .");
//
//	}

	@Test
	void testAlphanumericString() {
		assertEquals(4193, atoi.myAtoi("4193 with words"), "Should return 4193 .");
		assertEquals(0, atoi.myAtoi("words and 987"), "Should return 0 .");
	}
}
