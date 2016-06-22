package Model;

import View.SquareEquationView;
import Controller.SquareEquationController;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by GaBi on 10.04.2016.
 */

public class SquareEquationTest {

    SquareEquationModel equation;

    @BeforeClass
    public static void testSetup() {
        // Initialization
    }

    @AfterClass
    public static void testCleanup() {
        // Teardown for data used by the unit tests
    }

    // -------------------------------- Test method Model.SquareEquationModel.solve() ----------------------------------

    // test method solve() with discriminant > 0
    @Test
    public void testSolveWithPositiveDiscriminant() throws Exception{
        equation = new SquareEquationModel(1, 5, 6);
        double result[] = equation.solve();
        assertNotNull(result);
        assertEquals(SquareEquationView.RETURN_TWO_VALUES, 2, result.length);
        boolean equalsRes =
                ((Math.abs(result[0] - (-2.)) < SquareEquationController.EPSILON &&
                  Math.abs(result[1] - (-3.)) < SquareEquationController.EPSILON))
                     ||
                     ((Math.abs(result[0] - (-3.)) < SquareEquationController.EPSILON &&
                       Math.abs(result[1] - (-2.)) < SquareEquationController.EPSILON));
        assertTrue(equalsRes);
    }

    // test method solve() with discriminant == 0
    @Test
    public void testSolveWithZeroDiscriminant() throws Exception{
        equation = new SquareEquationModel(4, -20, 25);
        double actualResult[] = equation.solve();
        double expectedResult[] = {2.5};
        assertNotNull(actualResult);
        assertEquals(SquareEquationView.RETURN_ONE_VALUE, 1, actualResult.length);
        assertArrayEquals(actualResult, expectedResult, SquareEquationController.EPSILON);
    }

    // test method solve() with discriminant < 0
    @Test
    public void testSolveWithNegativeDiscriminant() throws Exception{
        equation = new SquareEquationModel(1, 4, 6);
        double actualResult[] = equation.solve();
        double expectedResult[] = {};
        assertNotNull(actualResult);
        assertEquals(SquareEquationView.NO_SOLUTION, 0, actualResult.length);
        assertArrayEquals(actualResult, expectedResult, SquareEquationController.EPSILON);
    }

    // test method solve() with incorrect data: equation is not square, coefficientA == 0
    @Test(expected = IllegalArgumentException.class)
    public void testNoRootsExceptionIsThrown(){
        equation = new SquareEquationModel(0, 1, 6);
        equation.solve();
    }
}
