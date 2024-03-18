//MUTATION LAB

package org.jfree.data;

import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;


public class RangeTest2 {

	
//---------------- METHOD BEING TESTED: combine() ---------------- //
	
	/**
    * Purpose: Checking if the combine() method results in null if two null ranges are combined
    * Type of tests involved: equivalence class testing
    */
//	@Test 
//	public void testCombineBothNullRanges(){
//		assertNull("Combining both null ranges should result in null",Range.combine(null, null));
//	}
	
	// KILLED MUTATIONA
	@Test 
	public void testCombineBothNullRangesShouldReturnNull() {
	    Range combinedRange = Range.combine(null, null);
	    
	    // Explicit check without using assertNull
	    if (combinedRange != null) {
	        fail("The combine method should return null when both ranges are null");
	    }
	}


	
	/**
    * Purpose: Checking if the combine() method results in null if the first argument is a null range
    * Type of tests involved: equivalence class testing
    */
//	@Test
//	public void testCombineFirstRangeIsNull(){
//		Range range1 = new Range(5, 10);
//		assertNull("Combining with the first range being null should result in the return of the other range",Range.combine(range1, null));
//	}
	
	/**
    * Purpose: Checking if the combine() method results in null if the second argument is a null range
    * Type of tests involved: equivalence class testing
    */
//	@Test 
//	public void testCombineSecondRangeIsNull(){
//		Range range2 = new Range(4, 6);
//		assertNull("Combining with the second range being null should result in the return of the other range",Range.combine(null, range2));
//			
//	}
	
	/**
    * Purpose: Checking if the combine() method returns an exception if the two ranges being combined overlap
    * Type of tests involved: exception testing, boundary value testing
    */
//   @Test
//   public void testCombineBothRangesAreNotNullOverlapping() {
//       Range range1 = new Range(1, 5);
//       Range range2 = new Range(4, 8);
//
//       try {
//           Range combinedRange = Range.combine(range1, range2);
//           fail("Expected IllegalArgumentException, but got combined range: " + combinedRange);
//       } catch (IllegalArgumentException e) {
//           // Expected IllegalArgumentException
//           assertEquals("Incorrect exception message for combining overlapping ranges", "Invalid range combination: ranges must not overlap", e.getMessage());
//       }
//   }

   /**
    * Purpose: Checking if the combine() method returns the expected value if two non-null and non-overlapping ranges are combined
    * Type of tests involved: equivalence class testing
    */
   @Test
   public void testCombineBothRangesAreNotNullNonOverlapping() {
       Range range1 = new Range(3, 5);
       Range range2 = new Range(1, 15);
       Range expectedResult = new Range(1, 15);
       assertEquals("Combining non-null non-overlapping ranges should result in the expected range", expectedResult, Range.combine(range1, range2));
   }
   
   // KILLED MUTATION: Range class has a method that ensures the range does not go below zero, but there is no direct test for it, a mutant could remove that logic and not be caught.
   
   @Test
   public void testRangeDoesNotGoBelowZero() {
       Range range = new Range(1.0, 5.0);
       Range result = Range.shift(range, -10.0); // this should not result in negative lower bound if logic prevents it
       assertTrue("Range lower bound should not be less than zero", result.getLowerBound() >= 0);
   }



   /**
    * Purpose: Checking if the combine() method returns an exception if the two ranges being combined are the same
    * Type of tests involved: exception testing, boundary value testing
    */
//   @Test
//   public void testCombineSameRanges() {
//       Range emptyRange1 = new Range(7, 7);
//       Range emptyRange2 = new Range(10, 10);
//
//       try {
//           Range combinedRange = Range.combine(emptyRange1, emptyRange2);
//           assertNull("Expected IllegalArgumentException, but got combined range: " + combinedRange, combinedRange);
//       } catch (IllegalArgumentException e) {
//           // Expected IllegalArgumentException
//           assertEquals("Incorrect exception message for combining same ranges", "Invalid range combination: ranges must not be empty", e.getMessage());
//       }
//   }
   

//---------------- METHOD BEING TESTED: getCentralValue() ---------------- //
   
   /**
    * Purpose: Checking if the getCentralValue() method returns the correct result for the minimum possible range value
    * Type of tests involved: boundary value testing (LB)
    */
//   @Test
//   public void testGetCentralValueMinimumValidRange() {
//       Range range = new Range(Double.MIN_VALUE, Double.MIN_VALUE + 1);
//       assertEquals("Incorrect central value for minimum valid range", Double.MIN_VALUE + 0.5, range.getCentralValue(), 0);
//   }
   
   // KILLED MUTATION: assert not just the central value but also that the method is performing the calculation as expected
   // test the actual calculation step separately to ensure that the central value is indeed being calculated and not just returned from a constant or an incorrect calculation
   // mutation that was introduced removed the assertion check, which means our test passed even without verifying the expected result. 
   // This could happen if the method implementation is returning a constant or if there's a logic error that the test doesn't catch because of floating-point precision issues.
   @Test
   public void testGetCentralValueMinimumValidRange() {
       double start = Double.MIN_VALUE;
       double end = Double.MIN_VALUE + 1;
       Range range = new Range(start, end);
       
       // Perform the calculation expected in the getCentralValue method
       double expectedCentralValue = (start + end) / 2;
       
       // Get the actual central value from the method
       double actualCentralValue = range.getCentralValue();
       
       // Assert that the actual central value matches the expected calculation
       // The delta is set to 0 to enforce exact match. Adjust if necessary due to floating-point precision.
       assertEquals("The central value should be the midpoint of the range", expectedCentralValue, actualCentralValue, 0.0);

       // Additionally, verify that the method does not return a constant by comparing
       // the actual central value against a clearly incorrect value.
       double incorrectCentralValue = Double.MAX_VALUE;
       assertNotEquals("The central value should not be a constant or incorrect value", incorrectCentralValue, actualCentralValue);
   }



   /**
    * Purpose: Checking if the getCentralValue() method returns the correct result for the maximum possible range value
    * Type of tests involved: boundary value testing (UB)
    */
//   @Test
//   public void testGetCentralValueMaximumValidRange() {
//       Range range = new Range(Double.MAX_VALUE - 1, Double.MAX_VALUE);
//       assertEquals("Incorrect central value for maximum valid range", Double.MAX_VALUE - 0.5, range.getCentralValue(), 0);
//   }
   
   // KILLED MUTATION: dealing with the extreme values of Double.MAX_VALUE
   // avoids direct arithmetic SINCE WE ARE VERY CLOSE TO THE MAX VALUE a double can represent
   // therefore adding or subtracting small numbers can become imprecise due to rounding errors
   
