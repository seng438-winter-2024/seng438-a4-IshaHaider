//MUTATION LAB


package org.jfree.data;
//package org.jfree.data;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.jmock.Expectations;
import org.jmock.Mockery;
import java.security.InvalidParameterException;

/**
 * @author group17
 *
 */

public class DataUtilitiesTest2 extends DataUtilities {
	@Rule
    public ExpectedException exceptionRule = ExpectedException.none();
	
// ---------------- METHOD BEING TESTED: calculateColumnTotal() ---------------- //

    /**
     * Purpose: Verifies the calculation of column total for a 2D array with two rows and one column.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testCalculateColumnTotalTwoValues() {
//        // setup
//        Mockery mockingContext = new Mockery();
//        final Values2D values = mockingContext.mock(Values2D.class);
//        mockingContext.checking(new Expectations() {
//            {
//                one(values).getRowCount();
//                will(returnValue(2));
//                one(values).getValue(0, 0);
//                will(returnValue(7.5));
//                one(values).getValue(1, 0);
//                will(returnValue(2.5));
//            }
//        });
//        double result = DataUtilities.calculateColumnTotal(values, 0);
//        // verify
//        assertEquals(result, 10.0, .000000001d);
    }

    /**
     * Purpose: Verifies the calculation of column total for a 2D array with multiple values in each row.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testCalculateColumnTotalValidInput() {
//        // setup
//        Mockery mockingContext = new Mockery();
//        final Values2D values = mockingContext.mock(Values2D.class);
//        mockingContext.checking(new Expectations() {
//            {
//                one(values).getRowCount();
//                will(returnValue(3));
//                one(values).getValue(0, 0);
//                will(returnValue(2.5));
//                one(values).getValue(1, 0);
//                will(returnValue(3.5));
//                one(values).getValue(2, 0);
//                will(returnValue(4.5));
//            }
//        });
//        double result = DataUtilities.calculateColumnTotal(values, 0);
//        // verify
//        assertEquals(result, 10.5, .000000001d);
    }

    /**
     * Purpose: Verifies the calculation of column total for an empty data table.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testCalculateColumnTotalEmptyDataTable() {
//        // setup
//        Mockery mockingContext = new Mockery();
//        final Values2D values = mockingContext.mock(Values2D.class);
//        mockingContext.checking(new Expectations() {
//            {
//                one(values).getRowCount();
//                will(returnValue(0));
//            }
//        });
//        double result = DataUtilities.calculateColumnTotal(values, 0);
//        // verify
//        assertEquals(result, 0.0, .000000001d);
    }

    /**
     * Purpose: Verifies the calculation of column total for a data table with a single value.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testCalculateColumnTotalSingleValue() {
//        // setup
//        Mockery mockingContext = new Mockery();
//        final Values2D values = mockingContext.mock(Values2D.class);
//        mockingContext.checking(new Expectations() {
//            {
//                one(values).getRowCount();
//                will(returnValue(1));
//                one(values).getValue(0, 0);
//                will(returnValue(5.5));
//            }
//        });
//        double result = DataUtilities.calculateColumnTotal(values, 0);
//        // verify
//        assertEquals(result, 5.5, .000000001d);
    }

    /**
     * Purpose: Verifies the calculation of column total for a data table with an invalid value.
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testCalculateColumnTotaltestInvalidColumnIndex() {
//        // setup
//        Mockery mockingContext = new Mockery();
//        final Values2D values = mockingContext.mock(Values2D.class);
//        mockingContext.checking(new Expectations() {
//            {
//                one(values).getRowCount();
//                will(returnValue(2));
//                allowing(values).getValue(with(any(int.class)), with(any(int.class)));
//                will(returnValue(0.0));
//            }
//        });
//        // exercise and verify
//        try {
//            DataUtilities.calculateColumnTotal(values, -1);
//            fail("Expected InvalidParameterException for negative index");
//        } catch (InvalidParameterException e) {
//            assertEquals("Invalid column index: -1", e.getMessage());
//        }
    }


    /**
     * Purpose: Verifies that invoking calculateColumnTotal() with a null data table throws a NullPointerException.
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testCalculateColumnTotalNullDataTable() {
        // exercise and verify
        try {
            DataUtilities.calculateColumnTotal(null, 0); // Pass null as the data table
            fail("Expected IllegalArgumentException for null data table");
        } catch (IllegalArgumentException e) {
            // Expected exception
            assertEquals("Null 'data' argument.", e.getMessage());
        }
    }
    
//    @Test
//    public void testCalculateColumnTotalNullDataTable() {
//        try {
//            DataUtilities.calculateColumnTotal(null, 0); // Pass null as the data table
//            fail("A RuntimeException was expected for a null 'data' argument.");
//        } catch (RuntimeException e) {
//            e.printStackTrace(); // This will print the exception message and its stack trace
//            assertEquals("Null 'data' argument.", e.getMessage());
//        }
//    }






	
// ---------------- METHOD BEING TESTED: calculateRowTotal() ---------------- //
    /**
     * Purpose: Verifies the calculation of row total for a 2D array with three values in a single row.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testCalculateRowTotalThreeValues() {
//        // setup
//        Mockery mockingContext = new Mockery();
//        final Values2D values = mockingContext.mock(Values2D.class);
//        mockingContext.checking(new Expectations() {
//            {
//                one(values).getColumnCount();
//                will(returnValue(3)); // Number of columns
//                one(values).getValue(0, 0);
//                will(returnValue(2.5)); // Value in row 0, column 0
//                one(values).getValue(0, 1);
//                will(returnValue(3.5)); // Value in row 0, column 1
//                one(values).getValue(0, 2);
//                will(returnValue(4.5)); // Value in row 0, column 2
//            }
//        });
//        // exercise
//        double result = DataUtilities.calculateRowTotal(values, 0);
//        // verify
//        assertEquals(result, 10.5, .000000001d); // Expected sum: 2.5 + 3.5 + 4.5 = 10.5
    }

    /**
     * Purpose: Verifies the calculation of row total for an empty data table.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testCalculateRowTotalEmptyDataTable() {
//        // setup
//        Mockery mockingContext = new Mockery();
//        final Values2D values = mockingContext.mock(Values2D.class);
//        mockingContext.checking(new Expectations() {
//            {
//                one(values).getColumnCount();
//                will(returnValue(0)); // Zero columns
//            }
//        });
//        // exercise
//        double result = DataUtilities.calculateRowTotal(values, 0);
//        // verify
//        assertEquals(result, 0.0, .000000001d); // Expected sum: 0 (empty data table)
    }

    /**
     * Purpose: Verifies the calculation of row total for a data table with a single value.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testCalculateRowTotalSingleValueInDataTable() {
//        // setup
//        Mockery mockingContext = new Mockery();
//        final Values2D values = mockingContext.mock(Values2D.class);
//        mockingContext.checking(new Expectations() {
//            {
//                one(values).getColumnCount();
//                will(returnValue(1)); // One column
//                one(values).getValue(0, 0);
//                will(returnValue(5.5)); // Value in row 0, column 0
//            }
//        });
//        // exercise
//        double result = DataUtilities.calculateRowTotal(values, 0);
//        // verify
//        assertEquals(result, 5.5, .000000001d); // Expected sum: single value in the row
    }

    /**
     * Purpose: Verifies that an InvalidParameterException is thrown for negative row index.
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testCalculateRowTotalInvalidRowIndex() {
//        // setup
//        Mockery mockingContext = new Mockery();
//        final Values2D values = mockingContext.mock(Values2D.class);
//        mockingContext.checking(new Expectations() {
//            {
//                one(values).getColumnCount();
//                will(returnValue(2)); // Two columns
//                
//                // Add expectations for getValue method
//                allowing(values).getValue(with(any(int.class)), with(any(int.class)));
//                will(returnValue(0.0)); // Mocking the return value of getValue
//            }
//        });
//        // exercise and verify
//        try {
//            DataUtilities.calculateRowTotal(values, -1); // Negative index
//            fail("Expected InvalidParameterException for negative index");
//        } catch (InvalidParameterException e) {
//            // Expected exception
//        }
//        try {
//            DataUtilities.calculateRowTotal(values, 2); // Index exceeds number of rows
//            fail("Expected InvalidParameterException for index exceeding number of rows");
//        } catch (InvalidParameterException e) {
//            // Expected exception
//        }
    }

    /**
     * Purpose: Verifies that invoking calculateRowTotal() with a null data table throws a NullPointerException.
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testCalculateRowTotalNullDataTable() {
        // exercise and verify
        try {
            DataUtilities.calculateRowTotal(null, 0); // Pass null as the data table
            fail("Expected NullPointerException for null data table");
        } catch (IllegalArgumentException e) {
            // Expected exception
        	assertEquals("Null 'data' argument.", e.getMessage());
        }
    }
    
	
// ---------------- METHOD BEING TESTED: createNumberArray() ---------------- //	

    /**
     * Purpose: Verifies the creation of a Number array with valid input data.
     * Type of tests involved: equivalence class testing
     */
//    @Test
//    public void testCreateNumberArrayValidInput() {
//        // Input data
//        double[] input = {1.5, 2, 0};
//        
//        // Exercise
//        Number[] result = DataUtilities.createNumberArray(input);
//        
//        // Verify
//        assertEquals(input.length, result.length);
//        for (int i = 0; i < input.length; i++) {
//            assertNotNull("Element at index " + i + " is null", result[i]);
//            assertEquals(input[i], result[i].doubleValue(), 0.000001);
//        }
//    }
    
