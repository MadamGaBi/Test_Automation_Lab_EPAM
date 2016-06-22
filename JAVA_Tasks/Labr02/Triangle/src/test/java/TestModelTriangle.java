/**
 * Created by GaBi on 17.03.2016.
 */

import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestModelTriangle {
    private static final double epsilon = 0.0000000001;
    private static Model tester;

    @Rule
    public final ExpectedException exp = ExpectedException.none();

    @BeforeClass
    public static void testSetup() {
        // Initialization
        tester = new Model();
    }

    @AfterClass
    public static void testCleanup() {
        // Teardown for data used by the unit tests
        tester = null;
    }

    // ---------------------------------------- Method countSemiPerimeter ----------------------------------------------

    // Test with correct values
    @Test
    public void testCountSemiPerimeter() {
        assertTrue("Semi-perimeter of triangle with sides 3, 4, 5 must be equal 6.0", (tester.countSemiPerimeter(3, 4, 5) - 6.0) < epsilon);
    }

    // Test with zero value (Expected IllegalArgumentException)
    @Test
    public void testCountSemiPerimeterExceptionIsThrown1() {
        exp.expect(Exception.class);
        tester.countSemiPerimeter(0, 3, 3);
    }

    // Test with negative value (Expected IllegalArgumentException)
    @Test
    public void testCountSemiPerimeterExceptionIsThrown2() {
        exp.expect(Exception.class);
        tester.countSemiPerimeter(-6, 3, 3);
    }

    // Test with not a triangle values (Expected IllegalArgumentException)
    @Test
    public void testCountSemiPerimeterExceptionIsThrown3() {
        exp.expect(Exception.class);
        tester.countSemiPerimeter(6, 21, 3);
    }

    // ------------------------------------------- Method countSquare --------------------------------------------------

    // Test with correct values
    @Test
    public void testCountSquare() {
        assertTrue("Square of triangle with sides 3, 4, 5 must be equal 4.0", (tester.countSquare(3, 4, 5) - 6.0) < epsilon);
    }

    // Test with zero value (Expected IllegalArgumentException)
    @Test
    public void testCountSquareExceptionIsThrown1() {
        exp.expect(Exception.class);
        tester.countSquare(0, 3, 3);
    }

    // Test with negative value (Expected IllegalArgumentException)
    @Test
    public void testCountSquareExceptionIsThrown2() {
        exp.expect(Exception.class);
        tester.countSquare(-6, 3, 3);
    }

    // Test with 'not a triangle' values (Expected IllegalArgumentException)
    @Test
    public void testCountSquareExceptionIsThrown3() {
        exp.expect(Exception.class);
        tester.countSquare(6, 21, 3);
    }

    // ------------------------------------ Method checkValuesForTriangle ----------------------------------------------

    // Test with correct values
    @Test
    public void testCheckValuesForTriangle10() {
        assertTrue(tester.checkValuesForTriangle(5, 5, 5));
    }

    // Test with zero value
    @Test
    public void testCheckValuesForTriangle1() {
        assertFalse(tester.checkValuesForTriangle(0, 3, 3));
    }

    // Test with zero value
    @Test
    public void testCheckValuesForTriangle2() {
        assertFalse(tester.checkValuesForTriangle(4, 0, 3));
    }

    // Test with zero value
    @Test
    public void testCheckValuesForTriangle3() {
        assertFalse(tester.checkValuesForTriangle(4, 5, 0));
    }

    // Test with negative value
    @Test
    public void testCheckValuesForTriangle4() {
        assertFalse(tester.checkValuesForTriangle(-4, 5, 3));
    }

    // Test with negative value
    @Test
    public void testCheckValuesForTriangle5() {
        assertFalse(tester.checkValuesForTriangle(4, -5, 3));
    }

    // Test with negative value
    @Test
    public void testCheckValuesForTriangle6() {
        assertFalse(tester.checkValuesForTriangle(4, 5, -3));
    }

    // Test with 'not a triangle' values
    @Test
    public void testCheckValuesForTriangle7() {
        assertFalse(tester.checkValuesForTriangle(44, 5, 3));
    }

    // Test with 'not a triangle' values
    @Test
    public void testCheckValuesForTriangle8() {
        assertFalse(tester.checkValuesForTriangle(4, 55, 3));
    }

    // Test with 'not a triangle' values
    @Test
    public void testCheckValuesForTriangle9() {
        assertFalse(tester.checkValuesForTriangle(4, 5, 33));
    }
}