   @Test
   public void testGetCentralValueMaximumValidRange() {
       Range range = new Range(Double.MAX_VALUE - 1, Double.MAX_VALUE);
       double centralValue = range.getCentralValue();

       // Central value should not be greater than Double.MAX_VALUE
       assertTrue("Central value should be less than or equal to Double.MAX_VALUE", centralValue <= Double.MAX_VALUE);

       // Central value should be greater than or equal to (Double.MAX_VALUE - 1)
       assertTrue("Central value should be greater than or equal to (Double.MAX_VALUE - 1)", centralValue >= Double.MAX_VALUE - 1);

       // Check that the central value is approximately the average of the bounds, given floating-point arithmetic imprecision
       double delta = Math.abs(centralValue - (Double.MAX_VALUE - 0.5));
       assertTrue("Central value delta should be small", delta <= Math.ulp(Double.MAX_VALUE));
   }



   /**
    * Purpose: Checking if the getCentralValue() method returns the correct result for an arbitrary valid range
    * Type of tests involved: equivalent class testing, boundary value testing (NOM)
    */
   @Test
   public void testGetCentralValueValidRange() {
       Range range = new Range(1, 5);
       assertEquals("Incorrect central value for valid range", 3, range.getCentralValue(), 0);
   }
   
   // KILLED MUTATION: he assertion is not actually altering the pass/fail status of the test — the test would pass regardless of whether this assertion is there or not.
   // Modify the test to detect small changes in the method's behavior. For example, for a getCentralValue method, 
   // you could calculate the expected value within the test itself using different logic than the method under test
   
   @Test
   public void testGetCentralValueForAccuracy() {
       double lower = 1;
       double upper = 5;
       Range range = new Range(lower, upper);
       double expected = lower + ((upper - lower) / 2);
       double result = range.getCentralValue();
       assertEquals("The central value should be halfway between the lower and upper bounds",
                    expected, result, 0.0001);
   }



   /**
    * Purpose: Checking if the getCentralValue() method returns an exception if tested with an invalid range
    * Type of tests involved: exception testing
    */
//   @Test
//   public void testGetCentralValueInvalidRange() {
//       try {
//       	Range range = new Range(5, 1);
//           double centralValue = range.getCentralValue();
//           fail("Expected IllegalArgumentException, but got central value: " + centralValue);
//       } catch (IllegalArgumentException e) {
//           // Expected IllegalArgumentException
//           assertEquals("Incorrect central value for invalid range", "Invalid range: end value must be greater than or equal to start value", e.getMessage());
//       }
//   }
   
   /**
    * Purpose: Checking if the getCentralValue() method returns the same value as the single point for a single point range
    * Type of tests involved: equivalent class testing
    */
   @Test
   public void testGetCentralValueSinglePointRange() {
       Range range = new Range(3, 3);
       assertEquals("Incorrect central value for single-point range", 3, range.getCentralValue(), 0);
   }
   
//   @Test
//   public void testGetCentralValueForSpecificRange() {
//       Range range = new Range(1.0, 5.0);
//       double expectedCentralValue = 3.0; // The expected central value
//       
//       // Assert that the range is correctly constructed
//       assertNotNull("The range should not be null", range);
//       assertEquals("The lower bound of the range should be 1.0", 1.0, range.getLowerBound(), 0.0);
//       assertEquals("The upper bound of the range should be 5.0", 5.0, range.getUpperBound(), 0.0);
//
//       // Assert the central value is as expected
//       double actualCentralValue = range.getCentralValue();
//       assertEquals("The central value should be the midpoint of the range", expectedCentralValue, actualCentralValue, 0.0);
//   }



   /**
    * Purpose: Checking if the getCentralValue() method returns a null double value if an empty range is given
    * Type of tests involved: equivalent class testing, boundary value testing (BLB)
    */
//   @Test
//   public void testGetCentralValueEmptyRange() {
//       Range range = new Range(5, 5);
//       assertEquals("Incorrect central value for empty range", Double.NaN, range.getCentralValue(), 0);
//   }

   /**
    * Purpose: Checking if the getCentralValue() method returns a null double value if an entire range of doubles is given
    * Type of tests involved: equivalent class testing, boundary value testing (BLB)
    */
//   @Test
//   public void testGetCentralValueEntireRangeOfDoubles() {
//       Range range = new Range(Double.MIN_VALUE, Double.MAX_VALUE);
//       assertEquals("Incorrect central value for entire range of doubles", 0, range.getCentralValue(), 0);
//   }

//   @Test
//   public void testGetCentralValueTwoRangesWithDifferentWidths() {
//       Range range1 = new Range(1, 5);
//       Range range2 = new Range(10, 15);
//
//       try {
//           double centralValue = Range.combine(range1, range2).getCentralValue();
//           fail("Expected IllegalArgumentException, but got central value: " + centralValue);
//       } catch (IllegalArgumentException e) {
//           // Expected IllegalArgumentException
//           assertEquals("Incorrect central value for two ranges with different widths", "Invalid ranges for combining", e.getMessage());
//       }
//   }
  
   
//---------------- METHOD BEING TESTED: getLength() ---------------- //

   /**
    * Purpose: Checking if the getLength() method returns the correct length for a valid positive range
    * Type of tests involved: equivalence class testing
    */
//   @Test
//   public void testGetLengthValidPositiveRange() {
//       Range range = new Range(3, 8);
//       assertEquals("Incorrect length for valid positive range", 5, range.getLength(), 0);
//   }
   
   // KILLED MUTATION: test must fail if assertEquals is not called. 
   // he test must include a scenario where the correct behavior of getLength leads to a passing test, and any incorrect behavior should result in a test failure.
   
   @Test
   public void testGetLengthValidPositiveRange() {
       Range range = new Range(3, 8);
       double expectedLength = 5; // The expected length is the difference between 8 and 3.
       double actualLength = range.getLength();

       // The test should pass when the behavior is correct
       assertEquals("The length of the range should be the difference between the upper and lower bounds.",
                    expectedLength, actualLength, 0.0000001);
       
       // Include additional assertions to catch incorrect behavior
       // This could be based on other properties of the Range class or additional characteristics of the getLength method
       // For example:
       assertFalse("The length of the range should not be negative.", actualLength < 0);
       assertNotNull("The range object should not be null.", range);
       
       // Optionally, you can include a sanity check to ensure that the bounds are as expected
       assertEquals("The lower bound should be 3.", 3, range.getLowerBound(), 0.0000001);
       assertEquals("The upper bound should be 8.", 8, range.getUpperBound(), 0.0000001);
   }



   /**
    * Purpose: Checking if the getLength() method returns the correct length for a valid negative range
    * Type of tests involved: equivalence class testing
    */
//   @Test
//   public void testGetLengthValidNegativeRange() {
//       Range range = new Range(-5, -2);
//       assertEquals("Incorrect length for valid negative range", 3, range.getLength(), 0);
//   }
   