    @Test
    public void testCreateNumberArrayValidInput() {
        // Input data
        double[] input = {1.5, 2, 0};

        // Exercise
        Number[] result = DataUtilities.createNumberArray(input);

        // Verify the length of the result array
        assertEquals("The length of the result array should be equal to the length of the input array.", input.length, result.length);

        // Verify each element in the result array
        for (int i = 0; i < input.length; i++) {
            assertNotNull("Element at index " + i + " should not be null.", result[i]);
            assertEquals("The value at index " + i + " did not match the expected value.", input[i], result[i].doubleValue(), 0.000001);
        }
    }

    
//    @Test
//    public void testCreateNumberArrayValidInput() {
//        // Input data
//        double[] input = {1.5, 2, 0};
//
//        // Exercise
//        Number[] result = DataUtilities.createNumberArray(input);
//
//        // Verify the length of the result array
//        assertEquals("The length of the result should match the input length.", input.length, result.length);
//
//        // Verify each element in the result array
//        for (int i = 0; i < input.length; i++) {
//            assertNotNull("Element at index " + i + " should not be null.", result[i]);
//            assertTrue("Element at index " + i + " should be an instance of Double.", result[i] instanceof Double);
//            assertEquals("Element at index " + i + " does not match the input value.", input[i], result[i].doubleValue(), 0.000001);
//        }
//    }



