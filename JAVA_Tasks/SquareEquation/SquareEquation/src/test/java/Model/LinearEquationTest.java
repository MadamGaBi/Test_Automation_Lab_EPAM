package Model;

import Controller.SquareEquationController;
import View.SquareEquationView;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by GaBi on 10.04.2016.
 */

public class LinearEquationTest {

    SquareEquationModel linearEquation;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    // --------------------------------- Test method Model.LinearEquationModel.solve() ---------------------------------

    // test method solve() with correct data: coefficientB != 0 and coefficientC != 0
    @Test
    public void testSolveNotZeroCoefficients() {
        linearEquation = new LinearEquationModel(2, -4);
        double result[] = linearEquation.solve();
        assertNotNull(result);
        assertEquals(SquareEquationView.RETURN_ONE_VALUE, 1, result.length);
        boolean equalsRes =
                (Math.abs(result[0] - (2.)) < SquareEquationController.EPSILON);
        assertTrue(equalsRes);
    }

    // test method solve() with correct data: coefficientB != 0 and coefficientC == 0
    @Test
    public void testSolveZeroCoefficientC() {
        linearEquation = new LinearEquationModel(2, 0);
        double result[] = linearEquation.solve();
        assertNotNull(result);
        assertEquals(SquareEquationView.RETURN_ONE_VALUE, 1, result.length);
        boolean equalsRes =
                (Math.abs(result[0] - (0.)) < SquareEquationController.EPSILON);
        assertTrue(equalsRes);
    }

    // test method solve() with incorrect data: coefficientB == 0 and coefficientC != 0
    @Test(expected = IllegalArgumentException.class)
    public void testSolveZeroCoefficientBExceptionIsThrown() {
        linearEquation = new LinearEquationModel(0, -4);
        linearEquation.solve();
    }

    // test method solve() with incorrect data: coefficientB == 0 and coefficientC == 0
    @Test(expected = IllegalArgumentException.class)
    public void testSolveZeroCoefficientsExceptionIsThrown() {
        linearEquation = new LinearEquationModel(0, 0);
        linearEquation.solve();
    }
}