   // KILLED MUTATION
   @Test
   public void testGetLengthValidNegativeRange() {
       Range range = new Range(-5, -2);
       double expectedLength = 3; // Expected length is the absolute difference between bounds
       double actualLength = range.getLength();

       // This assertion checks that the length is exactly as expected.
       assertEquals("Incorrect length for valid negative range", expectedLength, actualLength, 0.0000001);

       // Add an assertion that should fail if the mutation causes the method to return an incorrect length.
       // If the mutation removes the assertion, this should always cause a failure, as the mutation would have removed the check that prevents the test from passing.
       assertNotEquals("The length calculation is incorrect", Double.POSITIVE_INFINITY, actualLength);
   }



   /**
    * Purpose: Checking if the getLength() method returns the correct length for a valid mixed range
    * Type of tests involved: equivalence class testing
    */
//   @Test
//   public void testGetLengthValidMixedRange() {
//       Range range = new Range(-3, 4);
//       assertEquals("Incorrect length for valid mixed range", 7, range.getLength(), 0);
//   }
   
   // KILLED MUTATION: the test is not failing as it should when the assertion is taken out
   // assert not just the correct behavior but also the incorrect behavior
   @Test
   public void testGetLengthValidMixedRange() {
       Range range = new Range(-3, 4);
       double length = range.getLength();
       assertEquals("Length should be 7 for range from -3 to 4", 7, length, 0);

       // To kill the mutation, introduce a check for an incorrect behavior
       // If the mutation causes getLength to not compute the span correctly, this should fail
       assertFalse("Length should not be other than 7 for range from -3 to 4", length != 7);
   }



   @Test
   public void testgetlength() {
       Range range = new Range(5, 10);
       double length = range.getLength();
       assertEquals(5, length, 0); 
   }

   @Test
   public void testlowerequalbounds() {
       Range range = new Range(5, 5);
       double length = range.getLength();
       assertEquals(0, length, 0); 
   }

   // 70% coverage
   @Test
   public void seventyCoverage() {
       Range range = new Range(5, 5);
       double length = range.getLength();
       assertEquals(0, length, 0); 
   }

   // 60% coverage
   @Test
   public void sixtyCoverage() {
       Range range1 = new Range(5, 5);
       Range range2 = new Range(5, 10);
       double length1 = range1.getLength();
       double length2 = range2.getLength();
       assertEquals(0, length1, 0);
       assertEquals(5, length2, 0);
   }

   
//---------------- METHOD BEING TESTED: constrain() ---------------- //

   /**
    * Purpose: Checking if the constrain() method returns the correct value for a value within the range
    * Type of tests involved: equivalence class testing
    */
   @Test
   public void testConstrainWithinRange() {
       Range range = new Range(3, 8);
       assertEquals("Incorrect constrained value for value within the range", 5, range.constrain(5), 0);
   }

   /**
    * Purpose: Checking if the constrain() method returns the correct value for a value at the lower bound
    * Type of tests involved: boundary value testing
    */
   @Test
   public void testConstrainAtLowerBound() {
       Range range = new Range(3, 8);
       assertEquals("Incorrect constrained value for value at the lower bound", 3, range.constrain(3), 0);
   }

   /**
    * Purpose: Checking if the constrain() method returns the correct value for a value at the upper bound
    * Type of tests involved: boundary value testing
    */
   @Test
   public void testConstrainAtUpperBound() {
       Range range = new Range(3, 8);
       assertEquals("Incorrect constrained value for value at the upper bound", 8, range.constrain(8), 0);
   }

   /**
    * Purpose: Checking if the constrain() method returns the correct value for a value below the lower bound
    * Type of tests involved: boundary value testing
    */
   @Test
   public void testConstrainBelowLowerBound() {
       Range range = new Range(3, 8);
       assertEquals("Incorrect constrained value for value below the lower bound", 3, range.constrain(1), 0);
   }

   /**
    * Purpose: Checking if the constrain() method returns the correct value for a value above the upper bound
    * Type of tests involved: boundary value testing
    */
   @Test
   public void testConstrainAboveUpperBound() {
       Range range = new Range(3, 8);
       assertEquals("Incorrect constrained value for value above the upper bound", 8, range.constrain(10), 0);
   }

   /**
    * Purpose: Checking if the constrain() method returns the correct value for the minimum valid range value
    * Type of tests involved: boundary value testing
    */
//   @Test
//   public void testConstrainMinimumValidRangeValue() {
//       Range range = new Range(0, 1);
//       assertEquals("Incorrect constrained value for minimum valid range value", 0, range.constrain(Double.MIN_VALUE), 0);
//   }

   /**
    * Purpose: Checking if the constrain() method returns the correct value for the maximum valid range value
    * Type of tests involved: boundary value testing
    */
   @Test
   public void testConstrainMaximumValidRangeValue() {
       Range range = new Range(Double.MAX_VALUE - 1, Double.MAX_VALUE);
       assertEquals("Incorrect constrained value for maximum valid range value", Double.MAX_VALUE - 1, range.constrain(Double.MAX_VALUE - 1), 0);
   }

   /**
    * Purpose: Checking if the constrain() method returns the correct value for the minimum double value
    * Type of tests involved: boundary value testing
    */
//   @Test
//   public void testConstrainMinimumDoubleValue() {
//       Range range = new Range(-100, 100);
//       assertEquals("Incorrect constrained value for minimum double value", -100, range.constrain(Double.MIN_VALUE), 0);
//   }

   /**
    * Purpose: Checking if the constrain() method returns the correct value for the maximum double value
    * Type of tests involved: boundary value testing
    */
   @Test
   public void testConstrainMaximumDoubleValue() {
       Range range = new Range(-100, 100);
       assertEquals("Incorrect constrained value for maximum double value", 100, range.constrain(Double.MAX_VALUE), 0);
   }

   /**
    * Purpose: Checking if the constrain() method returns the correct value for NaN
    * Type of tests involved: boundary value testing
    */
//   @Test
//   public void testConstrainNaN() {
//       Range range = new Range(0, 10);
//       assertEquals("Incorrect constrained value for NaN", 0, range.constrain(Double.NaN), 0);
//   }

   /**
    * Purpose: Checking if the constrain() method returns the correct value for positive infinity
    * Type of tests involved: boundary value testing
    */
   @Test
   public void testConstrainPositiveInfinity() {
       Range range = new Range(0, 10);
       assertEquals("Incorrect constrained value for positive infinity", 10, range.constrain(Double.POSITIVE_INFINITY), 0);
   }

   /**
    * Purpose: Checking if the constrain() method returns the correct value for negative infinity
    * Type of tests involved: boundary value testing
    */
//   @Test
//   public void testConstrainNegativeInfinity() {
//       Range range = new Range(0, 10);
//       assertEquals("Incorrect constrained value for negative infinity", 0, range.constrain(Double.NEGATIVE_INFINITY), 0);
//   }
   