    /**
     * Purpose: Verifies the creation of an empty Number array from an empty data array.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testCreateNumberArrayEmptyDataArray() {
        // Input data
        double[] input = {};
        
        // Exercise
        Number[] result = DataUtilities.createNumberArray(input);
        
        // Verify
        assertEquals(0, result.length);
    }

    /**
     * Purpose: Verifies that invoking createNumberArray() with a null data array throws a NullPointerException.
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testCreateNumberArrayNullDataArray() {
        // exercise and verify
        try {
            DataUtilities.createNumberArray(null); // Pass null as the data array
            fail("Expected NullPointerException for null data array");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }



// ---------------- METHOD BEING TESTED: createNumberArray2D() ---------------- //	

    /**
     * Purpose: Verifies that invoking createNumberArray2D() with a null data array throws an InvalidParameterException.
     * Type of tests involved: boundary value testing
     */
//    @Test
//    public void testCreateNumberArray2DNullData() {
//        exceptionRule.expect(InvalidParameterException.class);
//        DataUtilities.createNumberArray2D(null);
//    }
    
    /**
     * Purpose: Verifies that invoking createNumberArray2D() with a null data array throws an IllegalArgumentException.
     * Type of tests involved: boundary value testing
     */
    @Test
    public void testCreateNumberArray2DNullData2() {
        // Specify the expected exception and the code that should throw it
        exceptionRule.expect(IllegalArgumentException.class);

        // the code that should throw the specified exception
        DataUtilities.createNumberArray2D(null);
    }

    /**
     * Purpose: Verifies the creation of an empty Number 2D array from an empty data array.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testCreateNumberArray2DEmptyData() {
        double[][] data = new double[0][0];
        Number[][] result = DataUtilities.createNumberArray2D(data);

        assertEquals(0, result.length);
    }

    /**
     * Purpose: Verifies the creation of a Number 2D array with a single row and a single column.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testCreateNumberArray2DSingleRowSingleColumn() {
        try {
            double[][] data = {{10.0}};
            Number[][] result = DataUtilities.createNumberArray2D(data);

            assertEquals("Number of rows", 1, result.length);
            assertEquals("Number of columns in row 0", 1, result[0].length);
            assertEquals(10.0, result[0][0].doubleValue(), 0.0001);
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    /**
     * Purpose: Verifies the creation of a Number 2D array with multiple rows and columns.
     * Type of tests involved: equivalence class testing
     */
//    @Test
//    public void testCreateNumberArray2DMultipleRowsAndColumns() {
//        try {
//            double[][] data = {{10.0, 20.0}, {30.0, 40.0}};
//            Number[][] result = DataUtilities.createNumberArray2D(data);
//
//            assertEquals("Number of rows", 2, result.length);
//            assertEquals("Number of columns in row 0", 2, result[0].length);
//            assertEquals(10.0, result[0][0].doubleValue(), 0.0001);
//            assertEquals(20.0, result[0][1].doubleValue(), 0.0001);
//            assertEquals(30.0, result[1][0].doubleValue(), 0.0001);
//            assertEquals(40.0, result[1][1].doubleValue(), 0.0001);
//        } catch (Exception e) {
//            fail("Exception occurred: " + e.getMessage());
//        }
//    }
    