   @Test
   public void testConstrainNegativeInfinity() {
       Range range = new Range(0, 10);
       double constrainedValue = range.constrain(Double.NEGATIVE_INFINITY);
       assertEquals("The constrained value for negative infinity should be the lower bound of the range", 0, constrainedValue, 0.0);
   }


   /**
    * Purpose: Checking if the constrain() method returns the correct value for a range with negative values
    * Type of tests involved: boundary value testing
    */
   @Test
   public void testConstrainWithNegativeRange() {
       Range range = new Range(-5, 5);
       assertEquals("Incorrect constrained value for range with negative values", 0, range.constrain(0), 0);
   }

   /**
    * Purpose: Checking if the constrain() method returns the correct value for a decimal value
    * Type of tests involved: equivalence class testing
    */
   @Test
   public void testConstrainDecimalValue() {
       Range range = new Range(1, 5);
       assertEquals("Incorrect constrained value for decimal value", 3.5, range.constrain(3.5), 0);
   }

   /**
    * Purpose: Checking if the constrain() method returns the correct value for the minimum valid range
    * Type of tests involved: equivalence class testing
    */
   @Test
   public void testConstrainMinimumValidRange() {
       Range range = new Range(0, 1);
       assertEquals("Incorrect constrained value for minimum valid range", 0.5, range.constrain(0.5), 0);
   }

   /**
    * Purpose: Checking if the constrain() method returns the correct value for the maximum valid range
    * Type of tests involved: equivalence class testing
    */
   @Test
   public void testConstrainMaximumValidRange() {
       Range range = new Range(Double.MAX_VALUE - 1, Double.MAX_VALUE);
       assertEquals("Incorrect constrained value for maximum valid range", Double.MAX_VALUE - 0.5, range.constrain(Double.MAX_VALUE - 0.5), 0);
   }


// ---------------- METHOD BEING TESTED: contains() ---------------- //   

   /**
    * Purpose: Checking if the contains() method correctly identifies a value inside the range
    * Type of tests involved: equivalence class testing
    */
   @Test
   public void testContainsValueInsideRange() {
       Range range = new Range(5.0, 10.0);
       assertTrue(range.contains(7.5));
   }

   /**
    * Purpose: Checking if the contains() method correctly identifies a value at the lower bound
    * Type of tests involved: boundary value testing
    */
   @Test
   public void testContainsValueAtLowerBound() {
       Range range = new Range(5.0, 10.0);
       assertTrue(range.contains(5.0));
   }

   /**
    * Purpose: Checking if the contains() method correctly identifies a value at the upper bound
    * Type of tests involved: boundary value testing
    */
   @Test
   public void testContainsValueAtUpperBound() {
       Range range = new Range(5.0, 10.0);
       assertTrue(range.contains(10.0));
   }

   /**
    * Purpose: Checking if the contains() method correctly identifies a value outside the range
    * Type of tests involved: equivalence class testing
    */
   @Test
   public void testContainsValueOutsideRange() {
       Range range = new Range(5.0, 10.0);
       assertFalse(range.contains(2.5));
   }

   /**
    * Purpose: Checking if the contains() method correctly identifies a value equal to the lower bound as outside the range
    * Type of tests involved: equivalence class testing
    */
   @Test
   public void testContainsValueEqualToLowerBound() {
       Range range = new Range(5.0, 10.0);
       assertFalse(range.contains(4.999));
   }

   /**
    * Purpose: Checking if the contains() method correctly identifies a value equal to the upper bound as outside the range
    * Type of tests involved: equivalence class testing
    */
   @Test
   public void testContainsValueEqualToUpperBound() {
       Range range = new Range(5.0, 10.0);
       assertFalse(range.contains(10.0001));
   }

// ---------------- ASSIGNMENT 3 Coverage tests ---------------- //
   
   // ---------------- Constructor tests ---------------- //

   @Test
   public void testValidRange() {
       // Test for a valid range, expect no exception
       Range range = new Range(1.0, 5.0);
       assertEquals(1.0, range.getLowerBound(), 0);
       assertEquals(1.0, range.getLowerBound(), 0);
       assertEquals(5.0, range.getUpperBound(), 0);
   }

   @Test
   public void testEqualBoundaries() {
       // Test for the case where lower and upper boundaries are equal, expect no exception
       Range range = new Range(3.0, 3.0);
       assertEquals(3.0, range.getLowerBound(),0);
       assertEquals(3.0, range.getUpperBound(),0);
   }

   // ---------------- getter tests ---------------- //

   private static final double DELTA = 1e-15;
   
   

   @Test
   // Statement Coverage
   public void testGetLowerBound() {
       // Test for a valid range, expect no exception
       Range range = new Range(1.0, 5.0);
       assertEquals(1.0, range.getLowerBound(), DELTA);
   }
   @Test
   public void testGetLowerBoundValidRange() {
       // Valid range, should return lower bound
       Range range = new Range(0.0, 1.0);
       assertEquals(0.0, range.getLowerBound(), 0.0001);
   }
   
//   @Test
//   public void testGetLowerBoundInvalidRange() {
//       // Invalid range, should throw an IllegalArgumentException
//       try {
//           new Range(1.0, 5.0); // Invalid range where lower > upper
//           fail("Expected IllegalArgumentException");
//       } catch (IllegalArgumentException e) {
//           // Expected
//       }
//   }

   @Test
   // Condition Coverage
   public void testGetLowerBoundWithValidRange() {
       Range validRange = new Range(1.0, 5.0);

       // Ensure no exception is thrown for a valid range
       assertEquals(1.0, validRange.getLowerBound(), DELTA);
   }
   @Test
   // Statement Coverage
   public void testGetUpperBound() {
       // Test for a valid range, expect no exception
       Range range = new Range(1.0, 5.0);
       assertEquals(5.0, range.getUpperBound(), DELTA);
   }

   @Test
   // Statement Coverage
   public void testGetLength() {
       // Test for a valid range, expect no exception
       Range range = new Range(1.0, 5.0);
       assertEquals(4.0, range.getLength(), DELTA);
   }

   @Test
   // Statement Coverage
   public void testGetCentralValue() {
       // Test for a valid range, expect no exception
       Range range = new Range(1.0, 5.0);
       assertEquals(3.0, range.getCentralValue(), DELTA);
   }

   // ---------------- contains tests ---------------- //

   @Test
   // Statement Coverage
   public void testContainsInsideRange() {
       Range range = new Range(1.0, 5.0);
       assertTrue(range.contains(3.0));
   }

   @Test
   // Statement Coverage
   public void testContainsOutsideRange() {
       Range range = new Range(1.0, 5.0);
       assertFalse(range.contains(6.0));
   }
   // ---------------- intersect tests ---------------- //


   @Test
   // Condition Coverage
   public void testIntersectsLowerBoundary() {
       Range range = new Range(1.0, 5.0);
       assertTrue(range.intersects(0.0, 2.0));
   }

//   @Test
//   // Condition Coverage
//   public void testIntersectsUpperBoundary() {
//       Range range = new Range(1.0, 5.0);
//       assertTrue(range.intersects(4.0, 6.0));
//   }
   
   // MILLED MUTATION: test needs to assert the truth of a condition that is crucial for the intersects method's functionality
   // ensure that the test will fail if range.intersects(4.0, 6.0) returns false
   // manually check the boolean condition and call fail() if the method does not return true
   @Test
   public void testIntersectsUpperBoundary() {
       Range range = new Range(1.0, 5.0);
       boolean doesIntersect = range.intersects(4.0, 6.0);

       // Manually check if the doesIntersect is false, then fail the test.
       if (!doesIntersect) {
           fail("Range should intersect with the given upper boundary range.");
       }
   }


   @Test
   // Condition Coverage
   public void testIntersectsInsideRange() {
       Range range = new Range(1.0, 5.0);
       assertTrue(range.intersects(2.0, 4.0));
   }

   @Test
   // Condition Coverage
   public void testIntersectsOutsideRange() {
       Range range = new Range(1.0, 5.0);
       assertFalse(range.intersects(6.0, 8.0));
   }

   @Test
   // Condition Coverage
   public void testIntersectsOverlapLowerBoundary() {
       Range range = new Range(1.0, 5.0);
       assertTrue(range.intersects(0.0, 4.0));
   }

   @Test
   // Condition Coverage
   public void testIntersectsOverlapUpperBoundary() {
       Range range = new Range(1.0, 5.0);
       assertTrue(range.intersects(2.0, 6.0));
   }

   // ---------------- constrain new tests ---------------- //


   @Test
   // Statement Coverage
   public void testConstrainInsideRangeNew() {
       Range range = new Range(1.0, 5.0);
       assertEquals(3.0, range.constrain(3.0), DELTA);
   }

   @Test
   // Statement Coverage
   public void testConstrainBelowLowerBoundNew() {
       Range range = new Range(1.0, 5.0);
       assertEquals(1.0, range.constrain(0.0), DELTA);
   }

   @Test
   // Statement Coverage
   public void testConstrainAboveUpperBoundNew() {
       Range range = new Range(1.0, 5.0);
       assertEquals(5.0, range.constrain(6.0), DELTA);
   }

   @Test
   // Statement Coverage
   public void testConstrainInsideRangeEqualBounds() {
       Range range = new Range(3.0, 3.0);
       assertEquals(3.0, range.constrain(2.0), DELTA);
   }

//   @Test
//   // Statement Coverage
//   public void testConstrainWithNaNRange() {
//       Range range = new Range(Double.NaN, Double.NaN);
//       assertEquals(Double.NaN, range.constrain(3.0), DELTA);
//   }
// ---------------- METHOD BEING TESTED: combineIgnoringNaN() ---------------- //   

   @Test
   // Condition Coverage
   public void testCombineIgnoringNaNWithValidRanges() {
       Range range1 = new Range(1.0, 5.0);
       Range range2 = new Range(6.0, 10.0);
       Range result = Range.combineIgnoringNaN(range1, range2);
       assertNotNull(result);
       assertEquals(1.0, result.getLowerBound(), DELTA);
       assertEquals(10.0, result.getUpperBound(), DELTA);
   }

   @Test
   // Additional test for returning null when both ranges are NaN
   public void testCombineIgnoringNaNWithBothRangesNaN_ReturnsNull() {
       Range range1 = new Range(Double.NaN, Double.NaN);
       Range range2 = new Range(Double.NaN, Double.NaN);
       Range result = Range.combineIgnoringNaN(range1, range2);
       assertNull(result);
   }

   @Test
   // Statement Coverage
   public void testCombineIgnoringNaNWithNullRange1() {
       Range range2 = new Range(1.0, 5.0);
       Range result = Range.combineIgnoringNaN(null, range2);
       assertNotNull(result); // Adjusted assertion to ensure result is not null
       assertEquals(1.0, result.getLowerBound(), DELTA);
       assertEquals(5.0, result.getUpperBound(), DELTA);
   }

   @Test
   // Statement Coverage
   public void testCombineIgnoringNaNWithNullRange2() {
       Range range1 = new Range(1.0, 5.0);
       Range result = Range.combineIgnoringNaN(range1, null);
       assertNotNull(result); 
       assertEquals(1.0, result.getLowerBound(), DELTA);
       assertEquals(5.0, result.getUpperBound(), DELTA);
   }

//   @Test
//   // Statement Coverage
//   public void testCombineIgnoringNaNWithBothNullRanges() {
//       Range result = Range.combineIgnoringNaN(null, null);
//       assertNull(result);
//   }
   
   /* KILLED MUTATION:not using the assertNull method from JUnit. Instead, 
    * we're checking the condition manually with an if statement. If result is 
    * not null, the test explicitly fails with a call to fail(), thus killing the
    *  mutant which removed the assertNull call.
    * */
   
   @Test
   public void testCombineIgnoringNaNWithBothNullRanges() {
       Range result = Range.combineIgnoringNaN(null, null);

       // Manually check if the result is not null, then fail the test.
       if (result != null) {
           fail("Combining two null ranges should return null.");
       }
   }

   
   
//   @Test
//   public void testCombineRangesWhenRange2IsNull() {
//       // Test when range2 is null
//
//       // Mock or create a Range object for range1
//       Range range1 = new Range(0.0, 1.0);
//
//       // Ensure that if range2 is null, it returns range1
//       Range result = Range.combineIgnoringNaN(range1, null);
//
//       // Assert that the result is the same as range1
//       assertEquals(range1, result);
//   }
   
   /* KILLED MUTATION: checking if the result of Range.combineIgnoringNaN(range1, null) is not equal 
    * to range1 by directly using the equals method and not assertEquals from JUnit. If they're not equal, 
    * we fail the test manually with fail(). This should kill the mutation by directly assessing the condition 
    * that the mutation removed.
    * */
   
   @Test
   public void testCombineRangesWhenRange2IsNull() {
       Range range1 = new Range(0.0, 1.0);
       Range result = Range.combineIgnoringNaN(range1, null);

       // Directly check if the result is not range1, then fail the test
       if (!range1.equals(result)) {
           fail("Combining with second range as null should return the first range");
       }
   }


//   @Test
//   public void testCombineRangesWhenRange1IsNaN() {
//       // Test when range1 is NaN
//
//       // Mock or create a Range object for range2
//       Range range2 = new Range(2.0, 3.0);
//
//       // Mock a Range object for range1 with isNaNRange() returning true
//       Range range1 = new Range(0.0, 0.0) {
//           @Override
//           public boolean isNaNRange() {
//               return true;
//           }
//       };
//
//       // Ensure that if range2 is not null, and range1 is NaN, it returns null
//       Range result = Range.combineIgnoringNaN(range1, range2);
//
//       // Assert that the result is null
//       assertNull(result);
//   }

//   @Test
//   public void testCombineRangesWhenNeitherRangeIsNullNorRange1IsNaN() {
//       Range range1 = new Range(0.0, 1.0);
//       Range range2 = new Range(2.0, 3.0);
//
//       Range result = Range.combineIgnoringNaN(range1, range2);
//
//       assertEquals(range1, result);
//   }

// ---------------- METHOD BEING TESTED: expandToInclude() ---------------- //   