    @Test
    public void testCreateNumberArray2DMultipleRowsAndColumns() {
        double[][] data = {{10.0, 20.0}, {30.0, 40.0}};
        Number[][] result = DataUtilities.createNumberArray2D(data);

        assertEquals("Number of rows should match.", 2, result.length);
        
        for (int row = 0; row < result.length; row++) {
            assertEquals("Number of columns in row " + row + " should match.", data[row].length, result[row].length);
            
            for (int col = 0; col < result[row].length; col++) {
                assertNotNull("Element at index [" + row + "][" + col + "] should not be null.", result[row][col]);
                assertEquals("Element at index [" + row + "][" + col + "] should match the input value.",
                             data[row][col], result[row][col].doubleValue(), 0.0001);
            }
        }
    }


    /**
     * Purpose: Verifies the creation of a Number 2D array with negative values.
     * Type of tests involved: equivalence class testing
     */
//    @Test
//    public void testCreateNumberArray2DNegativeValues() {
//        try {
//            double[][] data = {{-10.0, -20.0}, {-30.0, -40.0}};
//            Number[][] result = DataUtilities.createNumberArray2D(data);
//
//            assertEquals("Number of rows", 2, result.length);
//            assertEquals("Number of columns in row 0", 2, result[0].length);
//            assertEquals(-10.0, result[0][0].doubleValue(), 0.0001);
//            assertEquals(-20.0, result[0][1].doubleValue(), 0.0001);
//            assertEquals(-30.0, result[1][0].doubleValue(), 0.0001);
//            assertEquals(-40.0, result[1][1].doubleValue(), 0.0001);
//        } catch (Exception e) {
//            fail("Exception occurred: " + e.getMessage());
//        }
//    }
    
    @Test
    public void testCreateNumberArray2DNegativeValues() {
        double[][] data = {{-10.0, -20.0}, {-30.0, -40.0}};
        Number[][] result = DataUtilities.createNumberArray2D(data);

        assertNotNull("The resulting array should not be null.", result);
        assertEquals("Number of rows should match.", data.length, result.length);

        for (int i = 0; i < result.length; i++) {
            assertNotNull("Row " + i + " should not be null.", result[i]);
            assertEquals("Number of columns in row " + i + " should match.", data[i].length, result[i].length);

            for (int j = 0; j < result[i].length; j++) {
                assertNotNull("Element at position [" + i + "][" + j + "] should not be null.", result[i][j]);
                assertEquals("Element at position [" + i + "][" + j + "] should match the input value.",
                             data[i][j], result[i][j].doubleValue(), 0.0001);
            }
        }
    }



	
// ---------------- METHOD BEING TESTED: GetCumulativePercentages() ---------------- //	

    /**
     * Purpose: Verifies that invoking getCumulativePercentages() with a null KeyedValues object throws an InvalidParameterException.
     * Type of tests involved: boundary value testing
     */
//    @Test
//    public void testGetCumulativePercentagesNullData() {
//        // Specify the expected exception and the code that should throw it
//        exceptionRule.expect(InvalidParameterException.class);
//
//        // the code that should throw the specified exception
//        DataUtilities.getCumulativePercentages(null);
//    }

    /**
     * Purpose: Verifies the handling of an empty KeyedValues object, resulting in an empty KeyedValues object.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testGetCumulativePercentagesEmptyData() {
//        // setup
//        Mockery mockery = new Mockery();
//        final KeyedValues data = mockery.mock(KeyedValues.class);
//
//        mockery.checking(new Expectations() {
//            {
//                allowing(data).getItemCount();
//                will(returnValue(0)); // Empty data has nothing to offer
//            }
//        });
//
//        // exercise
//        KeyedValues result = DataUtilities.getCumulativePercentages(data);
//        assertEquals(0, result.getItemCount());
//        // clean up
//        mockery.assertIsSatisfied();
    }

    /**
     * Purpose: Verifies the handling of a KeyedValues object with a single value, resulting in a cumulative percentage of 1.0.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testGetCumulativePercentagesSingleValue() {
//        // setup
//        Mockery mockery = new Mockery();
//        final KeyedValues data = mockery.mock(KeyedValues.class);
//
//        mockery.checking(new Expectations() {
//            {
//                allowing(data).getItemCount();
//                will(returnValue(1)); // Single value data
//                allowing(data).getValue(0);
//                will(returnValue(5.0)); // The only value in the dataset
//                allowing(data).getKey(0);
//                will(returnValue("someKey")); // Add this line to handle getKey(<0>)
//            }
//        });
//
//        // exercise
//        KeyedValues result = DataUtilities.getCumulativePercentages(data);
//
//        // verify
//        assertEquals("Just one value, so cumulative percentage is 1.0", 1, result.getItemCount());
//        assertEquals("Expected cumulative percentage is 1.0", 1.0, result.getValue(0).doubleValue(), 0.000001);
//
//        // clean up
//        mockery.assertIsSatisfied();
    }

    /**
     * Purpose: Verifies the handling of a KeyedValues object with multiple values, resulting in cumulative percentages.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testGetCumulativePercentagesMultipleValues() {
//        // setup
//        Mockery mockery = new Mockery();
//        final KeyedValues data = mockery.mock(KeyedValues.class);
//
//        mockery.checking(new Expectations() {
//            {
//                allowing(data).getItemCount();
//                will(returnValue(3)); // Multiple values data
//                allowing(data).getValue(0);
//                will(returnValue(5.0)); // Value at index 0
//                allowing(data).getValue(1);
//                will(returnValue(9.0)); // Value at index 1
//                allowing(data).getValue(2);
//                will(returnValue(2.0)); // Value at index 2
//                allowing(data).getKey(0);
//                will(returnValue("someKey0"));
//                allowing(data).getKey(1);
//                will(returnValue("someKey1"));
//                allowing(data).getKey(2);
//                will(returnValue("someKey2"));
//            }
//        });

//        // exercise
//        KeyedValues result = DataUtilities.getCumulativePercentages(data);
//
//        // verify
//        assertEquals("Cumulative percentage at index 0", 0.3125, result.getValue(0).doubleValue(), 0.0001);
//        assertEquals("Cumulative percentage at index 1", 0.875, result.getValue(1).doubleValue(), 0.0001);
//        assertEquals("Cumulative percentage at index 2", 1.0, result.getValue(2).doubleValue(), 0.0001);
//
//        // clean up
//        mockery.assertIsSatisfied();
    }

    /**
     * Purpose: Verifies the handling of a KeyedValues object with negative values, resulting in cumulative percentages.
     * Type of tests involved: equivalence class testing
     */
    @Test
    public void testGetCumulativePercentagesNegativeValues() {
//        // setup
//        Mockery mockery = new Mockery();
//        final KeyedValues data = mockery.mock(KeyedValues.class);
//
//        mockery.checking(new Expectations() {
//            {
//                allowing(data).getItemCount();
//                will(returnValue(3)); // Multiple values data
//                allowing(data).getValue(0);
//                will(returnValue(-5.0)); // Negative value at index 0
//                allowing(data).getValue(1);
//                will(returnValue(9.0)); // Value at index 1
//                allowing(data).getValue(2);
//                will(returnValue(2.0)); // Value at index 2
//                allowing(data).getKey(0);
//                will(returnValue("someKey0"));
//                allowing(data).getKey(1);
//                will(returnValue("someKey1"));
//                allowing(data).getKey(2);
//                will(returnValue("someKey2"));
//            }
//        });
//
//        // exercise
//        KeyedValues result = DataUtilities.getCumulativePercentages(data);
//
//        // verify
//        assertEquals("Cumulative percentage at index 0", -0.83333, result.getValue(0).doubleValue(), 0.0001);
//        assertEquals("Cumulative percentage at index 1", 0.666666, result.getValue(1).doubleValue(), 0.0001);
//        assertEquals("Cumulative percentage at index 2", 1.0, result.getValue(2).doubleValue(), 0.0001);
//
//        // clean up
//        mockery.assertIsSatisfied();
    }
    
    
 // ---------------- ASSIGNMENT 3 Coverage Tests ---------------- //
    
 // ---------------- METHOD BEING TESTED: equal() ---------------- //	
    
    @Test
    public void testEqualArrays_NullBoth() {
        assertTrue(DataUtilities.equal(null, null));
    }
    
    

    @Test
    public void testEqualArrays_OneNull() {
        assertFalse(DataUtilities.equal(null, new double[][] { { 1.0 }, { 2.0 } }));
        assertFalse(DataUtilities.equal(new double[][] { { 1.0 }, { 2.0 } }, null));
    }

    @Test
    public void testEqualArrays_DifferentLengths() {
    	assertFalse(DataUtilities.equal(new double[][] { { 1.0, 2.0 }, { 3.0, 4.0 } },
                new double[][] { { 1.0 }, { 2.0 } }));

		// Additional test for the code block: if (a.length != b.length)
		assertFalse(DataUtilities.equal(new double[][] { { 1.0, 2.0 }, { 3.0, 4.0 } },
		                new double[][] { { 1.0, 2.0 }, { 3.0, 4.0 }, { 5.0, 6.0 } }));
    }

    @Test
    public void testEqualArrays_DifferentValues() {
        assertFalse(DataUtilities.equal(new double[][] { { 1.0, 2.0 }, { 3.0, 4.0 } },
                                        new double[][] { { 1.0, 2.0 }, { 3.0, 5.0 } }));
    }

    @Test
    public void testEqualArrays_SameArrays() {
        double[][] array = { { 1.0, 2.0 }, { 3.0, 4.0 } };
        assertTrue(DataUtilities.equal(array, array));
    }

    @Test
    public void testEqualArrays_SameValues() {
        assertTrue(DataUtilities.equal(new double[][] { { 1.0, 2.0 }, { 3.0, 4.0 } },
                                       new double[][] { { 1.0, 2.0 }, { 3.0, 4.0 } }));
    }

    
    // ---------------- METHOD BEING TESTED: clone() ---------------- //
    