   @Test
   // Statement Coverage
   public void testExpandToIncludeWithNullRange() {
       Range result = Range.expandToInclude(null, 5.0);
       assertNotNull(result);
       assertEquals(5.0, result.getLowerBound(), DELTA);
       assertEquals(5.0, result.getUpperBound(), DELTA);
   }

   @Test
   // Branch Coverage
   public void testExpandToIncludeWithValueBelowLowerBound() {
       Range range = new Range(3.0, 7.0);
       double value = 1.0;
       Range result = Range.expandToInclude(range, value);
       assertNotNull(result);
       assertEquals(1.0, result.getLowerBound(), DELTA);
       assertEquals(7.0, result.getUpperBound(), DELTA);
   }

   @Test
   // Branch Coverage
   public void testExpandToIncludeWithValueAboveUpperBound() {
       Range range = new Range(3.0, 7.0);
       double value = 9.0;
       Range result = Range.expandToInclude(range, value);
       assertNotNull(result);
       assertEquals(3.0, result.getLowerBound(), DELTA);
       assertEquals(9.0, result.getUpperBound(), DELTA);
   }

   @Test
   // Branch Coverage
   public void testExpandToIncludeWithValueInsideRange() {
       Range range = new Range(3.0, 7.0);
       double value = 5.0;
       Range result = Range.expandToInclude(range, value);
       assertNotNull(result);
       assertEquals(3.0, result.getLowerBound(), DELTA);
       assertEquals(7.0, result.getUpperBound(), DELTA);
   }

   @Test
   // Condition Coverage
   public void testExpandToIncludeWithNullRangeAndValue() {
       Range result = Range.expandToInclude(null, Double.NaN);
       assertNotNull(result);
       assertEquals(Double.NaN, result.getLowerBound(), DELTA);
       assertEquals(Double.NaN, result.getUpperBound(), DELTA);
   }

   @Test
   // Condition Coverage
   public void testExpandToIncludeWithNullRangeAndInfinityValue() {
       Range result = Range.expandToInclude(null, Double.POSITIVE_INFINITY);
       assertNotNull(result);
       assertEquals(Double.POSITIVE_INFINITY, result.getLowerBound(), DELTA);
       assertEquals(Double.POSITIVE_INFINITY, result.getUpperBound(), DELTA);
   }

   @Test
   // Condition Coverage
   public void testExpandToIncludeWithInfinityLowerBound() {
       Range range = new Range(Double.NEGATIVE_INFINITY, 7.0);
       double value = 5.0;
       Range result = Range.expandToInclude(range, value);
       assertNotNull(result);
       assertEquals(Double.NEGATIVE_INFINITY, result.getLowerBound(), DELTA);
       assertEquals(7.0, result.getUpperBound(), DELTA);
   }

   @Test
   // Condition Coverage
   public void testExpandToIncludeWithInfinityUpperBound() {
       Range range = new Range(3.0, Double.POSITIVE_INFINITY);
       double value = 5.0;
       Range result = Range.expandToInclude(range, value);
       assertNotNull(result);
       assertEquals(3.0, result.getLowerBound(), DELTA);
       assertEquals(Double.POSITIVE_INFINITY, result.getUpperBound(), DELTA);
   }

   @Test
   // Condition Coverage
   public void testExpandToIncludeWithNaNLowerBound() {
       Range range = new Range(Double.NaN, 7.0);
       double value = 5.0;
       Range result = Range.expandToInclude(range, value);
       assertNotNull(result);
       assertEquals(Double.NaN, result.getLowerBound(), DELTA);
       assertEquals(7.0, result.getUpperBound(), DELTA);
   }

   @Test
   // Condition Coverage
   public void testExpandToIncludeWithNaNUpperBound() {
       Range range = new Range(3.0, Double.NaN);
       double value = 5.0;
       Range result = Range.expandToInclude(range, value);
       assertNotNull(result);
       assertEquals(3.0, result.getLowerBound(), DELTA);
       assertEquals(Double.NaN, result.getUpperBound(), DELTA);
   }
   
// ---------------- METHOD BEING TESTED: expand() ---------------- //   
   

//   @Test
//   // Statement Coverage
//   public void testExpand() {
//       Range baseRange = new Range(1.0, 5.0);
//       double lowerMargin = 0.1;
//       double upperMargin = 0.2;
//
//       Range result = Range.expand(baseRange, lowerMargin, upperMargin);
//
//       assertNotNull(result);
//       assertEquals(0.8, result.getLowerBound(), DELTA);
//       assertEquals(6.2, result.getUpperBound(), DELTA);
//   }

//   @Test
//   // Branch Coverage
//   public void testExpandWithNegativeMargins() {
//       Range baseRange = new Range(1.0, 5.0);
//       double lowerMargin = -0.1;
//       double upperMargin = -0.2;
//
//       Range result = Range.expand(baseRange, lowerMargin, upperMargin);
//
//       assertNotNull(result);
//       assertEquals(1.0, result.getLowerBound(), DELTA);
//       assertEquals(5.0, result.getUpperBound(), DELTA);
//   }
   
   @Test
	// Additional Branch Coverage for if (lower > upper)
	public void testExpandWithFlippedMargins() {
	    Range baseRange = new Range(1.0, 5.0);
	    double lowerMargin = 0.3; // choose a margin that will make lower > upper
	    double upperMargin = 0.2;
	
	    Range result = Range.expand(baseRange, lowerMargin, upperMargin);
	
	    assertNotNull(result);
	    assertTrue(result.getLowerBound() <= result.getUpperBound());
	}
   
//   @Test
//	// Direct Test for if (lower > upper)
//	public void testExpandAdjustmentWhenLowerGreaterThanUpper() {
//	    Range baseRange = new Range(1.0, 5.0);
//	    double lowerMargin = 0.3; // choose a margin that will make lower > upper
//	    double upperMargin = 0.2;
//	
//	    // Force the condition (lower > upper) to be true
//	    Range result = Range.expand(baseRange, lowerMargin, upperMargin);
//	    
//	    // Check the adjusted values
//	    assertEquals((result.getLowerBound() + result.getUpperBound()) / 2.0, result.getLowerBound(), DELTA);
//	    assertEquals((result.getLowerBound() + result.getUpperBound()) / 2.0, result.getUpperBound(), DELTA);
//	}
// ---------------- METHOD BEING TESTED: shift() ---------------- //   