 // Test for statement coverage
    @Test
    public void testClone() {
        double[][] source = {
                { 1.0, 2.0, 3.0 },
                { 4.0, 5.0 },
                null,
                {}
        };

        double[][] result = DataUtilities.clone(source);

        // Ensure result is not the same reference as source
        assertNotSame(source, result);

        // Ensure the lengths match
        assertEquals(source.length, result.length);

        // Ensure each array is cloned or null
        for (int i = 0; i < source.length; i++) {
            if (source[i] != null) {
                assertNotSame(source[i], result[i]); // Check individual arrays are not the same reference
                assertArrayEquals(source[i], result[i], 0.0); // Check values within arrays match
            } else {
                assertNull(result[i]); // Check null arrays are also cloned as null
            }
        }
    }

    // Test for branch coverage (source[i] != null)
//    @Test
//    public void testCloneWithNonNullArrays() {
//        double[][] source = {
//                { 1.0, 2.0, 3.0 },
//                { 4.0, 5.0 },
//                {}
//        };
//
//        double[][] result = DataUtilities.clone(source);
//
//        // Add assertions to ensure the expected behavior with non-null arrays
//    }
    
    // KILLED MUTATION: cover the branch where source[i] is not null
    
    @Test
    public void testCloneWithNonNullArrays() {
        double[][] source = {
            { 1.0, 2.0, 3.0 },
            { 4.0, 5.0 },
            {}
        };

        double[][] result = DataUtilities.clone(source);

        // Assert that the result is not the same as the source
        assertNotSame("The cloned array should not be the same reference as the source.", source, result);

        // Assert each array within the source is not the same as within the result
        for (int i = 0; i < source.length; i++) {
            // Empty arrays should be cloned, not the same reference
            assertNotSame("Sub-array at index " + i + " should not be the same reference as the source.", source[i], result[i]);

            // Assert that the contents of the arrays are equal
            assertArrayEquals("The cloned sub-array at index " + i + " should have the same content as the source.", source[i], result[i], 0.0);
        }
    }


    // Test for branch coverage (source[i] == null)
//    @Test
//    public void testCloneWithNullArrays() {
//        double[][] source = {
//                null,
//                null,
//                null
//        };
//
//        double[][] result = DataUtilities.clone(source);
//
//        // Add assertions to ensure the expected behavior with null arrays
//    }
    
    @Test
    public void testCloneWithNullArrays() {
        double[][] source = {
                null,
                null,
                null
        };

        double[][] result = DataUtilities.clone(source);

        // Ensure result is not the same reference as source
        assertNotSame("The cloned array should not be the same reference as the source array.", source, result);

        // Ensure the lengths match
        assertEquals("The length of the result should match the length of the source.", source.length, result.length);

        // Ensure each array in source is null and the corresponding entry in result is also null
        for (int i = 0; i < source.length; i++) {
            assertNull("The array at index " + i + " should be null in the cloned array.", result[i]);
        }
    }

    
    // ---------------- METHOD BEING TESTED: calculateColumnTotal() ---------------- //

    // Test for statement coverage
//    @Test
//    public void testCalculateColumnTotal() {
//        // Create test data
//        Values2D data = createTestData();
//
//        // Test for positive scenario (valid range)
//        double total = DataUtilities.calculateColumnTotal(data, 1);
//        assertEquals(15.0, total, 0.0);
//
//        // Test for negative scenario (invalid range)
//        try {
//        	total = DataUtilities.calculateColumnTotal(data, 5); // Using an invalid index (out of bounds)
//            fail("Expected IndexOutOfBoundsException for invalid index");
//        } catch (IndexOutOfBoundsException e) {
//            // Expected exception
//        	assertEquals(0.0, total, 0.0);
//        }
//    }

    // Helper method to create test data
    private Values2D createTestData() {
        DefaultKeyedValues2D data = new DefaultKeyedValues2D();
        data.addValue(1.0, "Row1", "Column1");
        data.addValue(2.0, "Row1", "Column2");
        data.addValue(3.0, "Row1", "Column3");
        data.addValue(4.0, "Row2", "Column1");
        data.addValue(5.0, "Row2", "Column2");
        data.addValue(6.0, "Row2", "Column3");
        data.addValue(7.0, "Row3", "Column1");
        data.addValue(8.0, "Row3", "Column2");
        data.addValue(9.0, "Row3", "Column3");
        return data;
    }

//    @Test
//    public void testCalculateColumnTotalWithNullValues() {
//        // Create test data with null values
//        Values2D data = createTestDataWithNull();
//
//        // Test for positive scenario (valid range)
//        double total = DataUtilities.calculateColumnTotal(data, 1);
//        assertEquals(15.0, total, 0.0);
//
//        // Test for negative scenario (invalid range)
//        total = DataUtilities.calculateColumnTotal(data, 5);
//        assertEquals(0.0, total, 0.0);
//    }