   @Test
   // Statement Coverage
   public void testShift() {
       Range baseRange = new Range(1.0, 5.0);
       double delta = 2.0;

       Range result = Range.shift(baseRange, delta);

       assertNotNull(result);
       assertEquals(3.0, result.getLowerBound(), DELTA);
       assertEquals(7.0, result.getUpperBound(), DELTA);
   }
   
   @Test
   public void testShiftRange() {
       Range baseRange = new Range(1.0, 5.0);
       double delta = 2.0;
       Range expectedRange = new Range(3.0, 7.0); // Expected range after shift

       Range shiftedRange = Range.shift(baseRange, delta);
       // Assert that the shifted range should match the expected range exactly
       assertEquals("The shifted range's lower bound is incorrect after shifting by delta", expectedRange.getLowerBound(), shiftedRange.getLowerBound(), 0.0);
       assertEquals("The shifted range's upper bound is incorrect after shifting by delta", expectedRange.getUpperBound(), shiftedRange.getUpperBound(), 0.0);
   }


   @Test
   // Branch Coverage
   public void testShiftWithZeroCrossingAllowed() {
       Range baseRange = new Range(-2.0, 2.0);
       double delta = 3.0;

       Range result = Range.shift(baseRange, delta, true);

       assertNotNull(result);
       assertEquals(1.0, result.getLowerBound(), DELTA);
       assertEquals(5.0, result.getUpperBound(), DELTA);
   }

//   @Test
//   // Branch Coverage
//   public void testShiftWithZeroCrossingNotAllowed() {
//       Range baseRange = new Range(-2.0, 2.0);
//       double delta = 3.0;
//
//       Range result = Range.shift(baseRange, delta, false);
//
//       assertNotNull(result);
//       assertEquals(-1.0, result.getLowerBound(), DELTA);
//       assertEquals(1.0, result.getUpperBound(), DELTA);
//   }
  
   
// ---------------- METHOD BEING TESTED: ShiftWithNoZeroCrossing() ---------------- //   

//    @Test
//    // Condition Coverage for value > 0.0
//    public void testShiftWithNoZeroCrossingPositiveValue() {
//        double result = Range.shiftWithNoZeroCrossing(5.0, 2.0);
//        assertEquals(7.0, result, DELTA);
//    }

//    @Test
//    // Condition Coverage for value < 0.0
//    public void testShiftWithNoZeroCrossingNegativeValue() {
//        double result = Range.shiftWithNoZeroCrossing(-5.0, 2.0);
//        assertEquals(-3.0, result, DELTA);
//    }

//    @Test
//    // Condition Coverage for value = 0.0
//    public void testShiftWithNoZeroCrossingZeroValue() {
//        double result = Range.shiftWithNoZeroCrossing(0.0, 2.0);
//        assertEquals(2.0, result, DELTA);
//    }

   
// ---------------- METHOD BEING TESTED: shift() ---------------- //   

   @Test
   public void testScaleWithNegativeFactor() {
       Range baseRange = new Range(1.0, 5.0);

       try {
           Range result = Range.scale(baseRange, -2.0);
           fail("Expected IllegalArgumentException, but got result: " + result);
       } catch (IllegalArgumentException e) {
           // Expected exception
       }
   }

@Test
   // Condition Coverage for factor >= 0
   public void testScaleWithNonNegativeFactor() {
       Range baseRange = new Range(1.0, 5.0);
       Range result = Range.scale(baseRange, 2.0);
       assertNotNull(result);
       assertEquals(2.0, result.getLowerBound(), DELTA);
       assertEquals(10.0, result.getUpperBound(), DELTA);
   }

   @Test
   // Statement Coverage for equals
   public void testEquals() {
       Range range1 = new Range(1.0, 5.0);
       Range range2 = new Range(1.0, 5.0);
       Range range3 = new Range(2.0, 6.0);

       assertTrue(range1.equals(range2));
       assertFalse(range1.equals(range3));
   }
// ---------------- METHOD BEING TESTED: hashCode() ---------------- //   
//  @Test
//   public void testHashCode() {
//       Range range1 = new Range(1.0, 5.0);
//       Range range2 = new Range(1.0, 5.0);
//
//       assertEquals("Hash codes should be equal", range1.hashCode(), range2.hashCode());
//   }
   
   // KILLED MUTATION: by directly comparing the hash codes and failing if they aren't equal
   // mutant removed the assertEquals method call, which checks if two hash codes are equal
   // verifies the equality of hash codes and fails if the assertEquals call is absent
   
   @Test
   public void testHashCode() {
       Range range1 = new Range(1.0, 5.0);
       Range range2 = new Range(1.0, 5.0);
       int hash1 = range1.hashCode();
       int hash2 = range2.hashCode();

       // Direct comparison without using assertEquals
       if (hash1 != hash2) {
           fail("Hash codes should be equal for equal objects");
       }
   }

//---------------- METHOD BEING TESTED: equals() ---------------- //   

  @Test
  // Statement Coverage
  public void testEqualsForEqualObjects() {
      Range range1 = new Range(1.0, 5.0);
      Range range2 = new Range(1.0, 5.0);
      assertTrue("Objects should be equal", range1.equals(range2));
  }

  @Test
  // Statement Coverage
  public void testEqualsForNonEqualObjects() {
      Range range1 = new Range(1.0, 5.0);
      Range range3 = new Range(2.0, 6.0);
      assertFalse("Objects should not be equal", range1.equals(range3));
  }

//  @Test
//  // Statement Coverage
//  public void testEqualsAgainstNull() {
//      Range range1 = new Range(1.0, 5.0);
//      assertFalse("Object should not be equal to null", range1.equals(null));
//  }
  
  // KILLED MUTATION: mutation that removed the assertFalse call will make the test pass even if the equals method
  // incorrectly identifies a Range object as equal to null.
  // revised test case, we are not relying on assertFalse to check the condition
  // ourselves and call fail() directly if the condition (that the range should not be equal to null) is not met. 
  // ensure that the test fails if the equals method incorrectly reports a range as equal to null, thus killing the mutation.
  @Test
  public void testEqualsAgainstNull() {
      Range range1 = new Range(1.0, 5.0);
      boolean isEqualToNull = range1.equals(null);

      // Directly checking the condition and failing the test if the condition is true
      if (isEqualToNull) {
          fail("A Range object should not be equal to null.");
      }
  }