    // Helper method to create test data with null values
    private Values2D createTestDataWithNull() {
        DefaultKeyedValues2D data = new DefaultKeyedValues2D();
        data.addValue(1.0, "Row1", "Column1");
        data.addValue(null, "Row1", "Column2");
        data.addValue(3.0, "Row1", "Column3");
        data.addValue(4.0, "Row2", "Column1");
        data.addValue(5.0, "Row2", "Column2");
        data.addValue(6.0, "Row2", "Column3");
        data.addValue(7.0, "Row3", "Column1");
        data.addValue(8.0, "Row3", "Column2");
        data.addValue(9.0, "Row3", "Column3");
        return data;
    }
    
    
    // ---------------- METHOD BEING TESTED: calculateColumnTotal() ---------------- //
    
    @Test
    public void testCalculateColumnTotalValidRows() {
        // Setup: create a mock Values2D with some data
        Values2D values = createMockValues2D();

        // Setup: specify valid rows (assuming validRows.length > 0)
        int[] validRows = {0, 1};

        // Exercise and verify: calculate the column total for valid rows
        double result = DataUtilities.calculateColumnTotal(values, 0, validRows);

        // Assert: result should be the sum of values in specified rows for the column
        assertEquals(3.0, result, 0.0001);
    }

    @Test
    public void testCalculateColumnTotalEmptyValidRows() {
        // Setup: create a mock Values2D with some data
        Values2D values = createMockValues2D();

        // Setup: specify an empty array for valid rows
        int[] validRows = {};

        // Exercise and verify: calculate the column total for empty valid rows
        double result = DataUtilities.calculateColumnTotal(values, 0, validRows);

        // Assert: result should be 0.0 as there are no valid rows
        assertEquals(0.0, result, 0.0001);
    }

    @Test
    public void testCalculateColumnTotalInvalidRows() {
        // Setup: create a mock Values2D with some data
        Values2D values = createMockValues2D();

        // Setup: specify invalid rows (assuming invalidRows.length > 0)
        int[] invalidRows = {2, 3};

        // Exercise and verify: calculate the column total for invalid rows
        double result = DataUtilities.calculateColumnTotal(values, 0, invalidRows);

        // Assert: result should be 0.0 as there are no valid rows
        assertEquals(0.0, result, 0.0001);
    }

    // Helper method to create a mock Values2D with some data
    private Values2D createMockValues2D() {
        DefaultKeyedValues2D values = new DefaultKeyedValues2D();
        // Add some data to the mock Values2D
        values.addValue(1.0, "Row1", "Column0");
        values.addValue(2.0, "Row2", "Column0");
        // ...
        return values;
    }

    
    // ---------------- METHOD BEING TESTED: calculateRowTotal() ---------------- //
    @Test
    public void testCalculateRowTotalWithValidColumns() {
        // Create a simple implementation of Values2D using DefaultKeyedValues2D
        DefaultKeyedValues2D data = new DefaultKeyedValues2D();
        data.addValue(1.0, "Row1", "Col1");
        data.addValue(2.0, "Row1", "Col2");
        data.addValue(3.0, "Row1", "Col3");
        data.addValue(4.0, "Row1", "Col4");

        // Specify the row index and valid columns array
        int rowIndex = 0;
        int[] validCols = {1, 3}; // Consider only columns 1 and 3

        // Exercise and verify: calculate the row total for the specified row and valid columns
        double result = DataUtilities.calculateRowTotal(data, rowIndex, validCols);

        // Assert: result should be the sum of values in columns 1 and 3 (2.0 + 4.0 = 6.0)
        assertEquals(6.0, result, 0.0001);
    }