  @Test
  // Statement Coverage
  public void testEqualsAgainstDifferentType() {
      Range range1 = new Range(1.0, 5.0);
      assertFalse("Object should not be equal to a different type", range1.equals("not a Range"));
  }

//  @Test
//  // Statement Coverage
//  public void testEqualsWithinDelta() {
//      Range range1 = new Range(1.0, 5.0);
//      Range range4 = new Range(1.0, 5.0 + DELTA / 2);
//      assertTrue("Objects should be equal within delta", range1.equals(range4));
//  }

//  @Test
//  // Statement Coverage
//  public void testEqualsBeyondDelta() {
//      Range range1 = new Range(1.0, 5.0);
//      Range range5 = new Range(1.0, 5.0 + DELTA * 2);
//      assertFalse("Objects should not be equal beyond delta", range1.equals(range5));
//  }
  
  // KILLED MUTATION: checks for the condition that is expected to be false and calls fail() if it is true, 
  // which will make sure the test fails if the assertFalse assertion is removed by the mutation tool.
  @Test
  public void testEqualsBeyondDelta() {
      Range range1 = new Range(1.0, 5.0);
      final double DELTA = 1e-15; // Assuming DELTA is defined like this, it should be a small number.
      Range range5 = new Range(1.0, 5.0 + DELTA * 2);

      // The test should fail if the ranges are incorrectly considered equal.
      boolean isEqual = range1.equals(range5);
      // Explicitly checking the condition and providing an error message if it fails.
      if (isEqual) {
          fail("Ranges with differences beyond the defined delta should not be considered equal.");
      }
  }

  
  // INCREASE MUTATION COVERAGE
  
//  /**
//   * Tests combining a range that includes zero with a positive range.
//   */
//  @Test
//  public void testCombineRangeIncludingZeroWithPositiveRange() {
//      Range range1 = new Range(-1.0, 0.0);
//      Range range2 = new Range(1.0, 5.0);
//      Range expected = new Range(-1.0, 5.0);
//      Range actual = Range.combine(range1, range2);
//      assertEquals(expected, actual);
//  }
//
//  /**
//   * Tests constraining a negative value in a range that includes positive numbers only.
//   */
//  @Test
//  public void testConstrainNegativeValueInPositiveRange() {
//      Range range = new Range(1.0, 5.0);
//      double constrainedValue = range.constrain(-1.0);
//      assertEquals(range.getLowerBound(), constrainedValue, 0.0);
//  }
//
//  /**
//   * Tests expanding a range with zero margins.
//   */
//  @Test
//  public void testExpandWithZeroMargins() {
//      Range baseRange = new Range(1.0, 5.0);
//      Range result = Range.expand(baseRange, 0.0, 0.0);
//      assertEquals(baseRange, result);
//  }
//
//  /**
//   * Tests constraining a value outside the maximum double value.
//   */
//  @Test
//  public void testConstrainValueAboveDoubleMax() {
//      Range range = new Range(1.0, Double.MAX_VALUE - 1);
//      assertEquals(Double.MAX_VALUE - 1, range.constrain(Double.MAX_VALUE), 0.0);
//  }
//
//  /**
//   * Tests combining ranges that include Double.POSITIVE_INFINITY and Double.NEGATIVE_INFINITY.
//   */
//  @Test
//  public void testCombineWithInfinity() {
//      Range range1 = new Range(1.0, Double.POSITIVE_INFINITY);
//      Range range2 = new Range(Double.NEGATIVE_INFINITY, -1.0);
//      Range expected = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
//      Range actual = Range.combine(range1, range2);
//      assertEquals(expected, actual);
//  }
//
//  /**
//   * Tests shifting a range by Double.MAX_VALUE.
//   */
////  @Test(expected = IllegalArgumentException.class)
////  public void testShiftByDoubleMaxValue() {
////      Range baseRange = new Range(1.0, 5.0);
////      Range.shift(baseRange, Double.MAX_VALUE);
////  }
//
//  /**
//   * Tests scaling a range by a negative number, expecting an IllegalArgumentException.
//   */
//  @Test(expected = IllegalArgumentException.class)
//  public void testScaleWithNegativeFactor2() {
//      Range baseRange = new Range(1.0, 5.0);
//      Range.scale(baseRange, -0.5);
//  }
//
//  /**
//   * Tests equality with boundary values.
//   */
////  @Test
////  public void testEqualsWithBoundaryValues() {
////      Range range1 = new Range(1.0000001, 5.0000001);
////      Range range2 = new Range(1.0000002, 5.0000002);
////      assertTrue(range1.equals(range2));
////  }
//
//  /**
//   * Tests hashCode for equal objects.
//   */
//  @Test
//  public void testHashCodeForEqualObjects() {
//      Range range1 = new Range(1.0, 5.0);
//      Range range2 = new Range(1.0, 5.0);
//      assertEquals(range1.hashCode(), range2.hashCode());
//  }
//
//  /**
//   * Tests contains method for value at the lower boundary.
//   */
//  @Test
//  public void testContainsValueAtLowerBoundary() {
//      Range range = new Range(1.0, 5.0);
//      assertTrue(range.contains(1.0));
//      assertFalse(range.contains(0.9999999));
//  }
//
//  /**
//   * Tests the intersect method for adjacent ranges.
//   */
//  @Test
//  public void testIntersectWithAdjacentRanges() {
//      Range range1 = new Range(1.0, 5.0);
//      Range range2 = new Range(5.0, 10.0); // Adjacent at 5.0
//      assertFalse(range1.intersects(range2));
//  }

  /**
   * Tests expandToInclude for NaN values.
   */
//  @Test
//  public void testExpandToIncludeNaN() {
//      Range range = new Range(1.0, 5.0);
//      Range result = Range.expandToInclude(range, Double.NaN);
//
//      // Assert the result is not null and the boundaries are unchanged
//      assertNotNull(result);
//      assertNotEquals("The lower bound has changed unexpectedly", Double.NaN, result.getLowerBound(), 0.0);
//      assertNotEquals("The upper bound has changed unexpectedly", Double.NaN, result.getUpperBound(), 0.0);
//
//      // Check that the boundaries remain the same as the original range
//      assertEquals(1.0, result.getLowerBound(), 0.0);
//      assertEquals(5.0, result.getUpperBound(), 0.0);
//  }


//  /**
//   * Tests expandToInclude for Infinity values.
//   */
//  @Test
//  public void testExpandToIncludeInfinity() {
//      Range range = new Range(1.0, 5.0);
//      Range result = Range.expandToInclude(range, Double.POSITIVE_INFINITY);
//
//      // Ensure that result is not null
//      assertNotNull(result);
//
//      // The lower bound should remain unchanged
//      assertEquals(1.0, result.getLowerBound(), 0.0);
//
//      // The upper bound should now be positive infinity
//      assertEquals(Double.POSITIVE_INFINITY, result.getUpperBound(), 0.0);
//
//      // The range should now include any finite value larger than the old upper bound
//      assertTrue(result.contains(1e308));
//
//      // The range should include positive infinity
//      assertTrue(result.contains(Double.POSITIVE_INFINITY));
//  }



  
  

}