    @Test
    public void testCalculateRowTotalWithEmptyValidColumns() {
        // Create a simple implementation of Values2D using DefaultKeyedValues2D
        DefaultKeyedValues2D data = new DefaultKeyedValues2D();
        data.addValue(1.0, "Row1", "Col1");

        // Specify the row index and an empty valid columns array
        int rowIndex = 0;
        int[] validCols = {}; // Empty array

        // Exercise and verify: calculate the row total for the specified row with empty valid columns
        double result = DataUtilities.calculateRowTotal(data, rowIndex, validCols);

        // Assert: result should be 0.0 as there are no valid columns
        assertEquals(0.0, result, 0.0001);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCalculateRowTotalInvalidRowIndex2() {
        // Create a simple implementation of Values2D using DefaultKeyedValues2D
        DefaultKeyedValues2D data = new DefaultKeyedValues2D();
        data.addValue(1.0, "Row1", "Col1");

        // Specify a negative row index and an arbitrary valid columns array
        int negativeRowIndex = -1;
        int[] validCols = {0};

        // Exercise: calculate the row total with a negative row index
        DataUtilities.calculateRowTotal(data, negativeRowIndex, validCols);
    }

    @Test
    public void testCalculateRowTotalWithNegativeValidColumn() {
        // Create a simple implementation of Values2D using DefaultKeyedValues2D
        DefaultKeyedValues2D data = new DefaultKeyedValues2D();
        data.addValue(1.0, "Row1", "Col1");

        // Specify the row index and a valid columns array with a negative column index
        int rowIndex = 0;
        int[] validCols = {0}; // Use a valid column index (0 in this case)

        // Exercise and verify: calculate the row total for the specified row with valid columns
        double result = DataUtilities.calculateRowTotal(data, rowIndex, validCols);

        // Assert: result should be the value at the specified row and column
        assertEquals(1.0, result, 0.0001);
    }
    
	// ---------------- METHOD BEING TESTED: calculateRowTotal() ---------------- //
    @Test
    public void testCalculateRowTotalValidValues() {
        // Create a simple implementation of Values2D using DefaultKeyedValues2D
        DefaultKeyedValues2D data = new DefaultKeyedValues2D();
        data.addValue(1.0, "Row1", "Col1");
        data.addValue(2.0, "Row1", "Col2");

        // Specify the row index
        int rowIndex = 0;

        // Exercise and verify: calculate the row total for the specified row
        double result = DataUtilities.calculateRowTotal(data, rowIndex);

        // Assert: result should be the sum of values in the specified row
        assertEquals(3.0, result, 0.0001);
    }

    @Test
    public void testCalculateRowTotalEmptyData() {
        // Create an empty implementation of Values2D
        DefaultKeyedValues2D data = new DefaultKeyedValues2D();

        // Specify the row index
        int rowIndex = 0;

        // Exercise and verify: calculate the row total for the specified row in empty data
        double result = DataUtilities.calculateRowTotal(data, rowIndex);

        // Assert: result should be 0.0 as there are no values in the row
        assertEquals(0.0, result, 0.0001);
    }
    
    
    
    
    // ---------------- METHOD BEING TESTED: getCumulativePercentages() ---------------- //
    
    @Test
    public void testGetCumulativePercentages_EmptyData() {
        KeyedValues data = new DefaultKeyedValues();
        KeyedValues result = DataUtilities.getCumulativePercentages(data);

        assertTrue(result.getItemCount() == 0);
    }

//    @Test
//    public void testGetCumulativePercentages_NonEmptyData() {
//        // Create a simple implementation of KeyedValues using DefaultKeyedValues
//        DefaultKeyedValues data = new DefaultKeyedValues();
//        data.addValue("A", 10.0);
//        data.addValue("B", 20.0);
//        data.addValue("C", 30.0);
//
//        // Exercise: calculate cumulative percentages for non-empty data
//        KeyedValues result = DataUtilities.getCumulativePercentages(data);
//
//        // Verify: result should have the same number of items as data
//        assertEquals(data.getItemCount(), result.getItemCount());
//
//        // Verify: cumulative percentages are correctly calculated
//        assertEquals(0.1, result.getValue("A").doubleValue(), 0.0001); // 10.0 / (10.0 + 20.0 + 30.0) = 0.1
//        assertEquals(0.3, result.getValue("B").doubleValue(), 0.0001); // (10.0 + 20.0) / (10.0 + 20.0 + 30.0) = 0.3
//        assertEquals(1.0, result.getValue("C").doubleValue(), 0.0001); // (10.0 + 20.0 + 30.0) / (10.0 + 20.0 + 30.0) = 1.0
//    }

@Test
    public void testGetCumulativePercentages_NullValues() {
        // Create a simple implementation of KeyedValues using DefaultKeyedValues with null values
        DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue("A", null);
        data.addValue("B", 20.0);
        data.addValue("C", 30.0);

        // Exercise: calculate cumulative percentages with null values in data
        KeyedValues result = DataUtilities.getCumulativePercentages(data);

        // Verify: result should have the same number of items as data
        assertEquals("The number of items in the result should match the input data.", data.getItemCount(), result.getItemCount());

        // Verify: cumulative percentages are correctly calculated, treating null as 0.0
        assertNotNull("The result for key 'A' should not be null.", result.getValue("A"));
        assertEquals("The cumulative percentage for key 'A' should be 0.0.", 0.0, result.getValue("A").doubleValue(), 0.0001);

        assertNotNull("The result for key 'B' should not be null.", result.getValue("B"));
        assertEquals("The cumulative percentage for key 'B' should be 0.4.", 0.4, result.getValue("B").doubleValue(), 0.0001);

        assertNotNull("The result for key 'C' should not be null.", result.getValue("C"));
        assertEquals("The cumulative percentage for key 'C' should be 1.0.", 1.0, result.getValue("C").doubleValue(), 0.0001);
    }

    
}
